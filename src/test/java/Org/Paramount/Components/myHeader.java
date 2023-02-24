package Org.Paramount.Components;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class myHeader extends BasePage {

    public myHeader(WebDriver driver) {
        super(driver);
    }

    By mainHeader = By.xpath("//ul[@class='coh-list-container coh-unordered-list navbar-nav ml-auto']");
    By aboutSection = By.xpath("//li[@class='coh-list-item nav-item']/a[@href='/about']");


    public void assertMainHdrIsDisplayed(){


     Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mainHeader)).isDisplayed());
     Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mainHeader)).isEnabled());

 }

 public void clickAboutSection(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutSection)).click();

 }

}
