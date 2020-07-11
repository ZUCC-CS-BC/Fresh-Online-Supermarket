package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.model.BeanAddress;
import cn.edu.zucc.freshos.model.ProductInformation;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmAddAddress extends JFrame {
	
	public UserInformation user;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddAddress frame = new FrmAddAddress();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAddAddress() {
		setVisible(true);
		
		setTitle("\u65B0\u589E\u6536\u8D27\u5730\u5740");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("地址编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 30, 110, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5728\u7701");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(80, 80, 110, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5728\u5E02");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(80, 130, 110, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5728\u533A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(80, 180, 110, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("详细地址");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(80, 230, 110, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6536\u8D27\u4EBA");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(80, 280, 110, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("联系方式");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(80, 330, 110, 30);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(200, 30, 180, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 80, 180, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 130, 180, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 180, 180, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 230, 180, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(200, 280, 180, 30);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(200, 330, 180, 30);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					String aID=textField.getText();
					String province=textField_1.getText();
					String city=textField_2.getText();
					String area=textField_3.getText();
					String addre=textField_4.getText();
					String uName=textField_5.getText();
					String phone=textField_6.getText();
					try {
						BeanAddress address2=FreshUtil.addressManager.addAddress(aID,user,province, city, area, addre, uName, phone);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(110, 390, 110, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(260, 390, 110, 40);
		contentPane.add(btnNewButton_1);
	}
}
