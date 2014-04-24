import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EraseDrug extends JFrame {
	Warehouse w;
	private JTextField txtName;
	public EraseDrug(Warehouse w1) {
		
		w = w1;
		
		setTitle("AddDrug");
		setSize(600, 600);
		getContentPane().setBackground(new Color(34, 139, 34));
		getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(116, 36, 114, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = txtName.getText();
				w.erase(n);
				
				//close the window
				setVisible(false);
				dispose();
			}
		});
		btnOk.setBackground(new Color(100, 149, 237));
		btnOk.setBounds(116, 79, 117, 25);
		getContentPane().add(btnOk);
		
		setVisible(true);
	}

}
