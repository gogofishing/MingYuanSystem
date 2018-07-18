package com.lzw.iframe.shangPinGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbSpinfo;

public class ShangPinTianJiaPanel extends JPanel {
	private JComboBox gysQuanCheng;
	private JTextField beiZhu;
	private JTextField wenHao;
	private JTextField piHao;
	private JTextField baoZhuang;
	private JTextField guiGe;
	private JTextField danWei;
	private JTextField chanDi;
	private JTextField jianCheng;
	private JTextField quanCheng;
	private JButton resetButton;
	
	public ShangPinTianJiaPanel() {
		setLayout(new GridBagLayout());
		setBounds(10, 10, 550, 400);
		setupComponent(new JLabel("商品名称:"), 0, 0, 1, 1, false);
		quanCheng = new JTextField();
		setupComponent(quanCheng, 1, 0, 3, 1, true);
		setupComponent(new JLabel("简称:"), 0, 1, 1, 1, false);
		jianCheng = new JTextField();
		setupComponent(jianCheng, 1, 1, 3, 10, true);
		setupComponent(new JLabel("产地:"), 0, 2, 1, 1, false);
		chanDi = new JTextField();
		setupComponent(chanDi, 1, 2, 3, 300, true);
		setupComponent(new JLabel("单位:"), 0, 3, 1, 1, false);
		danWei = new JTextField();
		setupComponent(danWei, 1, 3, 1, 130, true);
		setupComponent(new JLabel("规格:"), 2, 3, 1, 1, false);
		guiGe = new JTextField();
		setupComponent(guiGe, 3, 3, 1, 1, true);
		setupComponent(new JLabel("包装:"), 0, 4, 1, 1, false);
		baoZhuang = new JTextField();
		setupComponent(baoZhuang, 1, 4, 1, 1, true);
		setupComponent(new JLabel("批号:"), 2 ,4, 1, 1, false);
		piHao = new JTextField();
		setupComponent(piHao, 3, 4, 1, 1, true);
		setupComponent(new JLabel("批准文号:"), 0, 5, 1, 1, false);
		wenHao = new JTextField();
		setupComponent(wenHao, 1, 5, 3, 1, true);
		setupComponent(new JLabel("供应商全称:"), 0, 6, 1, 1, false);
		gysQuanCheng = new JComboBox();
		gysQuanCheng.setMaximumRowCount(5);
		setupComponent(gysQuanCheng, 1, 6, 3, 1, true);
		setupComponent(new JLabel("备注:"), 0, 7, 1, 1, false);
		beiZhu = new JTextField();
		setupComponent(beiZhu, 1, 7, 3, 1, true);
		final JButton tjButton = new JButton();
		tjButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(baoZhuang.getText().equals("") || chanDi.getText().equals("") || danWei.getText().equals("") 
						|| guiGe.getText().equals("") || jianCheng.getText().equals("") || piHao.getText().equals("")
						|| wenHao.getText().equals("") || quanCheng.getText().equals("")) {
					JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "请完成未填写的信息", "商品添加", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				ResultSet haveUser = Dao.query("select * from st_spinfo where spname='" + quanCheng.getText().trim() + "'");
				try {
					if(haveUser.next()) {
						System.out.println("error");
						JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "商品信息添加失败， 存在同商品名称", "客户添加信息", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ResultSet set = Dao.query("select max(id) from tb_spinfo");
				String id = null;
				try {
					if(set != null && set.next()) {
						String sid = set.getString(1);
						if(sid == null)
							id = "sp1001";
						else {
							String str = sid.substring(2);
							id = "sp" + (Integer.parseInt(str) + 1);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TbSpinfo spInfo = new TbSpinfo();// 商品信息
				spInfo.setId(id);// 设置商品编号
				spInfo.setBz(baoZhuang.getText().trim());// 设置包装
				spInfo.setCd(chanDi.getText().trim());// 设置产地
				spInfo.setDw(danWei.getText().trim());// 设置商品计量单位
				spInfo.setGg(guiGe.getText().trim());// 设置商品规格
				spInfo.setGysname(gysQuanCheng.getSelectedItem().toString().trim());// 设置供应商全称
				spInfo.setJc(jianCheng.getText().trim());// 设置商品简称
				spInfo.setMemo(beiZhu.getText().trim());// 设置备注
				spInfo.setPh(piHao.getText().trim());// 设置批号
				spInfo.setPzwh(wenHao.getText().trim());// 设置批准文号
				spInfo.setSpname(quanCheng.getText().trim());// 设置商品名称
				Dao.addSp(spInfo);// 添加商品信息
				JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "商品信息已经成功添加", "商品添加",
						JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
				resetButton.doClick();// “重置”按钮执行点击事件
			}
		});
		
		tjButton.setText("添加");
		setupComponent(tjButton, 1, 8, 1, 1, false);
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();
		gridBagConstraints_20.weighty = 1.0;
		gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);
		gridBagConstraints_20.gridy = 8;
		gridBagConstraints_20.gridx = 1;
		resetButton = new JButton();
		setupComponent(resetButton, 3, 8, 1, 1, false);
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				baoZhuang.setText("");
				chanDi.setText("");
				danWei.setText("");
				guiGe.setText("");
				jianCheng.setText("");
				beiZhu.setText("");
				piHao.setText("");
				wenHao.setText("");
				quanCheng.setText("");
			}
			
		});
		resetButton.setText("重置");
	}


	private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		// TODO Auto-generated method stub
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.insets = new Insets(5, 1, 3, 1);
		if(gridwidth > 1) {
			gridBagConstraints.gridwidth = gridwidth;
		}
		if(ipadx > 0) {
			gridBagConstraints.ipadx = ipadx;
		}
		if(fill) {
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		add(component, gridBagConstraints);
	}
	
	public void initGysBox() {
		List gysInfo = Dao.getGysInfos();
		List<Item> items = new ArrayList<Item>();
		gysQuanCheng.removeAllItems();
		for(Iterator iter = gysInfo.iterator(); iter.hasNext(); ) {
			List element = (List) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if(items.contains(item))
				continue;
			items.add(item);
			gysQuanCheng.addItem(item);
		}
	}
}
