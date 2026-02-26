package edu.co.ustavillavo.demo.repository;

import edu.co.ustavillavo.demo.entity.Player;
import edu.co.ustavillavo.demo.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    List<Player> findByRoom(Room room);      //Busca jugadores por sala en room
    long countByRoomAndAliveTrue(Room room); //Cuenta los jugadores registrados
}
