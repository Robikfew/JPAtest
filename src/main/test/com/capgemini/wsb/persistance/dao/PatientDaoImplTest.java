package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoImplTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    @Transactional
    public void testFindPatientsByLastName() {
        // given
        String lastName = "R";

        // when
        List<PatientEntity> patients = patientDao.findPatientsByLastName(lastName);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).hasSize(1);
    }

    @Test
    @Transactional
    public void testFindVisitsByPatientId() {
        // given
        Long patientId = 1L;

        // when
        List<VisitEntity> visits = patientDao.findVisitsByPatientId(patientId);

        // then
        assertThat(visits).isNotNull();
        assertThat(visits).hasSize(2);
    }

    @Test
    @Transactional
    public void testFindPatientsWithMoreThanVisits() {
        // given
        int visitsCount = 1; // Looking for patients with more than 2 visits

        // when
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanVisits(visitsCount);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).hasSize(1); // Assuming there is one patient with more than 2 visits
    }

    @Transactional
    @Test
    public void testFindPatientsWithLessMoneySpendThan() {
        // given
        int moneySpend = 222;

        // when
        List<PatientEntity> patients = patientDao.findPatientsWithLessMoneySpendThan(moneySpend);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).isNotEmpty();
        for (PatientEntity patient : patients) {
            assertThat(patient.getMoneySpend()).isLessThan(moneySpend);
        }
    }
}
