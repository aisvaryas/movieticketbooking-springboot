package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Booking;
import com.example.demo.Service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingContoller {
    @Autowired
    BookingService service;

    @PostMapping("/add/{memid}/{movid}")
    public String add(@PathVariable int memid,@PathVariable int movid,@RequestBody Booking b) {
        return service.addBooking( memid, movid,b);
    }

    @GetMapping("/all")
    public List<Booking> all() {
        return service.showAll();
    }
    
    @GetMapping("/search/{id}")
    public Booking search(@PathVariable int id) {
        return service.searchById(id);
    }
     @PutMapping("/cancel/{id}")
    public String cancel(@PathVariable int id) {
        return service.cancelBooking(id);
    }


}
