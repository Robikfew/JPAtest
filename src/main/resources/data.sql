INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
            VALUES (1, 'xx', 'yy', 'miasto', '62-030'),
                 (2, 'xx', 'yy', 'miasto', '62-030' );

-- Wstawianie danych do tabeli DOCTOR
INSERT INTO DOCTOR (id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
VALUES (1, 'Adam', 'D', '123456789', 'email@example.com', 'DR123', 'sfsf'),
       (2, 'Olga', 'S', '987654321', 'email@example.com', 'DR456', 'fsdf'),
       (3, 'Dawid', 'J', '555555555', 'email@example.com', 'DR789', 'ddfdf');

-- Wstawianie danych do tabeli PATIENT
INSERT INTO PATIENT (id, first_Name, last_Name, telephone_Number, email, patient_Number, date_Of_Birth, visits_Count)
VALUES (1, 'Julia', 'R', '987654321', 'email@example.com', 'P123', '1990-05-15', 2),
       (2, 'Martyna', 'B', '123456789', 'email@example.com', 'P456', '1985-08-20', 3),
       (3, 'Michal', 'L', '555555555', 'email@example.com', 'P789', '1976-12-10', 1);

-- Wstawianie danych do tabeli MEDICAL_TREATMENT
INSERT INTO MEDICAL_TREATMENT (id, description, type)
VALUES (1, 'Masaż', 'USG'),
       (2, 'Leczenie kanalowe', 'dentysta'),
       (3, 'Korekcja wzroku', 'okulista');

-- Wstawianie danych do tabeli VISIT
INSERT INTO VISIT (description, time, doctor_id, patient_id, medical_Treatment_id)
VALUES ('Zabieg', '2024-03-15 10:00:00', 1, 1, 1),
       ('Zabieg', '2024-03-16 14:00:00', 1, 2, 2),
       ('Operacja', '2024-03-17 11:00:00', 2, 3, 3);
