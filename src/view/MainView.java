package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MainView {

	private JFrame frame;									//主窗体
	private My_JList list;									//股票信息列表
	private JLabel daoJLabel = new JLabel("股票信息",JLabel.CENTER);				//右侧布局信息（暂用，将来换成数据化图片）
	private String[] string = { "股票1", "股票2", "股票3", "股票4", "股票5", "股票6" };		//JList列表内容
	private JPanel panel_L;					//左画布
	private JPanel panel_R; 				//右画布
	private JTextField serarchText;			//文本编辑框
	private JButton searchButton;			//搜索按钮
	private JSplitPane jSplitPane;			//分割画布的类
	private ScrollPane scrollPane;			//可滑动画布	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//赋值各个组件
		serarchText = new JTextField();
		searchButton = new JButton("搜索");
		frame = new JFrame();
		list = new My_JList(string);				//创建List
		panel_L = new JPanel();				//左边画布
	    panel_R = new JPanel();				//右边画布	
	    scrollPane = new ScrollPane();			//创建一个滑动画布并加入到外层画布上	
		jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, panel_L, panel_R); 			// 这里第一个参数是控制分割线竖
		
		
		//设置各个组件
		panel_R.setLayout(new BorderLayout());
		panel_L.setLayout(null);
		jSplitPane.setDividerLocation(220); 				// 分割线的位置 也就是初始位置
		jSplitPane.setOneTouchExpandable(false);			 // 是否可展开或收起，在这里没用
		jSplitPane.setDividerSize(2);						// 设置分割线的宽度 像素为单位！	
		scrollPane.setBounds(15, 75, 200, 600);
		scrollPane.setBackground(Color.white);
		daoJLabel.setSize(200,200);
		daoJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		serarchText.setFont(new Font("微软雅黑", Font.BOLD, 16));
		searchButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		serarchText.setBounds(17, 15, 120, 44);
		searchButton.setBounds(145,15, 66, 44);
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//设置关闭
		frame.setVisible(true);

	
		
		//添加各种组件
		scrollPane.add(list);
		panel_L.add(serarchText);
		panel_L.add(searchButton);
		panel_L.add(scrollPane);
		panel_R.add(daoJLabel,BorderLayout.CENTER);			
		frame.getContentPane().add(jSplitPane);           // 加入到面板中就好了 
		

		//设置点击事件
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				do_list_valueChanged(e);
			}
		});
		searchButton.addActionListener(new ActionListener() {
			String resStr = null;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(serarchText.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"股票名为空,请重新输入");
				}else {
					 resStr = serach(string,serarchText.getText());
						if (resStr == null) {
							JOptionPane.showMessageDialog(null,"找不到该股票信息");
						}
						else {
							 daoJLabel.setText(resStr);
						}
					
				}

			}
		});
	}
	
	//点击列表时触发事件
	protected void do_list_valueChanged(ListSelectionEvent e) {
		         daoJLabel.setText(list.getSelectedValue());
		     }
	
	//搜索方法
	protected String serach(String [] content,String str) {
		for(String str1 : content) {
			if(str1.equals(str)){
				return str1;
			}
		}
		return null;
	}

}
