package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;

    public Guest create(Guest guest) {
        return guestService.create(guest);
    }

    public Guest read(Integer id) {
        return guestService.read(id);
    }

    public Guest update(Guest guest) {
        return guestService.update(guest);
    }

    public void delete(Integer id) {
        guestService.delete(id);
    }
}
