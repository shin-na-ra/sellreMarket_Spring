package com.springlec.base.model;

import java.sql.Date;

public class Product {
	
/*
	1. Date : 2024.02.21
	2. Author : Woody Jo
	3. Version : v1.0.0
	4. Description : view 관련 DTO
*/
	
	int yid;
	String yname;
	String ysrc;
	String ytitle;
	int rid;
	String rcontent;
	int pid;
	String pname;
	String pengname;
	String allery;
	String nutrition;
	int pstock;
	Date pinsertdate;
	String origin;
	Date expirationdate;
	String description;
	int status;
	int priceid;
	String dPrice;
	String price;
	String recipelike;
	String ename;
	String econtent;
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
	int priceNotDiscount;
	int discount;
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
	
	public Product(String pname, String price, String dPrice, String pimage, String plikecount, int productid, String salerate) {
		super();
		this.pname = pname;
		this.price = price;
		this.dPrice = dPrice;
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
	
	public Product(String yname, String ysrc, String ytitle, String price, String dPrice, String recipelike, int recipeid, String salerate) {
		super();
		this.yname = yname;
		this.ysrc = ysrc;
		this.ytitle = ytitle;
		this.price = price;
		this.dPrice = dPrice;
		this.recipelike = recipelike;
		this.recipeid = recipeid;
		this.salerate = salerate;
	}
	
	public Product(int yid, String yname, String ysrc, String ytitle, int rid, String rcontent, int pid, String pname,
			String pengname, String allery, String nutrition, int pstock, Date pinsertdate, String origin,
			Date expirationdate, String description, int status, int priceid, String dPrice, String price,
			String recipelike, String ename, String econtent, String eimg, int recipeid, int productid, String pimage,
			String plikecount, String salerate, int qty) {
		super();
		this.yid = yid;
		this.yname = yname;
		this.ysrc = ysrc;
		this.ytitle = ytitle;
		this.rid = rid;
		this.rcontent = rcontent;
		this.pid = pid;
		this.pname = pname;
		this.pengname = pengname;
		this.allery = allery;
		this.nutrition = nutrition;
		this.pstock = pstock;
		this.pinsertdate = pinsertdate;
		this.origin = origin;
		this.expirationdate = expirationdate;
		this.description = description;
		this.status = status;
		this.priceid = priceid;
		this.dPrice = dPrice;
		this.price = price;
		this.recipelike = recipelike;
		this.ename = ename;
		this.econtent = econtent;
		this.eimg = eimg;
		this.recipeid = recipeid;
		this.productid = productid;
		this.pimage = pimage;
		this.plikecount = plikecount;
		this.salerate = salerate;
		this.qty = qty;
	}

	public int getYid() {
		return yid;
	}

	public void setYid(int yid) {
		this.yid = yid;
	}

	public String getYname() {
		return yname;
	}

	public void setYname(String yname) {
		this.yname = yname;
	}

	public String getYsrc() {
		return ysrc;
	}

	public void setYsrc(String ysrc) {
		this.ysrc = ysrc;
	}

	public String getYtitle() {
		return ytitle;
	}

	public void setYtitle(String ytitle) {
		this.ytitle = ytitle;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPengname() {
		return pengname;
	}

	public void setPengname(String pengname) {
		this.pengname = pengname;
	}

	public String getAllery() {
		return allery;
	}

	public void setAllery(String allery) {
		this.allery = allery;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	public Date getPinsertdate() {
		return pinsertdate;
	}

	public void setPinsertdate(Date pinsertdate) {
		this.pinsertdate = pinsertdate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPriceid() {
		return priceid;
	}

	public void setPriceid(int priceid) {
		this.priceid = priceid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLike() {
		return recipelike;
	}

	public void setLike(String recipelike) {
		this.recipelike = recipelike;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcontent() {
		return econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
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

	public String getRecipelike() {
		return recipelike;
	}

	public void setRecipelike(String recipelike) {
		this.recipelike = recipelike;
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