# OrangeHRM Automation Testing Framework

A Selenium-based automation testing framework developed for the OrangeHRM web application using **Java, Selenium WebDriver, TestNG, and Maven**. The framework follows the **Page Object Model (POM)** design pattern and supports scalable, reusable, and maintainable test automation.

---

## 🚀 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- Git & GitHub

---

## ✨ Features

- Page Object Model (POM) architecture
- Smoke, Functional, and Regression test suites
- Cross-browser execution (Chrome, Firefox, Edge)
- Headless browser support
- Explicit waits for synchronization
- Screenshot capture on test failures
- Extent Report generation
- Reusable page objects and utility classes
- Maven Profile-based test execution
- Browser selection using Maven system properties

---

## 📂 Modules Automated

- Login
- Dashboard
- Admin
- PIM
- Leave
- Recruitment
- My Info

---

## 📁 Project Structure

```text
OrangeHRM-Automation
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   ├── utilities
│   │   │   ├── resources
│   │   │   └── testComponents
│   │
│   └── test
│       └── java
│           ├── tests
│           └── listeners
│
├── testSuites
│   ├── smoke.xml
│   ├── functional.xml
│   └── regression.xml
│
├── reports
├── screenshots
├── pom.xml
└── README.md
```

---

## ▶️ Running the Project

### Clone the Repository

```bash
git clone https://github.com/your-username/OrangeHRM-Automation.git
cd OrangeHRM-Automation
```

### Install Dependencies

```bash
mvn clean install
```

---

## 🧪 Execute Test Suites

Run the required suite using the corresponding Maven profile.

### Smoke Suite

```bash
mvn test -PSmoke
```

### Functional Suite

```bash
mvn test -PFunctional
```

### Regression Suite

```bash
mvn test -PRegression
```

---

## 🌐 Browser Execution

Override the default browser configured in `GlobalData.properties` using the `browser` system property.

### Chrome

```bash
mvn test -PSmoke -Dbrowser=chrome
```

### Chrome (Headless)

```bash
mvn test -PSmoke -Dbrowser=chromeHeadless
```

### Firefox

```bash
mvn test -PFunctional -Dbrowser=firefox
```

### Firefox (Headless)

```bash
mvn test -PFunctional -Dbrowser=firefoxHeadless
```

### Microsoft Edge

```bash
mvn test -PRegression -Dbrowser=edge
```

### Microsoft Edge (Headless)

```bash
mvn test -PRegression -Dbrowser=edgeHeadless
```

> **Note:** If the `browser` parameter is not provided, the framework automatically uses the browser specified in `src/main/resources/GlobalData.properties`.

---

## 📊 Reports

After execution:

- Extent Reports are generated in the **reports** folder.
- Failure screenshots are stored in the **screenshots** folder.

---

## 👤 Author

**Hariharan R**

- GitHub: https://github.com/your-username
- LinkedIn: https://linkedin.com/in/your-profile
