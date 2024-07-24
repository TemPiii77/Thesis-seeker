package application.controller;

import application.dao.SzemelyDAO;
import application.dao.TanszekDAO;
import application.model.Hallgato;
import application.model.Temavezeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SzemelyController {

    @Autowired
    private SzemelyDAO szemelyDAO;
    @Autowired
    private TanszekDAO tanszekDAO;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("tanszekek", tanszekDAO.listTanszek());
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/registerhallgato")
    public String registerhallgato(@ModelAttribute Hallgato hallgato) {
        boolean res = szemelyDAO.insertHallgato(hallgato);
        if (res) {
            return "redirect:/register?success=true";
        }
        return "redirect:/register?error=true";
    }

    @PostMapping(value = "/registerbelsotv")
    public String registerbelsotv(@ModelAttribute Temavezeto temavezeto) {
        Temavezeto temavezeto2 = new Temavezeto(temavezeto.getEgyetemiAzonosito(), temavezeto.getElotag(), temavezeto.getVezeteknev(), temavezeto.getKeresztnev(),
                temavezeto.getJelszo(), temavezeto.getJelszoUjra(), "ROLE_BELSOTV", temavezeto.getMunkakoriBeosztas(), "Belső témavezető", temavezeto.getTanszekNev());
        boolean res = szemelyDAO.insertTemavezeto(temavezeto2);
        if (res) {
            return "redirect:/register?success2=true";
        }
        return "redirect:/register?error2=true";
    }
}
