package com.lzw.dao.model;

public class TbRkthDetail implements java.io.Serializable {
	private Integer id;
	private String tbRkthMain;
	private String spid;
	private Double dj;
	private Integer sl;
	
	public TbRkthDetail() {
		
	}
	
	public TbRkthDetail(String tbRkthMain, String spid, Double dj,
			Integer sl) {
		this.tbRkthMain = tbRkthMain;
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

	public String getTbRkthMain() {
		return tbRkthMain;
	}

	public void setTbRkthMain(String tbRkthMain) {
		this.tbRkthMain = tbRkthMain;
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
