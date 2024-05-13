INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
            VALUES (1, 'xx', 'Apart. 213', 'miasto', '62-030'),
                 (2, 'xx', 'Apart. 43', 'miasto', '62-039' ),
                 (3, 'df', 'Apart. 3', 'miasto', '543-34'),
                 (4, 'xx', 'Apart. 55', 'miasto', '62-037' ),
                 (5, 'df', 'Apart. 2', 'miasto', '543-34');

-- Wstawianie danych do tabeli DOCTOR
INSERT INTO DOCTOR (id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization, address_id)
VALUES (1, 'Adam', 'D', '123456789', 'email@example.com', 'DR123', 'SURGEON', 1),
       (2, 'Olga', 'S', '987654321', 'email@example.com', 'DR456', 'GP', 2),
       (3, 'Dawid', 'J', '555555555', 'email@example.com', 'DR789', 'DERMATOLOGIST', 3);

-- Wstawianie danych do tabeli PATIENT
INSERT INTO PATIENT (id, first_Name, last_Name, telephone_Number, email, patient_Number, date_Of_Birth,money_Spend, visits_Count, address_id)
VALUES (1, 'Julia', 'R', '987654321', 'email@example.com', 'P123', '1990-05-15',777, 2, 4),
       (2, 'Martyna', 'K', '123456789', 'email@example.com', 'P456', '1985-08-20',555, 1, 5),
       (3, 'Michal', 'L', '555555555', 'email@example.com', 'P789', '1976-12-10',123, 1, null);

-- Wstawianie danych do tabeli VISIT
INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES (1, 'Zabieg', '2024-03-15 10:00:00', 2, 3),
       (2, 'Zabieg', '2024-03-16 14:00:00', 3, 1),
       (3, 'Zabieg', '2024-03-18 14:00:00', 3, 2),
       (4, 'Operacja', '2024-03-17 11:00:00', 1, 1);

-- Wstawianie danych do tabeli MEDICAL_TREATMENT
INSERT INTO MEDICAL_TREATMENT (id, description, type, visit_id)
VALUES (1, 'Masaż', 'USG', 1),
       (2, 'Leczenie kanalowe', 'EKG', 2),
       (3, 'Leczenie kanalowe', 'EKG', 4),
       (4, 'Korekcja wzroku', 'RTG', 3);


