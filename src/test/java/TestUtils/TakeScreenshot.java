package TestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

    private static final String SCREENSHOT_DIRECTORY = "failed_scenarios";
    private static final String SCREENSHOT_EXTENSION = ".png";

    public static void takeScreenshot(WebDriver driver, Scenario scenario) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = nameScreenshot(scenario);
            Path destinationPath = Paths.get(SCREENSHOT_DIRECTORY, screenshotName);
            Files.createDirectories(destinationPath.getParent());
            Files.move(screenshotFile.toPath(), destinationPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    private static String nameScreenshot(Scenario scenario) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        return String.format("%s_%s%s", scenarioName, timestamp, SCREENSHOT_EXTENSION);
    }

}

