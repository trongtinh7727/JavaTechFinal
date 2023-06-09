package com.iiex.cinema.Controller;


import com.iiex.cinema.Api.CustomResponse;
import com.iiex.cinema.Model.Seat;
import com.iiex.cinema.Service.SeatService;
import com.iiex.cinema.Service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/seats")
@RestController
public class SeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private ShowroomService showroomService;
    SeatController(SeatService seatService){
        this.seatService = seatService;
    }
    @GetMapping("/getByTheater/{id}")
    ResponseEntity<CustomResponse> getByTheater(@PathVariable Long id){
        List<Seat> schedules = seatService.getByShowRoom(showroomService.findShowroomByID(id));
        CustomResponse<Seat> response = new CustomResponse(true, schedules);
        return ResponseEntity.ok(response);
    }
    
}
