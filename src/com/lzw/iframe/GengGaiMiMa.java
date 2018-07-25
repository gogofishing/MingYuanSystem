package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.lzw.dao.Dao;

public class GengGaiMiMa extends JInternalFrame {
	private JPasswordField oldPass;
	private JPasswordField newPass2;
	private JPasswordField newPass1;
	
	public GengGaiMiMa() {
		super();
		setIconifiable(true);
		setTitle("��������");
		setClosable(true);
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 300, 230);
		
		final JLabel label_1 = new JLabel();
		label_1.setFont(new Font("", Font.PLAIN, 14));
		label_1.setText("�� �� �� :");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridx = 3;
		gridBagConstraints_2.gridy = 0;
		getContentPane().add(label_1, gridBagConstraints_2);
		
		oldPass = new JPasswordField();
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.weighty = 1.0;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_3.gridwidth = 3;
		gridBagConstraints_3.gridx = 1;
		gridBagConstraints_3.gridy = 3;
		getContentPane().add(oldPass, gridBagConstraints_3);
		
		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("", Font.PLAIN, 14));
		label_2.setText("�� �� ��:");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy = 4;
		gridBagConstraints_4.gridx = 0;
		getContentPane().add(label_2, gridBagConstraints_4);
		
		newPass1 = new JPasswordField();
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.weighty = 1.0;
		gridBagConstraints_5.ipadx = 30;
		gridBagConstraints_5.insets = new Insets(0, 0, 0,10);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.gridwidth = 3;
		gridBagConstraints_5.gridy = 4;
		gridBagConstraints_5.gridx = 1;
		getContentPane().add(newPass1, gridBagConstraints_5);
		
		final JLabel label_3 = new JLabel();
		label_3.setFont(new Font("", Font.PLAIN, 14));
		label_3.setText("ȷ��������:");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy = 5;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(label_3, gridBagConstraints_6);
		
		newPass2 = new JPasswordField();
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.weighty = 1.0;
		gridBagConstraints_7.ipadx = 30;
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_7.weightx = 1.0;
		gridBagConstraints_7.gridwidth = 3;
		gridBagConstraints_7.gridy = 5;
		gridBagConstraints_7.gridx = 1;
		getContentPane().add(newPass2, gridBagConstraints_7);
		
		final JButton button = new JButton("ȷ��");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent arg0) {
				// TODO Auto-generated method stub
				String newPass1Str = newPass1.getText();
				String newPass2Str = newPass2.getText();
				if(newPass1.equals(newPass2Str)) {
					String oldPassStr = oldPass.getText();
					int res = Dao.modifyPassword(oldPassStr, newPass1Str);
					if(res <= 0) {
						String failed = "��������ʧ�ܣ�����������Ƿ���ȷ��";
						JOptionPane.showMessageDialog(getContentPane(), failed);
						return;
					}
					JOptionPane.showMessageDialog(getContentPane(), "�޸�����ɹ���");
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "������������벻һ����");
				}
			}
			
		});
		
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.weighty = 1.0;
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 6;
		gridBagConstraints_8.gridx = 1;
		getContentPane().add(button, gridBagConstraints_8);
		
		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent arg0) {
				// TODO Auto-generated method stub
				oldPass.setText(null);
				newPass1.setText(null);
				newPass2.setText(null);
			}
			
		});
		
		button_1.setText("����");
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridwidth = 2;
		gridBagConstraints_9.weighty = 1.0;
		gridBagConstraints_9.gridy = 6;
		gridBagConstraints_9.gridx = 2;
		getContentPane().add(button_1, gridBagConstraints_9);
	}

}
