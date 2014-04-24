import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class replenishDrug extends JFrame {
	
	Warehouse w;
	private JTextField txtName;
	private JTextField txtQuantity;
	private JTextField txtBoxes;
	
	public replenishDrug(Warehouse w1) {
		w = w1;
		
		setTitle("Replenish Drug");
		setSize(600, 600);
		getContentPane().setBackground(new Color(34, 139, 34));
		getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(40, 32, 114, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity (0 default)");
		txtQuantity.setBounds(233, 32, 154, 19);
		getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtBoxes = new JTextField();
		txtBoxes.setText("Boxes");
		txtBoxes.setBounds(40, 72, 114, 19);
		getContentPane().add(txtBoxes);
		txtBoxes.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = txtName.getText();
				int quantity = Integer.parseInt(txtQuantity.getText());
				int boxes = Integer.parseInt(txtBoxes.getText());
				
				w.fillDrug(n, quantity, boxes);
				
				//close the window
				setVisible(false);
				dispose();
			}
		});
		btnOk.setBackground(new Color(100, 149, 237));
		btnOk.setBounds(138, 154, 117, 60);
		getContentPane().add(btnOk);
		
		setVisible(true);
		
	}
	
}
