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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmFreshChangeInfor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFreshChangeInfor frame = new FrmFreshChangeInfor();
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
	public FrmFreshChangeInfor() {
		setVisible(true);
		
		setTitle("\u4FEE\u6539\u4E2A\u4EBA\u8D44\u6599");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3  \u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(70, 30, 110, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027  \u522B");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(70, 80, 110, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u624B  \u673A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(70, 130, 110, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u90AE  \u7BB1");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(70, 180, 110, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u5728\u57CE\u5E02");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(70, 230, 110, 30);
		contentPane.add(lblNewLabel_4);
		
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 180, 180, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 230, 180, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					try {
						FreshUtil.userManager.changeInfor(UserInformation.currentLoginUser,textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
						setVisible(false);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		btnNewButton.setBounds(90, 290, 100, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(254, 290, 97, 40);
		contentPane.add(btnNewButton_1);
	}
}
