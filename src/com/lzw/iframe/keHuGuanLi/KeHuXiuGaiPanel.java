package com.lzw.iframe.keHuGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import keyListener.InputKeyListener;

import com.lzw.Item;
import com.lzw.dao.Dao;
import com.lzw.dao.model.TbKhinfo;

public class KeHuXiuGaiPanel extends JPanel {
	
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
	private JButton modifyButton;
	private JButton delButton;
	private JComboBox kehu;
	
	public KeHuXiuGaiPanel() {
		setBounds(10, 10, 460, 300);
		setLayout(new GridBagLayout());
		setVisible(true);
		
		final JLabel khName = new JLabel("�ͻ�ȫ��:");
		setupComponent(khName, 0, 0, 1, 0, false);
		keHuQuanCheng = new JTextField();
		keHuQuanCheng.setEditable(false);
		setupComponent(keHuQuanCheng, 1, 0, 3, 350, true);
		
		final JLabel addressLable = new JLabel("�ͻ���ַ:");
		setupComponent(addressLable, 0, 1, 1, 0, false);
		diZhi = new JTextField();
		setupComponent(diZhi, 1, 1, 3, 0, true);
		
		setupComponent(new JLabel("�ͻ����:"), 0, 2, 1, 0, false);
		keHuJianCheng = new JTextField();
		setupComponent(keHuJianCheng, 1, 2, 1, 130, true);
		
		setupComponent(new JLabel("��������:"), 2, 2, 1, 0, false);
		youZhengBianMa = new JTextField();
		setupComponent(youZhengBianMa, 3, 2, 1, 100, true);
		youZhengBianMa.addKeyListener(new InputKeyListener());
		
		setupComponent(new JLabel("�绰:"), 0, 3, 1, 0, false);
		dianHua = new JTextField();
		setupComponent(dianHua, 1, 3, 1, 100, true);
		dianHua.addKeyListener(new InputKeyListener());
		
		setupComponent(new JLabel("����:"), 2, 3, 1, 0, false);
		chuanZhen = new JTextField();
		chuanZhen.addKeyListener(new InputKeyListener());
		setupComponent(chuanZhen, 3, 3, 1, 100, true);
		
		setupComponent(new JLabel("��ϵ��:"), 0, 4, 1, 0, false);
		lianXiRen = new JTextField();
		setupComponent(lianXiRen, 1, 4, 1, 100, true);
		
		setupComponent(new JLabel("��ϵ�绰:"), 2, 4, 1, 0, false);
		lianXiDianHua = new JTextField();
		setupComponent(lianXiDianHua, 3, 4, 1, 100, true);
		lianXiDianHua.addKeyListener(new InputKeyListener());
		
		setupComponent(new JLabel("E-Mail:"), 0, 5, 1, 0, false);
		EMail = new JTextField();
		setupComponent(EMail, 1, 5, 3, 350, true);
		
		setupComponent(new JLabel("��������:"), 0, 6, 1, 0, false);
		kaiHuYinHang = new JTextField();
		setupComponent(kaiHuYinHang, 1, 6, 1, 100, true);
		
		setupComponent(new JLabel("�����˻�:"), 2, 6, 1, 0, false);
		yinHangZhangHao = new JTextField();
		setupComponent(yinHangZhangHao, 3, 6, 1, 100, true);
		
		setupComponent(new JLabel("ѡ��ͻ�:"), 0, 7, 1, 0, false);
		kehu = new JComboBox();
		kehu.setPreferredSize(new Dimension(230, 21));
		initCombox();
		kehu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doKeHuSelectAction();
			}
			
		});
		setupComponent(kehu, 1, 7, 2, 0, true);
		modifyButton = new JButton("�޸�");
		delButton = new JButton("ɾ��");
		JPanel panel = new JPanel();
		panel.add(modifyButton);
		panel.add(delButton);
		setupComponent(panel, 3, 7, 1, 0, false);
		
		delButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Item item = (Item) kehu.getSelectedItem();
				if(item == null || !(item instanceof Item)) {
					return;
				}
				int comfirm = JOptionPane.showConfirmDialog(KeHuXiuGaiPanel.this, "ȷ��ɾ���ͻ���Ϣ��");
				if(comfirm == JOptionPane.YES_OPTION) {
					int rs = Dao.delete("delete tb_khinfo where id ='" + item.getId() + "'");
					if(rs > 0) {
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�ͻ���" + item.getName() + "��ɾ���ɹ�");
						kehu.removeItem(item);
					}
				}
			}
			
		});
		
		modifyButton.addActionListener(new ActionListener() {// ���޸ġ���ť�Ķ����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// ������ݱ��������
				TbKhinfo khinfo = new TbKhinfo();// �ͻ���Ϣ
				khinfo.setId(item.getId());// ���ÿͻ����
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
				if (Dao.updateKeHu(khinfo) == 1)// ���Ŀͻ���Ϣ����������1
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�޸����");// ������ʾ��
				else// ���Ŀͻ���Ϣ������������1
					JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "�޸�ʧ��");// ������ʾ��
			}
		});
	}

	private void initCombox() {
		// TODO Auto-generated method stub
		List khInfo = Dao.getKhInfos();
		List<Item> items = new ArrayList<Item>();
		kehu.removeAllItems();
		for(Iterator iter = khInfo.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if(items.contains(item))
				continue;
			items.add(item);
			kehu.addItem(item);
		}
		doKeHuSelectAction();
	}

	private void doKeHuSelectAction() {
		// TODO Auto-generated method stub
		Item selectedItem;
		if(!(kehu.getSelectedItem() instanceof Item)){
			return;
		}
		selectedItem = (Item) kehu.getSelectedItem();// ��á�ѡ��ͻ��������б��е�ѡ��
		TbKhinfo khInfo = Dao.getKhInfo(selectedItem);// �ͻ���Ϣ
		keHuQuanCheng.setText(khInfo.getKhname());// ���á��ͻ�ȫ�ơ��ı����е��ı�����
		diZhi.setText(khInfo.getAddress());// ���á���ַ���ı����е��ı�����
		keHuJianCheng.setText(khInfo.getJian());// ���á��ͻ���ơ��ı����е��ı�����
		youZhengBianMa.setText(khInfo.getBianma());// ���á��������롱�ı����е��ı�����
		dianHua.setText(khInfo.getTel());// ���á��绰���ı����е��ı�����
		chuanZhen.setText(khInfo.getFax());// ���á����桱�ı����е��ı�����
		lianXiRen.setText(khInfo.getLian());// ���á���ϵ�ˡ��ı����е��ı�����
		lianXiDianHua.setText(khInfo.getLtel());// ���á���ϵ�绰���ı����е��ı�����
		EMail.setText(khInfo.getMail());// ���á�E-Mail���ı����е��ı�����
		kaiHuYinHang.setText(khInfo.getXinhang());// ���á��������С��ı����е��ı�����
		yinHangZhangHao.setText(khInfo.getHao());// ���á������˺š��ı����е��ı�����
		
	}

	private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
		// TODO Auto-generated method stub
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if(gridwidth > 1) 
			gridBagConstrains.gridwidth = gridwidth;
		if(ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if(fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		add(component, gridBagConstrains);
	}
}
