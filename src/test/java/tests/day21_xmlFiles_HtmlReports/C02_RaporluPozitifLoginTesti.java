package tests.day21_xmlFiles_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {

    /*
        varolan bir method'u raporlu hale getirmek icin
        1- icinde bulundugu class'i TestBaseRapor'a child yapin
        2- test adimlarini raporlamak icin extentTest objesine deger atamasi yapin
        3- Raporda cikmasini istedigimiz test adimlarini info/pass olarak olusturun
     */

    @Test
    public void pozitifLoginTesti(){

        extentTest = extentReports.createTest("pozitif login testi","Gecerli bilgilerle sisteme giris yapilabilir");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        ReusableMethods.bekle(1);
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");
        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage
                .loginEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");
        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage
                .loginPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);
        extentTest.info("Kullanici sifresi olarak gecerli password girer");
        //5- Login butonuna basarak login olun
        testotomasyonuPage
                .loginSiginButonu
                .click();
        extentTest.info("Login butonuna basarak login olur");
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logOutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");


    }
}
