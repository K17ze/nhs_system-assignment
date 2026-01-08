#!/bin/bash
# Compilation script for NHS Healthcare Management System

echo "Compiling NHS Healthcare Management System..."

# Create build directories
mkdir -p build/classes

# Compile Java files
javac -d build/classes -encoding UTF-8 src/nhs/**/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    echo "To run the application:"
    echo "java -cp build/classes nhs.NHSApplication"
else
    echo "Compilation failed!"
    exit 1
fi
