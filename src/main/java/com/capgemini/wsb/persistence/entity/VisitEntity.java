package com.capgemini.wsb.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime time;

    // Relacja z encją DoctorEntity - wiele wizyt może być przypisanych do jednego lekarza
    @ManyToOne
    private DoctorEntity doctor;

    // Relacja z encją PatientEntity - wiele wizyt może być przypisanych do jednego pacjenta
    @ManyToOne
    private PatientEntity patient;

    // Relacja z encją MedicalTreatmentEntity - jedna wizyta może być przypisana do jednego leczenia
    @ManyToOne
    private MedicalTreatmentEntity medicalTreatment;

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public MedicalTreatmentEntity getMedicalTreatment() {
        return medicalTreatment;
    }

    public void setMedicalTreatment(MedicalTreatmentEntity medicalTreatment) {
        this.medicalTreatment = medicalTreatment;
    }
}
