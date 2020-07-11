package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.model.BeanAdmin;
import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmAddFreshKind extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmAddKind frame = new FrmAddKind();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAddFreshKind() {
		setVisible(true);
		
		setTitle("新增生鲜类别");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("类别编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(60, 30, 110, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("类别名称");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(60, 80, 110, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("类别描述");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(60, 130, 110, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(180, 30, 180, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 80, 180, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 130, 180, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					String kID=textField.getText();
					String kName=textField_1.getText();
					String kDes=textField_2.getText();
					try {
						FreshCategory user=FreshUtil.kindManager.addKind(kID,kName,kDes);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					setVisible(false);
				}
				
			}
		});
		btnNewButton.setBounds(100, 185, 110, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(240, 185, 110, 40);
		contentPane.add(btnNewButton_1);
	}
}
