package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("convidados")
    public String guests(Model model) {
        List<Guest> guests = guestService.list();
        model.addAttribute("guests", guests);

        Guest guest = new Guest();
        model.addAttribute("guest", guest);

        return "convidados";
    }

    @PostMapping("convidados")
    public String create(@ModelAttribute Guest guest, Model model) {
        guestService.create(guest);

        return guests(model);
    }

    @PostMapping("convidados/{id}")
    public String delete(@PathVariable int id, Model model) {
        guestService.delete(id);

        return "redirect:/convidados";
    }

}
