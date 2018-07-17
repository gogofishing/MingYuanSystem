package com.lzw.iframe.keHuGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKhinfo;

public class KeHuTianJiaPanel extends JPanel {
	
	private JTextField keHuQuanCheng;
	private JTextField yinHangZhangHao;
	private JTextField kaiHuYinHang;
	private JTextField EMail;
	private JTextField lianXiDianHua;
	private JTextField lianXiRen;
	private JTextField chuanZhen;
	private JTextField dianHua;
	private JTextField youZhengBianMa;
	private JTextField diZhi;
	private JTextField keHuJianCheng;
	private JButton resetButton;
	
	public KeHuTianJiaPanel() {
		super();
		setBounds(10, 10, 460, 300);
		setLayout(new GridBagLayout());
		setVisible(true);
		
		final JLabel khName = new JLabel();
		khName.setText("客户全称:");
		setupComponet(khName, 0, 0, 1, 0, false);
		keHuQuanCheng = new JTextField();
		setupComponet(keHuJianCheng, 1, 0, 3, 350, true);
		
		final JLabel addressLabel = new JLabel("客户地址:");
		setupComponet(addressLabel, 0, 1, 1, 0, false);
		diZhi = new JTextField();
		setupComponet(diZhi, 1, 1, 3, 0, true);
		
		final JLabel jc = new JLabel();
		jc.setText("客户简称:");
		setupComponet(jc, 0, 2, 1, 0, false);
		keHuJianCheng = new JTextField();
		setupComponet(keHuJianCheng, 1, 2, 1, 100, true);
		
		setupComponet(new JLabel("邮政编码:"), 2, 2, 1, 0, false);
		youZhengBianMa = new JTextField();// “邮政编码”文本框
		setupComponet(youZhengBianMa, 3, 2, 1, 100, true);// 设置“邮政编码”文本框的位置并添加到容器中
		youZhengBianMa.addKeyListener(new InputKeyListener());// 为“邮政编码”文本框添加键盘输入事件的监听
		
		setupComponet(new JLabel("电话:"), 0, 3, 1, 0, false);
		dianHua = new JTextField();
		setupComponet(dianHua, 1, 3, 1, 100, true);
		dianHua.addKeyListener(new InputKeyListener());
		
		setupComponet(new JLabel("传真:"), 2, 3 , 1, 0, false);
		chuanZhen = new JTextField();
		chuanZhen.addKeyListener(new InputKeyListener());
		setupComponet(chuanZhen, 3, 3, 1, 100, true);
		
		setupComponet(new JLabel("联系人:"), 0, 4, 1, 0, false);
		lianXiRen = new JTextField();
		setupComponet(lianXiRen, 1, 4, 1, 100, true);
		
		setupComponet(new JLabel("联系电话:"), 2, 4, 1, 0, false);
		lianXiDianHua = new JTextField();
		setupComponet(lianXiDianHua, 3, 4, 1, 100, true);
		lianXiDianHua.addKeyListener(new InputKeyListener());
		
		setupComponet(new JLabel("E-Mail:"), 0, 5, 1, 0, false);
		EMail = new JTextField();
		setupComponet(EMail, 1, 5, 3, 350, true);
		
		setupComponet(new JLabel("开户银行:"), 0, 6, 1, 0, false);
		kaiHuYinHang = new JTextField();
		setupComponet(kaiHuYinHang, 1, 6, 1, 100, true);
		
		setupComponet(new JLabel("银行账号:"), 2, 6, 1, 0, false);
		yinHangZhangHao = new JTextField();
		setupComponet(yinHangZhangHao, 3, 6, 1, 100, true);
		
		final JButton saveButton = new JButton("保存");// “保存”按钮
		setupComponet(saveButton, 1, 7, 1, 0, false);// 设置“保存”按钮的位置并添加到容器中
		saveButton.addActionListener(new SaveButtonActionListener());// 为“保存”按钮添加动作事件的监听
		
		resetButton = new JButton("重置");// “重置”按钮
		setupComponet(resetButton, 3, 7, 1, 0, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ChongZheButtonActionListener());// 为“重置”按钮添加动作事件的监听
		
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		// TODO Auto-generated method stub
		final GridBagConstraints  gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if(gridwidth > 1) {
			gridBagConstrains.gridwidth = gridwidth;
		}
		if(ipadx > 0) {
			gridBagConstrains.ipadx = ipadx;
		}
		if(fill) {
			gridBagConstrains.fill = gridBagConstrains.HORIZONTAL;
		}
		add(component, gridBagConstrains);
	}
	
	private class ChongZheButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			keHuJianCheng.setText("");
			yinHangZhangHao.setText("");
			kaiHuYinHang.setText("");
			EMail.setText("");
			lianXiDianHua.setText("");
			lianXiRen.setText("");
			chuanZhen.setText("");
			dianHua.setText("");
			youZhengBianMa.setText("");
			diZhi.setText("");
			keHuQuanCheng.setText("");
		}
		
	}
	
	private final class SaveButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			// TODO Auto-generated method stub
			if(diZhi.getText().equals("") || youZhengBianMa.getText().equals("") || chuanZhen.getText().equals("")
					|| yinHangZhangHao.getText().equals("") || keHuJianCheng.getText().equals("")
					|| keHuQuanCheng.getText().equals("") || lianXiRen.getText().equals("")
					|| lianXiDianHua.getText().equals("") || EMail.getText().equals("") || dianHua.getText().equals("")
					|| kaiHuYinHang.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请填写全部信息");
				return;
			}
		
			ResultSet haveUser = Dao.query("select * from tb_khinfo where khname ='" + keHuQuanCheng.getText().trim() + "'");
			try {
				if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
					System.out.println("error");// 控制台输出error
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "客户信息添加失败，存在同名客户", "客户添加信息",
							JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
					return;
				} 
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			ResultSet set = Dao.query("select max(id) from tb_khinfo");
			String id = null;
			try {
				if(set != null && set.next()) {
					String sid = set.getString(1);
					if(sid == null) 
						id = "kh1001";
					else {
						String str = sid.substring(2);
						id = "kh" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			TbKhinfo khinfo = new TbKhinfo();// 客户信息
			khinfo.setId(id);// 设置商品编号
			khinfo.setAddress(diZhi.getText().trim());// 设置客户地址
			khinfo.setBianma(youZhengBianMa.getText().trim());// 设置邮编
			khinfo.setFax(chuanZhen.getText().trim());// 设置传真
			khinfo.setHao(yinHangZhangHao.getText().trim());// 设置银行账号
			khinfo.setJian(keHuJianCheng.getText().trim());// 设置客户简称
			khinfo.setKhname(keHuQuanCheng.getText().trim());// 设置客户名称
			khinfo.setLian(lianXiRen.getText().trim());// 设置联系人
			khinfo.setLtel(lianXiDianHua.getText().trim());// 设置联系电话
			khinfo.setMail(EMail.getText().trim());// 设置电子邮箱
			khinfo.setTel(dianHua.getText().trim());// 设置电话
			khinfo.setXinhang(kaiHuYinHang.getText());// 设置开户银行
			
			Dao.addKeHu(khinfo);
			JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "已成功添加客户","客户添加信息", JOptionPane.INFORMATION_MESSAGE);
			resetButton.doClick();
		}
	
	}
	

}
