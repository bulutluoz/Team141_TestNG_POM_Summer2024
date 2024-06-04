package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebAppPage {

    public WebAppPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="signin_button")
    public WebElement ilkSayfaSigninLinki;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement loginUsernameKutusu;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement loginPasswordKutusu;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement logInSignInButton;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLinki;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLinki;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownElementi;
}
