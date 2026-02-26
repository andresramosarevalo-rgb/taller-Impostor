package edu.co.ustavillavo.demo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.UUID;

@Getter
@AllArgsConstructor                //Genera un constructor con todos los campos
public class CreateRoomResponse {  //Representa lo que tu quieres devolverle al cliente

    private String roomCode;
    private UUID hostPlayerId;


}
