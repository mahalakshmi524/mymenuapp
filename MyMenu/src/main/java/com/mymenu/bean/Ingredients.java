package com.mymenu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mahalakshmi
 *
 */
@Entity
@Table(name="INGREDIENTS")
public class Ingredients{
	@Id
	@Column(name="ingredients_id")
	private int ingredientsId;
	@Column(name="ingredient_name")
    private String ingredientName;
	@Column(name="quantatity")
	private String quantatity;

	public Ingredients() {
		
	}
    
  	public Ingredients(int ingredientsId, String ingredientName, String quantatity) {
		super();
		this.ingredientsId = ingredientsId;
		this.ingredientName = ingredientName;
		this.quantatity = quantatity;
	}



	public String getQuantatity() {
		return quantatity;
	}

	public void setQuantatity(String quantatity) {
		this.quantatity = quantatity;
	}

	public int getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	
}