package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.model.BeanAdmin;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class FrmUserStarter extends JFrame {

	private JPanel contentPane;
	private JTextField userId;
	private JPasswordField userPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserStarter frame = new FrmUserStarter();
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
	public FrmUserStarter() {
		setBackground(new Color(240, 240, 240));
		setTitle("ÓÃ»§µÇÂ¼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ID = new JLabel("\u7528\u6237\u540D");
		ID.setFont(new Font("ËÎÌå", Font.PLAIN, 25));
		ID.setBounds(72, 43, 98, 24);
		contentPane.add(ID);
		
		JLabel PWD = new JLabel("\u5BC6\u7801");
		PWD.setFont(new Font("ËÎÌå", Font.PLAIN, 25));
		PWD.setBounds(72, 100, 72, 25);
		contentPane.add(PWD);
		
		userId = new JTextField();
		userId.setBounds(160, 45, 190, 28);
		contentPane.add(userId);
		userId.setColumns(10);
		
		userPwd = new JPasswordField();
		userPwd.setBounds(160, 102, 190, 28);
		contentPane.add(userPwd);
		
		
		JButton btnCreat = new JButton("×¢²á");
		btnCreat.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		btnCreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnCreat) {
					new FrmUserRegister();
				}
				setVisible(false);
			}
		});
		btnCreat.setBounds(31, 189, 116, 37);
		contentPane.add(btnCreat);
		
		JButton Login = new JButton("µÇÂ¼");
		Login.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Login) {
					String userid=userId.getText();
					String pwd=new String(userPwd.getPassword());
					try {
						UserInformation.currentLoginUser= FreshUtil.userManager.login(userid, pwd);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
						return;
					}
					new FrmUserSystem();
					setVisible(false);
				}
			}
		});
		Login.setBounds(158, 189, 113, 37);
		contentPane.add(Login);
		
		JButton  LastStep= new JButton("\u9000\u51FA");
		LastStep.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		LastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == LastStep) {
					new FrmFreshStarter();
					setVisible(false);
				}
			}
		});
		LastStep.setBounds(285, 189, 113, 37);
		contentPane.add(LastStep);
		
		this.setVisible(true);
	}
}
