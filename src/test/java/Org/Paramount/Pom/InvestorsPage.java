package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InvestorsPage extends BasePage {

    public InvestorsPage(WebDriver driver) {
        super(driver);
    }



    public void assertInvestorPgUrl(String txt){

        Assert.assertEquals(driver.getCurrentUrl(), txt);

    }

}
