package com.example.store.Repository;

import com.example.store.Entity.Reservation;
import com.example.store.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStore(Store store);
}