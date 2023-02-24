package Org.Paramount.Base;

import Org.Paramount.Factory.MakeDriver;
import Org.Paramount.Utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.swing.plaf.basic.BasicRootPaneUI;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    TestUtils testUtils = new TestUtils();
    static protected String dateTime;

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);

    }

    public WebDriver getDriver() {
        return this.driver.get();
    }


    @Parameters({"Browser"})
    @BeforeMethod
    public void StartDriver(String Browser) {

        setDriver(new MakeDriver().initializeDriver(Browser));


    }

    @Parameters({"Browser"})
    @AfterMethod
    public void quitDriver(String Browser, ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            File destFile = new File("Screenshots" + File.separator + Browser + "_" + getDateTime() + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + File.separator +
                    result.getMethod().getMethodName() + ".png");

            getScreenshot(destFile);
        }

        getDriver().quit();
    }
    public void getScreenshot(File destfile) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File scr = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr, destfile);

    }

    public String getDateTime() {

        return dateTime;
    }

    @BeforeTest
    public void beforeTest(){

        dateTime = testUtils.getDateTime();

    }

}
