package com.mymenu.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mymenu.bean.Menu;
import com.mymenu.controller.RecipeController;
import com.mymenu.dto.IngredientsDto;
import com.mymenu.dto.MenuDto;
import com.mymenu.service.RecipeService;
import com.mymenu.userresponse.ReceipeResponse;



@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
 class ReceipeControllerTest {
	
	 @InjectMocks
	 RecipeController receipeController;
	     
	    @Mock
	    RecipeService receipeService;
	     
	    @Test
	     void testCreate() {
	    	 List<IngredientsDto> ingredientList=new ArrayList<>();
		        IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
		        IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
		        ingredientList.add(ingredients);
		        ingredientList.add(ingredients1);
		        
		        ReceipeResponse response= new ReceipeResponse();
		        when(receipeService.saveReceipe(any(MenuDto.class))).thenReturn(response);
	        
	        MenuDto menuDto = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"werw");
	        ResponseEntity<ReceipeResponse> responseEntity = receipeController.createReceipe(menuDto);
	         
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	    }
	    
	    @Test
	     void testGetReceipes() {
	    	
	    	  List<IngredientsDto> ingredientList=new ArrayList<>();
		        IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
		        IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
		        ingredientList.add(ingredients);
		        ingredientList.add(ingredients1);
		        
		        MenuDto menuDto = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"werw");
		        MenuDto menuDto1 = new MenuDto(2, "panipuri",new Date(), true ,10,ingredientList,"werw");
	         
	    	List<MenuDto> menuList=new ArrayList<>();
	    	menuList.add(menuDto);
	    	menuList.add(menuDto1);
	    	
	    	when(receipeService.getAllReceipes()).thenReturn(menuList);
	      
	        ResponseEntity<ReceipeResponse> responseEntity = receipeController.getRecipes();
	         
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	       List<Menu> receipeResponse = (List<Menu>) responseEntity.getBody().getResponse();
	        assertThat(receipeResponse.size()).isEqualTo(2);

	    }
  
	    @Test
	     void testUpdate() {
	        
	   	    List<IngredientsDto> ingredientList=new ArrayList<>();
	        IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
	        IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
	        ingredientList.add(ingredients);
	        ingredientList.add(ingredients1);
	        
	        ReceipeResponse response= new ReceipeResponse();
	        when(receipeService.updateReceipe(any(MenuDto.class))).thenReturn(response);
	   
	        
	        MenuDto menuDto1 = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"zxcxzc");
	        ResponseEntity<ReceipeResponse> responseEntity = receipeController.updateReceipe(menuDto1);
	      
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	       
	    }
	    
	    @Test
	     void testDelete() {
	         
	        ReceipeResponse response= new ReceipeResponse();
	        when(receipeService.deleteReceipe(any(MenuDto.class))).thenReturn(response);
	        List<IngredientsDto> ingredientList=new ArrayList<>();
	        IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
	        IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
	        ingredientList.add(ingredients);
	        ingredientList.add(ingredients1);
	        
	        MenuDto menuDto = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"werw");
	        ResponseEntity<ReceipeResponse> responseEntity = receipeController.deleteReceipe(menuDto);
	         
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	        

	    }
	    
}
