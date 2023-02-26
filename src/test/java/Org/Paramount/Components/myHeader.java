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
    By brandSection = By.xpath("//li[@class='coh-list-item nav-item']/a[@href='/brands']");
    By newsSection = By.xpath("//li[@class='coh-list-item nav-item']/a[@href='/news']");
    By carrersSection = By.xpath("//span[normalize-space()='Careers']");
    By investorsSection = By.xpath("//span[normalize-space()='Investors']");
    By paramountPlusSection = By.xpath("//a[@href='https://www.paramountplus.com/']/span[@class='coh-inline-element']");




    public void assertMainHdrIsDisplayed(){


     Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mainHeader)).isDisplayed());
     Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mainHeader)).isEnabled());

 }

 public synchronized void clickAboutSection(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutSection)).click();

 }

 public void clickBrandSection(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(brandSection)).click();

 }

 public void clickNewsSection(){


        wait.until(ExpectedConditions.visibilityOfElementLocated(newsSection)).click();
 }

 public void clickCareerSection(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(carrersSection)).click();
 }

 public void clickInvestorsSection(){


        wait.until(ExpectedConditions.visibilityOfElementLocated(investorsSection)).click();

 }

 public void clickParamountPlusSection(){

     wait.until(ExpectedConditions.visibilityOfElementLocated(paramountPlusSection)).click();

 }

}
