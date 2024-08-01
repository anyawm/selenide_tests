package pages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import java.util.Locale;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;
import pages.components.CalendarComponent;
import pages.components.PictureComponent;
import pages.components.StateAndCity;


public class RegistrationPage {

  Faker faker = new Faker(new Locale("fr"));
  PictureComponent pictureComponent = new PictureComponent();
  CalendarComponent calendarComponent = new CalendarComponent();
  StateAndCity stateAndCity = new StateAndCity();

  private final String titlepage = "Student Registration Form";
  private SelenideElement
      lastNameInput = $("#lastName"),
      firstNameInput = $("#firstName"),
      emailInput = $("#userEmail");

  public RegistrationPage openPage() {
    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text(titlepage));

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

  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    calendarComponent.setDate(day, month, year);

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

  public RegistrationPage setBirthDay(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    calendarComponent.setDate(day, month, year);

    return this;
  }

  public RegistrationPage setState(String value) {
    stateAndCity.chooseState(value);

    return this;
  }

  public RegistrationPage setCity(String value) {
    stateAndCity.chooseCity(value);

    return this;
  }

  public RegistrationPage submitButton() {
    $("#submit").click();

    return this;
  }

  public RegistrationPage checkResult(String key, String value) {
    $(".table-responsive").$(byText(key)).parent().
        shouldHave(text(value));

    return this;
  }

  public RegistrationPage checkModalAppears() {
    $(".modal-dialog").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    return this;
  }

  public RegistrationPage formTitle() {
    $(".practice-form-wrapper").shouldHave(text(titlepage));

    return this;
  }


}
