package com.lzw;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

import com.lzw.dao.*;

public class ToolBar extends JToolBar {
	
	private MenuBar menuBar;
	/**
	 * ȱʡ���캯��
	 */
	private ToolBar() {
		
	}
	/**
	 * �������캯��
	 */
	public ToolBar(MenuBar frameMenuBar) {
		super();
		this.menuBar = frameMenuBar;
		initialize();
	}
	/**
	 * �����ʼ������
	 */
	private void initialize() {
		// TODO Auto-generated method stub
		setSize(new Dimension(600, 24));// ���ù������Ŀ��
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));// ���ù������ı߿�
		add(createToolButton(menuBar.getJinhuoItem()));// �򹤾�������ӽ�����
		add(createToolButton(menuBar.getXiaoshou_danItem()));// �򹤾�����������۵�
		add(createToolButton(menuBar.getKucun_pandianItem()));// �򹤾�������ӿ���̵�
		add(createToolButton(menuBar.getJiage_tiaozhengItem()));// �򹤾�������Ӽ۸����
		add(createToolButton(menuBar.getShangpin_chaxunItem()));// �򹤾����������Ʒ��ѯ
		add(createToolButton(menuBar.getShangpin_guanliItem()));// �򹤾����������Ʒ���Ϲ���
		add(createToolButton(menuBar.getKehu_guanliItem()));// �򹤾�������ӿͻ����Ϲ���
		add(createToolButton(menuBar.getGys_guanliItem()));// �򹤾�������ӹ�Ӧ�����Ϲ���
		add(createToolButton(menuBar.getExitItem()));// �򹤾���������˳�ϵͳ
	}
	/**
	 * ������������ť�ķ���
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton createToolButton(final JMenuItem item) {
		// TODO Auto-generated method stub
		JButton button = new JButton();
		button.setText(item.getText());
		button.setToolTipText(item.getText());
		button.setIcon(item.getIcon());
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				item.doClick();
			}
			
		});
		return button;
	}
	
	public void setMenuBar(MenuBar menuBar) {// ���ò˵���
		this.menuBar = menuBar;
	}
}
