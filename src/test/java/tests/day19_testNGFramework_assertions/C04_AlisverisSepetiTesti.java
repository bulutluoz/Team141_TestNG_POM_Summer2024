package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_AlisverisSepetiTesti {

    @Test
    public void alisverisSepetiTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage
                .aramakutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage
                .sonucElementleriList
                .get(0)
                .click();

        //4- urun ismini kaydedin
        String ilkUrunIsmi = testotomasyonuPage
                                        .ilkUrunSayfasindaUrunIsimElementi
                                        .getText();

        // ve urunu sepete ekleyin
        testotomasyonuPage
                .addToCartButonu
                .click();

        //5- your cart linkine tiklayin
        testotomasyonuPage
                .yourCartLinki
                .click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepettekiUrunIsmi = testotomasyonuPage
                                            .sepettekiUrunIsimElementi
                                            .getText();

        Assert.assertEquals(ilkUrunIsmi,sepettekiUrunIsmi);

        //7- sayfayi kapatin
        Driver.quitDriver();

    }
}
