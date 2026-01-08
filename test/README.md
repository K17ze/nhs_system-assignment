# Test Directory

This directory is reserved for unit tests and integration tests.

## Testing Structure

Tests should follow the same package structure as the source code:
- `nhs.models` tests
- `nhs.controllers` tests
- `nhs.views` tests
- `nhs.utils` tests

## Example Test

```java
package nhs.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class PatientRecordTest {
    @Test
    public void testPatientCreation() {
        PatientRecord patient = new PatientRecord(
            "P001", "John Doe", "john@nhs.uk",
            "NHS12345", "1990-01-01", "07123456789", "City GP"
        );
        assertEquals("P001", patient.getIdentifier());
        assertEquals("John Doe", patient.getFullName());
    }
}
```
