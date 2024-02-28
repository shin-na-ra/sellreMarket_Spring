package com.springlec.base.model;

public class AdminOrderDto {

	int rcount;
	String rcomment;
	int productid;
	String pname;
	int pstock;
	int amount;
	String status;
	
	public AdminOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public String getRcomment() {
		return rcomment;
	}

	public void setRcomment(String rcomment) {
		this.rcomment = rcomment;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
