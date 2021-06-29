package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping
    public Guest create(@RequestBody Guest guest) {
        return guestService.create(guest);
    }

    @GetMapping("{id}")
    public Guest read(@PathVariable Integer id) {
        return guestService.read(id);
    }

    @PutMapping
    public Guest update(@RequestBody Guest guest) {
        return guestService.update(guest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        guestService.delete(id);
    }

    @GetMapping
    public List<Guest> list() {
        return guestService.list();
    }
}
