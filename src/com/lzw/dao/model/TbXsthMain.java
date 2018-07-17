package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbXsthMain implements java.io.Serializable {
	private String xsthId;// 销售退货编号
	private String pzs;// 品种数量
	private String je;// 总计金额
	private String ysjl;// 验收结论
	private String khname;// 客户名称
	private String thdate;// 退货日期
	private String czy;// 操作员
	private String jsr;// 经手人
	private String jsfs;// 结算方式
	private Set tbXsthDetails = new HashSet(0);// 销售退货详细信息

	public TbXsthMain() {// 缺省构造函数
	}
	
	public TbXsthMain(String xsthId, String pzs, String je, String ysjl, String khname, String thdate, String czy,
			String jsr, String jsfs) {// 完整构造函数
		this.xsthId = xsthId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.thdate = thdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}

	public String getXsthId() {
		return xsthId;
	}

	public void setXsthId(String xsthId) {
		this.xsthId = xsthId;
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

	public String getKhname() {
		return khname;
	}

	public void setKhname(String khname) {
		this.khname = khname;
	}

	public String getThdate() {
		return thdate;
	}

	public void setThdate(String thdate) {
		this.thdate = thdate;
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

	public Set getTbXsthDetails() {
		return tbXsthDetails;
	}

	public void setTbXsthDetails(Set tbXsthDetails) {
		this.tbXsthDetails = tbXsthDetails;
	}
}
