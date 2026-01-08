# Project Structure

## Complete Directory Tree

```
nhs_system/
├── src/
│   └── nhs/
│       ├── controllers/          # Controller layer (MVC)
│       │   ├── AppointmentManagementController.java
│       │   ├── PatientManagementController.java
│       │   ├── PrescriptionManagementController.java
│       │   └── ReferralManagementController.java
│       ├── data/                 # CSV data files
│       │   ├── appointments.csv
│       │   ├── clinicians.csv
│       │   ├── facilities.csv
│       │   ├── patients.csv
│       │   ├── prescriptions.csv
│       │   ├── referrals.csv
│       │   └── staff.csv
│       ├── models/               # Model layer (MVC)
│       │   ├── AdministrativeStaff.java
│       │   ├── ClinicalReferral.java
│       │   ├── GeneralPractitioner.java
│       │   ├── HealthcareProvider.java
│       │   ├── MedicalAppointment.java
│       │   ├── MedicalFacility.java
│       │   ├── MedicationPrescription.java
│       │   ├── NursingStaff.java
│       │   ├── PatientRecord.java
│       │   ├── Person.java
│       │   ├── ReferralService.java (Singleton)
│       │   └── SpecialistConsultant.java
│       ├── utils/                # Utility classes
│       │   ├── CSVFileReader.java
│       │   ├── CSVFileWriter.java
│       │   └── DataFileManager.java
│       ├── views/                # View layer (MVC)
│       │   ├── ApplicationWindow.java
│       │   ├── AppointmentManagementView.java
│       │   ├── PatientManagementView.java
│       │   ├── PrescriptionManagementView.java
│       │   └── ReferralManagementView.java
│       └── NHSApplication.java   # Main entry point
├── build/                        # Build output (generated)
│   └── classes/
├── dist/                         # JAR files (generated)
├── test/                         # Test directory
│   └── README.md
├── .gitignore                    # Git ignore rules
├── build.xml                     # Ant build configuration
├── manifest.mf                   # JAR manifest
├── compile.bat                   # Windows compile script
├── compile.sh                    # Linux/Mac compile script
├── run.bat                       # Windows run script
├── run.sh                        # Linux/Mac run script
├── BUILD_INSTRUCTIONS.md         # Build instructions
├── PROJECT_STRUCTURE.md          # This file
├── PROJECT_SUMMARY.md            # Project summary
├── README.md                     # Main README
└── Reflective_Report.md          # Assignment report
```

## Package Structure

### nhs.models
- **Person**: Abstract base class for all system users
- **PatientRecord**: Patient entity (extends Person)
- **HealthcareProvider**: Base class for clinicians (extends Person)
- **GeneralPractitioner**: GP doctor (extends HealthcareProvider)
- **NursingStaff**: Nursing staff (extends HealthcareProvider)
- **SpecialistConsultant**: Specialist doctor (extends HealthcareProvider)
- **AdministrativeStaff**: Non-clinical staff (extends Person)
- **MedicalFacility**: Healthcare facility entity
- **MedicalAppointment**: Appointment entity
- **MedicationPrescription**: Prescription entity
- **ClinicalReferral**: Referral entity
- **ReferralService**: Singleton service for referral management

### nhs.controllers
- **PatientManagementController**: Manages patient operations
- **AppointmentManagementController**: Manages appointment operations
- **PrescriptionManagementController**: Manages prescription operations
- **ReferralManagementController**: Manages referral operations (uses Singleton)

### nhs.views
- **ApplicationWindow**: Main application frame
- **PatientManagementView**: Patient management GUI
- **AppointmentManagementView**: Appointment management GUI
- **PrescriptionManagementView**: Prescription management GUI
- **ReferralManagementView**: Referral management GUI

### nhs.utils
- **CSVFileReader**: Reads CSV data files
- **CSVFileWriter**: Writes data to CSV files
- **DataFileManager**: Centralized file path management

## Design Patterns

1. **MVC (Model-View-Controller)**: Clear separation across three layers
2. **Singleton**: Implemented in `ReferralService` class
3. **Inheritance**: Person → PatientRecord, HealthcareProvider, AdministrativeStaff
4. **Composition**: Controllers contain model instances

## File Counts

- **Java Source Files**: 25 files
- **CSV Data Files**: 7 files
- **Build Files**: 4 files (build.xml, manifest.mf, compile scripts)
- **Documentation**: 6 markdown files

## Total Project Files: 42+ files
