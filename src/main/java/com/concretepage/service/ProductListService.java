package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import com.concretepage.gs_ws.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductListService {

	private List<Product> productList = new ArrayList<>();

	{
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();

		product1.setName("a");
		product2.setName("b");
		product3.setName("c");
		product4.setName("d");

		product1.setProductId(1);
		product2.setProductId(2);
		product3.setProductId(3);
		product4.setProductId(4);

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
	}

	public List<Product> getProductList() {
		return productList;
	}

	public String getNameById(long id){
		String name="";
		for(Product p : productList){
			if(p.getProductId()==id)
				name = p.getName();

		} return name;
	}

}
