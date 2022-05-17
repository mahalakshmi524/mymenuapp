package com.mymenu.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mymenu.bean.Menu;
import com.mymenu.dto.MenuDto;
import com.mymenu.repository.RecipeRepository;
import com.mymenu.userresponse.ReceipeResponse;
/**
 * @author mahalakshmi
 *
 */
@Service
public class RecipeService {
	private  static final Logger logger=LoggerFactory.getLogger(RecipeService.class);
	
	/**
	 * Method to insert the recipes
	 *
	 * @return ResponseEntity
	 */
	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Method to get all the recipes
	 *
	 * @return List<MenuDto>
	 */
	public List<MenuDto> getAllReceipes(){	
		logger.info("inside getAllReceipes service method");		
					List<Menu> menuList= recipeRepository.findAll(); 				
			return menuList.stream().filter(Objects::nonNull)
					.map(e-> modelMapper.map(e, MenuDto.class)).collect(Collectors.toList());
	}
	
	/**
	 * Method to insert the recipes
	 *
	 * @return ReceipeResponse
	 */
	public ReceipeResponse saveReceipe(MenuDto menuDto){ 
		logger.info("inside saveReceipe service method");
		ReceipeResponse response=new ReceipeResponse(); 
		Optional<Menu> menudata=recipeRepository.findById(menuDto.getDishNum());
		if(menudata.isPresent()) {
			response.setResponse("Data already persist in the receipes");
		}
		else {
			Menu menu=modelMapper.map(menuDto,Menu.class);		
			recipeRepository.save(menu);
				response.setResponse("Successfully created"); 
		}
		return response;
		
	}
	
	/**
	 * Method to update the recipes
	 *
	 * @return ReceipeResponse
	 */
	public ReceipeResponse  updateReceipe(MenuDto menuDto){ 
		logger.info("inside updateReceipeservice  method");
		Integer dishNum=menuDto.getDishNum();
		Optional<Menu> menudata=recipeRepository.findById(dishNum);
		if(menudata.isPresent()) {
			Menu menu=modelMapper.map(menuDto,Menu.class);
			recipeRepository.save(menu);
			return new ReceipeResponse(HttpStatus.OK,"Success","Successfully updated");		
		}
		else {
			return new ReceipeResponse(HttpStatus.NOT_FOUND,"Receipe not found to update","Not found");
		}		
	}
	
	/**
	 * Method to delete the recipes
	 *
	 * @return ReceipeResponse
	 */
	public ReceipeResponse  deleteReceipe(MenuDto menuDto){ 
		logger.info("inside deleteReceipe method");
		Integer dishNum=menuDto.getDishNum();		
		Optional<Menu> menudata=recipeRepository.findById(dishNum);
		if(menudata.isPresent()) {
			Menu menu=modelMapper.map(menuDto,Menu.class);
			recipeRepository.delete(menu);
			return new ReceipeResponse(HttpStatus.OK,"Success","Successfully delete");		
		}
		else {
			return new ReceipeResponse(HttpStatus.NOT_FOUND,"Receipe not found to delete","Not found");
		}		
	}
	
	
}
