/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.json.simple.JSONObject;


/**
 *
 * @author Jon
 */
public class SaveToJSON {
    
    public void save(User userModel){
        
        JSONObject obj = new JSONObject();
        
        /*
        String username = (String) jsonObject.get("username");
                    String password = (String) jsonObject.get("password");
                    String name = (String) jsonObject.get("name");
                    String major = (String) jsonObject.get("major");
                    String year = (String) jsonObject.get("year");
                    String bio = (String) jsonObject.get("bio");
                    String interests = (String) jsonObject.get("interests");
        */
        
        obj.put("name", userModel.getUsername());
        obj.put("name", userModel.getPassword());
        obj.put("name", userModel.getName());
        obj.put("name", userModel.getMajor());
        obj.put("name", userModel.getYear());
        obj.put("name", userModel.getBio());
        obj.put("name", userModel.getInterests());
        

        
        //Random rand = new Random();

        //int  n = rand.nextInt(999999999) + 1;
        
        try (FileWriter file = new FileWriter("SavesJSON", true)) {
                file.write(obj.toJSONString());
                file.write(System.getProperty( "line.separator" ));
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + obj);
        }catch(IOException e){
            
        }
    }
}