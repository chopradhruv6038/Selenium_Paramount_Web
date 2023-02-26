package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CareerPage extends BasePage {

    public CareerPage (WebDriver driver){
        super(driver);
    }

    public void assertCareerPageUrl(String txt){

        Assert.assertEquals(driver.getCurrentUrl(), txt);

    }
}
