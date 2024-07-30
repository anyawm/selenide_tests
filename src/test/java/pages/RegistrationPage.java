package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import java.util.Locale;


public class RegistrationPage {

  Faker faker = new Faker(new Locale("fr"));
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


}
