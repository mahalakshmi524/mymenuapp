package com.mymenu.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.mymenu.bean.Menu;
import com.mymenu.dto.IngredientsDto;
import com.mymenu.dto.MenuDto;
import com.mymenu.repository.RecipeRepository;
import com.mymenu.service.RecipeService;
import com.mymenu.userresponse.ReceipeResponse;


@ExtendWith(MockitoExtension.class)
 class ReceipeServiceTest {
	
	@Mock
	RecipeRepository receipeRepository;
	     
	@InjectMocks
	    RecipeService receipeService;
	
	@Mock
	private ModelMapper modelMapper;
	
	private MenuDto menuDto;
	private Menu menu=new Menu();	
	
	 @BeforeEach
	    public void setup(){
		   List<IngredientsDto> ingredientList=new ArrayList<>();
	        IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
	        IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
	        ingredientList.add(ingredients);
	        ingredientList.add(ingredients1);	        
	        menuDto = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"zxcxzc");
	    }
	 
	 
	    @Test
	     void testCreate() {
	         
	        Menu menu=modelMapper.map(menuDto,Menu.class);
	    	
	    	given(receipeRepository.save(menu)).willReturn(null);
	    	
	       receipeService.saveReceipe(menuDto);
	       // then
	        verify(receipeRepository,never()).save(any(Menu.class));

	    }
	    
	    @Test
	    void testGetAllReceipes() {
			 
	    	  given(receipeRepository.findAll()).willReturn(List.of(menu));
	    	  
	    	  List<MenuDto> menuDtoList=receipeService.getAllReceipes();
	    	  
	    	  assertThat(menuDtoList).isNotNull();
	          assertThat(menuDtoList.size()).isEqualTo(1);
	    	 
	    }
	    
@Test
 void testUpdateReceipe() {
	
	 List<IngredientsDto> ingredientList=new ArrayList<>();
     IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
     IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
     ingredientList.add(ingredients);
     ingredientList.add(ingredients1);	        
     MenuDto menuDto1 = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"qwert");
	
	  given(receipeRepository.findById(1)).willReturn(Optional.of(menu));
	
	  Menu menu1=modelMapper.map(menuDto1,Menu.class);
       given(receipeRepository.save(menu1)).willReturn(null);
       
       ReceipeResponse response=receipeService.updateReceipe(menuDto1);
       assertThat(response.getMessage().equals("Success"));
       
}
	
@Test
 void testDeleteReceipe() {
	
	   List<IngredientsDto> ingredientList=new ArrayList<>();
       IngredientsDto ingredients=new IngredientsDto(1, "wheet","1spoon");
       IngredientsDto ingredients1=new IngredientsDto(2, "salt","1spoon");
       ingredientList.add(ingredients);
       ingredientList.add(ingredients1);	        
       MenuDto menuDto1 = new MenuDto(1, "Samosa",new Date(), true ,10,ingredientList,"qwert");
       
       given(receipeRepository.findById(1)).willReturn(Optional.of(menu));       
		
       Menu menu1=modelMapper.map(menuDto1,Menu.class);
       willDoNothing().given(receipeRepository).delete(menu1);
       
       ReceipeResponse response=receipeService.deleteReceipe(menuDto1);
       assertThat(response.getMessage().equals("Success"));
       
}

}
