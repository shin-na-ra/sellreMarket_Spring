package com.springlec.base.model;

import java.sql.Date;

public class Product {
	
/*
	1. Date : 2024.02.21
	2. Author : Woody Jo
	3. Version : v1.0.0
	4. Description : view 관련 DTO
*/
	
	String pname;
	String dPrice;
	String price;
	String eimg;
	int recipeid;
	int productid;
	String pimage;
	String plikecount;
	String salerate;
	int qty;
	String uname;
	String tel_no;
	String email;
	String address;
	String detailaddress;
	int priceGetDiscount;
	int discount;
	int priceNotDiscount;
	int cartid;
	int purchaseid;
	
	
	public Product(String eimg) {
		super();
		this.eimg = eimg;
	}
	
	public Product(String pname, String price, String pimage, int qty) {
		super();
		this.pname = pname;
		this.price = price;
		this.pimage = pimage;
		this.qty = qty;
	}
	
	public Product(String uname, String tel_no, String email, String address, String detailaddress) {
		super();
		this.uname = uname;
		this.tel_no = tel_no;
		this.email = email;
		this.address = address;
		this.detailaddress = detailaddress;
	}

	public Product(String price, String dPrice, String pname, String pimage, String plikecount, int productid, String salerate) {
		super();
		this.price = price;
		this.dPrice = dPrice;
		this.pname = pname;
		this.pimage = pimage;
		this.plikecount = plikecount;
		this.productid = productid;
		this.salerate = salerate;
	}
	
	public Product(int productid, String pname, int qty, int priceGetDiscount, int discount, int priceNotDiscount,  String pimage, int cartid) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.qty = qty;
		this.priceGetDiscount = priceGetDiscount;
		this.discount = discount;
		this.priceNotDiscount = priceNotDiscount;
		this.pimage = pimage;
		this.cartid = cartid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEimg() {
		return eimg;
	}

	public void setEimg(String eimg) {
		this.eimg = eimg;
	}

	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPlikecount() {
		return plikecount;
	}

	public void setPlikecount(String plikecount) {
		this.plikecount = plikecount;
	}

	public String getdPrice() {
		return dPrice;
	}

	public void setdPrice(String dPrice) {
		this.dPrice = dPrice;
	}

	public String getSalerate() {
		return salerate;
	}

	public void setSalerate(String salerate) {
		this.salerate = salerate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPriceGetDiscount() {
		return priceGetDiscount;
	}


	public void setPriceGetDiscount(int priceGetDiscount) {
		this.priceGetDiscount = priceGetDiscount;
	}


	public int getPriceNotDiscount() {
		return priceNotDiscount;
	}


	public void setPriceNotDiscount(int priceNotDiscount) {
		this.priceNotDiscount = priceNotDiscount;
	}


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public int getPurchaseid() {
		return purchaseid;
	}


	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

}