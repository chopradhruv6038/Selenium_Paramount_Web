package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ParamountPlusPage extends BasePage {

    public ParamountPlusPage(WebDriver driver) {
        super(driver);
    }


    public void assertParamountPlusPgUrl(String txt){

        Assert.assertEquals(driver.getCurrentUrl(), txt);

    }

}
