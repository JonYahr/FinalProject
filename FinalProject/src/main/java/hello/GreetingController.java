package hello;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/Index")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/Form")
    public String address(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("it worked");
        return "Form";
        
    }
    
    @GetMapping("/Thankyou")
    public String addressSubmit(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        
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
        return "Welcome";
    }
    
    @GetMapping("/Profile")
    public String Profile(Model model) {        
        return "Profile";
    }
    
    @GetMapping("/Login")
    public String Login(Model model) {        
        return "Login";
    }
    
    @PostMapping("/Thankyou")
    public String checkPersonInfo(@RequestParam(name="name") String name, @RequestParam(name="major") String major, @RequestParam(name="year") String year, @RequestParam(name="bio", required=false) String bio, @RequestParam(name="interests", required=false) String interests, Model model) {

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