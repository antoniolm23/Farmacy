import javax.swing.JFrame;
import javax.swing.JFrame;

import java.util.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
public class showWindow extends JFrame {
	
	public showWindow(List<String> ls, String name) {
		
		setTitle("Show" + name);
		setSize(1000, 500);
		getContentPane().setBackground(new Color(34, 139, 34));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		List<JTextField> listTF = new ArrayList<JTextField>();
		int n = ls.size();
		for(int i=0; i<n; i++) {
			listTF.add(i, new JTextField());
			listTF.get(i).setEditable(false);
			listTF.get(i).setFont(new Font("Dialog", Font.BOLD, 16));
			
			listTF.get(i).setBounds((i+1)*20, (i+1)*30, 20, 500);
			listTF.get(i).setText(ls.get(i));
			getContentPane().add(listTF.get(i));
		}
		
		setVisible(true);
		
	}
}
