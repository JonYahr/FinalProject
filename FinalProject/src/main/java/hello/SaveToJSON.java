/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        
        obj.put("username", userModel.getUsername());
        obj.put("password", userModel.getPassword());
        obj.put("name", userModel.getName());
        obj.put("major", userModel.getMajor());
        obj.put("year", userModel.getYear());
        obj.put("bio", userModel.getBio());
        obj.put("interests", userModel.getInterests());
        

        
        //Random rand = new Random();

        //int  n = rand.nextInt(999999999) + 1;
        
        try (FileWriter file = new FileWriter("SavesJSON", true)) {
                file.write(obj.toJSONString());
                file.write(System.getProperty( "line.separator" ));
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + obj);
                File f = new File("SavesJSON");
                //Print absolute path
                System.out.println(f.getAbsolutePath());
        }catch(IOException e){
            
        }
    }
}