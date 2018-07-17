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
		khName.setText("�ͻ�ȫ��:");
		setupComponet(khName, 0, 0, 1, 0, false);
		keHuQuanCheng = new JTextField();
		setupComponet(keHuJianCheng, 1, 0, 3, 350, true);
		
		final JLabel addressLabel = new JLabel("�ͻ���ַ:");
		setupComponet(addressLabel, 0, 1, 1, 0, false);
		diZhi = new JTextField();
		setupComponet(diZhi, 1, 1, 3, 0, true);
		
		final JLabel jc = new JLabel();
		jc.setText("�ͻ����:");
		setupComponet(jc, 0, 2, 1, 0, false);
		keHuJianCheng = new JTextField();
		setupComponet(keHuJianCheng, 1, 2, 1, 100, true);
		
		setupComponet(new JLabel("��������:"), 2, 2, 1, 0, false);
		youZhengBianMa = new JTextField();// ���������롱�ı���
		setupComponet(youZhengBianMa, 3, 2, 1, 100, true);// ���á��������롱�ı����λ�ò���ӵ�������
		youZhengBianMa.addKeyListener(new InputKeyListener());// Ϊ���������롱�ı�����Ӽ��������¼��ļ���
		
		setupComponet(new JLabel("�绰:"), 0, 3, 1, 0, false);
		dianHua = new JTextField();
		setupComponet(dianHua, 1, 3, 1, 100, true);
		dianHua.addKeyListener(new InputKeyListener());
		
		setupComponet(new JLabel("����:"), 2, 3 , 1, 0, false);
		chuanZhen = new JTextField();
		chuanZhen.addKeyListener(new InputKeyListener());
		setupComponet(chuanZhen, 3, 3, 1, 100, true);
		
		setupComponet(new JLabel("��ϵ��:"), 0, 4, 1, 0, false);
		lianXiRen = new JTextField();
		setupComponet(lianXiRen, 1, 4, 1, 100, true);
		
		setupComponet(new JLabel("��ϵ�绰:"), 2, 4, 1, 0, false);
		lianXiDianHua = new JTextField();
		setupComponet(lianXiDianHua, 3, 4, 1, 100, true);
		lianXiDianHua.addKeyListener(new InputKeyListener());
		
		setupComponet(new JLabel("E-Mail:"), 0, 5, 1, 0, false);
		EMail = new JTextField();
		setupComponet(EMail, 1, 5, 3, 350, true);
		
		setupComponet(new JLabel("��������:"), 0, 6, 1, 0, false);
		kaiHuYinHang = new JTextField();
		setupComponet(kaiHuYinHang, 1, 6, 1, 100, true);
		
		setupComponet(new JLabel("�����˺�:"), 2, 6, 1, 0, false);
		yinHangZhangHao = new JTextField();
		setupComponet(yinHangZhangHao, 3, 6, 1, 100, true);
		
		final JButton saveButton = new JButton("����");// �����桱��ť
		setupComponet(saveButton, 1, 7, 1, 0, false);// ���á����桱��ť��λ�ò���ӵ�������
		saveButton.addActionListener(new SaveButtonActionListener());// Ϊ�����桱��ť��Ӷ����¼��ļ���
		
		resetButton = new JButton("����");// �����á���ť
		setupComponet(resetButton, 3, 7, 1, 0, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ChongZheButtonActionListener());// Ϊ�����á���ť��Ӷ����¼��ļ���
		
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
				JOptionPane.showMessageDialog(null, "����дȫ����Ϣ");
				return;
			}
		
			ResultSet haveUser = Dao.query("select * from tb_khinfo where khname ='" + keHuQuanCheng.getText().trim() + "'");
			try {
				if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
					System.out.println("error");// ����̨���error
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "�ͻ���Ϣ���ʧ�ܣ�����ͬ���ͻ�", "�ͻ������Ϣ",
							JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
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
			TbKhinfo khinfo = new TbKhinfo();// �ͻ���Ϣ
			khinfo.setId(id);// ������Ʒ���
			khinfo.setAddress(diZhi.getText().trim());// ���ÿͻ���ַ
			khinfo.setBianma(youZhengBianMa.getText().trim());// �����ʱ�
			khinfo.setFax(chuanZhen.getText().trim());// ���ô���
			khinfo.setHao(yinHangZhangHao.getText().trim());// ���������˺�
			khinfo.setJian(keHuJianCheng.getText().trim());// ���ÿͻ����
			khinfo.setKhname(keHuQuanCheng.getText().trim());// ���ÿͻ�����
			khinfo.setLian(lianXiRen.getText().trim());// ������ϵ��
			khinfo.setLtel(lianXiDianHua.getText().trim());// ������ϵ�绰
			khinfo.setMail(EMail.getText().trim());// ���õ�������
			khinfo.setTel(dianHua.getText().trim());// ���õ绰
			khinfo.setXinhang(kaiHuYinHang.getText());// ���ÿ�������
			
			Dao.addKeHu(khinfo);
			JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "�ѳɹ���ӿͻ�","�ͻ������Ϣ", JOptionPane.INFORMATION_MESSAGE);
			resetButton.doClick();
		}
	
	}
	

}
