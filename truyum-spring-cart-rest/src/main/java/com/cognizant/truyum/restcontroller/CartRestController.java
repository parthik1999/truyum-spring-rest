package com.cognizant.truyum.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CartRestController {
	
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/getcarts")
	public List<MenuItem> getItemsInCart()
	{
	log.info("Start");
		
		List<MenuItem> cartList = cartService.getCart();
		int total=0;
		
		if(cartList.isEmpty())
		{
			return null;
		}
		
		log.info("END");
		return cartList;
	}
	
	
	@DeleteMapping("/deleteCart")
	public String deleteItem(@RequestBody MenuItem menuItem) {
		log.info("Start");
		cartService.deleteItem(menuItem.getId());
//		List<MenuItem> carts = cartService.getCart();
//		log.debug("Cart:{}", carts);
//		int total=0;
//		if(carts.isEmpty())
//		{
//			return "cart-empty";
//		}
//		for (MenuItem cart : carts) {
//			total+=cart.getPrice();
//		}
//		model.put("cart", carts);
//		model.put("total", total);
		log.info("End");
		return "Item Deleted Succesfully";
	}
	
	

}
