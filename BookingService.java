package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Member;
import com.example.demo.Entity.Movie;
import com.example.demo.Repository.BookingRepo;
import com.example.demo.Repository.MemberRepo;
import com.example.demo.Repository.MovieRepo;

@Service
public class BookingService {
    @Autowired
    BookingRepo br;

    @Autowired
    MemberRepo memr;

    @Autowired
    MovieRepo movr;

    public String addBooking(int memid, int movid, Booking b) {
        Member m= memr.findById(memid).orElse(null);
        Movie mv= movr.findById(movid).orElse(null);

        if (m != null && mv != null) {

            b.setMember(m);
            b.setMovie(mv);
            b.setBookingDate(LocalDate.now());

            double bill = b.getNoOfSeats() * mv.getTicketPrice();
            b.setTotalAmount(bill);

            b.setBookingStatus("Booked");

            br.save(b);

            return "ticket booked";
        }

        return "member/ movvie not found";

    }

    public List<Booking> showAll() {
        return br.findAll();
        
    }

    public Booking searchById(int id) {
       return br.findById(id).orElse(null);
    }

    public String cancelBooking(int id) {
        Booking b= br.findById(id).orElse(null);
        if(b!=null){
            b.setBookingStatus("canceled");
            br.save(b);
            return "canceled";
        }
        return "not found";
    }



   



    

}
