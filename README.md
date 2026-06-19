[![Java CI with Gradle](https://github.com/AkshatGit-1/CodeAlpha_JavaGradleApp/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/AkshatGit-1/CodeAlpha_JavaGradleApp/actions/workflows/ci-cd.yml)

# 🚀 CodeAlpha Internship - Task 3
## Java Application using Gradle

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Gradle](https://img.shields.io/badge/Gradle-9.5.1-02303A?style=for-the-badge&logo=gradle)
![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions)
![Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)

---

## 📋 Project Overview

A **Student Management System** built with Java and automated 
using Gradle build tool. This project demonstrates core DevOps 
principles including automated builds, dependency management, 
and CI/CD pipeline integration using GitHub Actions.

---

## 🎯 Features

- ✅ Add and manage student records
- ✅ Calculate marks, percentage, and grades automatically
- ✅ Generate complete result sheets
- ✅ Identify class topper
- ✅ Track pass/fail status
- ✅ Subject-wise average calculation
- ✅ Individual report cards

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 (LTS) | Programming Language |
| Gradle | 9.5.1 | Build Automation |
| JUnit Jupiter | 5.10.0 | Unit Testing |
| GitHub Actions | Latest | CI/CD Pipeline |

---

## 📁 Project Structure

```text
CodeAlpha_JavaGradleApp/
│
├── .github/
│ └── workflows/
│ └── ci-cd.yml ← CI/CD Pipeline
│
├── src/
│ ├── main/java/org/example/
│ │ ├── App.java ← Main Entry Point
│ │ ├── Student.java ← Student Model
│ │ ├── StudentManager.java← Business Logic
│ │ └── ResultGenerator.java← Report Generation
│ │
│ └── test/java/org/example/
│ ├── StudentTest.java
│ └── StudentManagerTest.java
│
├── build.gradle ← Gradle Build Config
├── settings.gradle ← Project Settings
├── gradlew ← Gradle Wrapper
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Gradle 9.5.1 (or use wrapper)
- Git

### Clone the Repository
```bash
git clone https://github.com/YourUsername/CodeAlpha_JavaGradleApp.git
cd CodeAlpha_JavaGradleApp
```
---

## 🛠️ Custom Gradle Tasks
Below are the primary custom gradle tasks configured for managing this project:

| Task Name | Description | Command |
| :--- | :--- | :--- |
| `clean` | Deletes the build directory and resets compilation cache | `./gradlew clean` |
| `build` | Compiles source files, runs all checks, and packages the app | `./gradlew build` |
| `test` | Executes the JUnit unit testing suite locally | `./gradlew test` |

---

## 🚀 CI/CD Pipeline Explanation
This repository utilizes **GitHub Actions** to automate the integration and deployment flow:
1. **Build and Test Job**: Triggers automatically on any push or pull request to the `main` branch. It sets up a headless Ubuntu environment, loads the Java 22 Development Kit via Temurin, grants running permissions to the Gradle wrapper wrapper, executes standard verification routines, and generates target archives.
2. **Code Quality Check Job**: Performs structural static code parsing validation rules sequentially after dependencies verify successfully.
3. **Pipeline Status Report Job**: Aggregates final metadata outputs across preceding execution contexts to report the live green telemetry status back to the repository interface.

---

## 📊 Test Results
The following coverage validation matrix represents the compiled metrics evaluated natively inside the cloud build virtual instance:

| Test Suite | Total Assertions | Passed | Failed | Status |
| :--- | :--- | :--- | :--- | :--- |
| `StudentTest` | 3 | 3 | 0 | ✅ PASS |
| `StudentManagerTest` | 4 | 4 | 0 | ✅ PASS |

---

## 👨‍💻 Developer Info
* **Name:** Akshat Vishnoi
* **Role:** DevOps Intern
* **Organization:** CodeAlpha
* **Project:** Automated Student Management Application using Advanced Gradle Packaging Structures
