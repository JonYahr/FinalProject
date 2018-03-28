/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jon
 */
public class LoadFromJSON {
    
    
    public ArrayList<User> load(){
        
        BufferedReader br = null;
        JSONParser parser = new JSONParser();
        ArrayList<User> userModelList = new ArrayList<>();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("SavesJSON"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println("Record:\t" + sCurrentLine);

                User userModel = new User();
                
                Object obj;
                try {
                    
                    obj = parser.parse(sCurrentLine);
                    JSONObject jsonObject = (JSONObject) obj;
                    
                    String username = (String) jsonObject.get("username");
                    String password = (String) jsonObject.get("password");
                    String name = (String) jsonObject.get("name");
                    String major = (String) jsonObject.get("major");
                    String year = (String) jsonObject.get("year");
                    String bio = (String) jsonObject.get("bio");
                    String interests = (String) jsonObject.get("interests");
                    
                    userModel.setUsername(username);
                    userModel.setPassword(password);
                    userModel.setName(name);
                    userModel.setMajor(major);
                    userModel.setYear(year);
                    userModel.setBio(bio);
                    userModel.setInterests(interests);
                    
                    userModelList.add(userModel);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return userModelList;
        
    }
}