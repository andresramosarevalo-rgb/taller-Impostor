package edu.co.ustavillavo.demo.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateRoomRequest {

    @NotBlank                 //No permite que el usuario coloque este campo vacio
    private String hostNickname;

    @NotBlank                 //Y spring devuelve 400 automaticamente
    private String category;

    @NotNull                  //No permite que este campo este vacio
    private Integer impostorCount;
}
