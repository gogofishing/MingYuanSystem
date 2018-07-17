package com.lzw.iframe;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.gysGuanLi.*;

public class GysGuanLi extends JInternalFrame {
	
	public GysGuanLi() {
		setIconifiable(true);
		setClosable(true);
		setTitle("��Ӧ�̹���");
		JTabbedPane tabPane = new JTabbedPane();
		final GysXiuGaiPanel  spxgPanel = new GysXiuGaiPanel();
		final GysTianJiaPanel sptjPanel = new GysTianJiaPanel();
		tabPane.addTab("��Ӧ����Ϣ���", null, sptjPanel,"��Ӧ�����");
		tabPane.addTab("��Ӧ����Ϣ�޸���ɾ��", null, spxgPanel, "�޸���ɾ��");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				spxgPanel.initComboBox();
			}
			
		});
		pack();
		setVisible(true);
	}

}
