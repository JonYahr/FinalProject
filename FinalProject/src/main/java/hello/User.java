/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author JonYa
 */
public class User {
    
    private String username;
    private String password;
    private String name;
    private String major;
    private String year;
    private String bio;
    private String interests;
    private String url;
    
    public User(){
        
        //String username, String password, String name, String major, String year, String bio, String interests
        
        /*
        this.username = username;
        this.password = password;
        this.name = name;
        this.major = major;
        this.year = year;
        this.bio = bio;
        this.interests = interests;
        */
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getYear() {
        return year;
    }

    public String getBio() {
        return bio;
    }

    public String getInterests() {
        return interests;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
