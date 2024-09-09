package ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class listPhim_DangChieu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public listPhim_DangChieu() {
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setBackground(new Color(255, 255, 255));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblNewLabel = new JLabel("Form 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
	}

}
