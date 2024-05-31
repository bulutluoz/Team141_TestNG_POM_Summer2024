package tests.day18_testNGFrameworkHazirlama;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebdriverUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebdriverUniversityNegatifLoginTesti {

    @Test
    public void negatifLoginTesti(){

        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        WebdriverUniversityPage webdriverUniversityPage = new WebdriverUniversityPage();

        //bilgisayarimda ilk sayfada login portal gorunuyor, asagi inmeye gerek yok
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",webdriverUniversityPage.loginPortalYazisi);

        //3."Login Portal" a tiklayin
        webdriverUniversityPage.loginPortalYazisi.click();

        //4.Diger window'a gecin
        ReusableMethods.windowaGec("http://webdriveruniversity.com/Login-Portal/index.html",Driver.getDriver());
        //5."username" ve  "password" kutularina fake deger yazdirin

        Faker faker = new Faker();

        webdriverUniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webdriverUniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        webdriverUniversityPage.loginButonu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver()
                                        .switchTo().alert()
                                        .getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver()
                .switchTo().alert()
                .accept();


        //9.Ilk sayfaya geri donun
        ReusableMethods.windowaGec("https://webdriveruniversity.com/",Driver.getDriver());

        //10.Ilk sayfaya donuldugunu test edin
        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.quitDriver();
    }
}
