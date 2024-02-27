package com.springlec.base.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AdminEventDto {

	int eventid;
	String ename;
	String econtent;
	String startdate;
	String enddate;
	int salerate;
	String status;
	int productid;
	
	int catetoryid;
	String pname;
	String img;
	
	MultipartFile attchFile;
	List<MultipartFile> image;
	
	String insertDate;
	
	
	
	
	public AdminEventDto() {
		// TODO Auto-generated constructor stub
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
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

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getSalerate() {
		return salerate;
	}

	public void setSalerate(int salerate) {
		this.salerate = salerate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCatetoryid() {
		return catetoryid;
	}

	public void setCatetoryid(int catetoryid) {
		this.catetoryid = catetoryid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public MultipartFile getAttchFile() {
		return attchFile;
	}

	public void setAttchFile(MultipartFile attchFile) {
		this.attchFile = attchFile;
	}

	public List<MultipartFile> getImage() {
		return image;
	}

	public void setImage(List<MultipartFile> image) {
		this.image = image;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}


}
	
