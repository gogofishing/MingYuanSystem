package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import com.lzw.iframe.czyGI.TJJingShouRen;
import com.lzw.iframe.czyGI.*;

public class JsrGL extends JInternalFrame {
	
	public JsrGL() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 491, 200);
		setTitle("经手人管理");
		JTabbedPane tabPane = new JTabbedPane();
		final TJJingShouRen tjPanel = new TJJingShouRen();
		final SetJSR setPanel = new SetJSR();
		tabPane.addTab("添加经手人", null, tjPanel, "添加经手人");
		tabPane.addTab("设置经手人", null, setPanel, "设置经手人");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				setPanel.initTable();
			}
			
		});
		pack();
		setVisible(true);
	}

}
