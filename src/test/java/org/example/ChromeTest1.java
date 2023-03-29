package org.example;

import java.io.IOException;import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 {

  @BeforeTest
  public void startDockerScale()throws IOException, InterruptedException {
    StartDocker s = new StartDocker();
    s.startFile();
  }

  @AfterTest
  public void stopDockerDeleteFile()throws IOException, InterruptedException {
    StopDocker d = new StopDocker();
    d.stopFile();
  }

  @Test
  public void test1() throws MalformedURLException {

    // TODO Auto-generated method stub
    ChromeOptions cap = new ChromeOptions();
    cap.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    URL url = new URL("http://localhost:4444/wd/hub");
    RemoteWebDriver driver = new RemoteWebDriver(url, cap);
    driver.get("https://google.com");
    //driver.quit();
    System.out.println(driver.getTitle());
  }
}
