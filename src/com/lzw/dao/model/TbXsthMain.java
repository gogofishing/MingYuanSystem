package com.lzw.dao.model;

import java.util.HashSet;
import java.util.Set;

public class TbXsthMain implements java.io.Serializable {
	private String xsthId;// �����˻����
	private String pzs;// Ʒ������
	private String je;// �ܼƽ��
	private String ysjl;// ���ս���
	private String khname;// �ͻ�����
	private String thdate;// �˻�����
	private String czy;// ����Ա
	private String jsr;// ������
	private String jsfs;// ���㷽ʽ
	private Set tbXsthDetails = new HashSet(0);// �����˻���ϸ��Ϣ

	public TbXsthMain() {// ȱʡ���캯��
	}
	
	public TbXsthMain(String xsthId, String pzs, String je, String ysjl, String khname, String thdate, String czy,
			String jsr, String jsfs) {// �������캯��
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
