package com.example.reservationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
class ReservationRestController1 {

/* 방법1. SpringMVC 와 거의 비슷한 구조이다. 리턴타입이 Flux 임.

    private final ReservationRepository rr;

    public ReservationRestController1(ReservationRepository rr) {
        this.rr = rr;
    }

    @GetMapping("/reservations")
    Flux<Reservation> reservationFlux () {
        return this.rr.findAll();
    }
*/

}
