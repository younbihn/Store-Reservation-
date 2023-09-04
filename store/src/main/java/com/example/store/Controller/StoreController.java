package com.example.store.Controller;

import com.example.store.Entity.Store;
import com.example.store.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.ui.Model;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/stores")
    public String listStores(Model model) {
        List<Store> stores = storeService.getAllStores();
        model.addAttribute("stores", stores);
        return "store/list";
    }

    @GetMapping("/stores/{id}")
    public String storeDetails(@PathVariable Long id, Model model) {
        Store store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        return "store/details";
    }

    @PostMapping("/stores")
    public String createStore(@ModelAttribute Store store) {
        storeService.createStore(store);
        return "redirect:/stores";
    }
}