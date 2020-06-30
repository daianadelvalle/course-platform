package ar.com.ada.courseplatform.service;

import ar.com.ada.courseplatform.model.dto.SocioEconomicStudyDTO;
import ar.com.ada.courseplatform.model.entity.SocioEconomicStudy;
import ar.com.ada.courseplatform.model.entity.Student;
import ar.com.ada.courseplatform.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.courseplatform.model.repository.SocioEconomicStudyRepository;
import ar.com.ada.courseplatform.model.repository.StudentRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SocioEconomicStudyServicesTest {

    @Mock
    private SocioEconomicStudyRepository socioEconomicStudyRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CycleAvoidingMappingContext context;

    @InjectMocks
    private SocioEconomicStudyServices socioEconomicStudyServices;

    @Test @Order(0)
    public void whenFindAllThenReturnSocioEconomicStudyList() {
        //GIVEN
        SocioEconomicStudy studyMock = new SocioEconomicStudy()
                .setId(1L)
                .setStudy(true)
                .setWork(true)
                .setIncomes(false);

        SocioEconomicStudy studyMock2 = new SocioEconomicStudy()
                .setId(1L)
                .setStudy(true)
                .setWork(true)
                .setIncomes(false);

        SocioEconomicStudy studyMock3 = new SocioEconomicStudy()
                .setId(1L)
                .setStudy(true)
                .setWork(true)
                .setIncomes(false);

        // Lista de entrega fake
        List<SocioEconomicStudy> socioEconomicStudyList = Arrays.asList(studyMock, studyMock2, studyMock3);

        when(socioEconomicStudyRepository.findAll()).thenReturn(socioEconomicStudyList);

        //WHEN
        List<SocioEconomicStudyDTO> socioEconomicStudyDTOList = socioEconomicStudyServices.findAll();

        //THEN
        assertThat(socioEconomicStudyDTOList.size()).isEqualTo(3);
        assertThat(socioEconomicStudyDTOList.get(0).getStudy()).isEqualTo(true);
        assertThat(socioEconomicStudyDTOList.get(0).getWork()).isEqualTo(true);
    }

    @Test @Order(1)
    public void whenSaveReturnProductDtoSaved() {
        //GIVEN
        Student student = new Student()
                .setId(1L)
                .setName("Valentín")
                .setLastName("Delvalle")
                .setGender("masculino")
                .setBirthdate(LocalDate.of(1993, 05, 17))
                .setAdress("disney 777, Florida");
        studentRepository.save(student);

        SocioEconomicStudy socioEconomicStudyMock = new SocioEconomicStudy()
                .setId(1L)
                .setStudy(true)
                .setWork(true)
                .setIncomes(false)
                .setStudent(student)
                ;
        when(socioEconomicStudyRepository.save(any(SocioEconomicStudy.class))).thenReturn(socioEconomicStudyMock);
        when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

        SocioEconomicStudyDTO dto = new SocioEconomicStudyDTO()
                .setId(1L)
                .setStudy(true)
                .setWork(true)
                .setIncomes(false)
                .setStudentId(1l)
                ;

        //WHEN
        SocioEconomicStudyDTO dtoSaved = socioEconomicStudyServices.save(dto);

        //THEN
        assertThat(dtoSaved.getId()).isEqualTo(1);
    }

}