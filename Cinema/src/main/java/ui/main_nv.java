package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import service.backGround_Color;
import service.changeColor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class main_nv extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, head, menu;
	private JPanel form;
	private JPanel btnPhim, btnSuatChieu;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTabbedPane tabbedPane;
	private listPhim_DangChieu listPhim_DangChieu;
	private JScrollPane scroll;
	private listAllPhim listAllPhim;
	private JLabel lblNewLabel_2;
	private JLabel logo;
	private JLabel user;
	private JLabel lbl_clock;
	private JPanel pn_clock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_nv frame = new main_nv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_nv() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(700, 500));
		
		head = new JPanel();
		head.setBorder(new EmptyBorder(0, 50, 0, 40));
		head.setBackground(backGround_Color.bg_color);
		head.setPreferredSize(new Dimension(getWidth(), 100));
		contentPane.add(head, BorderLayout.NORTH);
		head.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("CINEMA");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 80));
		head.add(lblNewLabel_2, BorderLayout.WEST);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(main_nv.class.getResource("/icon/icons8-star-100.png")));
		head.add(logo, BorderLayout.CENTER);
		
		user = new JLabel("");
		user.setIcon(new ImageIcon(main_nv.class.getResource("/icon/user-50.png")));
		head.add(user, BorderLayout.EAST);
		
		menu = new JPanel();
		menu.setBackground(backGround_Color.bg_color);
		menu.setPreferredSize(new Dimension(250, getHeight()));
		contentPane.add(menu, BorderLayout.WEST);
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		
		btnPhim = new JPanel();
		btnPhim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		btnPhim.setPreferredSize(new Dimension(getWidth(), 100));
		btnPhim.setMaximumSize(btnPhim.getPreferredSize());
		btnPhim.setBackground(backGround_Color.bg_color_deep);
		
		btnSuatChieu = new JPanel();
		btnSuatChieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor.changCorlor(btnSuatChieu, backGround_Color.bg_color_deep);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changeColor.changCorlor(btnSuatChieu, backGround_Color.bg_color);
			}
		});
		btnSuatChieu.setPreferredSize(new Dimension(getWidth(), 100));
		btnSuatChieu.setMaximumSize(btnPhim.getPreferredSize());
		btnSuatChieu.setBackground(backGround_Color.bg_color);
		
		menu.add(Box.createVerticalStrut(50));
		menu.add(btnPhim);
		btnPhim.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Phim");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnPhim.add(lblNewLabel, BorderLayout.CENTER);
		
		pn_clock = new JPanel();
		pn_clock.setBorder(new EmptyBorder(0, 0, 10, 0));
		pn_clock.setPreferredSize(new Dimension(getWidth(), getHeight()));
		pn_clock.setMaximumSize(btnPhim.getPreferredSize());
		pn_clock.setBackground(backGround_Color.bg_color);
		menu.add(Box.createVerticalStrut(50));
		menu.add(btnSuatChieu);
		menu.add(pn_clock);
		btnSuatChieu.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("Suất Chiếu");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnSuatChieu.add(lblNewLabel_1);
		pn_clock.setLayout(new BorderLayout(0, 0));
		
		
		
		lbl_clock = new JLabel("16 : 00 PM 24/12/2024");
		lbl_clock.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_clock.setForeground(Color.WHITE);
		lbl_clock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pn_clock.add(lbl_clock, BorderLayout.SOUTH);
		
		form = new JPanel();
		contentPane.add(form, BorderLayout.CENTER);
		form.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		form.add(tabbedPane);
		
		listPhim_DangChieu = new listPhim_DangChieu();
		scroll = new JScrollPane(listPhim_DangChieu);
		scroll.setBorder(null);
		tabbedPane.add("Phim Đang Chiếu",scroll);
		
		listAllPhim = new listAllPhim();
		scroll = new JScrollPane(listAllPhim);
		scroll.setBorder(null);
		tabbedPane.add("Tất Cả Phim",scroll);
	}

}
