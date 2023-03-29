package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {

  public static void main (String[] args)throws MalformedURLException {

    // TODO Auto-generated method stub
    //ImmutableCapabilities cap = new ImmutableCapabilities("browserName", "chrome");
    ChromeOptions cap = new ChromeOptions();
    cap.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    URL url = new URL("http://localhost:4444/wd/hub");
    RemoteWebDriver driver = new RemoteWebDriver(url, cap);
    driver.get("https://google.com");
    //driver.quit();
    System.out.println(driver.getTitle());
  }
}
