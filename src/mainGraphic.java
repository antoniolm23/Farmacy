import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class mainGraphic extends JFrame {
	
	Warehouse w = new Warehouse();
	
	public mainGraphic() {
		
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
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(26, 231, 117, 25);
		getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBackground(new Color(100, 149, 237));
		btnLoad.setBounds(233, 231, 117, 25);
		getContentPane().add(btnLoad);
		
		JButton btnInventary = new JButton("Inventary");
		btnInventary.setBackground(new Color(100, 149, 237));
		btnInventary.setBounds(311, 41, 117, 25);
		getContentPane().add(btnInventary);
		
		JButton btnDrugtotaketoday = new JButton("DrugToTakeToday");
		btnDrugtotaketoday.setBackground(new Color(100, 149, 237));
		btnDrugtotaketoday.setBounds(27, 148, 190, 25);
		getContentPane().add(btnDrugtotaketoday);
		
		JButton btnExpiringdrugs = new JButton("ExpiringDrugs");
		btnExpiringdrugs.setBackground(new Color(100, 149, 237));
		btnExpiringdrugs.setBounds(267, 148, 190, 25);
		getContentPane().add(btnExpiringdrugs);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w.print();
			}
		});
		btnPrint.setBackground(new Color(100, 149, 237));
		btnPrint.setBounds(166, 183, 117, 25);
		getContentPane().add(btnPrint);
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		mainGraphic g = new mainGraphic();
	}
	
}
