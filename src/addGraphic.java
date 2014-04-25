import javax.swing.JFrame;
import java.util.*;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class addGraphic extends JFrame {
	private JTextField txtName;
	private JTextField txtBoxquantity;
	private JTextField txtMetricpL;
	private JTextField txtTakenquantity;
	private JTextField txtDailyfrequency;
	private JTextField txtOverallfrequency;
	private JTextField txtPrescriptiontrueOr;
	
	Warehouse w;
	
	public addGraphic(Warehouse w1) {
		
		w = w1;
		
		setTitle("AddDrug");
		setSize(600, 600);
		getContentPane().setBackground(new Color(34, 139, 34));
		getContentPane().setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(12, 12, 114, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtBoxquantity = new JTextField();
		txtBoxquantity.setText("BoxQuantity");
		txtBoxquantity.setBounds(159, 12, 114, 19);
		getContentPane().add(txtBoxquantity);
		txtBoxquantity.setColumns(10);
		
		txtMetricpL = new JTextField();
		txtMetricpL.setText("Metric (p, l or g)");
		txtMetricpL.setBounds(297, 12, 114, 19);
		getContentPane().add(txtMetricpL);
		txtMetricpL.setColumns(10);
		
		txtTakenquantity = new JTextField();
		txtTakenquantity.setText("TakenQuantity");
		txtTakenquantity.setBounds(12, 54, 114, 19);
		getContentPane().add(txtTakenquantity);
		txtTakenquantity.setColumns(10);
		
		txtDailyfrequency = new JTextField();
		txtDailyfrequency.setText("DailyFrequency");
		txtDailyfrequency.setBounds(169, 54, 114, 19);
		getContentPane().add(txtDailyfrequency);
		txtDailyfrequency.setColumns(10);
		
		txtOverallfrequency = new JTextField();
		txtOverallfrequency.setText("OverallFrequency");
		txtOverallfrequency.setBounds(297, 181, 114, 19);
		getContentPane().add(txtOverallfrequency);
		txtOverallfrequency.setColumns(10);
		
		JLabel lblEvery = new JLabel("1 = every day");
		lblEvery.setBounds(287, 124, 104, 15);
		getContentPane().add(lblEvery);
		
		JLabel lblOccasionally = new JLabel("0 = occasionally");
		lblOccasionally.setBounds(277, 97, 114, 15);
		getContentPane().add(lblOccasionally);
		
		JLabel lblAlternate = new JLabel("2 = alternate days");
		lblAlternate.setBounds(288, 151, 148, 15);
		getContentPane().add(lblAlternate);
		
		txtPrescriptiontrueOr = new JTextField();
		txtPrescriptiontrueOr.setText("No Prescription (true or false)");
		txtPrescriptiontrueOr.setBounds(22, 95, 174, 19);
		getContentPane().add(txtPrescriptiontrueOr);
		txtPrescriptiontrueOr.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			//get the various fields
			public void mouseClicked(MouseEvent e) {
				String n = txtName.getText();
				int q = Integer.parseInt(txtBoxquantity.getText());
				char u = txtName.getText().charAt(0);
				float f = Float.parseFloat(txtTakenquantity.getText());
				boolean b = Boolean.parseBoolean(txtPrescriptiontrueOr.getText());
				int freq = Integer.parseInt(txtOverallfrequency.getText());
				int df = Integer.parseInt(txtDailyfrequency.getText());
				Drug d = new Drug(n, q, u, b, 0, freq, f, df);
				w.addDrug(d);
				
				//close the window
				setVisible(false);
				dispose();
			}
		});
		btnOk.setBackground(new Color(100, 149, 237));
		btnOk.setBounds(53, 161, 117, 58);
		getContentPane().add(btnOk);
		
		setVisible(true);
	}
}
