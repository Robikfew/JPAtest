package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public interface PatientDao extends Dao<PatientEntity, Long> {
    void deleteVisit(VisitEntity visitEntity);
    void deleteDoctor(DoctorEntity doctorEntity);
}
