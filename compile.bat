@echo off
echo Compiling NHS Healthcare Management System...
if not exist build mkdir build
if not exist build\classes mkdir build\classes

javac -d build\classes -encoding UTF-8 src\nhs\**\*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo To run the application:
    echo java -cp build\classes nhs.NHSApplication
) else (
    echo Compilation failed!
    pause
    exit /b 1
)

pause
