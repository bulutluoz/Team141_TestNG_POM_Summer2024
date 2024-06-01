package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_Assertion {

    @Test
    public void test01(){

        /*
            TestNG assertion konusunda bize 2 alternatif sunar

            1- JUnit'de oldugu gibi Assert.... ile assertion'lari yapabiliriz
               Bu kullanimda FAILED olan ilk assertion'da
               kodun calismasi durur,
               o satirdan sonra calismaya engel bir hata varsa onlari bize soylemez

            2- SoftAssert kullanimi
               Kodumuz bizim belirledigimiz satira kadar
               assertion'lar FAILED olsa da calismaya devam eder
               bizim belirledigimiz satirda
               yaptigi tum assertion'lardan FAILED olan(lar) varsa rapor eder
               ve calismayi o satirda durdurur
         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // anasayfaya gittiginizi test edin

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        // belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage
                .aramakutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        Assert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>0);

        // ilk urunu tiklayin
        testotomasyonuPage
                .sonucElementleriList
                .get(0)
                .click();

        // acilan sayfadaki urun isminde case sensitive olmadan
        // aranacak kelime bulundugunu test edin

        String expectedIsimIcerigi = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage
                                            .ilkUrunSayfasindaUrunIsimElementi
                                            .getText()
                                            .toLowerCase(); // case sensitive olmamasi icin

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));

        // sayfayi kapatin

        Driver.quitDriver();

    }
}
