package application.controller;

import application.dao.HallgatoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HallgatoController {

    @Autowired
    private HallgatoDAO hallgatoDAO;


    @GetMapping("/hallgato")
    public String hallgato(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("adatok", hallgatoDAO.sajatAdatokListazasa(username));
        return "hallgato";
    }
}
