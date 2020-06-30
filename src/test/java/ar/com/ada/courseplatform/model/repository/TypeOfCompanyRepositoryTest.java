package ar.com.ada.courseplatform.model.repository;

import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeOfCompanyRepositoryTest {

    @Autowired
    @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    @Test
    @Order(0)
    public void whenSaveThenReturnAnTypeOfCompanyWithId() {
        //GIVEN
        TypeOfCompany typeOfCompany = new TypeOfCompany()
                .setCategory("IT");
        //WHEN
        TypeOfCompany saved = typeOfCompanyRepository.save(typeOfCompany);

        //THEN
        assertNotNull(saved.getId());
        assertNotNull(saved.getCategory());
    }

    @Test
    @Order(1)
    public void whenFindByIdThenReturnTypeOfCompany() {
        //GIVEN

        TypeOfCompany typeOfCompany = new TypeOfCompany().setCategory("TI");
        typeOfCompanyRepository.save(typeOfCompany);

        //WHEN
        Optional<TypeOfCompany> byId = typeOfCompanyRepository.findById(1L);

        //THEN
        assertEquals(true, byId.isPresent());
        assertEquals(2L, typeOfCompany.getId());
    }

    @Test @Order(2)
    public void whenFindAllThenReturnTypeOfCompanyList() {
        //GIVEN
        List<TypeOfCompany> typeOfCompanyList = Arrays.asList(
                new TypeOfCompany().
                        setCategory("TI"),
                new TypeOfCompany()
                .setCategory("Software"));
        typeOfCompanyRepository.saveAll(typeOfCompanyList);
        //WHEN
        List<TypeOfCompany> productList = typeOfCompanyRepository.findAll();

        //THEN
        assertThat(productList).hasSize(4);
    }

}