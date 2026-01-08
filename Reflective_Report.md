# Reflective Report: NHS Healthcare Management System Implementation

## Introduction

This report reflects on the implementation of the NHS Healthcare Management System, discussing how the design models from Part 1 have been realised in the Java implementation, and how the Model-View-Controller (MVC) architectural pattern has been applied to structure the application.

## Realisation of Design Models

The implementation successfully translates the class diagram and use case models from Part 1 into working Java code. The key domain classes identified in the design phase - Patient, Appointment, Prescription, and Referral - have been implemented as `PatientRecord`, `MedicalAppointment`, `MedicationPrescription`, and `ClinicalReferral` respectively. These classes encapsulate the attributes and behaviours defined in the original design, maintaining the relationships and associations specified in the class diagram.

The inheritance relationship from the design, where Patient extends User, has been implemented as `PatientRecord` extending `Person`, preserving the abstraction of common user attributes. The associations between classes, such as appointments linking patients to clinicians, have been maintained through identifier references, allowing the system to establish relationships without tight coupling.

## MVC Pattern Implementation

The application has been structured using the three-tier MVC architecture, clearly separating concerns across three distinct layers:

**Model Layer (`nhs.models`)**: This layer contains all domain entities and business logic. Classes such as `PatientRecord`, `MedicalAppointment`, `MedicationPrescription`, and `ClinicalReferral` represent the core data structures. The `ReferralService` class implements the Singleton pattern, ensuring a single instance manages all referral operations, preventing data inconsistencies and maintaining system integrity.

**View Layer (`nhs.views`)**: The view components are responsible for user interface presentation. Classes like `PatientManagementView`, `AppointmentManagementView`, `PrescriptionManagementView`, and `ReferralManagementView` handle all GUI interactions. The `ApplicationWindow` class serves as the main container, using a tabbed interface to organise different system modules. The views are designed to be passive, displaying data and capturing user input without containing business logic.

**Controller Layer (`nhs.controllers`)**: Controllers act as intermediaries between views and models. The `PatientManagementController`, `AppointmentManagementController`, `PrescriptionManagementController`, and `ReferralManagementController` classes handle all business operations. They process user requests from views, interact with model objects, and coordinate data persistence. This separation ensures that views remain independent of model implementation details, and models remain independent of presentation logic.

## Singleton Pattern Application

The Singleton pattern has been implemented in the `ReferralService` class to manage referral operations. This ensures that only one instance of the referral service exists throughout the application lifecycle, preventing duplicate referral processing and maintaining data consistency. The implementation uses double-checked locking for thread safety, ensuring the singleton instance is created correctly in multi-threaded environments. The controller layer accesses this singleton through the `ReferralManagementController`, demonstrating proper separation of concerns while utilising the pattern effectively.

## Data Persistence

The system uses CSV files for data persistence, with utility classes `CSVFileReader` and `CSVFileWriter` handling file operations. The controllers coordinate with these utilities to load initial data and persist new records. When prescriptions or referrals are created, they are automatically written to their respective CSV files, ensuring data persistence across application sessions.

## Conclusion

The implementation successfully realises the design models from Part 1, maintaining the class structure, relationships, and behaviours specified in the original design. The MVC pattern has been consistently applied throughout the application, providing clear separation of concerns and making the codebase maintainable and extensible. The Singleton pattern implementation for referral management ensures system consistency, and the overall architecture supports the requirements of a healthcare management system effectively.
