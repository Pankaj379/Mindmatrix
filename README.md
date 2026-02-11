# Mindmatrix Automation Framework 🔧🚀

## Overview
This project contains a Hybrid Test Automation Framework developed for testing an enterprise PRM (Partner Relationship Management) platform.

The goal of the framework is to provide scalable, maintainable, and reliable automation for UI and functional workflows while reducing manual regression effort and improving release confidence.

The framework was designed to simulate real production testing scenarios including regression validation, build verification, and data validation.

---

**Repository:** [https://github.com/Pankaj379/Mindmatrix.git](https://github.com/Pankaj379/Mindmatrix.git)

**Recorded Video:** [Demo-Video.webm](https://github.com/user-attachments/assets/96809cc1-4945-4b0a-b408-569579e17276)

**Mp4 Format:**

https://github.com/user-attachments/assets/983b0677-2d38-473c-97b7-b81da06db345

---

## Tech Stack
- Language: Java
- Automation Tool: Selenium WebDriver
- Test Framework: TestNG
- Build Tool: Maven
- CI Support: Jenkins Ready
- API Validation: Postman / RestAssured (support)
- Design Pattern: Page Object Model (POM)

---

## Framework Architecture
The framework follows a Hybrid approach combining:
- Page Object Model for maintainability
- Data-driven execution using TestNG
- Reusable utilities for common operations
- Modular test design for scalability

Structure:

src/main/java
- pages (UI locators & actions)
- utilities (waits, browser setup, helpers)

src/test/java
- testcases (test logic)
- base (driver initialization & setup)
- listeners (report handling)

testng.xml
- suite execution configuration

---

## Key Features
- Reusable page classes
- Centralized driver management
- Parallel execution ready
- Group execution (Smoke / Regression)
- Easy module expansion
- Failure debugging support

---

## Problem Solved
Before automation:
- Full regression took multiple days
- Manual verification required for each release

After automation:
- Automated core workflows
- Reduced regression effort significantly
- Faster build validation
- Improved release reliability

---

## Example Covered Scenarios
- Login & authentication validation
- Asset & template workflow validation
- Form submission & UI verification
- Negative and edge-case scenarios

---

## How to Run
1. Clone repository
2. Install dependencies
3. Update config in base class
4. Run testng.xml

Command:
mvn clean test

---

## Future Improvements
- Docker execution
- Reporting dashboard
- API automation integration
- Cross-browser execution

