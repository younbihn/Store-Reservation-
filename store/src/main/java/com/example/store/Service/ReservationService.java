package com.example.store.Service;

import com.example.store.Entity.Reservation;
import com.example.store.Entity.Store;
import com.example.store.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationsByStore(Store store) {
        return reservationRepository.findByStore(store);
    }

    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void approveReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null) {
            reservation.setApproved(true);
            reservationRepository.save(reservation);
        }
    }

    public void rejectReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null) {
            reservation.setApproved(false);
            reservationRepository.save(reservation);
        }
    }
}