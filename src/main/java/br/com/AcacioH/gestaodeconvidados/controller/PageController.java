package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private GuestService guestService;

    @GetMapping("convidados")
    public String guests(Model model) {
        model.addAttribute("guests", guestService.list());
        return "convidados";
    }
}
