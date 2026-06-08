# AIR Hybrid Playwright Framework

A Java-based hybrid automation framework using Playwright, Cucumber, TestNG, and ExtentReports for UI and API test automation.

## Overview

This repository contains a hybrid automation framework for testing web applications and APIs. It uses Playwright for browser automation, Cucumber for BDD-style scenarios, TestNG as the test runner, and ExtentReports for generating HTML reports.

## Tech stack

- Java 21
- Maven
- Playwright
- Cucumber JVM
- TestNG
- ExtentReports
- Jackson Databind

## Prerequisites

- Java JDK 21 installed and `JAVA_HOME` configured
- Maven installed and available on your PATH
- Git installed
- Internet access for Maven dependency download

## Project setup

1. Clone the repository:

```bash
git clone https://github.com/suryanceR/Playwright_Automation_AIR.git
cd Playwright_Automation_AIR
```

2. Verify Java and Maven versions:

```bash
java -version
mvn -v
```

3. Install project dependencies and build:

```bash
mvn clean compile
```

## Running tests

Execute the full test suite using Maven:

```bash
mvn test
```

You can also run specific test runners or features by configuring TestNG or Cucumber runner options in `src/test/java/runner/TestRunner.java`.

## Reports

After execution, the generated reports are available in the `target/` directory:

- `target/ExtentReport.html`
- `target/cucumber-report.html`
- `target/surefire-reports/`

## Framework structure

- `pom.xml` - Maven project configuration and dependencies
- `src/test/java/` - Java source code for test implementation
  - `api/` - API client, request builder, and response validator utilities
  - `constants/` - Framework constants
  - `factory/` - Playwright browser setup and management
  - `hooks/` - Cucumber/TestNG hooks
  - `pages/` - Page object models
  - `runner/` - Test runner configuration
  - `stepdefinitions/` - Cucumber step definitions
  - `utils/` - Utility classes for configuration, JSON, logging, reports, screenshots, and session management
- `src/test/resources/` - Test resources
  - `config.properties` - Environment and test configuration
  - `features/` - Cucumber feature files
  - `testdata/` - Test data payloads and assets

## Notes

- The framework currently uses Java 21 via Maven compiler plugin.
- If you want to keep binary output out of source control, consider adding `target/` to `.gitignore`.
- Update `src/test/resources/config.properties` with application-specific URLs or credentials before running tests.

## Contribution

Feel free to extend the framework by adding new feature files, page objects, step definitions, or custom report utilities.
