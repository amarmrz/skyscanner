![GitHub Actions Workflow Status](https://github.com/LINKAVIE/triangle-store-rh-selenium-ui-test/workflows/UI/badge.svg)

#### Prerequisites

- Java Development Kit (JDK) installed on your machine
- IntelliJ IDEA (or any preferred Java IDE)
- Internet connectivity to download project dependencies

#### Installation

1. Clone this repository to your local machine or download and extract the ZIP file.
2. Open IntelliJ IDEA and select "Open" from the main menu.
3. Navigate to the project directory and select the project folder.
4. IntelliJ IDEA will import the project and set up the necessary configurations.

#### Structure

- `src/features/Candidate`: Contains the feature files written in Gherkin syntax.
- `src/test/java/TestSteps`: Contains the step definition files written in Java and map the steps defined in the feature files.
- `src/test/java/TestUtils`: Contains utility classes or helper methods that are used across the test suite.
- `src/test/java/TestRunner`: Contains the JUnit test runner class (`CandidateAppTests`) with Cucumber options.
- `pom.xml`: Maven project configuration file that includes dependencies and plugins.

#### Configuration

1. Open the `pom.xml` file and ensure that the required dependencies for Selenium 4, Cucumber 7, and JUnit 5 are present.
2. Customize the CucumberOptions in the `CandidateAppTests` class according to your needs. Update the `features`, `glue`, and `tags` options as required.
3. Update the package names and test steps according to your project structure and naming conventions.

#### Usage

To run the tests, follow these steps:

1. Open the `CandidateAppTests` class.
2. Right-click inside the class and select "Run CandidateAppTests" or use the shortcut (e.g., Shift + F10).

#### Reporting
The tests will execute, and the results will be displayed in the IntelliJ IDEA test runner window. Additionally, the test results will be saved as follows:

- `cucumber_results/candidate_report.html`: To view the detailed HTML test report.
- `cucumber_results/candidate_report.json`: To view the detailed JSON test report.
- `failed_scenarios/scenarioName_timestamp.png`: To view the captured screenshot when a test scenario fails.
