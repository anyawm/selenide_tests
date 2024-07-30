package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {

  RegistrationPage registrationPage = new RegistrationPage();
  Faker faker = new Faker();

  String userName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String userEmail = faker.internet().emailAddress();
  String userNumber = faker.phoneNumber().subscriberNumber(10);
  String currentAddress = faker.lebowski().quote();

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    //Configuration.holdBrowserOpen = true;
    //Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
    //Configuration.timeout = 40000;
    // Configuration.pageLoadTimeout = 40000;
    Configuration.pageLoadStrategy = "eager";
  }

}