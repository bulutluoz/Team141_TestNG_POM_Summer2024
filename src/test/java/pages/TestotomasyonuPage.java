package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuPage {
    // Her page class'inda kullanilacak driver objesi class'a tanitilmalidir
    // BUnun icin constructor'i gorunur hale getirip
    // constructor icinde driver'i class'a tanimlariz

    public TestotomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // WebElement aramakutusu = Driver.getDriver().findElement(By.id("global-search"));

    @FindBy(id = "global-search")
    public WebElement aramakutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucElementi;

}
