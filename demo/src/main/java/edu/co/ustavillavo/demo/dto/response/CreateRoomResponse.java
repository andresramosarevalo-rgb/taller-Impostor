package edu.co.ustavillavo.demo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.UUID;

@Getter
@AllArgsConstructor                //Genera un constructor con todos los campos
public class CreateRoomResponse {

    private String roomCode;
    private UUID hostPlayerId;


}
