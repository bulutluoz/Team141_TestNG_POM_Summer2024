package tests.day18_testNGFrameworkHazirlama;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C07_BirdenFazlaTestMethodu {

    @Test(priority = -17)
    public void testOtomasyonuTesti(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edelim

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();
    }

    @Test (priority = -17)
    public void wisequarterTesti(){

        Driver.getDriver().get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edelim

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();
    }

    @Test (priority = 4)
    public void bestbuyTesti(){

        Driver.getDriver().get("https://www.bestbuy.com");

        // url'in bestbuy icerdigini test edelim

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Driver.quitDriver();
    }
}
