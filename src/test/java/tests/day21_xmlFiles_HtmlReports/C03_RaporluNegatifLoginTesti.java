package tests.day21_xmlFiles_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluNegatifLoginTesti extends TestBaseRapor {

    @Test(groups = "smoke")
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Gecersiz password ile sisteme giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- gecerli email, gecersiz password girin
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("gecerli email, gecersiz password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSiginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        extentTest.info("Basarili olarak giris yapilamadigini test eder");

    }

    @Test
    public void gecersizEmailTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Testi",
                "Gecersiz email ile sisteme giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- gecersiz email, gecerli password girin
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("gecersiz email, gecerli password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSiginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        extentTest.info("Basarili olarak giris yapilamadigini test eder");

    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Gecersiz Password Testi",
                "Gecersiz email ve gecersiz password ile sisteme giris yapilamaz");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- gecersiz email, gecersiz password girin
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("gecersiz email, gecersiz password girer");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSiginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        extentTest.info("Basarili olarak giris yapilamadigini test eder");

    }

}
