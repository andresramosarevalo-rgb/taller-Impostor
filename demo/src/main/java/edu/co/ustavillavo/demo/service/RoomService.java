package edu.co.ustavillavo.demo.service;

import edu.co.ustavillavo.demo.entity.RoomStatus;
import edu.co.ustavillavo.demo.entity.Player;
import edu.co.ustavillavo.demo.dto.request.CreateRoomRequest;
import edu.co.ustavillavo.demo.dto.response.CreateRoomResponse;
import edu.co.ustavillavo.demo.entity.Room;
import edu.co.ustavillavo.demo.repository.PlayerRepository;
import edu.co.ustavillavo.demo.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;


@RequiredArgsConstructor //Genera un constructor automaticamente con los atributos final
@Service //Le dice a Spring que esta clase contiene logica de negocio y la crea automaticamente como un Bean
public class RoomService {


    //Constructor
    private final RoomRepository roomRepository;
    private final PlayerRepository playerRepository;

    public CreateRoomResponse createRoom (CreateRoomRequest request) {

        String code = UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        //Crear un room
        Room room = new Room();
        room.setCode(code);
        room.setStatus(RoomStatus.LOBBY);
        room.setHostPlayerId(null);
        room.setCategory(request.getCategory());
        room.setImpostorCount(request.getImpostorCount());
        room.setCurrentRound(0);

        roomRepository.save(room);

        //Crear Host Player
        Player host = new Player();
        host.setNickname(request.getHostNickname());
        host.setAlive(true);
        host.setRoom(room);

        //Asigna hostPlayerId a room
        playerRepository.save(host);
        room.setHostPlayerId(host.getId());
        roomRepository.save(room);

        return  new CreateRoomResponse(room.getCode(), host.getId());


    }

  }


