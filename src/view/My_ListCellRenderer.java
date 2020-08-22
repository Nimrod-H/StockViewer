package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
//自定义JList子项布局
public class My_ListCellRenderer implements ListCellRenderer<Object>{
	Color blue = null;
	Color white = null;
	public My_ListCellRenderer() {
		blue = Color.BLUE;
		white = Color.white;
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String string = (String)value;
		JLabel jl = new JLabel(string);
		jl.setOpaque(true);
		jl.setFont(new Font("微软雅黑",Font.PLAIN,24));
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setPreferredSize(new Dimension(195,50));
		jl.setBorder(BorderFactory.createLineBorder(Color.black));
		if(isSelected) {
			jl.setBackground(blue);
			jl.setForeground(white);
		}else {
			jl.setBackground(white);
			jl.setForeground(blue);
		}
		return jl;
	}

}
