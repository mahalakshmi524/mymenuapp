package com.mymenu.dto;
/**
 * @author mahalakshmi
 *
 */
public class IngredientsDto {
	
	private int ingredientsId;	
    private String ingredientName;
    private String quantatity;
    
    public IngredientsDto() {
    	
    }
    
	
	public IngredientsDto(int ingredientsId, String ingredientName, String quantatity) {
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

	@Override
	public String toString() {
		return "IngredientsDto [ingredientsId=" + ingredientsId + ", ingredientName=" + ingredientName + "]";
	}
	
	
    
}
