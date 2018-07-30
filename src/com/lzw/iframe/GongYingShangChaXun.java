package com.lzw.iframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbGysinfo;

public class GongYingShangChaXun extends JInternalFrame	{
	private JTable table;
	private JTextField conditionContent;
	private JComboBox conditionOperation;
	private JComboBox conditionName;
	
	public GongYingShangChaXun() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("��Ӧ����Ϣ��ѯ");
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 609, 375);
		
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[] {"��Ӧ��ID", "��Ӧ��ȫ��", "���", "��������", "��ַ", "�绰", "����", "��ϵ��", "��ϵ�˵绰", "��������",
				"��������" };
		dftm.setColumnIdentifiers(tableHeads);
		final JScrollPane scrollPane = new JScrollPane(table);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 0, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		setupComponet(new JLabel("ѡ���ѯ����:"), 0, 0, 1, 1, false);
		conditionName = new JComboBox();
		conditionName.setModel(new DefaultComboBoxModel(new String[] {"��Ӧ��ȫ��", "���"}));
		setupComponet(conditionName, 1, 0, 1, 30, true);
		conditionOperation = new JComboBox();
		conditionOperation.setModel(new DefaultComboBoxModel(new String[] { "����", "����" }));
		setupComponet(conditionOperation, 2, 0, 1, 30, true);
		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);
		final JButton queryButton = new JButton();
		queryButton.addActionListener(new queryAction(dftm));
		setupComponet(queryButton,4, 0, 1, 1, false);
		queryButton.setText("��ѯ");
		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				conditionContent.setText("");
				List list = Dao.getGysInfos();
				updateTable(list, dftm);
			}
			
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("��ʾȫ������");
	}

	private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		// TODO Auto-generated method stub
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		if(gridwidth > 1) 
			gridBagConstraints.gridwidth = gridwidth;
		if(ipadx > 0)
			gridBagConstraints.ipadx = ipadx;
		gridBagConstraints.insets = new Insets(5, 1, 3, 1);
		if(fill)
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstraints);
	}
	
	private final class queryAction implements ActionListener {
		private final DefaultTableModel dftm;
		
		public queryAction(DefaultTableModel dftm) {
			// TODO Auto-generated method stub
			this.dftm = dftm;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String conName, conOperation, content;
			List list = null;
			conName = conditionName.getSelectedItem().toString().trim();
			conOperation = conditionOperation.getSelectedItem().toString().trim();
			content = conditionContent.getText().trim();
			String sql = "select * from tb_gysInfo where ";
			if(conName.equals("��Ӧ��ȫ��")) {
				if(conOperation.endsWith("����")) {
					list = Dao.findForList(sql + "name='" + content + "'"); 
				}
				else {
					list = Dao.findForList(sql + "name like '%" + content + "%'");
				}
			}
			else {
				if(conOperation.endsWith("����")) {
					list = Dao.findForList(sql + "jc='" + content + "'");
				}
				else {
					list = Dao.findForList(sql + "jc like '%" + content + "%'");
				}
			}
			updateTable(list, dftm);
		}
		
		
	}
	private void updateTable(List list, final DefaultTableModel dftm) {
		// TODO Auto-generated method stub
		int num = dftm.getRowCount();
		for(int i = 0; i < num; i++) {
			dftm.removeRow(0);
		}
		Iterator iterator = list.iterator();
		TbGysinfo gysInfo;
		while(iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			gysInfo = Dao.getGysInfo(item);
			Vector rowData = new Vector();
			rowData.add(gysInfo.getId());// ��Ӧ�̱��
			rowData.add(gysInfo.getName());// ��Ӧ������
			rowData.add(gysInfo.getJc());// ��Ӧ�̼��
			rowData.add(gysInfo.getBianma());// ��������
			rowData.add(gysInfo.getAddress());// ��Ӧ�̵�ַ
			rowData.add(gysInfo.getTel());// �绰
			rowData.add(gysInfo.getFax());// ����
			rowData.add(gysInfo.getLian());// ��ϵ��
			rowData.add(gysInfo.getLtel());// ��ϵ�绰
			rowData.add(gysInfo.getYh());// ��������
			rowData.add(gysInfo.getMail());// ��������
			dftm.addRow(rowData);// �����������������ݣ���Ӧ����Ϣ��
		}
	}

}
