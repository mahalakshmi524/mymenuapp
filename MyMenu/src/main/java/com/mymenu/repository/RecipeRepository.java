package com.mymenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymenu.bean.Menu;
/**
 * @author mahalakshmi
 *
 */
@Repository
public interface RecipeRepository extends JpaRepository<Menu,Integer>{
     
}
