package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKucun;

public class JiaGeTiaoZheng extends JInternalFrame {
	
	private TbKucun kcInfo;
	private JLabel guiGe;
	private JTextField kuCunJinE;
	private JTextField kuCunShuLiang;
	private JTextField danJia;
	private JComboBox shangPinMingCheng;
	
	private void updateJinE() {
		Double dj = Double.valueOf(danJia.getText());
		Integer sl = Integer.valueOf(kuCunShuLiang.getText());
		kuCunJinE.setText((dj * sl) + "");
	}
	
	public JiaGeTiaoZheng() {
		super();
		
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameActivated(final InternalFrameEvent e) {
				DefaultComboBoxModel mingChengModel = (DefaultComboBoxModel) shangPinMingCheng.getModel();
				mingChengModel.removeAllElements();
				List list = Dao.getKucunInfos();
				Iterator iterator = list.iterator();
				while(iterator.hasNext()) {
					List element = (List) iterator.next();
					Item item = new Item();
					item.setId((String) element.get(0));
					item.setName((String) element.get(1));
					mingChengModel.addElement(item);
				}
			}
		});
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(new GridBagLayout());
		setTitle("价格调整");
		setBounds(100, 100, 531, 253);
		
		setupComponet(new JLabel("商品名称:"), 0, 0, 1, 1, false);
		
		setupComponet(new JLabel("规　　格："), 2, 0, 1, 0, false);// 设置“规格”标签的位置并添加到容器中
		guiGe = new JLabel();// “规格”标签
		guiGe.setForeground(Color.BLUE);// 设置“规格”标签中的字体颜色为蓝色
		guiGe.setPreferredSize(new Dimension(130, 21));// 设置“规格”标签的宽高
		setupComponet(guiGe, 3, 0, 1, 1, true);// 设置“规格”标签的位置并添加到容器中
		
		setupComponet(new JLabel("产　　地： "), 0, 1, 1, 0, false);// 设置“产地”标签的位置并添加到容器中
		final JLabel chanDi = new JLabel();// “产地”标签
		chanDi.setForeground(Color.BLUE);// 设置“产地”标签中的字体颜色为蓝色
		setupComponet(chanDi, 1, 1, 1, 1, true);// 设置“产地”标签的位置并添加到容器中
		
		setupComponet(new JLabel("简　　称："), 2, 1, 1, 0, false);// 设置“简称”标签的位置并添加到容器中
		final JLabel jianCheng = new JLabel();// “简称”标签
		jianCheng.setForeground(Color.BLUE);// 设置“简称”标签中的字体颜色为蓝色
		setupComponet(jianCheng, 3, 1, 1, 1, true);// 设置“简称”标签的位置并添加到容器中
		
		setupComponet(new JLabel("包　　装："), 0, 2, 1, 0, false);// 设置“包装”标签的位置并添加到容器中
		final JLabel baoZhuang = new JLabel();// “包装”标签
		baoZhuang.setForeground(Color.BLUE);// 设置“包装”标签中的字体颜色为蓝色
		setupComponet(baoZhuang, 1, 2, 1, 1, true);// 设置“包装”标签的位置并添加到容器中
		
		setupComponet(new JLabel("单　　位："), 2, 2, 1, 0, false);// 设置“单位”标签的位置并添加到容器中
		final JLabel danWei = new JLabel();// “单位”标签
		danWei.setForeground(Color.BLUE);// 设置“单位”标签中的字体颜色为蓝色
		setupComponet(danWei, 3, 2, 1, 1, true);// 设置“单位”标签的位置并添加到容器中
		
		setupComponet(new JLabel("单　　价："), 0, 3, 1, 0, false);// 设置“单价”标签的位置并添加到容器中
		danJia = new JTextField();// “单价”文本框
		danJia.addKeyListener(new KeyAdapter() {// 为“单价”文本框添加键盘事件的监听
			public void keyReleased(final KeyEvent e) {
				updateJinE();// 更改库存金额的方法
			}
		});
		setupComponet(danJia, 1, 3, 1, 1, true);// 设置“单价”文本框的位置并添加到容器中
		
		setupComponet(new JLabel("库存数量："), 2, 3, 1, 0, false);// 设置“库存数量”标签的位置并添加到容器中
		kuCunShuLiang = new JTextField();// “库存数量”文本框
		kuCunShuLiang.setEditable(false);// 设置“库存数量”文本框不可编辑
		setupComponet(kuCunShuLiang, 3, 3, 1, 1, true);// 设置“库存数量”文本框的位置并添加到容器中

		setupComponet(new JLabel("库存金额："), 0, 4, 1, 0, false);// 设置“库存金额”标签的位置并添加到容器中
		kuCunJinE = new JTextField();// “库存金额”文本框
		kuCunJinE.setEditable(false);// 设置“库存金额”文本框不可编辑
		setupComponet(kuCunJinE, 1, 4, 1, 1, true);// 设置“库存金额”文本框的位置并添加到容器中
		
		final JButton okButton = new JButton();
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				kcInfo.setDj(Double.valueOf(danJia.getText()));
				kcInfo.setKcsl(Integer.valueOf(kuCunShuLiang.getText()));
				int rs = Dao.updateKucunDj(kcInfo);
				if(rs > 0)
					JOptionPane.showMessageDialog(getContentPane(), "价格调整完毕。", kcInfo.getSpname() + "价格调整",
							JOptionPane.QUESTION_MESSAGE);// 弹出“价格调整完毕”提示框
			}
			
		});
		okButton.setText("确定");
		setupComponet(okButton, 1, 5, 1, 1, false);// 设置“确定”按钮的位置并添加到容器中

		final JButton closeButton = new JButton();// “关闭”按钮
		closeButton.addActionListener(new ActionListener() {// 为“关闭”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				JiaGeTiaoZheng.this.doDefaultCloseAction();// 关闭价格调整窗体
			}
		});
		closeButton.setText("关闭");// 设置“关闭”按钮中的文本内容
		setupComponet(closeButton, 2, 5, 1, 1, false);// 设置“关闭”按钮的位置并添加到容器中

		shangPinMingCheng.addItemListener(new ItemListener() {// 为“商品名称”下拉列表添加选项事件的监听
			public void itemStateChanged(final ItemEvent e) {
				Object selectedItem = shangPinMingCheng.getSelectedItem();// 获得“商品名称”下拉列表被选中的选项
				if (selectedItem == null)// “商品名称”下拉列表被选中的选项不存在
					return;// 退出应用程序
				Item item = (Item) selectedItem;// 获得数据表公共类
				kcInfo = Dao.getKucun(item);// 获取库存信息
				if (kcInfo.getId() == null)// 库存信息中的商品编号不存在
					return;// 退出应用程序
				int dj, sl;// 声明“单价”、“库存数量”
				dj = kcInfo.getDj().intValue();// 为“单价”赋值
				sl = kcInfo.getKcsl().intValue();// 为“库存数量”赋值
				chanDi.setText(kcInfo.getCd());// 设置“产地”标签里的文本内容
				jianCheng.setText(kcInfo.getJc());// 设置“简称”标签里的文本内容
				baoZhuang.setText(kcInfo.getBz());// 设置“包装”标签里的文本内容
				danWei.setText(kcInfo.getDw());// 设置“单位”标签里的文本内容
				danJia.setText(kcInfo.getDj() + "");// 设置“单价”文本框里的文本内容
				kuCunShuLiang.setText(kcInfo.getKcsl() + "");// 设置“库存数量”文本框里的文本内容
				kuCunJinE.setText(dj * sl + "");// 设置“库存金额”文本框里的文本内容
				guiGe.setText(kcInfo.getGg());// 设置“规格”标签里的文本内容
			}
		});
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		// TODO Auto-generated method stub
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
		gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 5);// 组件彼此的间距
		if (gridwidth > 1)// 组件横跨网格数大于1
			gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
		if (ipadx > 0)// 组件横向填充的大小大于0
			gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
		if (fill)// 组件占据空白区域
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		getContentPane().add(component, gridBagConstrains);// 添加组件
	}
	
}
