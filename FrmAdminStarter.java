package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.control.*;
import cn.edu.zucc.freshos.model.BeanAdmin;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class FrmAdminStarter extends JFrame {
	
	private JPanel contentPane;
	private JTextField adminId;
	private JPasswordField adminPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminStarter frame = new FrmAdminStarter();
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
	public FrmAdminStarter() {
		setTitle("管理员登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		adminId = new JTextField();
		adminId.setBounds(150, 33, 200, 26);
		contentPane.add(adminId);
		adminId.setColumns(10);
		
		adminPwd = new JPasswordField();
		adminPwd.setBounds(150, 96, 200, 26);
		contentPane.add(adminPwd);
		
		JLabel ID = new JLabel("\u8D26\u53F7");
		ID.setFont(new Font("宋体", Font.PLAIN, 25));
		ID.setBounds(90, 30, 55, 30);
		contentPane.add(ID);
		
		JLabel PWD = new JLabel("\u5BC6\u7801");
		PWD.setFont(new Font("宋体", Font.PLAIN, 25));
		PWD.setBounds(90, 90, 55, 30);
		contentPane.add(PWD);
		
		JButton Login = new JButton("登录");
		Login.setFont(new Font("宋体", Font.PLAIN, 20));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Login) {
					String adminid=adminId.getText();
					String pwd=new String(adminPwd.getPassword());
					try {
						BeanAdmin.currentLoginAdmin= FreshUtil.adminManager.login(adminid, pwd);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					new FrmAdminSystem();
					setVisible(false);
				}
			}
		});
		Login.setBounds(90, 160, 113, 40);
		contentPane.add(Login);
		
		JButton  LastStep= new JButton("\u9000\u51FA");
		LastStep.setFont(new Font("宋体", Font.PLAIN, 20));
		LastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == LastStep) {
					new FrmFreshStarter();
					setVisible(false);
				}
			}
		});
		LastStep.setBounds(252, 160, 113, 40);
		contentPane.add(LastStep);
		
		this.setVisible(true);
	}
}
