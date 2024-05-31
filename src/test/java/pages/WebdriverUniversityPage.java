package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebdriverUniversityPage {

    public WebdriverUniversityPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
