package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import Org.Paramount.Components.Footer;
import Org.Paramount.Components.myHeader;
import Org.Paramount.Utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage extends BasePage {

    protected myHeader myheader;
    protected Footer myfooter;
    TestUtils testUtils;

    SoftAssert softAssert;

    public HomePage(WebDriver driver) {
        super(driver);

        myheader = new myHeader(driver);
        myfooter = new Footer(driver);
        testUtils = new TestUtils();

        softAssert = new SoftAssert();
    }


    By paramountIconHmPg = By.xpath("//img[@class='coh-image coh-image-responsive-xl']");

    By homePgSubHeader = By.xpath("//h5[@class='coh-heading section-heading-medium']");


    public void loadUrl(String url) {
        driver.get(url);

    }

    public HomePage assertParamountIconHmPg() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(paramountIconHmPg)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(paramountIconHmPg)).isEnabled());

        return this;
    }

    public HomePage assertMainHeaderIsDisplayed() {

        myheader.assertMainHdrIsDisplayed();

        return this;
    }

    public String getActualHmPgSubHeader() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePgSubHeader)).getText();
    }

    public String expectedHmPgSubHeader(String subHeader) {

        return subHeader;

    }

    public HomePage assertHmPgSubheader(String subheader) {

        Assert.assertEquals(getActualHmPgSubHeader(), expectedHmPgSubHeader(subheader));
        testUtils.log().info("\nActual Sub Header : " + getActualHmPgSubHeader() + "\nExpected Sub Header : " + expectedHmPgSubHeader(subheader));

        return this;

    }

    public HomePage assertSocialFooterIsDisplayed() {

        myfooter.assertSocialFooter();

        return this;
    }

    public AboutPage clickAboutSection() {

        myheader.clickAboutSection();

        return new AboutPage(driver);

    }

    public GlobalBrandsPage clickGlobalBrandSection() {

        myheader.clickBrandSection();

        return new GlobalBrandsPage(driver);
    }

}
