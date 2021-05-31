package com.cognizant.truyum.restcontroller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.truyum.model.MenuItem;

import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "cart",url="${CART_SERVICE:http://localhost:9092}")
public interface MenuItemFeignClient {
	
	@GetMapping("/truyum/rest/cart/getcarts")
	String getCarts();
	
	@DeleteMapping("/truyum/rest/cart/deleteCart")
	String deleteCart(MenuItem menuItem);

}
