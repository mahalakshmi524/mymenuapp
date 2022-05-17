package com.mymenu.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author mahalakshmi
 *
 */
@Entity
@Table(name="MENU")
public class Menu{

	@Id
	@Column(name="dish_num")
	private Integer dishNum;
	@Column(name="dish_name")
	private String dishName;
	@Column(name="creation_date")
    private Date creationDate;
	@Column(name="vegetarian")
    private boolean vegetarian;
	@Column(name="number_people")
    private int numberPeople;	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@Column(name="INGREDIENTS")
    private List<Ingredients> ingredientsList;	
	@Column(name="cookingDescription")
    private String cookingDescription;
	
	public Menu() {
		
	}
	
	public Menu(Integer dishNum, String dishName, Date creationDate, boolean vegetarian, int numberPeople,
			List<Ingredients> ingredientsList, String cookingDescription) {
		super();
		this.dishNum = dishNum;
		this.dishName = dishName;
		this.creationDate = creationDate;
		this.vegetarian = vegetarian;
		this.numberPeople = numberPeople;
		this.ingredientsList = ingredientsList;
		this.cookingDescription = cookingDescription;
	}
	
	public Integer getDishNum() {
		return dishNum;
	}
	public void setDishNum(Integer dishNum) {
		this.dishNum = dishNum;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	public int getNumberPeople() {
		return numberPeople;
	}
	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}
	public List<Ingredients> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<Ingredients> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	public String getCookingDescription() {
		return cookingDescription;
	}
	public void setCookingDescription(String cookingDescription) {
		this.cookingDescription = cookingDescription;
	}    

    

   
}