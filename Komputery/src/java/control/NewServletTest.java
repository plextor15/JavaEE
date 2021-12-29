package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "testowy")
public class NewServletTest {
    @RequestMapping("/pierwszy")
    public String pierwszyWidok(Model model) {
        String ciag="Spring MVC";
        model.addAttribute("wiadomosc", ciag);
        return "testing_V";
    }
}
