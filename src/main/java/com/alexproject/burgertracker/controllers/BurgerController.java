package com.alexproject.burgertracker.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alexproject.burgertracker.models.Burger;
import com.alexproject.burgertracker.services.BurgerService;



@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
    public String index(Model model) 
	{
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		model.addAttribute("burger", new Burger());
        return "index.jsp";
    }

		
	@PostMapping("/")
	public String createBurger(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			Model model)
	{
		if (result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers());
            return "index.jsp";
        } else {
            burgerService.createBurger(burger);
            return "redirect:/";
        }
	}
	
	
	@GetMapping("/burgers/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model) 
	{
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	
	@PutMapping("/burgers/{id}")
	public String update(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result)
	{
		if(result.hasErrors())
		{
			return "edit.jsp";
		} else
		{
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
	
}
