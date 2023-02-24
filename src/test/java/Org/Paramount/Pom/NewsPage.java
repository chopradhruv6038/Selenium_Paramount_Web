package Org.Paramount.Pom;

import Org.Paramount.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage assertNewsPgUrl(String txt){

        Assert.assertEquals(driver.getCurrentUrl(), txt);

        return this;

    }


}
