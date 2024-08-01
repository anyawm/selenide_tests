package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCity {
  public void chooseState (String value) {
    $("#state").click();
    $("#stateCity-wrapper").$(byText(value)).click();
  }

  public void chooseCity(String value) {
    $("#city").click();
    $("#stateCity-wrapper").$(byText(value)).click();
  }
}
