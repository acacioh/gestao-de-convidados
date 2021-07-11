package br.com.AcacioH.gestaodeconvidados.controller;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public Page<Guest> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return guestService.findAll(page, size);
    }

    @PostMapping
    public Guest create(String name) {
        return guestService.create(name);
    }

    @GetMapping("{id}")
    public Guest findById(@PathVariable Integer id) {
        return guestService.findById(id);
    }

    @PutMapping
    public Guest update(Guest guest) {
        return guestService.update(guest);
    }

    @DeleteMapping
    public void delete(Integer id) {
        guestService.delete(id);
    }
}
