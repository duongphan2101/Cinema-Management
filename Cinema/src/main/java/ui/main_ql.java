package ui;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import service.backGround_Color;
import service.clock;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class main_ql extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Menu;
	private JLabel logo;
	private JPanel btnPhim;
	private JPanel btnLogo;
	private JLabel lblNewLabel;
	private JPanel btnSuatChieu;
	private JLabel lblNewLabel_1;
	private JPanel btnNhanSu;
	private JPanel btnThongKe;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel MenuList;
	private JLabel lbl_clock;
	private Timer timer;
	private JPanel head;
	private JPanel link;
	private JPanel white_space;
	private JPanel Right;
	private JLabel lblLink;
	private JPanel content;
	private JTabbedPane tabbedPane;
	private JPanel PhimDangChieu;
	private JPanel All_Phim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_ql frame = new main_ql();
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
	public main_ql() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setMinimumSize(new Dimension(700, 500));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.setBackground(backGround_Color.bg_color);
        head = new JPanel();
		head.setPreferredSize(new Dimension(1200 - 250, 100));
		head.setLayout(new BorderLayout(0, 0));
		
		link = new JPanel();
		link.setBorder(null);
		head.add(link, BorderLayout.CENTER);
		link.setPreferredSize(new Dimension(1200 - 250, 80));
		link.setBackground(backGround_Color.bg_color_deep);
		link.setLayout(new BorderLayout(0, 0));
		
		lblLink = new JLabel("Quản Lý/Phim Đang Chiếu");
		lblLink.setForeground(new Color(255, 255, 255));
		lblLink.setFont(new Font("Tahoma", Font.PLAIN, 18));
		link.add(lblLink);
		lblLink.setBorder(new EmptyBorder(0, 30, 0, 0));
		
		
		
		white_space = new JPanel();
		white_space.setBackground(new Color(255, 255, 255));
		head.add(white_space, BorderLayout.NORTH);
		white_space.setPreferredSize(new Dimension(1200 - 250, 20));
		
		Right = new JPanel();
		Menu = new JPanel();
		
		contentPane.add(Menu);
		contentPane.add(Right);
		
		Right.setLayout(new BorderLayout());
		Right.add(head, BorderLayout.NORTH);
		
		content = new JPanel();
		Right.add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		content.add(tabbedPane);
			
		PhimDangChieu = new PhimDangChieu();
		tabbedPane.addTab("Phim Đang Chiếu", null, PhimDangChieu, null);
		
		All_Phim = new AllPhim();
		tabbedPane.addTab("Tất Cả Phim", null, All_Phim, null);
		
		tabbedPane.addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        Component selectedComponent = tabbedPane.getSelectedComponent();
		        
		        if (selectedComponent == PhimDangChieu) {
		            lblLink.setText("Quản Lý/Phim Đang Chiếu");
		        } else if (selectedComponent == All_Phim) {
		            lblLink.setText("Quản Lý/Tất Cả Phim");
		        }
		    }
		});
		
		Menu.setPreferredSize(new Dimension(250, getHeight()));
		Menu.setBackground(backGround_Color.bg_color);
		Menu.setLayout(new BorderLayout());
		Menu.setMaximumSize(new Dimension(250, this.getHeight()));
		
		btnLogo = new JPanel();
		btnLogo.setPreferredSize(new Dimension(getWidth(), 100));
		btnLogo.setMaximumSize(btnLogo.getPreferredSize());
		btnLogo.setBackground(backGround_Color.bg_color);
		btnLogo.setLayout(new BorderLayout(0, 0));
		
		logo = new JLabel("");
		logo.setPreferredSize(new Dimension(2500, 100));
		logo.setIcon(new ImageIcon(main_ql.class.getResource("/icon/user-50.png")));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnLogo.add(logo);
		
		btnPhim = new JPanel();
		btnPhim.setPreferredSize(new Dimension(getWidth(), 100));
		btnPhim.setMaximumSize(btnPhim.getPreferredSize());
		btnPhim.setBackground(backGround_Color.bg_color_deep);
		
		btnPhim.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Phim");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(main_ql.class.getResource("/icon/icons8-film-50.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		btnPhim.add(lblNewLabel, BorderLayout.CENTER);
		
		btnSuatChieu = new JPanel();
		btnSuatChieu.setPreferredSize(new Dimension(1200, 100));
		btnSuatChieu.setMaximumSize(new Dimension(1200, 100));
		btnSuatChieu.setBackground(backGround_Color.bg_color);
		
		btnSuatChieu.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("Suất Chiếu");
		lblNewLabel_1.setIcon(new ImageIcon(main_ql.class.getResource("/icon/icons8-list-50.png")));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnSuatChieu.add(lblNewLabel_1, BorderLayout.CENTER);
		
		btnNhanSu = new JPanel();
		btnNhanSu.setPreferredSize(new Dimension(1200, 100));
		btnNhanSu.setMaximumSize(new Dimension(1200, 100));
		btnNhanSu.setBackground(backGround_Color.bg_color);
		
		btnNhanSu.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("Nhân Sự");
		lblNewLabel_2.setIcon(new ImageIcon(main_ql.class.getResource("/icon/people50.png")));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		btnNhanSu.add(lblNewLabel_2, BorderLayout.CENTER);
		
		btnThongKe = new JPanel();
		btnThongKe.setPreferredSize(new Dimension(1200, 100));
		btnThongKe.setMaximumSize(new Dimension(1200, 100));
		btnThongKe.setBackground(backGround_Color.bg_color);
		
		btnThongKe.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_3 = new JLabel("Thống Kê");
		lblNewLabel_3.setIcon(new ImageIcon(main_ql.class.getResource("/icon/icons8-chart-50.png")));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		btnThongKe.add(lblNewLabel_3, BorderLayout.CENTER);

		Menu.add(btnLogo, BorderLayout.NORTH);
		MenuList = new JPanel();
		MenuList.setBackground(Menu.getBackground());
		MenuList.setLayout(new BoxLayout(MenuList, BoxLayout.Y_AXIS));
		MenuList.add(btnPhim);
		MenuList.add(Box.createVerticalStrut(20));
		MenuList.add(btnSuatChieu);
		MenuList.add(Box.createVerticalStrut(20));
		MenuList.add(btnNhanSu);
		MenuList.add(Box.createVerticalStrut(20));
		MenuList.add(btnThongKe);
		Menu.add(MenuList, BorderLayout.CENTER);
		
		lbl_clock = new JLabel("New label");
		lbl_clock.setForeground(new Color(255, 255, 255));
		lbl_clock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_clock.setHorizontalAlignment(SwingConstants.CENTER);
		Menu.add(lbl_clock, BorderLayout.SOUTH);
		
		timer = new Timer(0, this);
        timer.start();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lbl_clock.setText(clock.updateClock());
	}
	
//    private void switchPanel(JPanel panel) {
//    	form.remove(deskPane);
//        deskPane = panel;
//        form.add(deskPane);
//        form.revalidate();
//        form.repaint();
//    }

}
