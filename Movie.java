package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Movie {
    @Id
    private int movieId;

    @NotBlank(message="movie cannot be empty")
    private String movieName;

    @NotBlank(message="language cannot be empty")
    private String language;

    @NotBlank(message="genre cannot be empty")
    private String genre;

    @Positive(message="duration must be greater than zero")
    private int duration;
    @DecimalMin(value="1.00",message="ticket price must be greater than 0")
    private double ticketPrice;

    public Movie() {
    }

    public Movie(int duration, String genre, String language, int movieId, String movieName, double ticketPrice) {
        this.duration = duration;
        this.genre = genre;
        this.language = language;
        this.movieId = movieId;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
    }
    
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", genre=" + genre
                + ", duration=" + duration + ", ticketPrice=" + ticketPrice + "]";
    }

    
}
