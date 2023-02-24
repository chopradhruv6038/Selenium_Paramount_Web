package Org.Paramount.Components;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Footer extends BasePage {

    public Footer(WebDriver driver) {
        super(driver);
    }

    By socialFooter = By.xpath("//div[@class='coh-container row column coh-ce-cpt_footer-5c8c4d83']");




    public void assertSocialFooter(){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(socialFooter)).isEnabled());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(socialFooter)).isDisplayed());


    }





}
