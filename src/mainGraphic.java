import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.swing.JTextField;

public class mainGraphic extends JFrame {
	
	Warehouse w = new Warehouse();
	private JTextField textField;
	public mainGraphic() {
		
		ImageIcon icon = new ImageIcon("../img/Farmacia.png");
		setIconImage(icon.getImage());
		setTitle("Farmacy Project");
		getContentPane().setBackground(new Color(0, 128, 0));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(500, 500);
		
		JButton btnAdddrug = new JButton("AddDrug");
		btnAdddrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addGraphic ag = new addGraphic(w);
			}
		});
		btnAdddrug.setBackground(new Color(100, 149, 237));
		btnAdddrug.setBounds(26, 41, 117, 25);
		getContentPane().add(btnAdddrug);
		
		JButton btnTakedrug = new JButton("TakeDrug");
		btnTakedrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				takeDrug td = new takeDrug(w);
			}
		});
		btnTakedrug.setBackground(new Color(100, 149, 237));
		btnTakedrug.setBounds(233, 88, 117, 25);
		getContentPane().add(btnTakedrug);
		
		JButton btnErasedrug = new JButton("EraseDrug");
		btnErasedrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EraseDrug ed = new EraseDrug(w);
			}
		});
		btnErasedrug.setBackground(new Color(100, 149, 237));
		btnErasedrug.setBounds(166, 41, 117, 25);
		getContentPane().add(btnErasedrug);
		
		JButton btnReplenishdrug = new JButton("ReplenishDrug");
		btnReplenishdrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				replenishDrug rd = new replenishDrug(w);
			}
		});
		btnReplenishdrug.setBackground(new Color(100, 149, 237));
		btnReplenishdrug.setBounds(26, 88, 154, 25);
		getContentPane().add(btnReplenishdrug);
		
		textField = new JTextField();
		textField.setBounds(333, 12, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		//set the actual date
		textField.setEditable(false);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					w.writeToFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(26, 231, 117, 25);
		getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					w.readFile();
					textField.setText(w.getDay() + "-"+ w.getMonth() + "-" + w.getYear());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setBackground(new Color(100, 149, 237));
		btnLoad.setBounds(233, 231, 117, 25);
		getContentPane().add(btnLoad);
		
		JButton btnDrugtotaketoday = new JButton(" DrugToTakeToday");
		btnDrugtotaketoday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<String> ls = w.showToday();
				showWindow sw = new showWindow(ls, "Drugs to take today");
			}
		});
		btnDrugtotaketoday.setBackground(new Color(100, 149, 237));
		btnDrugtotaketoday.setBounds(27, 148, 190, 25);
		getContentPane().add(btnDrugtotaketoday);
		
		JButton btnExpiringdrugs = new JButton("ExpiringDrugs");
		btnExpiringdrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<String> ls = w.expiringDrugs();
				showWindow sw = new showWindow(ls, " Expiring Drugs");
			}
		});
		btnExpiringdrugs.setBackground(new Color(100, 149, 237));
		btnExpiringdrugs.setBounds(267, 148, 190, 25);
		getContentPane().add(btnExpiringdrugs);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<String> lp = w.print();
				showWindow sw1 = new showWindow(lp, " Drugs inventary");
			}
		});
		btnPrint.setBackground(new Color(100, 149, 237));
		btnPrint.setBounds(166, 183, 117, 25);
		getContentPane().add(btnPrint);
		
		JButton btnDay = new JButton("Day");
		btnDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w.elapsingDay();
			}
		});
		btnDay.setBackground(new Color(100, 149, 237));
		btnDay.setBounds(340, 41, 117, 25);
		getContentPane().add(btnDay);
		
		setVisible(true);
	}
	
	public Warehouse getWarehouse() {return w;}
	
	public void setDate() {
		textField.setText(w.getDay() + "-"+ w.getMonth() + "-" + w.getYear());	
	}
	
	public void load() throws FileNotFoundException {
		w.readFile();
		setDate();
	}
	
	public static void main(String args[]) {
		mainGraphic g = new mainGraphic();
		try {
			g.load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Process p = new Process();
		//p.start();
		//p.run(g.getWarehouse());
	}
}
