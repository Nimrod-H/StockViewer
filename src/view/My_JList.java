package view;

import java.awt.ScrollPane;

import javax.swing.JList;

public class My_JList extends JList<String>{
	public My_JList(String[] string) {
		super(string);
		setOpaque(false);
		setCellRenderer(new My_ListCellRenderer());
	}
}
