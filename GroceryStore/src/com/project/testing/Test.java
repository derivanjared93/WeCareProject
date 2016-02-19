package com.project.testing;

import java.util.ArrayList;
import java.util.List;

import com.project.pojo.Customer;
import com.project.pojo.Food;
import com.project.pojo.Food.Category;
import com.project.pojo.Order;

public class Test 
{

	public static void main(String[] args) 
	{
		Customer c = new Customer();
		Food f = new Food();
		Order o;
		List<Food> currentOrder = new ArrayList<Food>();
		
		f.setFoodCategory(Category.DAIRY.name());
		Food f1 = new Food("Milk", 1.99, Category.DAIRY, true, 396, "Dean's 2%");
		Food f2 = new Food("Eggs", 2.99, Category.PROTEIN, true, 400, "Eggselent");
		Food f3 = new Food("Bananas", .45, Category.FRUIT, true, 50, "Chiquita");
		Food f4 = new Food("Frozen Burritos", .99, Category.OIL, false, 8, "Gross");
		
		currentOrder.add(f1);
		currentOrder.add(f2);
		currentOrder.add(f3);
		currentOrder.add(f4);
		
		
		c.setCurrentOrder(currentOrder);
		o = new Order(c.getCustomerID(), f1.getFoodPrice(), "2/18/2016");
		o.getOrderTotal();
	}

}
