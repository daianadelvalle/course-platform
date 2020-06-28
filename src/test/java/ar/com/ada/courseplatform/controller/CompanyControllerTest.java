package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.entity.Company;
import ar.com.ada.courseplatform.model.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Test
    public void shouldBeCreatedANewCompany() {
        //GIVEN
        String url = "http://localhost:" + port + "/companies";
        List<Company> companyList = Arrays.asList(
                new Company()
                        .setName("Ada")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993)),
                new Company()
                        .setName("Google")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993)),
                new Company()
                        .setName("Facebook")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993))
        );
        companyRepository.saveAll(companyList);
//        HttpHeaders httpHeaders = new HttpHeaders();
        //WHEN
        ResponseEntity<List<CompanyDTO>> response = testRestTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CompanyDTO>>() {}
        );
        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(3);
    }


}