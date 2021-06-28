package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.dto.GuestDto;
import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;

    public GuestDto create(GuestDto guest) {
        return guestService.create(guest);
    }

    public GuestDto read(Integer id) {
        return guestService.read(id);
    }

    public GuestDto update(GuestDto guest) {
        return guestService.update(guest);
    }

    public void delete(Integer id) {
        guestService.delete(id);
    }
}
