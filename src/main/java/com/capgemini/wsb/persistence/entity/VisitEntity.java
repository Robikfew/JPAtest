package com.capgemini.wsb.persistence.entity;

import javafx.print.Collation;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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

    // Relacja jednostronna z encją MedicalTreatmentEntity - wiele leczeń może być przypisanych do jednej wizyty
    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL)
    private List<MedicalTreatmentEntity> medicalTreatments; // Relacja jednostronna od strony dziecka

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

    public List<MedicalTreatmentEntity> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }

}
