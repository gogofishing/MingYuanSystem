package com.lzw.login;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

import com.lzw.MainFrame;
import com.lzw.dao.Dao;

public class LoginDialog extends JFrame {
	private LoginPanel loginPanel = null;
	private JLabel jLabel = null;
	private JTextField userField = null;
	private JLabel jLabel1 = null;
	private JPasswordField passwordField = null;
	private JButton loginButton = null;
	private JButton exitButton = null;
	private static String userStr;
	private MainFrame mainFrame;
//	
//	public static void main(String[] args) {
//		LoginDialog a = new LoginDialog();
//	}
//	
	public LoginDialog() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();
			initialize();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		Dimension size = getToolkit().getScreenSize();
		setLocation((size.width - 396) / 2, (size.height - 240) / 2);
		setSize(396, 240);
		this.setTitle("��½ϵͳ");
		setContentPane(getLoginPanel());
	}

	private LoginPanel getLoginPanel() {
		if (loginPanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����롱��ǩ
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// ���á����롱��ǩ��λ������
			jLabel1.setText("�ܡ��룺");// ���á����롱��ǩ���ı�����
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("�û�����");// ���á��û�������ǩ���ı�����
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// ���á��û�������ǩ��λ������
			loginPanel = new LoginPanel();// ��¼���
			loginPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			loginPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			loginPanel.add(getUserField(), null);// �ѡ��û������ı������ڵ�¼�����
			loginPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����
			loginPanel.add(getPasswordField(), null);// �ѡ����롱�ı������ڵ�¼�����
			loginPanel.add(getLoginButton(), null);// �ѡ���¼����ť���ڵ�¼�����
			loginPanel.add(getExitButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		}
		return loginPanel;// ���ص�¼���
	}
	
	private JTextField getUserField() {
		if(userField == null) {
			userField = new JTextField();
			userField.setBounds(new Rectangle(142, 39, 127, 22));
		}
		return userField;
	}
	
	private JPasswordField getPasswordField() {
		if(passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));
			passwordField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
			});
		}
		return passwordField;
	}
	
	private JButton getLoginButton() {
		if(loginButton == null) {
			loginButton = new JButton();
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));
			loginButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						// TODO Auto-generated method stub
						userStr = userField.getText();
						String passStr = new String(passwordField.getPassword());
						if (!Dao.checkLogin(userStr, passStr)) {
							JOptionPane.showMessageDialog(LoginDialog.this, "�û����������޷���¼", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
							return;
						} 
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);// ����������Ĺرշ�ʽ
					mainFrame.setVisible(true);// ʹ������ɼ�
					MainFrame.getCzyStateLabel().setText(userStr);// �����������в���Ա��ǩ��������
					setVisible(false);// ʹ��¼���岻�ɼ�
				}
				
			});
		}
		return loginButton;
	}
	
	private JButton getExitButton() {
		if(exitButton == null) {
			exitButton = new JButton();
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));
			exitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			});
		}
		return exitButton;
	}
	 
	public String getUserStr() {// ��á��û������ı����е�����
		return userStr;// ���ء��û������ı����е�����
	}


}
