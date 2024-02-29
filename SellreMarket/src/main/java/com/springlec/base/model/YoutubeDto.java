package com.springlec.base.model;

public class YoutubeDto {

	int youtubeid;
	String yname;
	String image;
	String ytitle;
	String rcontent;
	int productid;
	int recipeid;
	String type;
	
	public YoutubeDto() {
		// TODO Auto-generated constructor stub
	}

	public int getYoutubeid() {
		return youtubeid;
	}

	public void setYoutubeid(int youtubeid) {
		this.youtubeid = youtubeid;
	}

	public String getYname() {
		return yname;
	}

	public void setYname(String yname) {
		this.yname = yname;
	}


	public String getYtitle() {
		return ytitle;
	}

	public void setYtitle(String ytitle) {
		this.ytitle = ytitle;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
