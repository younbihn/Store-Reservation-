package com.example.store.Service;

import com.example.store.Entity.Reservation;
import com.example.store.Entity.Store;
import com.example.store.Repository.ReservationRepository;
import com.example.store.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Autowired
    private ReservationRepository reservationRepository;

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public void createStore(Store store) {
        storeRepository.save(store);
    }

    public List<Reservation> getReservationsForStore(Store store) {
        return reservationRepository.findByStore(store);
    }
}