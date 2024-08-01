package tests;

import static io.qameta.allure.Allure.step;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SelenideTestPageObject extends TestBase {

  @Test
  @DisplayName("Full Student Registration Form")
  void registrationPageFull() {
    step("Открытие формы", () -> {
      registrationPage.openPage();
    });

    step("Заполнение формы", () -> {
      registrationPage
          .setFirstName(userName)
          .setLastName(lastName)
          .setEmail(userEmail)
          .setGender("Other")
          .setPhone(userNumber)
          .setDateOfBirth("10", "March", "2000")
          .setSubject(userSubject)
          .setHobbies("Sports")
          .setAddress(currentAddress)
          .setPhoto("devushka-koshka melk.png")
          .setState("NCR")
          .setCity("Delhi")
          .submitButton();

    });
    step("Проверка зполнения формы", () -> {
      registrationPage
          .checkModalAppears()
          .checkResult("Student Name", userName)
          .checkResult("Student Email", userEmail)
          .checkResult("Mobile", userNumber)
          .checkResult("Hobbies", "Sports");
    });
  }

  @Test
  @DisplayName("Minimal Student Registration Form")
  void registrationPageMin() {
    step("Открытие формы", () -> {
      registrationPage.openPage();
    });

    step("Заполнение формы", () -> {
      registrationPage
          .setFirstName(userName)
          .setLastName(lastName)
          .setGender("Female")
          .setPhone(userNumber)
          .submitButton();

    });
    step("Проверка зполнения формы", () -> {
      registrationPage
          .checkModalAppears()
          .checkResult("Student Name", userName)
          .checkResult("Gender", "Female")
          .checkResult("Mobile", userNumber)
          .checkResult("Date of Birth", "01 August,2024");
    });
  }

  @Test
  @DisplayName("Minimal Student Registration Form")
  void registrationPageWithoutGender() {
    step("Открытие формы", () -> {
      registrationPage.openPage();
    });

    step("Заполнение формы", () -> {
      registrationPage
          .setFirstName(userName)
          .setLastName(lastName)
          .setEmail(userEmail)
          .setPhone(userNumber)
          .setDateOfBirth("10", "March", "2000")
          .setSubject(userSubject)
          .setHobbies("Sports")
          .setAddress(currentAddress)
          .setPhoto("devushka-koshka melk.png")
          .setState("NCR")
          .setCity("Delhi")
          .submitButton();

    });
    step("Проверка зполнения формы", () -> {
      registrationPage.formTitle();
    });
  }

}
