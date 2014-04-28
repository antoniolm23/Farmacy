import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;


public class alertMessage extends JFrame {
	public alertMessage(String name) {
		setTitle("ALERT");
		setSize(1000, 300);
		getContentPane().setBackground(Color.RED);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 34));
		lblNewLabel.setBounds(170, 72, 926, 135);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText(name);
		
		setVisible(true);
	}
}
