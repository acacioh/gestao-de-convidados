package br.com.AcacioH.gestaodeconvidados.service;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import br.com.AcacioH.gestaodeconvidados.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public Guest create(Guest guest) {
        Guest g = new Guest();
        g.setName(guest.getName());

        Guest guestSaved = guestRepository.save(g);
        return guestSaved;
    }

    public Guest read(Integer id) {
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


    }
}
