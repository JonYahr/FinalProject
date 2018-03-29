package hello;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    String SESSION_username = "Login";
    String SESSION_password = "";
    
    SaveToJSON save = new SaveToJSON();
    
    @GetMapping("/Index")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("SESSION_username", SESSION_username);
        return "index";
    }

    @GetMapping("/Form")
    public String address(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("it worked");
        model.addAttribute("SESSION_username", SESSION_username);
        return "Form";
        
    }
    
    @GetMapping("/Thankyou")
    public String addressSubmit(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("SESSION_username", SESSION_username);
        
        /*
        model.addAttribute("name", name);
        model.addAttribute("major", major);
        model.addAttribute("year", year);
        model.addAttribute("bio", bio);
        model.addAttribute("interests", interests);
        */
        //name, major, year, bio, interests

        return "Thankyou";
    }
    
    @GetMapping("/Welcome")
    public String welcome(Model model) {
        model.addAttribute("SESSION_username", SESSION_username);
        return "Welcome";
    }
    
    @GetMapping("/Profile")
    public String Profile(Model model) {    
        
        model.addAttribute("SESSION_username", SESSION_username);
        
        if(SESSION_username.equals("Login")){
            return "Login";
        }
        
        model.addAttribute("SESSION_username", SESSION_username);
        
        return "Profile";
    }
    
    @PostMapping("/ProfileConfirmation")
    public String ProfileConfirmation(@RequestParam(name="name") String name, @RequestParam(name="major") String major, @RequestParam(name="year") String year, 
            @RequestParam(name="bio") String bio, @RequestParam(name="interests") String interests, Model model) {      
        
        model.addAttribute("SESSION_username", SESSION_username);
        
        if(SESSION_username.equals("Login")){
            return "Login";
        }
        
        List<String> fileContent = null;
        
        try {
            fileContent = new ArrayList<>(Files.readAllLines(Paths.get("SavesJSON"), StandardCharsets.UTF_8));
            
        } catch (IOException ex) {
            Logger.getLogger(GreetingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(fileContent.size());

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).contains(SESSION_username)){
                
                System.out.println("HERE IS LINE I: " + fileContent.get(i));
                
                model.addAttribute("SESSION_username", SESSION_username);
                        
                JSONObject obj = new JSONObject();
        
                obj.put("username", SESSION_username);
                obj.put("password", SESSION_password);
                obj.put("name", name);
                obj.put("major", major);
                obj.put("year", year);
                obj.put("bio", bio);
                obj.put("interests", interests);
                        
                fileContent.set(i, obj.toJSONString());
                break;
            }
        }
        
        try {
            Files.write(Paths.get("SavesJSON"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(GreetingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addAttribute("name", name);
        model.addAttribute("major", major);
        model.addAttribute("year", year);
        model.addAttribute("bio", bio);
        model.addAttribute("interests", interests);
        
        return "ProfileConfirmation";
    }
    
    @GetMapping("/Login")
    public String Login(Model model) {  
        model.addAttribute("SESSION_username", SESSION_username);
        return "Login";
    }
    
    @GetMapping("/LoginConfirmation")
    public String LoginConfirmation(@RequestParam(name="username", required = true) String username, @RequestParam(name="password", required = true) String password, Model model) {
        
        SESSION_username = username;
        SESSION_password = password;
        
        model.addAttribute("SESSION_username", SESSION_username);        
        return "LoginConfirmation";
    }
    
    @PostMapping("/LoginConfirmation")
    public String PostLoginConfirmation(@RequestParam(name="username", required = true) String username, @RequestParam(name="password", required = true) String password, Model model) {
        SESSION_username = username;
        SESSION_password = password;
        model.addAttribute("SESSION_username", SESSION_username);        
        return "LoginConfirmation";
    }
    
    @PostMapping("/SignupConfirmation")
    public String SignupConfirmation(@RequestParam(name="username", required = true) String username, @RequestParam(name="password", required = true) String password, @RequestParam(name="confirmPassword", required = true) String confirmPassword, Model model) {
        
        //if pass = pass and username does not exist...
        
        SESSION_username = username;
        SESSION_password = password;
        model.addAttribute("SESSION_username", SESSION_username);
        
        User user = new User();        
        
        user.setUsername(username);
        user.setPassword(password);
        user.setName("");
        user.setMajor("");
        user.setYear("");
        user.setBio("");
        user.setInterests("");
        
        save.save(user);
                
        return "SignupConfirmation";
    }
    
    @GetMapping("/SignupConfirmation")
    public String PostSignupConfirmation(Model model) {
        model.addAttribute("SESSION_username", SESSION_username);
        //SESSION_username = username;
        //SESSION_password = password;
        //model.addAttribute("SESSION_username", SESSION_username);   
        model.addAttribute("SESSION_username", SESSION_username);  
        return "SignupConfirmation";
    }
    
    @GetMapping("/Signup")
    public String Signup(Model model) {
        model.addAttribute("SESSION_username", SESSION_username);
        return "Signup";
    }
    
    @PostMapping("/Thankyou")
    public String checkPersonInfo(@RequestParam(name="name") String name, @RequestParam(name="major") String major, @RequestParam(name="year") String year, @RequestParam(name="bio", required=false) String bio, @RequestParam(name="interests", required=false) String interests, Model model) {

        model.addAttribute("SESSION_username", SESSION_username);
        
        System.out.println("it worked");
        
        model.addAttribute("name", name);
        model.addAttribute("major", major);
        model.addAttribute("year", year);
        model.addAttribute("bio", bio);
        model.addAttribute("interests", interests);
        
        return "Thankyou";
        
    }
    
    //@RequestMapping(value = "/image/{imageName}")


    
    @GetMapping("/File")
    public String Image(Model model) throws IOException {
        ByteArrayOutputStream b = null;
        try{
            BufferedImage image = ImageIO.read(new File("C:\\Users\\JonYa\\OneDrive\\Documents\\NetBeansProjects2\\gs-serving-web-content\\initial\\src\\main\\java\\Assets\\elefun.jpg"));

            // write it to byte array in-memory (jpg format)
            b = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", b);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("here");
        // do whatever with the array...
        byte[] jpgByteArray = b.toByteArray();
        String s = new sun.misc.BASE64Encoder().encode(jpgByteArray);
        
        // convert it to a String with 0s and 1s        
        StringBuilder sb = new StringBuilder();
        for (byte by : jpgByteArray)
            sb.append(Integer.toBinaryString(by & 0xFF));
        
        model.addAttribute("image", s);
        
        return "File";
        
    }
    
}