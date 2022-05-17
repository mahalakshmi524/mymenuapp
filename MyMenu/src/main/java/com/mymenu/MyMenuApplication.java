package com.mymenu;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * @author mahalakshmi
 *
 */
@SpringBootApplication
public class MyMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMenuApplication.class, args);
	}
	
	/**
	 * Method to map the objects
	 *
	 * @return expected object.
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	   
}
