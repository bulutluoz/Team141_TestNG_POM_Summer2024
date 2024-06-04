package tests.day20_softAssertion_xmlDosyalar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssertion {
    @Test
    public void currencyTesti(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webAppUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        //    dogrulayin(verify) dendiginde genelde softAssert tercih edilir
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("webAppUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Gidilen url farkli, satir 22");

        // 3. Sign in butonuna basin
        WebAppPage webAppPage = new WebAppPage();

        webAppPage.ilkSayfaSigninLinki
                    .click();

        // 4. Login kutusuna “username” yazin
        webAppPage.loginUsernameKutusu
                    .sendKeys(ConfigReader.getProperty("webAppUsername"));

        // 5. Password kutusuna “password” yazin
        webAppPage.loginPasswordKutusu
                    .sendKeys(ConfigReader.getProperty("webAppPassword"));

        // 6. Sign in tusuna basin
        webAppPage.logInSignInButton
                    .click();

        // 7. Back tusuna basin
        Driver.getDriver()
                .navigate()
                .back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(webAppPage.onlineBankingLinki.isDisplayed() , "Giris yapilamadi satir 49");

        // 9. Online banking menusunu tiklayin
        webAppPage.onlineBankingLinki
                    .click();

        //10. Pay Bills sayfasina gidin
        webAppPage.payBillsLinki
                .click();
        //11. “Purchase Foreign Currency” tusuna basin
        webAppPage.purchaseCurrencyTab
                .click();
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(webAppPage.pcCurrencyDropdownElementi.isEnabled() , "dropdown erisilebilir degil satir 62");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(webAppPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenKur = ConfigReader.getProperty("webAppSelectedCurrency");
        String actualSecilenKur = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenKur,expectedSecilenKur,"EUR secilememis, satir 73");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        String expectedDropdownMenuBoyutu = ConfigReader.getProperty("webAppDropdownBoyut");
        Integer actualDropdownMenuBoyutu = select.getOptions()
                                                    .size();

        softAssert.assertEquals(actualDropdownMenuBoyutu+"",expectedDropdownMenuBoyutu,"Dropdown menu boyutu yanlis satir 81");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        List<WebElement> optionsElementList = select.getOptions();
        List<String> dropdownOpsiyonlariStringList = ReusableMethods.stringListesineDonustur(optionsElementList);

        softAssert.assertTrue(dropdownOpsiyonlariStringList.contains( ConfigReader.getProperty("webAppDropdownIcerik") ),"dropdown menu Canada dolari icermiyor, satir 91");

        //17. Sayfayi kapatin
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
