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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmAddAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField adminid;
	private JTextField adminname;
	private JPasswordField pwd;
	private JPasswordField repwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddAdmin frame = new FrmAddAdmin();
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
	public FrmAddAdmin() {
		setVisible(true);
		
		setTitle("\u65B0\u589E\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 480, 340);
		setAlwaysOnTop(false);//置顶
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ID = new JLabel("管理员账号");
		ID.setFont(new Font("宋体", Font.PLAIN, 25));
		ID.setBounds(60, 30, 130, 30);
		contentPane.add(ID);
		
		JLabel NAME = new JLabel("管理员姓名");
		NAME.setFont(new Font("宋体", Font.PLAIN, 25));
		NAME.setBounds(60, 80, 130, 30);
		contentPane.add(NAME);
		
		JLabel PWD = new JLabel("\u5BC6    \u7801");
		PWD.setFont(new Font("宋体", Font.PLAIN, 25));
		PWD.setBounds(60, 130, 130, 30);
		contentPane.add(PWD);
		
		JLabel REPWD = new JLabel("确认密码");
		REPWD.setFont(new Font("宋体", Font.PLAIN, 25));
		REPWD.setBounds(60, 180, 130, 30);
		contentPane.add(REPWD);
		
		adminid = new JTextField();
		adminid.setBounds(200, 30, 180, 30);
		contentPane.add(adminid);
		adminid.setColumns(10);
		
		adminname = new JTextField();
		adminname.setBounds(200, 80, 180, 30);
		contentPane.add(adminname);
		adminname.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(200, 130, 180, 30);
		contentPane.add(pwd);
		
		repwd = new JPasswordField();
		repwd.setBounds(200, 180, 180, 30);
		contentPane.add(repwd);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					String aId=adminid.getText();
					String aNmae=adminname.getText();
					String pwd1=new String(pwd.getPassword());
					String pwd2=new String(repwd.getPassword());
					try {
						BeanAdmin user=FreshUtil.adminManager.reg(aId,aNmae,pwd1,pwd2);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(110, 240, 110, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(260, 240, 110, 40);
		contentPane.add(btnNewButton_1);
	}
}
