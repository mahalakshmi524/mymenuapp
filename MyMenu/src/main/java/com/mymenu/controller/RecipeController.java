package com.mymenu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymenu.dto.MenuDto;
import com.mymenu.service.RecipeService;
import com.mymenu.userresponse.ReceipeResponse;
/**
 * @author mahalakshmi
 *
 */
@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {
	
	private  static final Logger logger=LoggerFactory.getLogger(RecipeController.class);
	
	@Autowired
	RecipeService recipeService;
	
	private static final String SUCCESS="Success";	
	private static final String FAILURE="Failure";
	private static final String EMPTYREQUEST="Request empty";

	/**
	 * Method to insert the recipes
	 *
	 * @return ResponseEntity
	 */
	@PostMapping("/createRecipe")
    public ResponseEntity<ReceipeResponse> createReceipe(@RequestBody MenuDto menu){
		logger.info("inside createReceipe method");
		  ReceipeResponse response;  
		if(menu !=null) {
		response=recipeService.saveReceipe(menu);  
		response=new ReceipeResponse(HttpStatus.OK,SUCCESS,response.getResponse());
		 }else {
	      response=new ReceipeResponse(HttpStatus.BAD_REQUEST,FAILURE," empty");
		}
		return ResponseEntity.status(response.getStatus()).body(response);
     }
     
	/**
	 * Method to get the all recipes
	 *
	 * @return ResponseEntity
	 */
     @GetMapping("/getRecipes")
    public ResponseEntity<ReceipeResponse> getRecipes() {
    	 logger.info("inside getRecipes method");
    	 ReceipeResponse response;         
         List<MenuDto> menuList=recipeService.getAllReceipes();
         if(!menuList.isEmpty()) {
        	 response=new ReceipeResponse(HttpStatus.OK,SUCCESS,menuList);      
         }else {
        	 response=new ReceipeResponse(HttpStatus.OK,SUCCESS,"No receipes available");      
         }
         logger.info("exit getRecipes method");
			 return ResponseEntity.status(response.getStatus()).body(response);
			 
     }
     
     /**
 	 * Method to update the recipe
 	 *
 	 * @return ResponseEntity
 	 */
     @PutMapping("/updateRecipe")
     public ResponseEntity<ReceipeResponse> updateReceipe(@RequestBody MenuDto menu){
    	  logger.info("inside updateReceipe method");
    	  ReceipeResponse response;  
  		if(menu !=null) {
  		  response= recipeService.updateReceipe(menu); 
  		  if(HttpStatus.NOT_FOUND.equals(response.getStatus())) {
  			response.setStatus(HttpStatus.NOT_FOUND);
  		  }else {
  			response.setStatus(HttpStatus.OK); 
  		  }
     }else {
    	  response=new ReceipeResponse(HttpStatus.BAD_REQUEST,FAILURE,EMPTYREQUEST);
		
	}
  		return ResponseEntity.status(response.getStatus()).body(response);
      }
     
     /**
 	 * Method to delete the recipe
 	 *
 	 * @return ResponseEntity
 	 */
     @DeleteMapping("/deleteRecipe")
     public ResponseEntity<ReceipeResponse> deleteReceipe(@RequestBody MenuDto menu){
    	  logger.info("inside deleteReceipe method");
    	  ReceipeResponse response;  
  		if(menu !=null) {
  			response= recipeService.deleteReceipe(menu);
  			if(HttpStatus.NOT_FOUND.equals(response.getStatus())) {
  	  			response.setStatus(HttpStatus.NOT_FOUND);
  	  		  }else {
  	  			response.setStatus(HttpStatus.OK); 
  	  		  }  		
     }else {
    	  response=new ReceipeResponse(HttpStatus.BAD_REQUEST,FAILURE,EMPTYREQUEST);
	}
  		return ResponseEntity.status(response.getStatus()).body(response);
			 
      }

}
