import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest(){
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter a word or phrase to make into a puzzel!");
  }

  @Test
  public void doesTheWordPuzzleGetPuzzled(){
    goTo("http://localhost:4567/");
    fill("#wordToPuzzle").with("puzzle");
    submit(".btn");
    assertThat(pageSource()).contains("p-zzl-");
  }

}
