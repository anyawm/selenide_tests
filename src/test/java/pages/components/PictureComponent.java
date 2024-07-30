package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class PictureComponent {
  public void loadPhoto (String picture) {
    $("#uploadPicture").uploadFromClasspath(picture);
  }

}
