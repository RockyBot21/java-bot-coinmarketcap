package dev.basicbot.json_activities;

import org.json.JSONObject;
import java.io.FileWriter;
//import java.io.IOException;
import java.io.File;

public class crudInJson {

    private boolean jsonFileExists = false;     

    // Instanciate the class 
    public crudInJson(boolean jsonFileExists){
        this.jsonFileExists = jsonFileExists;
    }

    // Methods in java
    // Check if file exists (Json file)
    public static void delJsonFile(String pathDir){
        try {
                File filePath = new File(pathDir);

                if (filePath.exists())   filePath.delete();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("JSON: Can't delete the json file.");
        }
    }

    // Create a json object
    public static JSONObject createJsonObj(){
        JSONObject json = new JSONObject();
        return json;            
    }

    // Insert data to Json object
    public static JSONObject insertDataJson(JSONObject jCoins, String keyVal, String valueVal){
        try {
                jCoins.put(keyVal, valueVal);
                return jCoins;

        } catch (Exception e) {
            return jCoins;
        }
    }

    // Create a json file with data 
    public boolean createJsonFile(String pathDir, JSONObject jCoins){        
        if (jCoins.isEmpty()) {
            return false;
        } else {
            FileWriter fileCoins = null;

            try {
                    fileCoins = new FileWriter(pathDir);
                    fileCoins.write(jCoins.toString(4));
                    //fileCoins.flush();
                    fileCoins.close();
                    jsonFileExists = true;
                    return jsonFileExists;                    
                    
            } catch (Exception e) {
                e.printStackTrace();
                return jsonFileExists;
                
            } /*finally {
                if (fileCoins != null) {
                    try {
                        fileCoins.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return jsonFileExists;
             
            }*/
        }
    }
}

