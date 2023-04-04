package com.ac.home.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ac.home.product.ProductDTO;

@Service
public class CartService{
	
	@Autowired
	private CartDAO cartDAO;
	
	public List<CartDTO> getCartList() throws Exception {
		return cartDAO.getCartList();
	}
	
	public int setCartAdd(CartDTO cartDTO) throws Exception {
		return cartDAO.setCartAdd(cartDTO);
	}
	
	public int setCartDelete(CartDTO cartDTO) throws Exception {
		return cartDAO.setCartDelete(cartDTO);
	}
	
	public Long getSumPrice(CartDTO cartDTO) throws Exception {
		return cartDAO.getSumPrice(cartDTO);
	}
	public int getCartUpdate(CartDTO cartDTO) throws Exception {
		
		return cartDAO.getCartUpdate(cartDTO);
	}
	public Long getSubPrice(CartDTO cartDTO) throws Exception {
		return cartDAO.getSubPrice(cartDTO);
	}
	
}
	
	
