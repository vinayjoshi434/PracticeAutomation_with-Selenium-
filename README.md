# PracticeAutomation_with-Selenium-
This project is a custom-built test automation framework developed using Java and Selenium WebDriver, designed with a clean and modular architecture. It includes features like JSON-based configuration, custom utility classes, screenshot capture, and a basic Extent Report implementation.


This project is a custom-built automation testing framework created using Java and Selenium WebDriver as part of my learning journey in test automation.

Instead of writing simple scripts, I focused on understanding how real-world frameworks are structured, and tried to build a clean, reusable, and modular setup.

The framework includes:

Modular structure using Page Object Model (POM)
JSON-based configuration and locator handling
Custom utility classes
Screenshot capture for debugging
Basic Extent Report integration

🧱 Project Structure
PracticeAutomation/
│
├── setup/
│   ├── browser.json         # Browser configuration
│   └── webelement.json      # XPath / locator storage
│
├── screenshots/             # Captured screenshots
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── factory/     # Driver initialization & setup
│   │   │   ├── PageObject/  # Page classes (POM structure)
│   │   │   ├── service/     # Action-level logic / business flows
│   │   │   ├── util/        # Utilities (JSON reader, waits, screenshots)
│   │   │   ├── reports/     # Extent report setup
│   │   │   ├── Executor.java
│   │   │   └── PracticeExecutor.java
│   │   │
│   │   └── resources/
│
├── test/                    # Test classes (if used separately)
├── target/                  # Build output (ignored in Git)
├── pom.xml                  # Maven configuration
└── .gitignore

⚙️ Tech Stack
Java
Selenium WebDriver
TestNG
Maven
JSON
Extent Reports

✨ Features Implemented
🔹 1. Custom Base Class
        Centralized WebDriver initialization
        Browser setup handled via configuration
        Common setup and teardown methods
🔹 2. JSON-Based Configuration
        Browser selection (Chrome, etc.)
        Application URL
        XPath / locators (externalized)

Example:

{
"browser": "chrome",
"baseUrl": "https://example.com"
}

👉 This removes hardcoding and makes the framework flexible.

🔹 3. Page Object Model (POM)
        Each page is defined as a separate class
        Locators and actions are separated from test logic

👉 Helps in maintainability and readability.

🔹 4. Utility Classes

Custom utilities created for:

JSON data reading
Wait handling
Element interactions
Screenshot capturing

👉 Avoids code duplication and improves reusability.

🔹 5. Screenshot Capture
        Automatically captures screenshots on test failure
        Helps in debugging issues during execution
🔹 6. Extent Report (Basic Implementation)
        Generates HTML reports after execution
        Shows:
        Test status (Pass/Fail)
        Screenshots (if configured)

▶️ How to Run the Project
1. Clone the Repository
   git clone https://github.com/vinayjoshi434/PracticeAutomation_with-Selenium-.git
2. Open Project
   Open in IntelliJ / Eclipse
   Ensure Maven dependencies are loaded
3. Configure Settings

Update JSON config file if needed:

{
"browser": "chrome",
"baseUrl": "your-url"
}
4. Run Tests

Using Maven:

mvn clean test

Or run directly from TestNG test classes.

📸 Reports & Screenshots
Extent Reports:
/reports/
Screenshots:
/screenshots/


🧠 What I Learned from This Project
How to design a modular automation framework
Importance of separating test logic and locators
Handling dynamic elements and waits in Selenium
Using JSON for configuration instead of hardcoding
Basic integration of test reporting (Extent Reports)
Practical experience with Git and resolving conflicts
🚧 Future Improvements
Parallel execution
CI/CD integration (Jenkins/GitHub Actions)
Data-driven testing
Advanced reporting
Retry mechanism for failed tests

🙌 Conclusion

This project helped me move from just writing Selenium scripts to understanding how a real automation framework is built and structured.

It reflects hands-on learning, experimentation, and solving real issues during development.

📌 Author

Vinay Joshi
GitHub: https://github.com/vinayjoshi434