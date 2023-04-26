package com.iiex.cinema.Service.impl;

import com.iiex.cinema.Model.Schedule;
import com.iiex.cinema.Model.Seat;
import com.iiex.cinema.Model.ShowRoom;
import com.iiex.cinema.Model.Ticket;

import com.iiex.cinema.Repository.TicketRepository;
import com.iiex.cinema.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public List<Ticket> generateTicket(Schedule schedule, float price) {
        List<Ticket> tickets = new ArrayList<>();
        ShowRoom showRoom = schedule.getShowRoom();
        List<Seat> seats = showRoom.getSeats();
        for (Seat seat :
                seats) {
            Ticket ticket = new Ticket(0,price,null,schedule,seat);
            ticketRepository.save(ticket);
            tickets.add(ticket);
        }
        return tickets;
    }
}
