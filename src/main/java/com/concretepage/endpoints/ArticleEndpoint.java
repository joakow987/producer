package com.concretepage.endpoints;

import com.concretepage.gs_ws.*;
import com.concretepage.service.BasketService;
import com.concretepage.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ArticleEndpoint {
	@Autowired
	ProductListService productListService;
	@Autowired
	BasketService basketService;

	private static final String NAMESPACE_URI = "http://www.concretepage.com/product-ws";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductListRequest")
	@ResponsePayload
	public GetProductListResponse getProductList(@RequestPayload GetProductListRequest request) {
		GetProductListResponse response = new GetProductListResponse();
		response.getProduct().addAll(productListService.getProductList());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addToBasketRequest")
	@ResponsePayload
	public AddToBasketResponse addProduct(@RequestPayload AddToBasketRequest request) {
		AddToBasketResponse response = new AddToBasketResponse();
		Product product = new Product();
		product.setProductId(request.getProductId());
		product.setName(productListService.getNameById(request.getProductId()));
		basketService.addToBasket(product);

        return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBasketRequest")
	@ResponsePayload
	public GetBasketResponse getBasket(@RequestPayload GetBasketRequest request) {
	GetBasketResponse response = new GetBasketResponse();
	response.getProduct().addAll(basketService.getBasket());

	return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteFromBasketRequest")
	@ResponsePayload
	public DeleteFromBasketResponse deleteProduct(@RequestPayload DeleteFromBasketRequest request) {
		DeleteFromBasketResponse response = new DeleteFromBasketResponse();
		Product product = new Product();
		product.setProductId(request.getProductId());
		product.setName(productListService.getNameById(request.getProductId()));
		basketService.deleteFromBasket(product);
		return response;
	}	
}
