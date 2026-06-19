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