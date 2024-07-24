package application.controller;

import application.dao.*;
import application.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private KarDAO karDAO;
    @Autowired
    private IntezetDAO intezetDAO;
    @Autowired
    private TanszekDAO tanszekDAO;
    @Autowired
    private SzakintezetekDAO szakintezetekDAO;
    @Autowired
    private SzakDAO szakDAO;
    @Autowired
    private JarDAO jarDAO;
    @Autowired
    private HallgatoDAO hallgatoDAO;
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private TemavezetoDAO temavezetoDAO;
    @Autowired
    private SzemelyDAO szemelyDAO;
    @Autowired
    private DolgozatDAO dolgozatDAO;
    @Autowired
    private VezetDAO vezetDAO;


    @GetMapping("/loadtanszekNev")
    @ResponseBody
    public List<Tanszek> loadtanszekNev(@RequestParam("szakAzonosito") String szakAzonosito) {
        return tanszekDAO.listSpecifiedTanszek(szakAzonosito);
    }

    @GetMapping("/loadszak")
    @ResponseBody
    public List<Szak> loadszak(@RequestParam("egyetemiAzonosito") String egyetemiAzonosito) {
        return szakDAO.listSpecifiedSzak(egyetemiAzonosito);
    }

    @GetMapping("/loadtemavezeto")
    @ResponseBody
    public List<String> loadtemavezeto(@RequestParam("dolgozatAzonosito") String dolgozatAzonosito) {
        List<String> teszt = temavezetoDAO.listSpecifiedTemavezeto(dolgozatAzonosito);

        return teszt;
    }


    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("karok", karDAO.listKar());
        model.addAttribute("intezetek", intezetDAO.listIntezet());
        model.addAttribute("tanszekek", tanszekDAO.listTanszek());
        model.addAttribute("szakintezetek", szakintezetekDAO.listSzakintezetek());
        model.addAttribute("szakok", szakDAO.listSzak());
        model.addAttribute("jarok", jarDAO.listJar());
        model.addAttribute("hallgatok", hallgatoDAO.listHallgato());
        model.addAttribute("adminok", adminDAO.listAdmin());
        model.addAttribute("temavezetok", temavezetoDAO.listTemavezeto());
        model.addAttribute("belsotemavezetok", temavezetoDAO.listBelsoTemavezeto());
        model.addAttribute("kulsotemavezetok", temavezetoDAO.listKulsoTemavezeto());
        model.addAttribute("szemelyek", szemelyDAO.listSzemely());
        model.addAttribute("dolgozatok", dolgozatDAO.listDolgozat());
        model.addAttribute("vezetek", vezetDAO.listVezet());
        model.addAttribute("szemeszterek", szemeszter());
        model.addAttribute("melyikTemavezetohozHanyDolgozatFelevente", dolgozatDAO.melyikTemavezetohozHanyDolgozatFelevente());
        model.addAttribute("tanszekenkentHanyDolgozatFelevente", dolgozatDAO.tanszekenkentHanyDolgozatFelevente());
        String username = principal.getName();
        model.addAttribute("nev", username);

        model.addAttribute("kar", new Kar());
        model.addAttribute("intezet", new Intezet());
        model.addAttribute("tanszek", new Tanszek());
        model.addAttribute("szakintezet", new Szakintezetek());
        model.addAttribute("szak", new Szak());
        model.addAttribute("jar", new Jar());
        model.addAttribute("hallgato", new Hallgato());
        model.addAttribute("adminisztrator", new Adminisztrator());
        model.addAttribute("temavezeto", new Temavezeto());
        model.addAttribute("szemely", new Szemely());
        model.addAttribute("dolgozat", new Dolgozat());
        model.addAttribute("vezet", new Vezet());

        return "admin";
    }

    private List<String> szemeszter() {
        List<String> szemeszterek = new ArrayList<>();
        for (int i = 2000; i < 2099; i++) {
            String tmp = i + "/" + (i + 1) + "/" + 1;
            String tmp2 = i + "/" + (i + 1) + "/" + 2;
            szemeszterek.add(tmp);
            szemeszterek.add(tmp2);
        }
        return szemeszterek;
    }

    @PostMapping(value = "/createKar")
    public String createKar(@ModelAttribute Kar kar) {
        boolean res = karDAO.createKar(kar);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteKar")
    public String deleteKar(@ModelAttribute Kar kar) {
        boolean res = karDAO.deleteKar(kar);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/createIntezet")
    public String createIntezet(@ModelAttribute Intezet intezet) {
        boolean res = intezetDAO.createIntezet(intezet);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateIntezet")
    public String updateIntezet(@ModelAttribute Intezet intezet) {
        boolean res = intezetDAO.updateIntezet(intezet);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteIntezet")
    public String deleteIntezet(@ModelAttribute Intezet intezet) {
        boolean res = intezetDAO.deleteIntezet(intezet.getIntezetNev());
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/createTanszek")
    public String createTanszek(@ModelAttribute Tanszek tanszek) {
        boolean res = tanszekDAO.createTanszek(tanszek);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateTanszek")
    public String updateTanszek(@ModelAttribute Tanszek tanszek) {
        boolean res = tanszekDAO.updateTanszek(tanszek);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteTanszek")
    public String deleteTanszek(@ModelAttribute Tanszek tanszek) {
        boolean res = tanszekDAO.deleteTanszek(tanszek.getTanszekNev());
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/createSzak")
    public String createSzak(@ModelAttribute Szak szak) {
        boolean res = szakDAO.createSzak(szak);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateSzak")
    public String updateSzak(@ModelAttribute Szak szak) {
        boolean res = szakDAO.updateSzak(szak);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteSzak")
    public String deleteSzak(@ModelAttribute Szak szak) {
        boolean res = szakDAO.deleteSzak(szak.getSzakAzonosito());
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/registeradmin")
    public String registeradmin(@ModelAttribute Adminisztrator adminisztrator) {
        boolean res = szemelyDAO.insertAdmin(adminisztrator);
        if (res) {
            return "redirect:/admin?success=true";
        }
        return "redirect:/admin?error=true";
    }

    @PostMapping(value = "/registerkulsotv")
    public String registerkulsotv(@ModelAttribute Temavezeto temavezeto) {
        Temavezeto temavezeto2 = new Temavezeto(temavezeto.getEgyetemiAzonosito(), temavezeto.getElotag(), temavezeto.getVezeteknev(), temavezeto.getKeresztnev(),
                temavezeto.getJelszo(), temavezeto.getJelszoUjra(), "ROLE_KULSOTV", "nincs", "Külső témavezető", "nincs");
        boolean res = szemelyDAO.insertTemavezeto(temavezeto2);
        if (res) {
            return "redirect:/admin?success2=true";
        }
        return "redirect:/admin?error2=true";
    }


    @PostMapping(value = "/deleteSzemely")
    public String deleteSzemely(@ModelAttribute Szemely szemely) {
        boolean res = szemelyDAO.deleteSzemely(szemely.getEgyetemiAzonosito());
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateHallgato")
    public String updateHallgato(@RequestParam("egyetemiAzonosito") String egyetemiAzonosito) {
        String[] tmp = egyetemiAzonosito.split(";");

        Hallgato hallgato = new Hallgato(tmp[0], tmp[1]);
        boolean res = szemelyDAO.updateHallgato(hallgato);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateAdmin")
    public String updateAdmin(@ModelAttribute Adminisztrator adminisztrator) {
        boolean res = szemelyDAO.updateAdmin(adminisztrator);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateBelsoTV")
    public String updateBelsoTV(@ModelAttribute Temavezeto temavezeto) {
        boolean res = szemelyDAO.updateBelsoTV(temavezeto);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateSzemely")
    public String updateSzemely(@ModelAttribute Szemely szemely) {
        boolean res = szemelyDAO.updateSzemely(szemely);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/createSzakintezet")
    public String createSzakintezet(@ModelAttribute Szakintezetek szakintezetek) {
        boolean res = szakintezetekDAO.createSzakintezet(szakintezetek);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateSzakintezet")
    public String updateSzakintezet(@RequestParam("szakAzonosito") String szakAzonosito, @RequestParam("intezetNev") String intezetNev) {
        String[] tmp = szakAzonosito.split(";");

        Szakintezetek szakintezetek = new Szakintezetek(szakAzonosito, intezetNev);
        boolean res = szakintezetekDAO.updateSzakintezet(tmp[0], tmp[1], szakintezetek);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteSzakintezet")
    public String deleteSzakintezet(@RequestParam("szakAzonosito") String szakAzonosito) {
        String[] tmp = szakAzonosito.split(";");

        Szakintezetek szakintezetek = new Szakintezetek(tmp[0], tmp[1]);
        boolean res = szakintezetekDAO.deleteSzakintezet(szakintezetek);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }


    @PostMapping(value = "/createDolgozat")
    public String createDolgozat(@ModelAttribute Dolgozat dolgozat) {
        boolean res = dolgozatDAO.createDolgozat(dolgozat);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }


    @PostMapping(value = "/updateDolgozat")
    public String updateDolgozat(@ModelAttribute Dolgozat dolgozat) {
        boolean res = dolgozatDAO.updateDolgozat(dolgozat);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteDolgozat")
    public String deleteDolgozat(@ModelAttribute Dolgozat dolgozat) {
        boolean res = dolgozatDAO.deleteDolgozat(dolgozat.getDolgozatAzonosito());
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }


    @PostMapping(value = "/createJar")
    public String deleteJar(@ModelAttribute Jar jar) {
        boolean res = jarDAO.createJar(jar);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateJar")
    public String updateJar(@RequestParam("szakAzonosito") String szakAzonosito,
                            @RequestParam("kezdesSzemesztere") String kezdesSzemesztere, @RequestParam("vegzesSzemesztere") String vegzesSzemesztere,
                            @RequestParam("diplomaSorszama") String diplomaSorszama) {

        String[] tmp = szakAzonosito.split(";");

        Jar jar = new Jar(tmp[0], tmp[1], kezdesSzemesztere, vegzesSzemesztere, diplomaSorszama);
        boolean res = jarDAO.updateJar(jar);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }


    @PostMapping(value = "/deleteJar")
    public String deleteJar(@RequestParam("szakAzonosito") String szakAzonosito) {
        String[] tmp = szakAzonosito.split(";");

        Jar jar = new Jar(tmp[0], tmp[1]);
        boolean res = jarDAO.deleteJar(jar);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/createVezet")
    public String createVezet(@ModelAttribute Vezet vezet) {
        boolean res = vezetDAO.createVezet(vezet);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/updateVezet")
    public String updateVezet(@ModelAttribute Vezet vezet) {
        boolean res = vezetDAO.updateVezet(vezet.getDolgozatAzonosito(), vezet.getEgyetemiAzonosito());
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/deleteVezet")
    public String deleteVezet(@RequestParam("dolgozatAzonosito") String dolgozatAzonosito) {
        String[] tmp = dolgozatAzonosito.split(";");

        Vezet vezet = new Vezet(Integer.parseInt(tmp[0]), tmp[1]);
        boolean res = vezetDAO.deleteVezet(vezet);
        if (res) {
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }
}
