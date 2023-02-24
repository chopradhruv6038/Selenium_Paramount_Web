package Org.Paramount.Tests;

import Org.Paramount.Base.BaseTest;
import Org.Paramount.Pom.AboutPage;
import Org.Paramount.Pom.GlobalBrandsPage;
import Org.Paramount.Pom.HomePage;
import Org.Paramount.Pom.NewsPage;
import Org.Paramount.Utils.TestUtils;
import com.google.gson.JsonObject;
import io.qameta.allure.Story;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ParamountTests extends BaseTest {

    TestUtils testUtils;
    HomePage homePage;
    AboutPage aboutPage;
    GlobalBrandsPage globalBrandsPage;
    NewsPage newsPage;


    Properties props;
    InputStream propsis;
    InputStream Datais;
    JSONObject ExpectedData;

    @BeforeClass
    public void beforeClass() throws IOException {

        try {

            String JsonData = "Data/ExpectedTexts.json";

            Datais = getClass().getClassLoader().getResourceAsStream(JsonData);

            JSONTokener tokener = new JSONTokener(Datais);

            ExpectedData = new JSONObject(tokener);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (Datais != null) {
                Datais.close();
            }

        }


        // global properties
        props = new Properties();
        String propsData = "Data/config.properties";
        propsis = getClass().getClassLoader().getResourceAsStream(propsData);
        props.load(propsis);


    }

    @BeforeMethod
    public void beforeMethod(Method m) {

        testUtils = new TestUtils();
        homePage = new HomePage(getDriver());
        aboutPage = new AboutPage(getDriver());
        globalBrandsPage = new GlobalBrandsPage(getDriver());
        newsPage = new NewsPage(getDriver());

        testUtils.log().info(m.getName());

    }


    @Story("This test validates Main header, paramount icon, sub header and footer is displayed on home page")
    @Test
    public synchronized void validateHomePage() {

        homePage.loadUrl(props.getProperty("paramountUrl"));
        homePage.assertParamountIconHmPg().assertMainHeaderIsDisplayed()
                .assertHmPgSubheader(ExpectedData.getJSONObject("HomePage").getString("SubHeader"))
                .assertSocialFooterIsDisplayed();

    }

    @Story("This test validates user is able to navigate to about page and its content")
    @Test (priority = 1)
    public synchronized void validateAboutPage() {

        homePage.loadUrl(props.getProperty("paramountUrl"));
        aboutPage = homePage.clickAboutSection();
        aboutPage.assertUrl(ExpectedData.getJSONObject("AboutPage").getString("AboutPageUrl"))
                .assertAboutPageSubHeader(ExpectedData.getJSONObject("AboutPage").getString("SubHeader"));

    }


    @Story("This test validates navigation to Global brands page and its content")
    @Test (priority = 2)
    public synchronized void validateBrandsPage() {

        homePage.loadUrl(props.getProperty("paramountUrl"));
        globalBrandsPage = homePage.clickGlobalBrandSection();
        globalBrandsPage.assertBrandsPgSubHeader(ExpectedData.getJSONObject("BrandsPage").getString("SubHeader"));


    }

    @Story("This test validates navigation to news page")
    @Test (priority = 3)
    public synchronized void validateNewsPage() {

        homePage.loadUrl(props.getProperty("paramountUrl"));
        newsPage = homePage.clickNewsSection();
        newsPage.assertNewsPgUrl(ExpectedData.getJSONObject("NewsPage").getString("NewsPgURL"));


    }

}
