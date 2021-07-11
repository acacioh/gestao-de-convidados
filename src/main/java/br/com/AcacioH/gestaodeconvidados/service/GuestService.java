package br.com.AcacioH.gestaodeconvidados.service;

import br.com.AcacioH.gestaodeconvidados.exception.NotFoundException;
import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public Guest create(String name) {
        Guest g = new Guest();
        g.setName(name);
        Guest guestSaved = guestRepository.save(g);
        return guestSaved;
    }

    public Guest findById(Integer id) {
        Guest guest = getValidGuest(id);
        return guest;
    }

    private Guest getValidGuest(Integer id) {
        // Verify if a guest exists or throw exception
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new NotFoundException());

        return guest;
    }

    public Guest update(Guest guest) {
        // Just validate if the guest being updated is really an existing guest
        getValidGuest(guest.getId());

        return guestRepository.save(guest);
    }

    public void delete(Integer id) {
        Guest guest = getValidGuest(id);

        guestRepository.delete(guest);
    }

    public Page<Guest> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return guestRepository.findAll(pageRequest);
    }
}
