package dev.basicbot.web_activities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.time.Duration;

public class navigateInPage {
    
    // Create the attibutes for the driver
    private final WebDriver driver;

    // Instanciate the object 
    public navigateInPage(WebDriver inputDriver){
        this.driver = inputDriver;
        System.out.println("Instanciate the input arguments.");
    }

    // Open web page  
    public boolean openWebPage(String urlWebPage){
        if (this.driver != null){
            //Open web page & maximize window
            this.driver.get(urlWebPage);
            this.driver.manage().window().maximize();
            System.out.println("WEB - Web page is open");
            return true;
            
        } else {
            System.out.println("WEB - Web page not load correctly check execution.");
            return false;
        }  
    }

    // Find the crypto currency and make click
    public boolean selectAsset(String coinToClick){
        try {
                if (coinToClick != null){
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
                    String xpathCoin = String.format("//a[@href='/currencies/%s/']", coinToClick);
                    //  driver.findElement(By.xpath(xpathCoin) 
                    
                    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpathCoin)));

                    WebElement linkAsset = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath(xpathCoin))
                    );                    

                    js.executeScript("arguments[0].click();", linkAsset);

                    return true;
                } else {
                    return false;
                }        
            
        } catch (Exception e) {
            System.out.println("Can't select the coin (Asset)");
            return false;
        }
    }

    // Check if web page (Main) load correctly
    public boolean checkIfLoadMainPage(){
        try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
                //String xpathMainWebPage = String.format("//a[@href='/currencies/%s/']", "#search");

                WebElement inputBoxElement = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Log In']")));
                System.out.println("WEB - Main web page load correctly.");
                return (inputBoxElement.isDisplayed()) ? true: false;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }
                                                        
    // Search the cryptpo currency en several web page (Number of searches is implicitly)
    public boolean searchInTheNextPage(Integer pageNum, String urlWebPage){
        try {
                String urlByIndex = String.format((urlWebPage + "?page=%d"), pageNum);
                driver.get(urlByIndex);
                /*
                String xpathIndexWebPage = String.format("//a[contains(@aria-label, 'Page %d')]", pageNum);
                By pageNumberInput = By.xpath(xpathIndexWebPage);

                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpathIndexWebPage)));

                WebElement nextWepPage = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(xpathIndexWebPage))
                );                    

                js.executeScript("arguments[0].click();", nextWepPage);
                */
            return true;

        } catch (Exception e) {
            System.out.println("Error in change to the window. Error: " + e);            
            return false;
        }
    }

    // Extract price of coin
    public String getCoinValue(){
        String coinPrice = ""; 
        try {
                coinPrice = (driver.findElement(By.xpath("//*[@id=\"section-coin-overview\"]/div[2]/span"))).getText();

            } catch (Exception e) {
                e.printStackTrace();
        } finally {
            return coinPrice;
        }
    }
}

