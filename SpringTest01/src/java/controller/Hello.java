package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    
    @RequestMapping("/hello")
    public String sayHello(Model model) {
        
        //String info="Spring MVC";
        //model.addAttribute("wiadomosc", info);
        return "hello";
    }
}