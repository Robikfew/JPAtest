package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class DoctorMapper {

    public static DoctorTO mapToTO(DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        doctorTO.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));

        // Mapowanie wizyt
        List<VisitTO> visitTOList = new ArrayList<>();
        if (doctorEntity.getVisits() != null) {
            for (VisitEntity visitEntity : doctorEntity.getVisits()) {
                visitTOList.add(VisitMapper.mapToTO(visitEntity));
            }
        }
        doctorTO.setVisits(visitTOList);

        return doctorTO;
    }


    public static DoctorEntity mapToEntity(DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        doctorEntity.setAddress(AddressMapper.mapToEntity(doctorTO.getAddress()));

        // Mapowanie wizyt
        List<VisitEntity> visitEntityList = new ArrayList<>();
        if (doctorTO.getVisits() != null) {
            for (VisitTO visitTO : doctorTO.getVisits()) {
                visitEntityList.add(VisitMapper.mapToEntity(visitTO));
            }
        }
        doctorEntity.setVisits(visitEntityList);

        return doctorEntity;
    }
}
