package com.lzw.iframe.czyGI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.lzw.dao.Dao;
import com.lzw.dao.model.TbJsr;

public class TJJingShouRen extends JPanel {
	private JTextField jsrName;
	private JTextField tel;
	private JTextField age;
	private JComboBox<String> sex;
	
	private void clear() {
		jsrName.setText(null);
		tel.setText(null);
		age.setText(null);
	}
	
	public TJJingShouRen() {
		super();
		setLayout(new GridBagLayout());
		setBounds(0, 0, 280, 236);
		final JLabel label_4 = new JLabel();
		label_4.setFont(new Font("", Font.PLAIN, 14));
		label_4.setText("姓名 ：");
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.gridx = 0;
		gridBagConstraints_10.gridy = 0;
		add(label_4, gridBagConstraints_10);
		
		jsrName = new JTextField();
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.weighty = 1.0;
		gridBagConstraints_11.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_11.gridwidth = 2;
		gridBagConstraints_11.gridy = 0;
		gridBagConstraints_11.gridx = 1;
		add(jsrName, gridBagConstraints_11);
		
		final JLabel label = new JLabel();
		label.setFont(new Font("", Font.PLAIN, 14));
		label.setText("性别：");
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridx = 0;
		add(label, gridBagConstraints);
		
		sex = new JComboBox<String>();
		sex.addItem("男");
		sex.addItem("女");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.weightx = 1.0;
		gridBagConstraints_1.weighty = 1.0;
		gridBagConstraints_1.ipadx = -250;
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_1.gridwidth = 1;
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 1;
		add(sex, gridBagConstraints_1);
		
		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("", Font.PLAIN, 14));
		label_2.setText("年龄：");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy = 2;
		gridBagConstraints_4.gridx = 0;
		add(label_2, gridBagConstraints_4);
		
		age = new JTextField();
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.weighty = 1.0;
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.gridwidth = 2;
		gridBagConstraints_5.gridy = 2;
		gridBagConstraints_5.gridx = 1;
		add(age, gridBagConstraints_5);
		
		final JLabel label_3 = new JLabel();
		label_3.setFont(new Font("", Font.PLAIN, 14));
		label_3.setText("电话：");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_6.gridy = 3;// 组件位于网格的纵向索引为3
		gridBagConstraints_6.gridx = 0;// 组件位于网格的横向索引为0
		add(label_3, gridBagConstraints_6);// 向添加经手人面板中添加“电话”标签
		
		tel = new JTextField();// “电话”文本框
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_7.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);// 组件彼此的间距
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		gridBagConstraints_7.gridwidth = 2;// 组件横向跨越2个网格
		gridBagConstraints_7.gridy = 3;// 组件位于网格的纵向索引为3
		gridBagConstraints_7.gridx = 1;// 组件位于网格的横向索引为1
		add(tel, gridBagConstraints_7);// 向添加经手人面板中添加“电话”文本框
		
		final JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nameStr = jsrName.getText();
				if (nameStr == null || nameStr.isEmpty())// “姓名”文本框为空或“姓名”文本框中的文本内容为空
					return;// 退出应用程序
				String ageStr = new String(age.getText());// 获得“年龄”文本框中的文本内容
				TbJsr user = Dao.getJsr(nameStr, ageStr);// 经手人信息
				if (user.getSex() != null && !user.getSex().isEmpty()) {// 经手人的性别不为空且经手人表示性别的字符串的长度不为0
					JOptionPane.showMessageDialog(TJJingShouRen.this, "经手人(" + user.getName() + ")已经存在");// 弹出对话框
					sex.setFocusable(true);// // “性别”下拉列表获得焦点
					return;// 退出应用程序
				}
				String sexStr = sex.getSelectedItem() + "";// 获得经手人的性别
				TbJsr jsr = new TbJsr();// 经手人信息
				jsr.setTel(tel.getText());// 设置经手人电话
				jsr.setAge(age.getText());// 设置经手人年龄
				jsr.setName(nameStr);// 设置经手人姓名
				jsr.setSex(sexStr);// 设置经手人性别
				int i = Dao.addJsr(jsr);// 添加经手人
				if (i > 0)// 添加经手人的数目大于1
					JOptionPane.showMessageDialog(TJJingShouRen.this, "添加成功");// 弹出提示框
				clear();// 清除文本框的内容
			}
			
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_8.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;// 设置组件在该组件显示区域的右中
		gridBagConstraints_8.gridy = 5;// 组件位于网格的纵向索引为5
		gridBagConstraints_8.gridx = 1;// 组件位于网格的横向索引为1
		add(button, gridBagConstraints_8);// 向添加经手人面板中添加“添加”按钮

		final JButton button_1 = new JButton();// “重置”按钮
		button_1.addActionListener(new ActionListener() {// 为“重置”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				clear();// 清除文本框的内容
			}
		});
		button_1.setText("重置");// 设置“重置”按钮中的字体内容
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_9.weighty = 1.0;// 组件纵向扩大的权重是1.0
		gridBagConstraints_9.gridy = 5;// 组件位于网格的纵向索引为5
		gridBagConstraints_9.gridx = 2;// 组件位于网格的横向索引为2
		add(button_1, gridBagConstraints_9);// 向添加经手人面板中添加“重置”按钮
		
	}

}
