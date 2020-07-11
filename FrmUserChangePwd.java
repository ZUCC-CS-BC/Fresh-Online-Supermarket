package cn.edu.zucc.freshos.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmUserChangePwd extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserChangePwd frame = new FrmUserChangePwd();
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
	public FrmUserChangePwd() {
		
		setVisible(true);
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u539F\u59CB\u5BC6\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 30, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(80, 70, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(80, 110, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 30, 180, 30);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(200, 70, 180, 30);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(200, 110, 180, 30);
		contentPane.add(passwordField_2);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					try {
						FreshUtil.userManager.changePwd(UserInformation.currentLoginUser,new String(passwordField.getPassword()),new String(passwordField_1.getPassword()),new String(passwordField_2.getPassword()));
						setVisible(false);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
			}
		});
		btnNewButton.setBounds(90, 165, 120, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(234, 165, 120, 40);
		contentPane.add(btnNewButton_1);
		
	}
}
