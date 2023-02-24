package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import Org.Paramount.Utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AboutPage extends BasePage {

    TestUtils testUtils;

    public AboutPage(WebDriver driver) {
        super(driver);
        testUtils = new TestUtils();
    }

    By aboutPageSubHeader = By.xpath("//h5[@class='coh-heading heading']");


public String getActualSubHeaderText(){

    return wait.until(ExpectedConditions.visibilityOfElementLocated(aboutPageSubHeader)).getText();

}

public String expectedAboutPgSubHeader(String txt){

    return txt;

}

public AboutPage assertAboutPageSubHeader(String txt){

    Assert.assertEquals(getActualSubHeaderText(), expectedAboutPgSubHeader(txt));
    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(aboutPageSubHeader)).isDisplayed());
    testUtils.log().info("\nActual About page sub header : " + getActualSubHeaderText() + "\nExpected About page sub header : " + expectedAboutPgSubHeader(txt) );

    return this;
}

public AboutPage assertUrl(String txt){

    Assert.assertEquals(driver.getCurrentUrl(), txt);

    return this;

}

}
