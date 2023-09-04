package com.example.store.Controller;

import com.example.store.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservations/{id}/approve")
    public String approveReservation(@PathVariable Long id) {
        reservationService.approveReservation(id);
        return "redirect:/dashboard";
    }

    @PostMapping("/reservations/{id}/reject")
    public String rejectReservation(@PathVariable Long id) {
        reservationService.rejectReservation(id);
        return "redirect:/dashboard";
    }
}