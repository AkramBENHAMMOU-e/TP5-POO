# Professor and Department Management System

## Overview
A comprehensive JavaFX application for managing professors and departments in an educational institution, demonstrating object-oriented programming, database connectivity, and modern Java UI development.

## Features
- Full CRUD operations for Professors
- Full CRUD operations for Departments
- Search functionality
- Department assignment for professors
- Intuitive graphical user interface

## Screenshots
![Professeurs](screenshots/Prof.png)

![Ajouter professeurs](screenshots/AjoutProf.png)

![Modifier professeur](screenshots/ModifProf.png)

![Supprimer professeur](screenshots/SuppProf.png)

![Affecter un professeur](screenshots/AffectProf.png)

![Department](screenshots/depart.png)

## Class diagram
![Department](screenshots/classDiag.png)
## System Architecture

### Models
#### Professeur 
- `id`: Unique identifier
- `nom`: Last name
- `prenom`: First name
- `cin`: National ID
- `adresse`: Address
- `email`: Email address
- `telephone`: Phone number
- `dateRecrutement`: Recruitment date
- `departementId`: Department association

#### Departement 
- `id`: Unique identifier
- `nom`: Department name

### Business Logic Interface (`IMetier`)
#### Professor Operations
- Retrieve all professors
- Search professors
- Add professor
- Delete professor
- Update professor details

#### Department Operations
- Add department
- Retrieve all departments
- Delete department
- Update department details
- Retrieve professors by department

## Technical Components

### Database Connectivity
- Singleton database connection pattern
- MySQL database backend
- JDBC for database operations

### User Interface
- JavaFX framework
- FXML for UI design
- Modular controller architecture

## Project Structure
```
professor-management/
│
├── src/
│   ├── main/
│       ├── java/
│       │   ├── models/
│       │   │   ├── Professeur.java
│       │   │   └── Departement.java
│       │   │
│       │   ├── dao/
│       │   │   ├── IMetier.java
│       │   │   └── MetierImpl.java
│       │   │
│       │   ├── connectionDB/
│       │   │   └── SingletonConnexionDB.java
│       │   │
│       │   ├── controlleur/
│       │   │   ├── MainController.java
│       │   │   ├── ProfesseurController.java
│       │   │   └── DepartementController.java
│       │   │
│       │   └── helloApplication.java
│       │       
│       │
│       └── resources/
│           ├── fxml/
│               ├── Main.fxml
│               ├── ProfesseurSection.fxml
│               └── departementSection.fxml
│          
│   
│   
│      
│           
│
├── database/
│   └── schema.sql
│
├── screenshots/
│   └── ... (application screenshots)
│
├── pom.xml
└── README.md
```

## Requirements
- Java 11+
- JavaFX SDK
- MySQL 8.0+
- Maven or Gradle

## Database Setup
```sql
CREATE DATABASE professor_management;
USE professor_management;

CREATE TABLE Departement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE Professeur (
    id_prof INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    cin VARCHAR(20) UNIQUE,
    adresse VARCHAR(255),
    email VARCHAR(100),
    telephone VARCHAR(20),
    date_recrutement DATE,
    departement_id INT,
    FOREIGN KEY (departement_id) REFERENCES Departement(id)
);
```

## Configuration
1. Clone the repository
2. Configure database connection in `SingletonConnexionDB.java`
3. Install dependencies
4. Run database migration scripts

## Running the Application
```bash
# Build the project
mvn clean install

# Run JavaFX application
mvn javafx:run
```

## Key Technologies
- Java 11+
- JavaFX
- JDBC
- MySQL
- Maven/Gradle
- FXML
- Singleton Pattern

## Potential Improvements
- Add authentication
- Implement advanced search and filtering
- Generate reports
- Add data export functionality
