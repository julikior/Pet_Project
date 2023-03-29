package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2 {

  @Test
  public void test2() throws MalformedURLException {

    // TODO Auto-generated method stub
    ChromeOptions cap = new ChromeOptions();
    cap.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    URL url = new URL("http://localhost:4444/wd/hub");
    RemoteWebDriver driver = new RemoteWebDriver(url, cap);
    driver.get("https://gmail.com");
    //driver.quit();
    System.out.println(driver.getTitle());
  }
}
