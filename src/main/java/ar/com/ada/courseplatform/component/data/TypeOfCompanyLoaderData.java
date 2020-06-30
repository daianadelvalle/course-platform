package ar.com.ada.courseplatform.component.data;

import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import ar.com.ada.courseplatform.model.repository.TypeOfCompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TypeOfCompanyLoaderData implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeOfCompanyLoaderData.class);

    @Autowired
    @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    @Value("${spring.application.env}")
    private String appEnv;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LOGGER.info("Environment: " + appEnv);

        if (appEnv.trim().equals("dev") || appEnv.trim().equals("qa")) {

            LOGGER.info("Loading Type Of Company initial data...");

            List<TypeOfCompany> typeOfCompanyList = Arrays.asList(
                    new TypeOfCompany("Sociedad Anónima"),
                    new TypeOfCompany("Sociedad de Responsabilidad Limitada"),
                    new TypeOfCompany("Sociedad por Acciones Simplificada")
            );

            typeOfCompanyList.forEach(typeOfCompany -> typeOfCompanyRepository.save(typeOfCompany));

        }
    }
}