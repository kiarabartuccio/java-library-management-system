# Java Library Management System

A desktop library-management application built with Java Swing and Maven. The project uses object-oriented design to manage printed books and eBooks through a graphical interface.

## Features

- Add printed books and eBooks
- Remove books from the collection
- Search by title or author
- Display the complete library
- Save and load records using serialization
- Export library information in CSV format
- Separate models for physical and digital books

## Technologies and concepts

- Java 22
- Swing GUI
- Maven
- Interfaces and inheritance
- Singleton pattern
- File I/O, CSV, and object serialization

## Run the project

### NetBeans

1. Clone or download the repository.
2. Open the folder as a Maven project in NetBeans.
3. Run `LibraryManagementSystem.java`.

### Command line

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.mycompany.libraryoperations.LibraryManagementSystem"
```

## Main structure

- `Book`, `PrintedBook`, and `EBook` define the data model.
- `Library` manages the collection and persistence operations.
- `LibraryManagementSystem` launches the application.
- `com.Project.FinalProject` contains the Swing screens.

## Learning outcomes

This project applies inheritance, interfaces, polymorphism, the Singleton pattern, collections, persistence, and event-driven GUI programming in one complete Java application.

## Author

Kiara Bartuccio — Computer Technology student at Vanier College.
