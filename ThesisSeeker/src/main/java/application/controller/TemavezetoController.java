package application.controller;

import application.dao.DolgozatDAO;
import application.model.Dolgozat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class TemavezetoController {

    @Autowired
    private DolgozatDAO dolgozatDAO;


    @GetMapping("/belsoTemavezeto")
    public String belso(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("dolgozatok", dolgozatDAO.listTemavezetoDolgozat(username));
        model.addAttribute("temavezetonekHanyHallgatojaVedettSikeresenFelevente", dolgozatDAO.temavezetonekHanyHallgatojaVedettSikeresenFelevente(username));
        model.addAttribute("dolgozat", new Dolgozat());
        return "belsoTemavezeto";
    }

    @GetMapping("/kulsoTemavezeto")
    public String kulso(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("temavezetonekHanyHallgatojaVedettSikeresenFelevente", dolgozatDAO.temavezetonekHanyHallgatojaVedettSikeresenFelevente(username));
        return "kulsoTemavezeto";
    }

    @PostMapping(value = "/updateDolgozatCime")
    public String updateDolgozat(@ModelAttribute Dolgozat dolgozat) {
        boolean res = dolgozatDAO.updateDolgozatCime(dolgozat);
        if (res) {
            return "redirect:/belsoTemavezeto";
        }
        return "redirect:/belsoTemavezeto";
    }
}
