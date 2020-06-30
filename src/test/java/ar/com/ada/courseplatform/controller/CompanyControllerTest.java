package ar.com.ada.courseplatform.controller;

import ar.com.ada.courseplatform.model.dto.CompanyDTO;
import ar.com.ada.courseplatform.model.dto.ManagerDTO;
import ar.com.ada.courseplatform.model.dto.security.JwtAuthResponseBody;
import ar.com.ada.courseplatform.model.dto.security.JwtRequestBody;
import ar.com.ada.courseplatform.model.entity.Company;
import ar.com.ada.courseplatform.model.entity.Manager;
import ar.com.ada.courseplatform.model.entity.TypeOfCompany;
import ar.com.ada.courseplatform.model.repository.CompanyRepository;
import ar.com.ada.courseplatform.model.repository.ManagerRepository;
import ar.com.ada.courseplatform.model.repository.TypeOfCompanyRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired
    @Qualifier("managerRepository")
    private ManagerRepository managerRepository;

    @Autowired
    @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    @Test @Order(0)
    public void shouldBeGetListToCompanies() {
        //GIVEN
        String url = "http://localhost:" + port + "/companies";
        List<Company> companyList = Arrays.asList(
                new Company()
                        .setName("Ada")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setPhone(1554178231)
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993)),
                new Company()
                        .setName("Google")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setPhone(1554178231)
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993)),
                new Company()
                        .setName("Facebook")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setPhone(1554178231)
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993))
        );
        companyRepository.saveAll(companyList);
//        HttpHeaders httpHeaders = new HttpHeaders();

        //WHEN
        ResponseEntity<List<CompanyDTO>> response = testRestTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CompanyDTO>>() {
                }
        );
        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(3);
    }

    @Test @Order(1)
    public void shouldBeCreatedANewCompany() {
        // GIVEN
        String token = this.getAuthToken("admin");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        TypeOfCompany saTypeCompany = new TypeOfCompany().setCategory("SA");
        typeOfCompanyRepository.save(saTypeCompany);
        String urlTest = "http://localhost:" + port + "/companies";
        CompanyDTO newCompany = new CompanyDTO()
                .setName("Ada")
                .setCuil(37895697L)
                .setPhone(1554178231)
                .setAdress("alvarez")
                .setCategory("IT")
                .setFoundationYear(Year.of(1993))
                .setTypeOfCompanyId(1l);
        HttpEntity<CompanyDTO> reqBodyTest = new HttpEntity<>(newCompany, httpHeaders);
        // WHEN
        ResponseEntity<CompanyDTO> response = testRestTemplate.exchange(
                urlTest, HttpMethod.POST, reqBodyTest, new ParameterizedTypeReference<CompanyDTO>() {
                }
        );
        // THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isEqualTo(4);
    }

    @Test @Order(2)
    public void shouldGetToCompanyById() {
        //GIVEN
        String url = "http://localhost:" + port + "/companies/1";
        Company company =
                new Company()
                        .setName("Ada")
                        .setAdress("alvarez")
                        .setCategory("IT")
                        .setPhone(1554178231)
                        .setCuil(37895697L)
                        .setFoundationYear(Year.of(1993));
        companyRepository.save(company);
//        HttpHeaders httpHeaders = new HttpHeaders();

        //WHEN
        ResponseEntity<CompanyDTO> response = testRestTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<CompanyDTO>() {
                }
        );
        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(1);
    }
    private String getAuthToken(String role) {
        String urlToken = "http://localhost:" + port + "/login";
        JwtRequestBody jwtRequestBody = new JwtRequestBody().setUsername(role).setPassword(role);
        HttpEntity<JwtRequestBody> reqBodyToken = new HttpEntity<>(jwtRequestBody);
        ResponseEntity<JwtAuthResponseBody> resToken = testRestTemplate.exchange(
                urlToken, HttpMethod.POST, reqBodyToken, new ParameterizedTypeReference<JwtAuthResponseBody>() {
                }
        );
        return resToken.getBody().getToken();
    }

    @Test @Order(3)
    public void shouldBeCreatedANewManager() {
        // GIVEN
        String token = this.getAuthToken("admin");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        TypeOfCompany saTypeCompany = new TypeOfCompany().setCategory("SA");
        typeOfCompanyRepository.save(saTypeCompany);
        Company company = new Company()
                .setName("Ada")
                .setCuil(37895697L)
                .setPhone(1554178231)
                .setAdress("alvarez")
                .setCategory("IT")
                .setFoundationYear(Year.of(1993)
                );
        companyRepository.save(company);
        String urlTest = "http://localhost:" + port + "/managers";
        ManagerDTO newManager = new ManagerDTO()
                .setName("Carla")
                .setLastName("Gonzalez")
                .setIdentificationType("DNI")
                .setIdentification(1554178231)
                .setPosition("Gerente")
                .setEmail("carla@perez.com")
                .setCompanyId(1L);
        HttpEntity<ManagerDTO> reqBodyTest = new HttpEntity<>(newManager, httpHeaders);
        // WHEN
        ResponseEntity<ManagerDTO> response = testRestTemplate.exchange(
                urlTest, HttpMethod.POST, reqBodyTest, new ParameterizedTypeReference<ManagerDTO>() {
                }
        );
        // THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getId()).isEqualTo(1);
    }

    @Test @Order(4)
    public void shouldGetToManagerById() {
        //GIVEN
        String url = "http://localhost:" + port + "/managers/1";
        Manager manager =
                new Manager()
                        .setName("Carla")
                        .setLastName("Gonzalez")
                        .setIdentificationType("DNI")
                        .setIdentification(1554178231)
                        .setPosition("Gerente")
                        .setEmail("carla@perez.com");
        managerRepository.save(manager);
//        HttpHeaders httpHeaders = new HttpHeaders();

        //WHEN
        ResponseEntity<ManagerDTO> response = testRestTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<ManagerDTO>() {
                }
        );
        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(1);
    }

    @Test @Order(5)
    public void shouldBeGetListToManagers() {
        //GIVEN
        String url = "http://localhost:" + port + "/managers";
        List<Manager> managerList = Arrays.asList(
                new Manager()
                        .setName("Carla")
                        .setLastName("Gonzalez")
                        .setIdentificationType("DNI")
                        .setIdentification(1554178231)
                        .setPosition("Gerente")
                        .setEmail("carla@perez.com"),
                new Manager()
                        .setName("Carla")
                        .setLastName("Gonzalez")
                        .setIdentificationType("DNI")
                        .setIdentification(1554178231)
                        .setPosition("Gerente")
                        .setEmail("carla@perez.com"),
                new Manager()
                        .setName("Carla")
                        .setLastName("Gonzalez")
                        .setIdentificationType("DNI")
                        .setIdentification(1554178231)
                        .setPosition("Gerente")
                        .setEmail("carla@perez.com")
        );
        managerRepository.saveAll(managerList);
//        HttpHeaders httpHeaders = new HttpHeaders();

        //WHEN
        ResponseEntity<List<ManagerDTO>> response = testRestTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ManagerDTO>>() {
                }
        );
        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(5);
    }






}