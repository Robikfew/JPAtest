package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface PatientMapper {
    static PatientTO mapToTO(PatientEntity entity) {
        PatientTO patientTO = new PatientTO();
        patientTO.setId(entity.getId());
        patientTO.setFirstName(entity.getFirstName());
        patientTO.setLastName(entity.getLastName());
        return patientTO;
    }
}
