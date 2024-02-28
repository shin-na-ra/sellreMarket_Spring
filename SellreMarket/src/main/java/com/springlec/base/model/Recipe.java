package com.springlec.base.model;

public class Recipe {
	
	int yid;
	String yname;
	String ysrc;
	String ytitle;
	String dPrice;
	String price;
	String recipelike;
	int recipeid;
	String salerate;
	
	
	public Recipe(String yname, String ysrc, String ytitle, String dPrice, String price, String recipelike, int recipeid, String salerate) {
		super();
		this.yname = yname;
		this.ysrc = ysrc;
		this.ytitle = ytitle;
		this.dPrice = dPrice;
		this.price = price;
		this.recipelike = recipelike;
		this.recipeid = recipeid;
		this.salerate = salerate;
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


	public String getdPrice() {
		return dPrice;
	}


	public void setdPrice(String dPrice) {
		this.dPrice = dPrice;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getRecipelike() {
		return recipelike;
	}


	public void setRecipelike(String recipelike) {
		this.recipelike = recipelike;
	}


	public int getRecipeid() {
		return recipeid;
	}


	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}


	public String getSalerate() {
		return salerate;
	}


	public void setSalerate(String salerate) {
		this.salerate = salerate;
	}
	
	
}
