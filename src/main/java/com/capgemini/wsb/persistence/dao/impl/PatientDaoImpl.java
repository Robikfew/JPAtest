package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientEntity> findPatientsByLastName(String lastName) {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        Query query = entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanVisits(Long visitsCount) {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p JOIN FETCH p.visits v GROUP BY p.id, v.id HAVING COUNT(v) > :visitsCount");
        query.setParameter("visitsCount", visitsCount);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithLessMoneySpendThan(int moneySpend) {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.moneySpend < :moneySpend");
        query.setParameter("moneySpend", moneySpend);
        return query.getResultList();
    }


    @Override
    public void deleteVisit(VisitEntity visitEntity) {
        entityManager.remove(visitEntity);
    }

    @Override
    public void deleteDoctor(DoctorEntity doctorEntity) {
        entityManager.remove(doctorEntity);
    }
}
