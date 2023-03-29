package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxStandaloneTest {

  public static void main(String[] args) throws MalformedURLException {

    // TODO Auto-generated method stub
    ImmutableCapabilities cap = new ImmutableCapabilities("browserName", "firefox");
    URL url = new URL("http://localhost:4444/wd/hub");
    RemoteWebDriver driver = new RemoteWebDriver(url, cap);
    driver.get("https://google.com");
    System.out.println(driver.getTitle());
  }
}
