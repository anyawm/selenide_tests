package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import java.util.Locale;
import pages.components.PictureComponent;


public class RegistrationPage {

  Faker faker = new Faker(new Locale("fr"));
  PictureComponent pictureComponent = new PictureComponent();

  private final String titlepage = "Student Registration Form";
  private SelenideElement
      lastNameInput = $("#lastName"),
      firstNameInput = $("#firstName"),
      emailInput = $("#userEmail");

  public RegistrationPage openPage() {
    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text(titlepage));
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

    return this;
  }

  public RegistrationPage setFirstName(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setLastName(String value) {
    lastNameInput.setValue(value);

    return this;
  }
  public RegistrationPage setEmail(String value) {
    emailInput.setValue(value);

    return this;
  }
  public RegistrationPage setGender(String value) {
    $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements

    return this;
  }

  public RegistrationPage setPhone(String value) {
    $("#userNumber").setValue(value);

    return this;
  }
  public RegistrationPage setAddress(String value) {
    $("#currentAddress").setValue(value);

    return this;
  }

  public RegistrationPage setSubject(String value) {
    $("#subjectsInput").setValue(value).pressEnter();

    return this;
  }
  public RegistrationPage setBirthDay() {
    $("#dateOfBirthInput").click();

    return this;
  }

  public RegistrationPage setHobbies(String value) {
    $("#hobbiesWrapper").$(byText(value)).click();

    return this;
  }

  public RegistrationPage setPhoto(String picture) {
    pictureComponent.loadPhoto(picture);

    return this;
  }

  public RegistrationPage submitButton() {
    $("#submit").click();

    return this;
  }

}
