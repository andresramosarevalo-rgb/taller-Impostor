package edu.co.ustavillavo.demo.controller;

import edu.co.ustavillavo.demo.dto.request.CreateRoomRequest;
import edu.co.ustavillavo.demo.dto.response.CreateRoomResponse;
import edu.co.ustavillavo.demo.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public CreateRoomResponse createRoom(
            @Valid @RequestBody CreateRoomRequest request) {

        return roomService.createRoom(request);
    }
}