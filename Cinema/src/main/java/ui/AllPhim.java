package ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.border.EmptyBorder;

import dao.DAO_Movie;
import enities.Movie;
import service.ScrollPaneWin11;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class AllPhim extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private DAO_Movie dao;
	private JLabel lblName;
	private JPanel panel;
	private JLabel lblImg;

	/**
	 * Create the panel.
	 */
	public AllPhim() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new ScrollPaneWin11();
		add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 4, 50, 50));
		scrollPane.setBorder(null);
		
		dao = new DAO_Movie();
		List<Movie> lst = dao.getAllMovie();
		draw(lst);	
		
	}
	
	public void draw(List<Movie> lst) {
		for(Movie movie : lst) {
			JPanel item = new JPanel();
			item.setPreferredSize(new Dimension(180, 200));
			item.setBorder(new EmptyBorder(10, 20, 10, 20));
			item.setLayout(new BorderLayout());
			item.add(lblName = new JLabel(movie.getTitle()), BorderLayout.SOUTH);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			
			if(movie.getImg() != null) {
				lblImg = new JLabel();
				lblImg.setIcon(new ImageIcon(this.getClass().getResource("/imgs/"+movie.getImg())));
				item.add(lblImg, BorderLayout.CENTER);
				lblImg.setHorizontalAlignment(SwingConstants.CENTER);
			}else {
				lblImg = new JLabel();
				lblImg.setText("Hình Ảnh");
				item.add(lblImg, BorderLayout.CENTER);
				lblImg.setHorizontalAlignment(SwingConstants.CENTER);
			}
			
			panel.add(item);
		}
	}

}
