package com.tutorialsninja.browserfactory;

import com.tutorialsninja.propertyreader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.time.Duration.ofSeconds;

public class ManageBrowser {
    public static WebDriver driver;

    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    public void selectBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));
        driver.get(baseUrl);
    }
    public void closeBrowser(){
        if (driver!= null){
            driver.quit();
        }
    }
}
