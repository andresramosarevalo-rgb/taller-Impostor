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
    private final RoomRepository roomRepository;     //Esta clase depende de RoomRepository para funcionar
    private final PlayerRepository playerRepository; //Esta clase depende de PlayerRepository para funcionar

    public CreateRoomResponse createRoom (CreateRoomRequest request) {

        String code = UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        //Crear un room
        Room room = new Room(); //Crea un room en la memoria no mas
        room.setCode(code); //Le asigna el codigo
        room.setStatus(RoomStatus.LOBBY); //Le asigna el estado
        room.setHostPlayerId(null);
        room.setCategory(request.getCategory()); //Le asigna una categoria
        room.setImpostorCount(request.getImpostorCount()); //Le asigna los impostores
        room.setCurrentRound(0); //Estado inicial del juego

        roomRepository.save(room); //Aqui si ya se guarda en la base de datos

        //Crear Host Player
        Player host = new Player(); //Se crea un objeto Player y lo nombran como anfitrion
        host.setNickname(request.getHostNickname()); //Se asigna un nombre
        host.setAlive(true); //Se asigna su estado
        host.setRoom(room); //Se asigna su sala de juego

        //Asigna hostPlayerId a room
        playerRepository.save(host); //Se guarda en la base de datos
        room.setHostPlayerId(host.getId()); //Se le asigna el id al anfitrion
        roomRepository.save(room); // Y se guarda sala

        return  new CreateRoomResponse(room.getCode(), host.getId()); //Crea el DTO de salida


    }

  }


