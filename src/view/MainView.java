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

	private JFrame frame;									//������
	private My_JList list;									//��Ʊ��Ϣ�б�
	private JLabel daoJLabel = new JLabel("��Ʊ��Ϣ",JLabel.CENTER);				//�Ҳ಼����Ϣ�����ã������������ݻ�ͼƬ��
	private String[] string = { "��Ʊ1", "��Ʊ2", "��Ʊ3", "��Ʊ4", "��Ʊ5", "��Ʊ6" };		//JList�б�����
	private JPanel panel_L;					//�󻭲�
	private JPanel panel_R; 				//�һ���
	private JTextField serarchText;			//�ı��༭��
	private JButton searchButton;			//������ť
	private JSplitPane jSplitPane;			//�ָ������
	private ScrollPane scrollPane;			//�ɻ�������	
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
		//��ֵ�������
		serarchText = new JTextField();
		searchButton = new JButton("����");
		frame = new JFrame();
		list = new My_JList(string);				//����List
		panel_L = new JPanel();				//��߻���
	    panel_R = new JPanel();				//�ұ߻���	
	    scrollPane = new ScrollPane();			//����һ���������������뵽��㻭����	
		jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, panel_L, panel_R); 			// �����һ�������ǿ��Ʒָ�����
		
		
		//���ø������
		panel_R.setLayout(new BorderLayout());
		panel_L.setLayout(null);
		jSplitPane.setDividerLocation(220); 				// �ָ��ߵ�λ�� Ҳ���ǳ�ʼλ��
		jSplitPane.setOneTouchExpandable(false);			 // �Ƿ��չ��������������û��
		jSplitPane.setDividerSize(2);						// ���÷ָ��ߵĿ�� ����Ϊ��λ��	
		scrollPane.setBounds(15, 75, 200, 600);
		scrollPane.setBackground(Color.white);
		daoJLabel.setSize(200,200);
		daoJLabel.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		serarchText.setFont(new Font("΢���ź�", Font.BOLD, 16));
		searchButton.setFont(new Font("΢���ź�", Font.BOLD, 16));
		serarchText.setBounds(17, 15, 120, 44);
		searchButton.setBounds(145,15, 66, 44);
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//���ùر�
		frame.setVisible(true);

	
		
		//��Ӹ������
		scrollPane.add(list);
		panel_L.add(serarchText);
		panel_L.add(searchButton);
		panel_L.add(scrollPane);
		panel_R.add(daoJLabel,BorderLayout.CENTER);			
		frame.getContentPane().add(jSplitPane);           // ���뵽����оͺ��� 
		

		//���õ���¼�
		
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
				JOptionPane.showMessageDialog(null,"��Ʊ��Ϊ��,����������");
				}else {
					 resStr = serach(string,serarchText.getText());
						if (resStr == null) {
							JOptionPane.showMessageDialog(null,"�Ҳ����ù�Ʊ��Ϣ");
						}
						else {
							 daoJLabel.setText(resStr);
						}
					
				}

			}
		});
	}
	
	//����б�ʱ�����¼�
	protected void do_list_valueChanged(ListSelectionEvent e) {
		         daoJLabel.setText(list.getSelectedValue());
		     }
	
	//��������
	protected String serach(String [] content,String str) {
		for(String str1 : content) {
			if(str1.equals(str)){
				return str1;
			}
		}
		return null;
	}

}
