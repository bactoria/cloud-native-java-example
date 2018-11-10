package com.example.reservationservice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface ReservationRepository extends ReactiveMongoRepository<Reservation, String> {

}
