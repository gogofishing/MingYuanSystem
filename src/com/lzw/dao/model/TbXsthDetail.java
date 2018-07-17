package com.lzw.dao.model;

public class TbXsthDetail implements java.io.Serializable {
	private Integer id;
	private String tbXsthMain;
	private String spid;
	private Double dj;
	private Integer sl;
	
	public TbXsthDetail() {
		
	}
	
	public TbXsthDetail(String tbXsthMain, String spid, Double dj, Integer sl) {
		this.tbXsthMain = tbXsthMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTbXsthMain() {
		return tbXsthMain;
	}

	public void setTbXsthMain(String tbXsthMain) {
		this.tbXsthMain = tbXsthMain;
	}

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
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
