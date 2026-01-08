# Build Instructions

## Prerequisites

- Java JDK 8 or higher
- Apache Ant (optional, for using build.xml)

## Building the Project

### Method 1: Using Ant (Recommended)

1. Ensure Apache Ant is installed
2. Open terminal/command prompt in the project root
3. Run: `ant build`
4. The JAR file will be created in `dist/NHSHealthcareSystem.jar`
5. Run with: `ant run` or `ant run-jar`

### Method 2: Using Command Line

#### Windows:
```batch
compile.bat
run.bat
```

#### Linux/Mac:
```bash
chmod +x compile.sh run.sh
./compile.sh
./run.sh
```

### Method 3: Manual Compilation

```bash
# Create build directory
mkdir -p build/classes

# Compile
javac -d build/classes -encoding UTF-8 src/nhs/**/*.java

# Run
java -cp build/classes nhs.NHSApplication
```

## Project Structure

```
nhs_system/
├── src/              # Source code
├── build/            # Compiled classes (generated)
├── dist/             # JAR files (generated)
├── test/             # Test files
├── build.xml         # Ant build file
└── manifest.mf       # JAR manifest
```

## Running the Application

After compilation, run:
```bash
java -cp build/classes nhs.NHSApplication
```

Or use the generated JAR:
```bash
java -jar dist/NHSHealthcareSystem.jar
```

## Troubleshooting

- **ClassNotFoundException**: Ensure all source files are compiled and in the classpath
- **FileNotFoundException**: Check that CSV data files are in `src/nhs/data/` directory
- **Encoding issues**: Use UTF-8 encoding when compiling
