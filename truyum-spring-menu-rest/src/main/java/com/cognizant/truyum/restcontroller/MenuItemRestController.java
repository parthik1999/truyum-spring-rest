package com.cognizant.truyum.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MenuItemRestController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private MenuItemFeignClient menuItemFeignClient;
	
	@GetMapping("/test")
	public String sayHello()
	{
		return "Hello Parthik";
	}

	@GetMapping("/show-menu-list-admin")
	public List<MenuItem> showtMenuItemListAdmin()
	{
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		log.debug("Admin Menu List: {}", menuItemList);

		log.info("End");
		return menuItemList;
	}
	@GetMapping("/show-menu-list-customer")
	public List<MenuItem> showtMenuItemListCustomer()
	{
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		log.info("End");
		return menuItemList;
	}
	
	@PutMapping("/admin-edit-menu-item")
	public void editMenuItem(@RequestBody MenuItem menuItem)
	{
		//MenuItem menu=menuItemService.getMenuItem(menuItem.getId());
		//menu=menuItem;
		menuItemService.modifyMenuItem(menuItem);
	}
	
	
//	Feign Client call
	
	@GetMapping("/getCart")
	public ResponseEntity<String> getCartDetails()
	{
		return ResponseEntity.ok().body(menuItemFeignClient.getCarts());
	}
	
	@DeleteMapping("/deleteCart")
	public ResponseEntity<String> deleteCartDetails(@RequestBody MenuItem menuItem)
	{
		
		return ResponseEntity.ok().body(menuItemFeignClient.deleteCart(menuItem));
	}
}
