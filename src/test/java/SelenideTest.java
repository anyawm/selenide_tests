import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import com.codeborne.selenide.Configuration;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SelenideTest {

  @BeforeEach
  void beforeAll() {
   // Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    //Configuration.holdBrowserOpen = true;
    //Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
    //Configuration.timeout = 40000;
  }


  @Test
  @DisplayName("Elements")
  void switchingToTabs() {
    open("https://demoqa.com/");
    sleep(30000);  // Выполнение теста застынет
    $x("//h5[contains (text(), 'Element')]").should(exist, Duration.ofSeconds(40));
    $x("//h5[contains (text(), 'Element')]").click();
    $("#item-0").shouldHave(text("Text Box"));
    $("#item-1").shouldHave(text("Check Box"));
    $("#item-2").shouldHave(text("Radio Button"));
    $("#item-3").shouldHave(text("Web Tables"));
    $("#item-4").shouldHave(text("Buttons"));
    $("#item-5").shouldHave(text("Links"));
    $("#item-6").shouldHave(text("Broken Links - Images"));
    $("#item-7").shouldHave(text("Upload and Download"));
    $("#item-8").shouldHave(text("Dynamic Properties"));
  }

  @Test
  @DisplayName("Text-box")
  void successfulTextBox() {
    open("https://demoqa.com/text-box");
    $("#userName").setValue(TestData.userFullName);
    $("#userEmail").setValue(TestData.userEmail);
    $("#currentAddress").setValue("Russia, Moscow, Lenina 105-7");
    $("#permanentAddress").setValue("Russia, Moscow, Lenina 105-7");
    $("#submit").click();
    $("#name").shouldHave(text("Name:" + TestData.userFullName));
    $("#email").shouldHave(text("Email:" + TestData.userEmail));
    $x("//*[contains(text(), 'Current Address :')]").shouldHave(
        text("Current Address :Russia, Moscow, Lenina 105-7"));
    $x("//*[contains(text(), 'Current Address :')]").shouldHave(
        text("Permananet Address :Russia, Moscow, Lenina 105-7"));
  }

  @Test
  @DisplayName("Buttons")
  void successfulRadioButton() {
    open("https://demoqa.com/buttons");
    $("#doubleClickBtn").doubleClick();
    $("#doubleClickMessage").shouldHave(text("You have done a double click"));
    $("#rightClickBtn").contextClick();
    $("#rightClickMessage").shouldHave(text("You have done a right click"));
    $x("//button[text()='Click Me']").click();
    $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
  }
  @Test
  @DisplayName("Student Registration Form")
  void registrationPage() {
    step("Открыть форму регистрации", () -> {
      open("https://demoqa.com/automation-practice-form");
    });
    step("заполнить ФИО, почту, пол", () -> {
      $("#firstName").setValue(TestData.userName);
      $("#lastName").setValue(TestData.userSurname);
      $("#userEmail").setValue(TestData.userEmail);
      $x("//label[@for = 'gender-radio-3']").click();
    });
    step("заполнить номер телефона, дату рождения и предмет", () -> {
      $("#userNumber").setValue(TestData.userPhone);
      $("dateOfBirthInput").click();
      $x("//*[@aria-label = 'Choose Monday, July 22nd, 2024']").click();
      $("#subjectsInput").setValue(TestData.userSubject);
    });
    step("заполнить [хобби, адрес и штат]", () -> {
      //driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
      $("#currentAddress").setValue(TestData.userAddress);
    });
    step("отправка фото и формы", () -> {
      $("#uploadPicture").uploadFromClasspath("src/test/resources/devushka-koshka melk.png");
      $("#submit").submit();
    });
    step("Проверка зполнения формы", () -> {
      $(".modal-header").should(exist);
      $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    });
  }

}
