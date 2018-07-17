package com.lzw.dao.model;

public class TbSellDetail implements java.io.Serializable {
	private Integer id;
	private String tbSellMain;
	private String spid;
	private Double dj;
	private Integer sl;
	
	public TbSellDetail() {
		
	}
	
	public TbSellDetail(String tbSellMain, String spid, Double dj,
			Integer sl) {
		this.tbSellMain = tbSellMain;
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

	public String getTbSellMain() {
		return tbSellMain;
	}

	public void setTbSellMain(String tbSellMain) {
		this.tbSellMain = tbSellMain;
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
