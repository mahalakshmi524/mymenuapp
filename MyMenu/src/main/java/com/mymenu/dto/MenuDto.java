package com.mymenu.dto;

import java.util.Date;
import java.util.List;
/**
 * @author mahalakshmi
 *
 */
public class MenuDto {
private Integer dishNum;	
	private String dishName;	
    private Date creationDate;	
    private boolean vegetarian;	
    private int numberPeople;	
    private List<IngredientsDto> ingredientsList;	
    private String cookingDescription;
    
    public MenuDto() {
    	
    }
    
	public MenuDto(Integer dishNum, String dishName, Date creationDate, boolean vegetarian, int numberPeople,
			List<IngredientsDto> ingredientsList, String cookingDescription) {
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
	public List<IngredientsDto> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientsDto> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	public String getCookingDescription() {
		return cookingDescription;
	}
	public void setCookingDescription(String cookingDescription) {
		this.cookingDescription = cookingDescription;
	}
	@Override
	public String toString() {
		return "MenuDto [dishNum=" + dishNum + ", dishName=" + dishName + ", creationDate=" + creationDate
				+ ", vegetarian=" + vegetarian + ", numberPeople=" + numberPeople + ", ingredientsList="
				+ ingredientsList + ", cookingDescription=" + cookingDescription + "]";
	}
    
    
}
