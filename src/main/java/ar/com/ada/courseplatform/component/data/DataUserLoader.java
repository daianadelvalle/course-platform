package ar.com.ada.courseplatform.component.data;

import ar.com.ada.courseplatform.model.entity.security.Authority;
import ar.com.ada.courseplatform.model.entity.security.User;
import ar.com.ada.courseplatform.model.repository.security.AuthorityRepository;
import ar.com.ada.courseplatform.model.repository.security.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Component
@Order(2)
public class DataUserLoader implements ApplicationRunner {

    public static final Logger LOGGER = LoggerFactory.getLogger(DataUserLoader.class);

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired @Qualifier("authorityRepository")
    private AuthorityRepository authorityRepository;

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LOGGER.info("DataUserLoader.run");

        if (appEnv.trim().equals("dev") || appEnv.trim().equals("qa")) {
            LOGGER.info("Loading initial data Users");

            Authority adminAuthority = authorityRepository.findById(1L)
                    .orElseThrow(() -> new SQLException("Authority Not Found"));

            Authority managerAuthority = authorityRepository.findById(2L)
                    .orElseThrow(() -> new SQLException("Authority Not Found"));

            Authority studentAuthority = authorityRepository.findById(3L)
                    .orElseThrow(() -> new SQLException("Authority Not Found"));

            User admin = new User()
                    .setId(1L).setUsername("admin")
                    .setPassword(passwordEncoder.encode("admin"))
                    .setFirstName("admin").setLastName("admin")
                    .setEmail("admin@admin.com").setEnabled(true)
                    .addAuthority(adminAuthority)
                    .addAuthority(managerAuthority)
                    .addAuthority(studentAuthority);

            User manager = new User()
                    .setId(2L).setUsername("manager")
                    .setPassword(passwordEncoder.encode("manager"))
                    .setFirstName("manager").setLastName("manager")
                    .setEmail("manager@manager.com").setEnabled(true)
                    .addAuthority(managerAuthority)
                    .addAuthority(studentAuthority);

            User student = new User()
                    .setId(3L).setUsername("student")
                    .setPassword(passwordEncoder.encode("student"))
                    .setFirstName("student").setLastName("student")
                    .setEmail("student@student.com").setEnabled(true)
                    .addAuthority(studentAuthority);

            List<User> userList = Arrays.asList(admin, manager, student);
            userRepository.saveAll(userList);

        }
    }
}
