package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Movie;
import com.example.demo.Repository.MovieRepo;

@Service
public class MovieService {
    @Autowired
    MovieRepo or;

    public Movie addmov(Movie mv){
        return or.save(mv);

    }

    public List<Movie> show() {
        List<Movie> l= or.findAll();
        return l;
    }

    public Movie searchmovie(int id) {
        Movie m= or.findById(id).orElse(null);
        return m;
    }

    public String updatemov(int id,Movie m) {
        Movie x= or.findById(id).orElse(null);
        if(x!=null){
            x.setDuration(m.getDuration());
            x.setGenre(m.getGenre());
            x.setLanguage(m.getLanguage());
            x.setMovieName(m.getMovieName());
            x.setTicketPrice(m.getTicketPrice());
            or.save(x);
            return "updated";
        }
        return "not found";
    }

    public String delete(int id) {
        Movie x= or.findById(id).orElse(null);
        if(x!=null){
            or.deleteById(id);
            return "deleted";
        }
        return "not found";
      
    }

    public List<Movie> searchmov(String lang) {
        List<Movie> list =or.findAll();
        List<Movie> res= new ArrayList<>();

        for(Movie m: list){
            if(m.getLanguage().equals(lang)){
                res.add(m);
            }
            
        }
        return res;
    }

    public List<Movie> searchmovgenre(String genre) {
        List<Movie> list =or.findAll();
        List<Movie> res= new ArrayList<>();

        for(Movie m: list){
            if(m.getGenre().equals(genre)){
                res.add(m);
            }
            
        }
        return res;
    }


    
    
}
