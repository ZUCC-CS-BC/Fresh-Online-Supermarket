package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmUserRegister extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField username;
	private JTextField usergender;
	private JTextField phone;
	private JTextField email;
	private JTextField city;
	private JPasswordField userpwd;
	private JPasswordField userrepwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserRegister frame = new FrmUserRegister();
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
	public FrmUserRegister() {
		setVisible(true);
		
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 449, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ID = new JLabel("\u8D26  \u53F7");
		ID.setFont(new Font("宋体", Font.PLAIN, 25));
		ID.setBounds(80, 30, 100, 30);
		contentPane.add(ID);
		
		JLabel NAME = new JLabel("\u59D3  \u540D");
		NAME.setFont(new Font("宋体", Font.PLAIN, 25));
		NAME.setBounds(80, 80, 100, 30);
		contentPane.add(NAME);
		
		JLabel SEX = new JLabel("\u6027  \u522B");
		SEX.setFont(new Font("宋体", Font.PLAIN, 25));
		SEX.setBounds(80, 130, 100, 30);
		contentPane.add(SEX);
		
		JLabel PWD = new JLabel("\u5BC6  \u7801");
		PWD.setFont(new Font("宋体", Font.PLAIN, 25));
		PWD.setBounds(80, 180, 100, 30);
		contentPane.add(PWD);
		
		JLabel REPWD = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		REPWD.setFont(new Font("宋体", Font.PLAIN, 25));
		REPWD.setBounds(80, 230, 100, 30);
		contentPane.add(REPWD);
		
		JLabel PHONE = new JLabel("\u624B  \u673A");
		PHONE.setFont(new Font("宋体", Font.PLAIN, 25));
		PHONE.setBounds(80, 280, 100, 30);
		contentPane.add(PHONE);
		
		JLabel EMAIL = new JLabel("\u90AE\u7BB1");
		EMAIL.setFont(new Font("宋体", Font.PLAIN, 25));
		EMAIL.setBounds(80, 330, 100, 30);
		contentPane.add(EMAIL);
		
		JLabel CITY = new JLabel("\u6240\u5728\u57CE\u5E02");
		CITY.setFont(new Font("宋体", Font.PLAIN, 25));
		CITY.setBounds(80, 380, 100, 30);
		contentPane.add(CITY);
		
		userid = new JTextField();
		userid.setBounds(190, 30, 150, 26);
		contentPane.add(userid);
		userid.setColumns(10);
		
		username = new JTextField();
		username.setBounds(190, 80, 150, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		usergender = new JTextField();
		usergender.setBounds(190, 130, 150, 26);
		contentPane.add(usergender);
		usergender.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(190, 280, 150, 26);
		contentPane.add(phone);
		phone.setColumns(10);
		
		email = new JTextField();
		email.setBounds(190, 330, 150, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		city = new JTextField();
		city.setBounds(190, 380, 150, 26);
		contentPane.add(city);
		city.setColumns(10);
		
		userpwd = new JPasswordField();
		userpwd.setBounds(190, 180, 150, 26);
		contentPane.add(userpwd);
		
		userrepwd = new JPasswordField();
		userrepwd.setBounds(190, 230, 150, 26);
		contentPane.add(userrepwd);
		
		JButton Register = new JButton("\u5B8C\u6210\u6CE8\u518C");
		Register.setFont(new Font("宋体", Font.PLAIN, 20));
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==Register){
					String uId=userid.getText();
					String uNmae=username.getText();
					String uSex=usergender.getText();
					String uPhone=phone.getText();
					String uEmail=email.getText();
					String uCity=city.getText();
					String pwd1=new String(userpwd.getPassword());
					String pwd2=new String(userrepwd.getPassword());
					try {
						UserInformation user=FreshUtil.userManager.reg(uId,uNmae,uSex,pwd1,pwd2,uPhone,uEmail,uCity);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					new FrmUserStarter();
					setVisible(false);
				}
			}
		});
		Register.setBounds(90, 450, 120, 30);
		contentPane.add(Register);
		
		JButton  LastStep= new JButton("\u4E0A\u4E00\u6B65");
		LastStep.setFont(new Font("宋体", Font.PLAIN, 20));
		LastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == LastStep) {
					new FrmUserStarter();
					setVisible(false);
				}
			}
		});
		LastStep.setBounds(250, 450, 120, 30);
		contentPane.add(LastStep);
		
		this.setVisible(true);
	}
}
