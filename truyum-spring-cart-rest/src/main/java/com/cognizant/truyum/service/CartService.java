package com.cognizant.truyum.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.CartRepository;

@Service
public class CartService {

	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public void addToCart(int menuItemId) {
		
		Cart cart = new Cart();
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		User user = userService.getUser(1);
		System.out.println(cart);
		cart.setUser(user);
		System.out.println(cart);
		cart.setMenuItem(menuItem);
		System.out.println(cart);
		cartRepository.save(cart);

	}
	
	@Transactional
	public List<MenuItem> getCart(){
		//List<MenuItem> list = cartRepository.getcartlist();
		/*Object[] obj=cartRepository.getcartlist();
		
		List<MenuItem> list=new ArrayList<MenuItem>();//Arrays.asList(obj);
		for(Object ob:obj) {
			list.add((MenuItem)ob);
		}
		
		MenuItem[] menu=Arrays.stream(obj).toArray(MenuItem[]::new);
		for(MenuItem ob:menu) {
			list.add((MenuItem)ob);
		}
		System.out.println(list);
		return list;*/
		
		List<MenuItem> list1=new ArrayList<MenuItem>();
		List<Object[]> list = cartRepository.getcartlist();
		for(Object[] objArr : list)
		{
			int  me_id = (int)objArr[0];
		    String name = (String)objArr[1];
		    BigDecimal price = (BigDecimal)objArr[2];
		    
		    String freedelivery=(String)objArr[6];
		   MenuItem menu=new MenuItem();
		   menu.setId(me_id);
		   menu.setPrice(price.floatValue());
		   menu.setName(name);
		   menu.setFreeDelivery(freedelivery);
		   list1.add(menu);
		}
		
		System.out.println(list1);
		for(MenuItem me:list1) {
			System.out.println(me);
		}
		return list1;
	}
	
	@Transactional
	public void deleteItem(int id) {
		
		int ct_id = cartRepository.getCartNumber(id);
		System.out.println(ct_id);
		cartRepository.delete(cartRepository.findById(ct_id).get());
	}
}
