package com.lzw.iframe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.keHuGuanLi.*;

public class KeHuGuanLi extends JInternalFrame {
	public KeHuGuanLi() {
		setIconifiable(true);
		setClosable(true);
		setTitle("客户信息管理");
		JTabbedPane tabPane = new JTabbedPane();
		final KeHuXiuGaiPanel khxgPanel = new KeHuXiuGaiPanel();
		final KeHuTianJiaPanel khtjPanel = new KeHuTianJiaPanel();
		tabPane.addTab("客户信息添加", null, khtjPanel, "客户添加");// 把客户添加面板添加到选项卡面板中
		tabPane.addTab("客户信息修改与删除", null, khxgPanel, "修改与删除");// 把客户修改面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到客户管理内部窗体的内容面板中
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initCombox();// 初始化客户修改面板中的“选择客户”下拉列表
			}
		});
		pack();// 客户管理内部窗体中的组件按其首选大小进行布局
		setVisible(true);// 使客户管理内部窗体可见
	}

}
