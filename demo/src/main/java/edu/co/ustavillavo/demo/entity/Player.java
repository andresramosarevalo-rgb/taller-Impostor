package edu.co.ustavillavo.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity //Hace que la clase represente una tabla en la base de datos
@Table(name = "players")
@Getter @Setter


public class Player {

    //Genera un id para el jugador
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Column sirve para definir el nombre de la columna y restricciones
    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private boolean alive;


    @ManyToOne //Significa que muchos jugadores pertenecen a una misma sala
    @JoinColumn(name = "room_id", nullable = false) //Es una llave foranea que apunta a rooms
    private Room room;

    public Player(){

    }

}
