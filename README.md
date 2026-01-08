# NHS Healthcare Management System

## Project Overview

This is a Java-based healthcare management system implementing the Model-View-Controller (MVC) architectural pattern. The system manages patient records, appointments, prescriptions, and clinical referrals for NHS healthcare facilities.

## Project Structure

```
nhs_system/
├── src/
│   └── nhs/
│       ├── models/          # Model layer - domain entities
│       ├── views/           # View layer - GUI components
│       ├── controllers/     # Controller layer - business logic
│       ├── utils/           # Utility classes for file operations
│       ├── data/            # CSV data files
│       └── NHSApplication.java  # Main entry point
├── Reflective_Report.md    # Implementation reflection report
└── README.md               # This file
```

## Key Features

- **Patient Management**: Create, view, and manage patient records
- **Appointment Scheduling**: Manage medical appointments
- **Prescription Management**: Issue and track medication prescriptions
- **Referral System**: Create and manage clinical referrals using Singleton pattern

## Design Patterns Used

1. **MVC (Model-View-Controller)**: Clear separation of concerns across three layers
2. **Singleton Pattern**: Implemented in `ReferralService` for referral management

## Compilation and Execution

1. Ensure all CSV data files are in `src/nhs/data/` directory
2. Compile all Java files:
   ```bash
   javac -d build src/nhs/**/*.java
   ```
3. Run the application:
   ```bash
   java -cp build nhs.NHSApplication
   ```

## Requirements Met

✅ MVC architectural pattern implementation
✅ Singleton pattern for referral management
✅ CSV file loading and data persistence
✅ GUI using Java Swing
✅ CRUD operations for all entities
✅ File I/O for prescriptions and referrals

## Author

This implementation is an original work created for the healthcare management system assignment.
