package com.alexproject.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexproject.burgertracker.models.Burger;
import com.alexproject.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger b) {
		return burgerRepository.save(b);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) 
        {
            return optionalBurger.get();
        } 
        return null;
    }
	
	
	public Burger updateBurger(Long id, String burgerName, String restaurantName, Integer rating, String notes) {
		Burger burger = this.findBurger(id);
		burger.setBurgerName(burgerName);
		burger.setRestaurantName(restaurantName);
		burger.setRating(rating);
		burger.setNotes(notes);
		return burgerRepository.save(burger);
	}
	
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
	
}
