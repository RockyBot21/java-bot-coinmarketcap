package dev.basicbot;

import dev.basicbot.web_activities.navigateInPage;
import dev.basicbot.json_activities.crudInJson;
import dev.basicbot.log_activities.LogManager;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import java.nio.file.Path;
/*
    Example for the basic bot or automatization with java (Coinmarketcap).
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver = null; 

        try {
            Dotenv dotenv     = Dotenv.load();
            String urlWebPage = dotenv.get("URL_WEB_PAGE");
            String txtCoins   = dotenv.get("COINS_TO_CONSULT");
            String jCoinPath    = dotenv.get("PATH_JSON_FILE");
            String jCoinsName = dotenv.get("JSON_FILE_NAME");

            LogManager.getLogger().info("Load variables in the .env file.");
            
            String[] lsCoins = txtCoins.split(",");  

            Path jsonFile = Path.of(jCoinPath, jCoinsName);
            System.out.println("Path of json file: " + jsonFile.toString());

            crudInJson.delJsonFile(jsonFile.toString());
            JSONObject jCoins = crudInJson.createJsonObj();
            LogManager.getLogger().info("Create json file: " + jsonFile.toString());
            
            driver = new ChromeDriver();     
            navigateInPage bot = new navigateInPage(driver);
            Boolean webOpen =  bot.openWebPage(urlWebPage);
            LogManager.getLogger().info("Open web page url: " + urlWebPage);

            if (webOpen){
                // Iterate over each coin to search in the list
                for (String coin : lsCoins){
                    bot.checkIfLoadMainPage();
                    LogManager.getLogger().info("Check if web page load correctly.");

                    int count = 1;

                    try {
                          Pattern pattern = Pattern.compile("[2-9]");
                          Matcher matcher = pattern.matcher(driver.getCurrentUrl());                          

                          if (matcher.find()){
                            bot.searchInTheNextPage(count, urlWebPage);
                            LogManager.getLogger().info("Search inthe next page.");                            
                          }
                                                   
                    } catch (Exception e) {
                        continue;
                    }

                    do{
                        try {
                                Boolean coinFound = bot.selectAsset(coin.strip());
                                if (coinFound){
                                    System.out.println("Enter to the coin: " + coin.strip() + " in the page: " + count);                                    
                                    //Thread.sleep(5000);
                                    String priceCoin = bot.getCoinValue();
                                    System.out.println("Coin name: " + coin.strip() + " Value: " + priceCoin);
                                    LogManager.getLogger().info("Coin found with the name: " + coin.strip() + " Value: " + priceCoin);
                                    LogManager.getLogger().info("Coin found in the page number --> " + count);
                                    jCoins = crudInJson.insertDataJson(jCoins, coin.strip(), priceCoin.strip());                                     
                                    driver.navigate().back();
                                    //Thread.sleep(2000);
                                    break;

                                } else {
                                    count ++;
                                    System.out.println("Try to search in the next page num: " + count);
                                    bot.searchInTheNextPage(count, urlWebPage);                                                   
                                    continue;
                                } 

                        } catch (Exception e) {
                            System.out.println("Error in search by page.");
                            LogManager.getLogger().info("Error in search by page.");
                        }
                    } while(count <= 5);
                }
            }

            crudInJson jsonCreated = new crudInJson(false);
            boolean resultExe = jsonCreated.createJsonFile(jsonFile.toString(), jCoins);
            System.out.println("Json file created: " + resultExe);
            LogManager.getLogger().info("Write the results in json file.  Result: " + resultExe);

        } catch (Exception e) {
            System.out.println("Show error" + e.toString());
            LogManager.getLogger().info("Error in execution: " + e.getMessage());
            e.printStackTrace();
        } finally {            
            System.out.println("Close the session.");
            if (driver != null){
                LogManager.getLogger().info("Close session in web browser.");
                driver.quit();
            }
        }
    }
}
