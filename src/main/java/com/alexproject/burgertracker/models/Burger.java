package com.alexproject.burgertracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Burger Name must not be blank")
//	@Size(min = 1, max = 50)
	private String burgerName;
	
	@NotBlank(message="Restaurant Name must not be blank")
//	@Size(min = 1, max = 50)
	private String restaurantName;
	
//	@NotNull
	@Max(value=5, message="Choose a rating: 5 is the highest, 1 is the lowest.")
	@Min(value=1, message="Choose a rating: 5 is the highest, 1 is the lowest.")
	private Integer rating;
	
	@NotBlank(message="Notes must not be blank")
	@Size(max = 200)
	private String notes;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	// CONSTRUCTORS
	
	public Burger() {
	}
	
	public Burger(String burgerName, String restaurantName, Integer rating, String notes) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}
	
	public Burger(Long id, @NotBlank @Size(min = 1, max = 50) String burgerName,
			@NotBlank @Size(min = 1, max = 50) String restaurantName, @NotBlank @Size(min = 1, max = 5) Integer rating,
			@NotBlank @Size(max = 200) String notes, Date createdAt, Date updatedAt) {
		this.id = id;
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
// GETTERS AND SETTERS
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
}
