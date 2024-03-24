package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientDao patientDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeletingPatientShouldDeleteAssociatedVisits() {
        // given
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);

        // Symulowane wizyty
        List<VisitEntity> visits = new ArrayList<>();
        VisitEntity visit1 = new VisitEntity();
        visit1.setId(1L);
        visits.add(visit1);
        VisitEntity visit2 = new VisitEntity();
        visit2.setId(2L);
        visits.add(visit2);
        patientEntity.setVisits(visits);

        when(patientDao.findOne(patientId)).thenReturn(patientEntity);

        // when
        patientService.deletePatient(patientId);

        // then
        verify(patientDao, times(1)).delete(patientId);

        for (VisitEntity visit : visits) {
            verify(patientDao, times(1)).deleteVisit(visit);
        }

        verify(patientDao, never()).deleteDoctor(any());
    }

    @Test
    public void testFindingPatientByIdShouldReturnPatientTO() {
        // given
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        patientEntity.setFirstName("Julia");
        patientEntity.setLastName("R");

        when(patientDao.findOne(patientId)).thenReturn(patientEntity);

        // when
        PatientTO result = patientService.findById(patientId);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(patientId);
        assertThat(result.getFirstName()).isEqualTo("Julia");
        assertThat(result.getLastName()).isEqualTo("R");
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindingNonExistingPatientByIdShouldThrowEntityNotFoundException() {
        // given
        Long patientId = 1L;

        when(patientDao.findOne(patientId)).thenReturn(null);

        // when
        patientService.findById(patientId);

        // then
        // Wywolanie EntityNotFoundException
    }
}
