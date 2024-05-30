package tests.day17_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yerine getirin
    // 1- testotomasyonu anasayfaya gidin ve sayfaya gittiginizi test edin
    // 2- phone icin arama yapin ve urun bulunabildigini test edin
    // 3- ilk urune tiklayip, acilan safyada case sensitive olmaksizin
    //    urun isminin phone icerdigini test edin

    // Method'lar birbirini takip eden gorevler bulundurdugu icin
    // @BeforeClass ve @AfterClass kullanmaliyiz

    WebDriver driver;

    @BeforeClass
    public void setup(){
        // WebDriverManager.chromedriver().setup();
        // sirket bize bir WebDriver verirse onu kullaniriz
        // yoksa Selenium'un kendi WebDriver'ini kullanabiliriz
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    /*
        priority testlerin dogru siralama ile calismasini SAGLAR
        ANCAK bu ornekte oldugu gibi
        birbirine bagimli testlerde
        bir assertion failed oldugunda,
        geriye kalanlarin calismasi ANLAMSIZ hale gelebilir

        bu durumda priority ile yapilan siralama guzel ama eksik kalir

        TestNG ile bu ornekte oldugu gibi birbirine bagimli method'larin
        calismasini da birbirine bagimli hale getirebiliriz
        boylece onceki test calisip PASSED olmazsa
        sonraki test(ler) direk IGNORE edilir ve HIC CALISTIRILMAZ

        1- dependsOnMethods bir siralama yontemi degildir
           ama sira kendine gelen bir method baska bir method'a baglanmissa
           onceligi ona verir

        2- Biz test method'larini bagimsiz olarak calistirabiliriz
           Ancak bir method'u bagimsiz olarak calistirmak istedigimizde
           o method dependsOnMethods ile baska bir method'a baglanmissa
           once bagli oldugu method'un calismasini saglar
           ANCAK bu calisma 2 method icindir, daha fazla method birbirini calistirmaz
     */

    @Test
    public void anasayfaTesti()  {


        // 1- testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // ve sayfaya gittiginizi test edin
        // url'in testotomasyonu icerdigini test edelim

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test (dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edelim
        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucYaziElementi.getText();

        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);

    }

    @Test (dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){
        // 3- ilk urune tiklayip,

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acilan safyada case sensitive olmaksizin
        // urun isminin phone icerdigini test edin

        String expectedIsimIcerigi = "phone";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualIsimKucukHarf = urunIsimElementi.getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualIsimKucukHarf.contains(expectedIsimIcerigi));

    }



}
