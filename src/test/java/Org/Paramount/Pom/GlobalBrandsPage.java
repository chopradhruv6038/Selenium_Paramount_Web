package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GlobalBrandsPage extends BasePage {

    public GlobalBrandsPage(WebDriver driver) {
        super(driver);
    }

    By globalPageSubHeader = By.xpath("//h5[@class='coh-heading ssa-instance-3794668702 coh-ce-cpt_banner_with_image-bf50411c']");

    public String getActualBrandPgSubHeader() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(globalPageSubHeader)).getText();

    }

    public String getExpectedBrandPgSubHeader(String txt){

        return txt;
    }

    public GlobalBrandsPage assertBrandsPgSubHeader(String txt){

        Assert.assertEquals(getActualBrandPgSubHeader(),getExpectedBrandPgSubHeader(txt));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(globalPageSubHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(globalPageSubHeader)).isEnabled());

        return this;

    }

}
