package cn.edu.zucc.freshos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.freshos.FreshUtil;
import cn.edu.zucc.freshos.control.CategoryManager;
import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.model.ProductInformation;
import cn.edu.zucc.freshos.ui.FrmAddAdmin;
import cn.edu.zucc.freshos.ui.FrmFreshStarter;
import cn.edu.zucc.freshos.util.BaseException;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class FrmAdminSystem extends JFrame {

	private JPanel contentPane;
	
	private Object tblPlanTitle[]=FreshCategory.tableTitles;
	private Object tblPlanData[][];
	DefaultTableModel tabPlanModel=new DefaultTableModel();
	private JTable dataTablePlan=new JTable(tabPlanModel);
	
	
	private Object tblStepTitle[]=ProductInformation.tblStepTitle;
	private Object tblStepData[][];
	DefaultTableModel tabStepModel=new DefaultTableModel();
	private JTable dataTableStep=new JTable(tabStepModel);
	
	private FreshCategory curPlan=null;
	List<FreshCategory> allPlan=null;
	List<ProductInformation> planSteps=null;
	
	private void reloadPlanTable(){//这是测试数据，需要用实际数替换
		try {
			allPlan=FreshUtil.kindManager.loadAll();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblPlanData =  new Object[allPlan.size()][FreshCategory.tableTitles.length];
		for(int i=0;i<allPlan.size();i++){
			for(int j=0;j<FreshCategory.tableTitles.length;j++)
				tblPlanData[i][j]=allPlan.get(i).getCell(j);
		}
		tabPlanModel.setDataVector(tblPlanData,tblPlanTitle);
		this.dataTablePlan.validate();
		this.dataTablePlan.repaint();
	}
	private void reloadPlanStepTabel(int planIdx){
		if(planIdx<0) return;
		curPlan=allPlan.get(planIdx);
		try {
			planSteps=FreshUtil.productManager.loadProducts(curPlan);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblStepData =new Object[planSteps.size()][ProductInformation.tblStepTitle.length];
		for(int i=0;i<planSteps.size();i++){
			for(int j=0;j<ProductInformation.tblStepTitle.length;j++)
				tblStepData[i][j]=planSteps.get(i).getCell(j);
		}
		
		tabStepModel.setDataVector(tblStepData,tblStepTitle);
		this.dataTableStep.validate();
		this.dataTableStep.repaint();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminSystem frame = new FrmAdminSystem();
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
	public FrmAdminSystem() {
		
		setVisible(true);
		setTitle("管理员系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 750);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JMenu mnNewMenu2 = new JMenu("生鲜类别管理");
		menuBar.add(mnNewMenu2);
		
//		JMenuItem mntmNewMenuItem2_0 = new JMenuItem("查询类别");
//		mnNewMenu2.add(mntmNewMenuItem2_0);
		
		JMenuItem mntmNewMenuItem2_1 = new JMenuItem("新增类别");
		mnNewMenu2.add(mntmNewMenuItem2_1);
		
		JMenuItem mntmNewMenuItem2_2 = new JMenuItem("删除类别");
		mnNewMenu2.add(mntmNewMenuItem2_2);
		
		JMenuItem mntmNewMenuItem2_3 = new JMenuItem("修改类别");
		mnNewMenu2.add(mntmNewMenuItem2_3);
		
		mntmNewMenuItem2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mntmNewMenuItem2_1) {
					FrmAddFreshKind dlg=new FrmAddFreshKind();
					dlg.setVisible(true);
				}
			}
		});
		mntmNewMenuItem2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mntmNewMenuItem2_2) {
					if(curPlan==null) {
						JOptionPane.showMessageDialog(null, "请选择类别", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						FreshUtil.kindManager.deleteKind(curPlan);
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
			
			JMenu mnNewMenu3 = new JMenu("商品管理");
			menuBar.add(mnNewMenu3);
			
//		JMenuItem mntmNewMenuItem3_0 = new JMenuItem("查询商品");
//		mnNewMenu3.add(mntmNewMenuItem3_0);
			
			JMenuItem mntmNewMenuItem3_1 = new JMenuItem("新增商品");
			mnNewMenu3.add(mntmNewMenuItem3_1);
			
			JMenuItem mntmNewMenuItem3_2 = new JMenuItem("删除商品");
			mnNewMenu3.add(mntmNewMenuItem3_2);
			
			JMenuItem mntmNewMenuItem3_3 = new JMenuItem("修改商品");
			mnNewMenu3.add(mntmNewMenuItem3_3);
			
			mntmNewMenuItem3_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == mntmNewMenuItem3_1) {
						FrmAddProduct dlg=new FrmAddProduct();
						dlg.kind=curPlan;
						dlg.setVisible(true);
					}
				}
			});
			mntmNewMenuItem3_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == mntmNewMenuItem3_2) {
						int i=FrmAdminSystem.this.dataTableStep.getSelectedRow();
						if(i<0) {
							JOptionPane.showMessageDialog(null, "请选择商品", "错误",JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							FreshUtil.productManager.deleteProduct(planSteps.get(i));
						} catch (BaseException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
			});
		
			
			JMenu mnNewMenu_5 = new JMenu("优惠券管理");
			menuBar.add(mnNewMenu_5);
			
			JMenuItem mntmNewMenuItem_12 = new JMenuItem("查询优惠券");
			mnNewMenu_5.add(mntmNewMenuItem_12);
			
			JMenuItem mntmNewMenuItem_13 = new JMenuItem("新增优惠券");
			mnNewMenu_5.add(mntmNewMenuItem_13);
			
			JMenuItem mntmNewMenuItem_14 = new JMenuItem("修改优惠券");
			mnNewMenu_5.add(mntmNewMenuItem_14);
			
			JMenuItem mntmNewMenuItem_18 = new JMenuItem("删除优惠券");
			mnNewMenu_5.add(mntmNewMenuItem_18);
		
		
		JMenu mnNewMenu4 = new JMenu("菜谱管理");
		menuBar.add(mnNewMenu4);
		
		JMenuItem mntmNewMenuItem4_0 = new JMenuItem("查询菜谱");
		mnNewMenu4.add(mntmNewMenuItem4_0);
		
		JMenuItem mntmNewMenuItem4_1 = new JMenuItem("新增菜谱");
		mnNewMenu4.add(mntmNewMenuItem4_1);
		
		JMenuItem mntmNewMenuItem4_2 = new JMenuItem("删除菜谱");
		mnNewMenu4.add(mntmNewMenuItem4_2);
		
		JMenuItem mntmNewMenuItem4_3 = new JMenuItem("修改菜谱");
		mnNewMenu4.add(mntmNewMenuItem4_3);
		
		
		JMenu mnNewMenu5 = new JMenu("\u6EE1\u6298\u7BA1\u7406");
		menuBar.add(mnNewMenu5);
		
		JMenuItem mntmNewMenuItem5_0 = new JMenuItem("查询满减");
		mnNewMenu5.add(mntmNewMenuItem5_0);
		
		JMenuItem mntmNewMenuItem5_1 = new JMenuItem("新增满减");
		mnNewMenu5.add(mntmNewMenuItem5_1);
		
		JMenuItem mntmNewMenuItem5_2 = new JMenuItem("删除满减");
		mnNewMenu5.add(mntmNewMenuItem5_2);
		
		JMenuItem mntmNewMenuItem5_3 = new JMenuItem("修改满减");
		mnNewMenu5.add(mntmNewMenuItem5_3);
		
		JMenu mnNewMenu1 = new JMenu("用户管理");
		menuBar.add(mnNewMenu1);
		
		JMenuItem mntmNewMenuItem1_0 = new JMenuItem("查询用户");
		mnNewMenu1.add(mntmNewMenuItem1_0);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u8BC4\u4EF7");
		mnNewMenu1.add(mntmNewMenuItem);
		
		
		JMenu mnNewMenu0 = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		menuBar.add(mnNewMenu0);
		
		JMenuItem mntmNewMenuItem0_0 = new JMenuItem("查询员工");
		mnNewMenu0.add(mntmNewMenuItem0_0);
		
		JMenuItem mntmNewMenuItem0_1 = new JMenuItem("新增员工");
		mnNewMenu0.add(mntmNewMenuItem0_1);
		
		JMenuItem mntmNewMenuItem0_2 = new JMenuItem("删除员工");
		mnNewMenu0.add(mntmNewMenuItem0_2);
		
		mntmNewMenuItem0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mntmNewMenuItem0_1) {
					FrmAddAdmin dlg=new FrmAddAdmin();
					dlg.setVisible(true);
				}
			}
		});
		
		
		this.getContentPane().add(new JScrollPane(this.dataTablePlan), BorderLayout.WEST);
	    this.dataTablePlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmAdminSystem.this.dataTablePlan.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmAdminSystem.this.reloadPlanStepTabel(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableStep), BorderLayout.CENTER);
	    
	    this.reloadPlanTable();
		
	}
}
