package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> findPatientsWithLessMoneySpendThan(int moneySpend);

    void deleteVisit(VisitEntity visitEntity);
    void deleteDoctor(DoctorEntity doctorEntity);

    List<PatientEntity> findPatientsByLastName(String lastName);

    List<VisitEntity> findVisitsByPatientId(Long patientId);

    List<PatientEntity> findPatientsWithMoreThanVisits(Long visitsCount);
}
