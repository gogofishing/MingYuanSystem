package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbRukuMain implements java.io.Serializable {
	private String rkId;
	private String pzs;
	private String je;
	private String ysjl;
	private String gysname;
	private String rkdate;
	private String czy;
	private String jsr;
	private String jsfs;
	private Set<TbRukuDetail> tabRukuDetails = new HashSet<TbRukuDetail>(0);
	
	public TbRukuMain() {
		
	}
	
	public TbRukuMain(String rkId, String pzs, String je,
			String ysjl, String gysname, String rkdate,
			String czy, String jsr, String jsfs) {
		this.rkId = rkId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl  = ysjl;
		this.gysname = gysname;
		this.rkdate = rkdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}

	public String getRkId() {
		return rkId;
	}

	public void setRkId(String rkId) {
		this.rkId = rkId;
	}

	public String getPzs() {
		return pzs;
	}

	public void setPzs(String pzs) {
		this.pzs = pzs;
	}

	public String getJe() {
		return je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getYsjl() {
		return ysjl;
	}

	public void setYsjl(String ysjl) {
		this.ysjl = ysjl;
	}

	public String getGysname() {
		return gysname;
	}

	public void setGysname(String gysname) {
		this.gysname = gysname;
	}

	public String getRkdate() {
		return rkdate;
	}

	public void setRkdate(String rkdate) {
		this.rkdate = rkdate;
	}

	public String getCzy() {
		return czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	public String getJsfs() {
		return jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public Set<TbRukuDetail> getTabRukuDetails() {
		return tabRukuDetails;
	}

	public void setTabRukuDetails(Set<TbRukuDetail> tabRukuDetails) {
		this.tabRukuDetails = tabRukuDetails;
	}
}
