package com.lzw.dao.model;

public class TbRukuDetail implements java.io.Serializable {
	private String id;
	private String tbSpinfo;
	private String tbRukuMian;
	private Double dj;
	private Integer sl;
	
	public TbRukuDetail() {
		
	}
	
	public TbRukuDetail(String tbSpinfo, String tbRukuMian, Double dj,
			Integer sl) {
		this.tbSpinfo = tbSpinfo;
		this.tbRukuMian = tbRukuMian;
		this.dj = dj;
		this.sl = sl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTbSpinfo() {
		return tbSpinfo;
	}

	public void setTbSpinfo(String tbSpinfo) {
		this.tbSpinfo = tbSpinfo;
	}

	public String getTbRukuMian() {
		return tbRukuMian;
	}

	public void setTbRukuMian(String tbRukuMian) {
		this.tbRukuMian = tbRukuMian;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}
}
