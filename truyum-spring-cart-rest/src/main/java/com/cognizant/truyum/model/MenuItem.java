package com.cognizant.truyum.model;




import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "menu_item")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "me_id")
	private int id;
	@Column(name = "me_name")
	private String name;
	@Column(name = "me_price")
	private float price;
	@Column(name = "me_active")
	private String active;
	@Column(name = "me_date_of_launch")
//	@Temporal(TemporalType.DATE)
	private Date dateOfLaunch;
	@Column(name = "me_category")
	private String category;
	@Column(name = "me_free_delivery")
	private String freeDelivery;
	
	@OneToMany(mappedBy = "menuItem",fetch = FetchType.EAGER)
	private List<Cart> carts;
	
}
