package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElRinconDeSusiPage extends BaseHelper {
    @FindBy(id = "nav")
    WebElement navigationBar;
    @FindBy(className = "form-group")
    WebElement usernameAndPasswordField;

    WebDriver driver;

    public ElRinconDeSusiPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage(){
        driver.get("https://suzmar94.github.io/final-project/");
    }
    private void clickOnWorks(){
        List<WebElement> navBar = navigationBar.findElements(By.className("navigacija"));
        WebElement thirdOption = navBar.get(2);
        thirdOption.click();
    }

    private void usernameField(String text){
        List<WebElement> usernameBox = usernameAndPasswordField.findElements(By.tagName("input"));
        WebElement username = usernameBox.get(0);
        username.click();
        username.sendKeys(text);

    }
    private void passwordField(String text){
        List<WebElement> passwordBox = usernameAndPasswordField.findElements(By.tagName("input"));
        WebElement password = passwordBox.get(1);
        password.click();
        password.sendKeys(text);

    }
    private void submitButton(){
        List<WebElement> submitBox = usernameAndPasswordField.findElements(By.tagName("input"));
        WebElement submit = submitBox.get(2);
        submit.click();

    }
    public void logInForm(String text, String text1){
        navigateToPage();
        clickOnWorks();
        usernameField(text);
        passwordField(text1);
        submitButton();
    }
}
