package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);
        if (patientEntity == null) {
            throw new EntityNotFoundException(id);
        }
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    public void deletePatient(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);

        if (patientEntity != null) {
            List<VisitEntity> visits = patientEntity.getVisits();
            for (VisitEntity visit : visits) {
                patientDao.deleteVisit(visit);
            }
            patientDao.delete(id);
        } else {
            throw new EntityNotFoundException(id);
        }
    }
}
