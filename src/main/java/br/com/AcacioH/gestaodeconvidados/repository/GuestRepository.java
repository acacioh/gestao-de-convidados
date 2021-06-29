package br.com.AcacioH.gestaodeconvidados.repository;

import br.com.AcacioH.gestaodeconvidados.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
