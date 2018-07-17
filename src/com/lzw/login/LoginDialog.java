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
		this.setTitle("登陆系统");
		setContentPane(getLoginPanel());
	}

	private LoginPanel getLoginPanel() {
		if (loginPanel == null) {// 登录面板中没有组件时
			jLabel1 = new JLabel();// “密码”标签
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// 设置“密码”标签的位置与宽高
			jLabel1.setText("密　码：");// 设置“密码”标签的文本内容
			jLabel = new JLabel();// “用户名”标签
			jLabel.setText("用户名：");// 设置“用户名”标签的文本内容
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// 设置“用户名”标签的位置与宽高
			loginPanel = new LoginPanel();// 登录面板
			loginPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			loginPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			loginPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			loginPanel.add(getUserField(), null);// 把“用户名”文本框置于登录面板中
			loginPanel.add(jLabel1, null);// 把“密码”标签置于登录面板中
			loginPanel.add(getPasswordField(), null);// 把“密码”文本框置于登录面板中
			loginPanel.add(getLoginButton(), null);// 把“登录”按钮置于登录面板中
			loginPanel.add(getExitButton(), null);// 把“退出”按钮置于登录面板中
		}
		return loginPanel;// 返回登录面板
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
					if (e.getKeyChar() == '\n')// 按下的按键是回车时
						loginButton.doClick();// “登录”按钮执行点击事件
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
							JOptionPane.showMessageDialog(LoginDialog.this, "用户名与密码无法登录", "登录失败", JOptionPane.ERROR_MESSAGE);
							return;
						} 
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置主窗体的关闭方式
					mainFrame.setVisible(true);// 使主窗体可见
					MainFrame.getCzyStateLabel().setText(userStr);// 设置主窗体中操作员标签的字体是
					setVisible(false);// 使登录窗体不可见
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
	 
	public String getUserStr() {// 获得“用户名”文本框中的内容
		return userStr;// 返回“用户名”文本框中的内容
	}


}
