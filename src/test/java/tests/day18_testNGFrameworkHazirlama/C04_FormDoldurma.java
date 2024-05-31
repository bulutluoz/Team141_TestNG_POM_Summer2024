package tests.day18_testNGFrameworkHazirlama;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_FormDoldurma {

    @Test
    public void formDoldurmaTesti(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        TestotomasyonuFormPage testotomasyonuFormPage = new TestotomasyonuFormPage();

        Select selectGun = new Select(testotomasyonuFormPage.gunDropdownElementi);
        selectGun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        Select selectAy = new Select(testotomasyonuFormPage.ayDropdownElementi);
        selectAy.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testotomasyonuFormPage.yilDropdownElementi);
        selectYil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin

        System.out.println(
                selectGun.getFirstSelectedOption().getText() + " - " +
                selectAy.getFirstSelectedOption().getText() + " - " +
                selectYil.getFirstSelectedOption().getText()
        );

        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> aySecenekElementleriList =  selectAy.getOptions();

        System.out.println(ReusableMethods.stringListesineDonustur(aySecenekElementleriList));

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedBoyut = 13;
        int actualBoyut = aySecenekElementleriList.size();

        Assert.assertEquals(actualBoyut,expectedBoyut);

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
