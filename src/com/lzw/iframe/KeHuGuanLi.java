package com.lzw.iframe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.iframe.keHuGuanLi.*;

public class KeHuGuanLi extends JInternalFrame {
	public KeHuGuanLi() {
		setIconifiable(true);
		setClosable(true);
		setTitle("�ͻ���Ϣ����");
		JTabbedPane tabPane = new JTabbedPane();
		final KeHuXiuGaiPanel khxgPanel = new KeHuXiuGaiPanel();
		final KeHuTianJiaPanel khtjPanel = new KeHuTianJiaPanel();
		tabPane.addTab("�ͻ���Ϣ���", null, khtjPanel, "�ͻ����");// �ѿͻ���������ӵ�ѡ������
		tabPane.addTab("�ͻ���Ϣ�޸���ɾ��", null, khxgPanel, "�޸���ɾ��");// �ѿͻ��޸������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ��ͻ������ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initCombox();// ��ʼ���ͻ��޸�����еġ�ѡ��ͻ��������б�
			}
		});
		pack();// �ͻ������ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�ͻ������ڲ�����ɼ�
	}

}
