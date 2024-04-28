package org.example.pages;

import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class CreateMonsterPage {

    @FindBy(xpath = "//*[@data-testid='app-name']")
    private WebElement appName;

    @FindBy(xpath="//*[@id=\"webpack-dev-server-client-overlay-div\"]/button")
    private WebElement dismissButton;

    @FindBy(xpath = "//*[@id=\"webpack-dev-server-client-overlay\"]")
    private WebElement iframeError;

    @FindBy(xpath = "//*[@data-testid='btn-create-monster']")
    private WebElement confirmButton;

    @FindBy(xpath = "//P[text()='Your Monsters']")
    private WebElement yourMonstersLabel;

    @FindBy(xpath = "//*[@data-testid='monster-card']")
    private WebElement monsterCard;

    @FindBy(xpath = "//*[@data-testid='card-monster-name']")
    private WebElement monsterCardName;

    @FindBy(xpath = "//*[@data-testid='card-monster-hp']")
    private WebElement monsterCardHp;

    @FindBy(xpath = "//*[@data-testid='card-monster-attack']")
    private WebElement monsterCardAttack;

    @FindBy(xpath = "//*[@data-testid='card-monster-defense']")
    private WebElement monsterCardDefense;

    @FindBy(xpath = "//*[@data-testid='card-monster-speed']")
    private WebElement monsterCardSpeed;


    public CreateMonsterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean isMainPageOpened(){
        return appName.getText().equals(Constants.APP_NAME);
    }

    public String getAppName(){
        return appName.getText();
    }

    public void clickOnMonster(WebDriver driver, Integer monsterId){
        WebElement element = driver.findElement(By.xpath(String.format(Constants.MONSTER_LOCATOR, monsterId)));
        element.click();
    }

    public String getMonsterImageUrl(WebDriver driver, Integer monsterId){
        WebElement element = driver.findElement(By.xpath(String.format(Constants.MONSTER_LOCATOR, monsterId)+"/img"));
        return element.getAttribute("src");
    }

    public Boolean isIconMonsterEnabled(WebDriver driver, String monsterId){
        WebElement element = driver.findElement(By.xpath(String.format(Constants.MONSTER_LOCATOR, monsterId)));
        return element.isEnabled();
    }
    public void dismissError(WebDriver driver){
        driver.switchTo().frame(iframeError);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(
                ExpectedConditions.elementToBeClickable(dismissButton)).click();
    }

    public void setAttribute(WebDriver driver, String attribute, String value){
        WebElement element = driver.findElement(By.name(attribute.toLowerCase().trim()));
        element.sendKeys(value);
    }

    public void completeAttributes(Map<String, String> data, WebDriver driver) {
        for (Map.Entry<String, String> e : data.entrySet()) {
            setAttribute(driver, e.getKey(), e.getValue());
        }
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }

    public Boolean isYourMonstersLabelDisplayed(){
        System.out.println("LABEL = " + yourMonstersLabel.getText());
        return yourMonstersLabel.isDisplayed() && monsterCard.isDisplayed();
    }

    public String getMonsterName(){
        return monsterCardName.getText();
    }

    public String getMonsterHp(){
        return monsterCardHp.getText();
    }

    public String getMonsterAttack(){
        return monsterCardAttack.getText();
    }

    public String getMonsterDefense(){
        return monsterCardDefense.getText();
    }

    public String getMonsterSpeed(){
        return monsterCardSpeed.getText();
    }

}


