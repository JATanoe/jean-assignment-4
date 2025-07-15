# Student Course Report Generator

## Overview
This Java application processes student data from a master CSV file and generates course-specific reports. It filters students by course department (APMTH, STAT, COMPSCI), sorts them by grade in descending order (and by name alphabetically if grades are equal), and outputs the results to separate CSV files.

## Features
- Reads student data from a master CSV file
- Filters students by course department
- Sorts students by grade (descending) and name (alphabetical when grades are equal)
- Generates separate CSV reports for each course department
- Implements clean separation of concerns with service classes and interfaces

## Project Structure
```
├── course1.csv                   # Generated report for APMTH courses
├── course2.csv                   # Generated report for STAT courses
├── course3.csv                   # Generated report for COMPSCI courses
├── student-master-list.csv       # Master list of all student data
└── src
    └── com
        └── coderscampus
            ├── Main.java         # Application entry point
            ├── file
            │   ├── FileService.java  # Handles file I/O operations
            │   └── Fileable.java     # Interface for file operations
            └── student
                ├── ReportService.java    # Generates course reports
                ├── Student.java          # Student data model
                └── StudentService.java   # Processes student data
```

## Data Format
### Input (student-master-list.csv)
The master list contains student records with the following columns:
- Student ID: Unique identifier for each student
- Student Name: Full name of the student
- Course: Course code (department and number, e.g., "COMPSCI 321")
- Grade: Numeric grade (0-100)

### Output (course1.csv, course2.csv, course3.csv)
The generated reports maintain the same column structure but contain only students from the specific department, sorted by grade in descending order.

## How to Run
1. Ensure you have Java installed on your system
2. Compile the Java files:
   ```
   javac src/com/coderscampus/Main.java src/com/coderscampus/file/*.java src/com/coderscampus/student/*.java
   ```
3. Run the application:
   ```
   java -cp src com.coderscampus.Main
   ```
4. The application will generate three CSV files:
   - course1.csv (APMTH courses)
   - course2.csv (STAT courses)
   - course3.csv (COMPSCI courses)

## Implementation Details
- **Main.java**: Entry point that initializes services and triggers report generation
- **Student.java**: Data model implementing Comparable for sorting
- **FileService.java**: Handles reading from the master list and writing to report files
- **StudentService.java**: Processes student data, including filtering by course and sorting
- **ReportService.java**: Coordinates the generation of course-specific reports
- **Fileable.java**: Interface defining the contract for file operations