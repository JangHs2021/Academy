package com.ac.home.product;

import java.util.Date;
import java.util.List;

import com.ac.home.product.ProductImgDTO;
import com.ac.home.product.CategoryDTO;

public class ProductDTO {
	
	private Long num;
	private String title;
	private Long price;
	private String info;
	private Date regDate;
	private List<ProductImgDTO> productImgDTOs;
	private List<CategoryDTO> categoryDTOs;
	private List<BoardFileDTO> boardFileDTOs; 
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	public List<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}
	public void setCategoryDTOs(List<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}
	
	public List<ProductImgDTO> getProductImgDTOs() {
		return productImgDTOs;
	}
	public void setProductImgDTOs(List<ProductImgDTO> productImgDTOs) {
		this.productImgDTOs = productImgDTOs;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}	

}
