package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given: pacjent znajduje się w bazie danych

        // when:
        PatientTO patientTO = patientService.findById(1L);

        // then:
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo("Julia");
        assertThat(patientTO.getLastName()).isEqualTo("R");
        assertThat(patientTO.getDateOfBirth()).isEqualTo(LocalDate.of(1990, 5, 15));
        assertThat(patientTO.getEmail()).isEqualTo("email@example.com");
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("987654321");
        assertThat(patientTO.getPatientNumber()).isEqualTo("P123");
        assertThat(patientTO.getVisitsCount()).isNotNull();
        assertThat(patientTO.getMoneySpend()).isNotNull();
    }

    @Transactional
    @Test
    public void testShouldDeletePatientAndVisitsButNotDoctors() {
        // given:
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Jan");
        patientEntity.setLastName("Kowalski");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity.setPatientNumber("P432");
        patientEntity.setVisitsCount(2L);


        List<VisitEntity> visits = new ArrayList<>();
        VisitEntity visit1 = new VisitEntity();
        VisitEntity visit2 = new VisitEntity();
        visits.add(visit1);
        visits.add(visit2);
        patientEntity.setVisits(visits);

        Long patientId = patientDao.save(patientEntity).getId();

        // when:
        patientService.deletePatient(patientId);

        // then:
        assertThat(patientDao.findOne(patientId)).isNull(); // pacjent został usunięty
        assertThat(patientDao.findVisitsByPatientId(patientId)).isEmpty(); // wizyty zostały usunięte
        //doktorzy nie zostali usunięci
    }
}
