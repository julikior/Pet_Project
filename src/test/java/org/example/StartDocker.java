package org.example;

import static java.lang.System.currentTimeMillis;
import static org.testng.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StartDocker {

  public void startFile() throws IOException, InterruptedException {
    boolean flag = false;
    Runtime.getRuntime().exec("sh dockerUp.sh");

    String f = "output.txt";
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.SECOND, 45);
    long stopNow = cal.getTimeInMillis();
    Thread.sleep(3000);

    while (currentTimeMillis() < stopNow) {

      if (flag) {
        break;
      }

      BufferedReader reader= new BufferedReader(new FileReader(f));
      String currentLine = reader.readLine();

      while (currentLine != null && !flag) {
        if (currentLine.contains("Node has been added")) {
          System.out.println("The text was found");
          flag = true;
          break;
        }
        currentLine = reader.readLine();
      }
      reader.close();
    }
    assertTrue(flag);
    Runtime.getRuntime().exec("sh scale.sh");
    Thread.sleep(15000);
  }
}
