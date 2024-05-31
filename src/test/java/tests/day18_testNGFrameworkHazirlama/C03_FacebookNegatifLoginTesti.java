package tests.day18_testNGFrameworkHazirlama;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_FacebookNegatifLoginTesti {

    @Test
    public void negatifLoginTesti(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // cikiyorsa cookies'i kabul edin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookiesKabulButonu.click();
        ReusableMethods.bekle(3);

        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        // page class'i olusturup locate'leri yaptik

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker = new Faker();



        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());

        ReusableMethods.bekle(3);

        facebookPage.loginButonu.click();

        ReusableMethods.bekle(5);
        //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.basariliGirisYapilamadiUyarisi.isDisplayed());


        //5- sayfayi kapatin

        Driver.quitDriver();

    }
}
