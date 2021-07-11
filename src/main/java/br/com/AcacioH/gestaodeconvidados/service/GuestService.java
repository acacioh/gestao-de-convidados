package br.com.AcacioH.gestaodeconvidados.service;

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
        Guest guest = guestRepository.findById(id).orElse(null);
        return guest;
    }

    public Guest update(Guest guest) {
        return guestRepository.save(guest);
    }

    public void delete(Integer id) {
        Guest guest = guestRepository.findById(id).orElse(null);

        if (guest == null) {
            throw new RuntimeException("Convidado não encontrado");
        }

        guestRepository.delete(guest);
    }

    public Page<Guest> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return guestRepository.findAll(pageRequest);
    }
}
