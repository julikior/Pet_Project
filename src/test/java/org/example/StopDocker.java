package org.example;

import static java.lang.System.currentTimeMillis;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.checkerframework.checker.units.qual.Current;

public class StopDocker {

  public void stopFile() throws IOException, InterruptedException {
    boolean flag = false;
    Runtime.getRuntime().exec("sh dockerDown.sh");

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
        if (currentLine.contains("Shutdown complete")) {
          System.out.println("The text was found");
          flag = true;
          break;
        }
        currentLine = reader.readLine();
      }
      reader.close();
    }
    assertTrue(flag);
    File file = new File("Output.txt");
    if (file.delete()) {
      System.out.println("File is deleted successfully");
    }
  }
}
