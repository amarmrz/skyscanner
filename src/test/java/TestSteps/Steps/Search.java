package TestSteps.Steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.Locale;

import static TestSteps.Steps.Hooks.driver;
import static TestSteps.Steps.Hooks.wait;
import static org.openqa.selenium.By.*;


public class Search {
    Faker faker = new Faker(new Locale("en"));
    String Location = faker.address().city();
    String Destination = faker.address().city();

    @Given("User navigate to the website")
    public void User_navigate_to_the_website() {
        driver.get("https://www.skyscanner.ae/");
    }

    @And("User type the flight info")
    public void userTypeTheFlightInfo() {
        WebElement From = wait.until(ExpectedConditions.visibilityOfElementLocated(id("originInput-input")));
        From.clear();
        From.sendKeys(Location);

        WebElement To = wait.until(ExpectedConditions.visibilityOfElementLocated(id("destinationInput-input")));
        To.clear();
        To.sendKeys(Destination);

        WebElement Depart = wait.until(ExpectedConditions.visibilityOfElementLocated(id("depart-fsc-datepicker-button")));
        Depart.click();
        WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(("//button[normalize-space()=" + getCurrentDay() + "])[1]"))));
        date.click();

        WebElement date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(("(//button[normalize-space()=" + getLastDayOfMonth() + "])[2]"))));
        date1.click();

    }

    @When("User clicks on search")
    public void userClicksOnSearch() {
        WebElement Search = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("desktop-cta")));
        Search.click();
    }

    @Then("User redirected to available flights")
    public void userRedirectedToAvailableFlights() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("CombinedResultsPlaces_title"))).isDisplayed();
    }

    @And("User clicks on Hotels button")
    public void userClicksOnHotelsButton() {
        WebElement hotels = wait.until(ExpectedConditions.visibilityOfElementLocated(id("skhot")));
        hotels.click();
    }

    @And("User type the Hotels info")
    public void userTypeTheHotelsInfo() {
        WebElement hotelName = wait.until(ExpectedConditions.visibilityOfElementLocated(id("destination-autosuggest")));
        hotelName.clear();
        hotelName.sendKeys(Location);

        WebElement checkIn = wait.until(ExpectedConditions.visibilityOfElementLocated(id("checkin")));
        checkIn.click();
        WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//span[normalize-space()=" + getCurrentDay()
                + "]")));
        date.click();

        WebElement checkOut = wait.until(ExpectedConditions.visibilityOfElementLocated(id("checkout")));
        checkOut.click();
        WebElement date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//span[normalize-space()=" + getLastDayOfMonth()
                + "]")));
        date1.click();
    }

    @Then("User redirected to available Hotels")
    public void userRedirectedToAvailableHotels() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("filterExpandButton"))).isDisplayed();
    }


    @When("User clicks on search hotel")
    public void userClicksOnSearchHotel() {
        WebElement searchHotel = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("search-button")));
        searchHotel.click();
    }

    @And("User clicks on car rental button")
    public void userClicksOnCarRentalButton() {
        WebElement carRental = wait.until(ExpectedConditions.visibilityOfElementLocated(id("carhire-search-controls-search-button")));
        carRental.click();
    }

    @And("User type the car rental info")
    public void userTypeTheCarRentalInfo() {
        WebElement pickUpLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(id("carhire-search-controls-location-pick-up")));
        pickUpLocation.clear();
        pickUpLocation.sendKeys(Location);

        WebElement pickUpDate = wait.until(ExpectedConditions.visibilityOfElementLocated(id("carhire-search-controls-date-pick-up")));
        pickUpDate.click();
        WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//span[normalize-space()=" + getCurrentDay()
                + "]")));
        date.click();

        WebElement returnDate = wait.until(ExpectedConditions.visibilityOfElementLocated(id("carhire-search-controls-date-drop-off")));
        returnDate.click();
        WebElement date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("(//span[@aria-hidden='true'][normalize-space()=" + getLastDayOfMonth() + "])[2]")));
        date1.click();


    }

    @When("User clicks on car rental hotel")
    public void userClicksOnCarRentalHotel() {
        WebElement searchHotel = wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("carhire-search-controls-search-button")));
        searchHotel.click();
    }

    @Then("User redirected to available car rental")
    public void userRedirectedToAvailableCarRental() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(id("open-filters-button"))).isDisplayed();

    }

    public static int getCurrentDay() {
        return LocalDate.now().getDayOfMonth();
    }

    public static int getLastDayOfMonth() {

        LocalDate currentDate = LocalDate.now();
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        return lastDayOfMonth.getDayOfMonth();
    }

}
