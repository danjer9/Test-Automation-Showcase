package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16,10)));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieStarting11AMTo4pmWith25PercentDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Showing showing = new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,30)));
        assertEquals(8.25, turningRed.calculateTicketPrice(showing));
    }

    @Test
    void movieShowing7thOfTheDayWith1DollarDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Showing showing = new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19,30)));
        assertEquals(10, turningRed.calculateTicketPrice(showing));
    }
}
