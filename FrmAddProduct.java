package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.control.CategoryManager;
import cn.edu.zucc.freshos.model.BeanAdmin;
import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.model.ProductInformation;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;
import java.awt.Font;

public class FrmAddProduct extends JFrame {

	public FreshCategory kind=null;
	private JPanel contentPane;
	private JTextField productid;
	private JTextField productname;
	private JTextField price;
	private JTextField vipprice;
	private JTextField number;
	private JTextField norm;
	private JTextField details;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmAddAdmin frame = new FrmAddAdmin();
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
	public FrmAddProduct() {
		setVisible(true);
		
		setTitle("新增商品");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 452, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PID = new JLabel("商品编号");
		PID.setFont(new Font("宋体", Font.PLAIN, 25));
		PID.setBounds(60, 30,110, 30);
		contentPane.add(PID);
		
		JLabel NAME = new JLabel("商品名称");
		NAME.setFont(new Font("宋体", Font.PLAIN, 25));
		NAME.setBounds(60, 80,110, 30);
		contentPane.add(NAME);
		
		JLabel PRICE = new JLabel("\u4EF7  \u683C");
		PRICE.setFont(new Font("宋体", Font.PLAIN, 25));
		PRICE.setBounds(60, 130,110, 30);
		contentPane.add(PRICE);
		
		JLabel VPRICE = new JLabel("会员价");
		VPRICE.setFont(new Font("宋体", Font.PLAIN, 25));
		VPRICE.setBounds(60, 180,110, 30);
		contentPane.add(VPRICE);
		
		JLabel NUM = new JLabel("\u6570  \u91CF");
		NUM.setFont(new Font("宋体", Font.PLAIN, 25));
		NUM.setBounds(60, 230,110, 30);
		contentPane.add(NUM);
		
		JLabel NORM = new JLabel("\u89C4  \u683C");
		NORM.setFont(new Font("宋体", Font.PLAIN, 25));
		NORM.setBounds(60, 280,110, 30);
		contentPane.add(NORM);
		
		JLabel DETAIL = new JLabel("\u8BE6  \u60C5");
		DETAIL.setFont(new Font("宋体", Font.PLAIN, 25));
		DETAIL.setBounds(60, 330, 110, 30);
		contentPane.add(DETAIL);
		
		productid = new JTextField();
		productid.setBounds(180, 30, 180, 30);
		contentPane.add(productid);
		productid.setColumns(10);
		
		productname = new JTextField();
		productname.setBounds(180, 80, 180, 30);
		contentPane.add(productname);
		productname.setColumns(10);
		
		price = new JTextField();
		price.setBounds(180, 130, 180, 30);
		contentPane.add(price);
		price.setColumns(10);
		
		vipprice = new JTextField();
		vipprice.setBounds(180, 180, 180, 30);
		contentPane.add(vipprice);
		vipprice.setColumns(10);
		
		number = new JTextField();
		number.setBounds(180, 230, 180, 30);
		contentPane.add(number);
		number.setColumns(10);
		
		norm = new JTextField();
		norm.setBounds(180, 280, 180, 30);
		contentPane.add(norm);
		norm.setColumns(10);
		
		details = new JTextField();
		details.setBounds(180, 330, 180, 30);
		contentPane.add(details);
		details.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					String pID=productid.getText();
					//String kID=kindid.getText();
					String pNAME=productname.getText();
					String Price=price.getText();
					String VPrice=vipprice.getText();
					String Number=number.getText();
					String Norm=norm.getText();
					String Details=details.getText();
					try {
						ProductInformation product=FreshUtil.productManager.addProduct(pID, kind, pNAME, Price, VPrice, Number, Norm, Details);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(80, 400, 110, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(236, 400, 110, 40);
		contentPane.add(btnNewButton_1);
		
		
	}
}
