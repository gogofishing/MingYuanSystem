package com.lzw.iframe.keHuGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKhinfo;

public class KeHuXiuGaiPanel extends JPanel {
	
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
	private JButton modifyButton;
	private JButton delButton;
	private JComboBox kehu;
	
	public KeHuXiuGaiPanel() {
		setBounds(10, 10, 460, 300);
		setLayout(new GridBagLayout());
		setVisible(true);
		
		final JLabel khName = new JLabel("客户全称:");
		setupComponent(khName, 0, 0, 1, 0, false);
		keHuQuanCheng = new JTextField();
		keHuQuanCheng.setEditable(false);
		setupComponent(keHuQuanCheng, 1, 0, 3, 350, true);
		
		final JLabel addressLable = new JLabel("客户地址:");
		setupComponent(addressLable, 0, 1, 1, 0, false);
		diZhi = new JTextField();
		setupComponent(diZhi, 1, 1, 3, 0, true);
		
		setupComponent(new JLabel("客户简称:"), 0, 2, 1, 0, false);
		keHuJianCheng = new JTextField();
		setupComponent(keHuJianCheng, 1, 2, 1, 130, true);
		
		setupComponent(new JLabel("邮政编码:"), 2, 2, 1, 0, false);
		youZhengBianMa = new JTextField();
		setupComponent(youZhengBianMa, 3, 2, 1, 100, true);
		youZhengBianMa.addKeyListener(new InputKeyListener());
		
		setupComponent(new JLabel("电话:"), 0, 3, 1, 0, false);
		dianHua = new JTextField();
		setupComponent(dianHua, 1, 3, 1, 100, true);
		dianHua.addKeyListener(new InputKeyListener());
		
		setupComponent(new JLabel("传真:"), 2, 3, 1, 0, false);
		chuanZhen = new JTextField();
		chuanZhen.addKeyListener(new InputKeyListener());
		setupComponent(chuanZhen, 3, 3, 1, 100, true);
		
		setupComponent(new JLabel("联系人:"), 0, 4, 1, 0, false);
		lianXiRen = new JTextField();
		setupComponent(lianXiRen, 1, 4, 1, 100, true);
		
		setupComponent(new JLabel("联系电话:"), 2, 4, 1, 0, false);
		lianXiDianHua = new JTextField();
		setupComponent(lianXiDianHua, 3, 4, 1, 100, true);
		lianXiDianHua.addKeyListener(new InputKeyListener());
		
		setupComponent(new JLabel("E-Mail:"), 0, 5, 1, 0, false);
		EMail = new JTextField();
		setupComponent(EMail, 1, 5, 3, 350, true);
		
		setupComponent(new JLabel("开户银行:"), 0, 6, 1, 0, false);
		kaiHuYinHang = new JTextField();
		setupComponent(kaiHuYinHang, 1, 6, 1, 100, true);
		
		setupComponent(new JLabel("银行账户:"), 2, 6, 1, 0, false);
		yinHangZhangHao = new JTextField();
		setupComponent(yinHangZhangHao, 3, 6, 1, 100, true);
		
		setupComponent(new JLabel("选择客户:"), 0, 7, 1, 0, false);
		kehu = new JComboBox();
		kehu.setPreferredSize(new Dimension(230, 21));
		initCombox();
		kehu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doKeHuSelectAction();
			}
			
		});
		setupComponent(kehu, 1, 7, 2, 0, true);
		modifyButton = new JButton("修改");
		delButton = new JButton("删除");
		JPanel panel = new JPanel();
		panel.add(modifyButton);
		panel.add(delButton);
		setupComponent(panel, 3, 7, 1, 0, false);
		
		delButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Item item = (Item) kehu.getSelectedItem();
				if(item == null || !(item instanceof Item)) {
					return;
				}
				int comfirm = JOptionPane.showConfirmDialog(KeHuXiuGaiPanel.this, "确认删除客户信息吗？");
				if(comfirm == JOptionPane.YES_OPTION) {
					int rs = Dao.delete("delete tb_khinfo where id ='" + item.getId() + "'");
					if(rs > 0) {
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "客户：" + item.getName() + "。删除成功");
						kehu.removeItem(item);
					}
				}
			}
			
		});
		
		modifyButton.addActionListener(new ActionListener() {// “修改”按钮的动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// 获得数据表公共类对象
				TbKhinfo khinfo = new TbKhinfo();// 客户信息
				khinfo.setId(item.getId());// 设置客户编号
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
				if (Dao.updateKeHu(khinfo) == 1)// 更改客户信息的数量等于1
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "修改完成");// 弹出提示框
				else// 更改客户信息的数量不等于1
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "修改失败");// 弹出提示框
			}
		});
	}

	private void initCombox() {
		// TODO Auto-generated method stub
		List khInfo = Dao.getKhInfos();
		List<Item> items = new ArrayList<Item>();
		kehu.removeAllItems();
		for(Iterator iter = khInfo.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if(items.contains(item))
				continue;
			items.add(item);
			kehu.addItem(item);
		}
		doKeHuSelectAction();
	}

	private void doKeHuSelectAction() {
		// TODO Auto-generated method stub
		Item selectedItem;
		if(!(kehu.getSelectedItem() instanceof Item)){
			return;
		}
		selectedItem = (Item) kehu.getSelectedItem();// 获得“选择客户”下拉列表中的选项
		TbKhinfo khInfo = Dao.getKhInfo(selectedItem);// 客户信息
		keHuQuanCheng.setText(khInfo.getKhname());// 设置“客户全称”文本框中的文本内容
		diZhi.setText(khInfo.getAddress());// 设置“地址”文本框中的文本内容
		keHuJianCheng.setText(khInfo.getJian());// 设置“客户简称”文本框中的文本内容
		youZhengBianMa.setText(khInfo.getBianma());// 设置“邮政编码”文本框中的文本内容
		dianHua.setText(khInfo.getTel());// 设置“电话”文本框中的文本内容
		chuanZhen.setText(khInfo.getFax());// 设置“传真”文本框中的文本内容
		lianXiRen.setText(khInfo.getLian());// 设置“联系人”文本框中的文本内容
		lianXiDianHua.setText(khInfo.getLtel());// 设置“联系电话”文本框中的文本内容
		EMail.setText(khInfo.getMail());// 设置“E-Mail”文本框中的文本内容
		kaiHuYinHang.setText(khInfo.getXinhang());// 设置“开户银行”文本框中的文本内容
		yinHangZhangHao.setText(khInfo.getHao());// 设置“银行账号”文本框中的文本内容
		
	}

	private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		// TODO Auto-generated method stub
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if(gridwidth > 1) 
			gridBagConstrains.gridwidth = gridwidth;
		if(ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if(fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		add(component, gridBagConstrains);
	}
}
