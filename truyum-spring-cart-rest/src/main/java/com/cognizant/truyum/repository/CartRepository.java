package com.cognizant.truyum.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	
	//@Query(value = "Select m.me_name,m.me_price from truyum.user u inner join truyum.cart c on u.us_id=c.ct_us_id inner join truyum.menu_item m on c.ct_pr_id=m.me_id",nativeQuery = true)
	
	@Query(value="Select m.me_id,m.me_name,m.me_price,m.me_active,m.me_date_of_launch,m.me_category,m.me_free_delivery from truyum.menu_item m,truyum.cart c,truyum.user u where c.ct_pr_id=m.me_id and c.ct_us_id=u.us_id",nativeQuery = true)
	public List<Object[]> getcartlist();
	
	@Query(value = "select ct_id from truyum.cart where ct_pr_id=?1",nativeQuery = true)
	public int getCartNumber(int ct_id);
	
	
}
