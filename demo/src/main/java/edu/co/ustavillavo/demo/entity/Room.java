package edu.co.ustavillavo.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity                 //Hace que esta clase represente una tabla en la base de datos
@Table(name = "rooms")  //Fuerza a que la tabla se llame rooms
@Getter @Setter         //Crea los getters y setters solo con estas dos anotaciones

public class Room {

    //Cada sala tendra un identificador unico generado automaticamnete
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Este es el codigo que se comparten los jugadores
    @Column(unique = true, nullable = false)
    private String code;

    //Guarda el RoomState como TEXTO y no como NUMERO
    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    //Guardamos el id del host y no puede ser null
    @Column(nullable = false)
    private UUID hostPlayerId;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int impostorCount;

    @Column(nullable = false)
    private int currentRound;

    private String secretWord;
    private String winner;

    public Room(){
    }
}

