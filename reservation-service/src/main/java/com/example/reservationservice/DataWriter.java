package com.example.reservationservice;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class DataWriter implements ApplicationRunner {

    private final ReservationRepository reservationRepository;

    public DataWriter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        reservationRepository
                .deleteAll()
                .thenMany(Flux.just("Marcin", "Jakub", "Josh", "Bob")
                        .map(name -> new Reservation(null, name))
                        .flatMap(this.reservationRepository::save))
                .thenMany(this.reservationRepository.findAll())
                .subscribe(System.out::println);

        /*
        Flux<String> names = Flux.just("Marcin", "Jakub", "Josh", "Bob");
        Flux<Reservation> reservations = names.map(name -> new Reservation(null,name));
        Publisher<Reservation> saved = reservations.flatMap(r-> this.reservationRepository.save(r));
//        Publisher<Publisher<Reservation>> saved = reservations.map(r-> this.reservationRepository.save(r));
        ((Flux<Reservation>) saved).subscribe(System.out::println);
        */

    }
}
