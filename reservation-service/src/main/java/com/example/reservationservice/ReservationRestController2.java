package com.example.reservationservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/*
    방법2. 좀더 펑셔널한 컨트롤러 ( 여기선 라우터)
    조쉬롱은 이 방법을 선호한다고 함.

*/


@Configuration
class ReservationRestController2 {

    @Bean
    RouterFunction<ServerResponse> routes(ReservationRepository rr) {
        return route(GET("/reservations"), req -> ok().body(rr.findAll(), Reservation.class));
    }

}
