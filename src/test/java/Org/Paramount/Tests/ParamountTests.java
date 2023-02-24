package Org.Paramount.Tests;

import Org.Paramount.Base.BaseTest;
import Org.Paramount.Pom.HomePage;
import Org.Paramount.Utils.TestUtils;
import com.google.gson.JsonObject;
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

        testUtils.log().info(m.getName());

    }


    @Test
    public void ValidateAboutPage() {

        homePage.loadUrl(props.getProperty("paramountUrl"));
        homePage.assertParamountIconHmPg()
                .assertHmPgSubheader(ExpectedData.getJSONObject("HomePage").getString("SubHeader"));


    }


}
