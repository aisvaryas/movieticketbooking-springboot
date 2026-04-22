package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Movie;
import com.example.demo.Service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired 
    MovieService movieservice;


    @PostMapping("/add")
    public Movie addmovie(@RequestBody Movie mv){
        return movieservice.addmov(mv);
        
    }

    @GetMapping("/all")
    public List<Movie> showall(){
        return movieservice.show();
    }

    @GetMapping("/search/{id}")
    public Movie search(@PathVariable int id){
        return movieservice.searchmovie(id);
    }

    @PutMapping("/update/{id}")
    public String updatemovie(@PathVariable int id,@RequestBody Movie m){
        return movieservice.updatemov(id,m);
    }

    @DeleteMapping("/delete/{id}")
    public String deletemovie(@PathVariable int id){
        return movieservice.delete(id);
    }

    @GetMapping("/search/{lang}")
    public List<Movie> searchbylang(@PathVariable String lang){
        List<Movie> l =movieservice.searchmov(lang);
        return l;
    }

    @GetMapping("/search/{genre}")
    public List<Movie> searchbygenre(@PathVariable String genre){
          List<Movie> l =movieservice.searchmovgenre(genre);
        return l;
    }


    
}
