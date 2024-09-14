package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO_KHACHHANG;
import enities.Customer;
import service.CustomOptionPane;
import service.RoundedPanel;
import service.backGround_Color;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

public class frm_checkCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DAO_KHACHHANG dao;
	private JPanel head;
	private JLabel lblNewLabel;
	private JTextField txtSdt;
	private JPanel body;
	private JLabel search;
	private JLabel lblTnKhchHng;
	private JTextField txtTen;
	private JPanel bottom;
	private JPanel btnXacNhan;
	private JLabel lblNewLabel_1;
	private Customer kh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_checkCustomer frame = new frm_checkCustomer();
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
	
	public String getPhone() {
	    return txtSdt.getText();
	}

	public String getName() {
	    return txtTen.getText();
	}

	public frm_checkCustomer() {
		setType(Type.UTILITY);
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 450, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		head = new JPanel();
		head.setBackground(new Color(255, 255, 255));
		contentPane.add(head, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Số Điện Thoại");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		head.add(lblNewLabel);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		head.add(txtSdt);
		
		search = new JLabel("");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sdt = txtSdt.getText();
					dao = new DAO_KHACHHANG();
					Customer cus = dao.getCustomerbySDT(sdt);
					kh = cus;
					if(cus!=null) {
						txtSdt.setText(Customer.getPhone());
						txtTen.setText(Customer.getName());
					}else {
						CustomOptionPane.showMess("Không tìm thấy khách hàng trong hệ thống");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		search.setIcon(new ImageIcon(frm_checkCustomer.class.getResource("/icon/icons8-search-24.png")));
		search.setHorizontalAlignment(SwingConstants.CENTER);
		head.add(search);
		
		body = new JPanel();
		body.setBackground(new Color(255, 255, 255));
		contentPane.add(body, BorderLayout.CENTER);
		
		lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		body.add(lblTnKhchHng);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		body.add(txtTen);
		
		lblNewLabel.setPreferredSize(lblTnKhchHng.getPreferredSize());
		
		bottom = new JPanel();
		bottom.setBackground(new Color(255, 255, 255));
		contentPane.add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new BorderLayout(0, 0));
		
		btnXacNhan = new RoundedPanel(20);
		btnXacNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(kh!=null) {
					Customer.setName(Customer.getName());
					Customer.setPhone(Customer.getPhone());
					Customer.setCustomerId(Customer.getCustomerId());
					dispose();
				}else {
					dao = new DAO_KHACHHANG();
					 try {
						String ten = txtTen.getText();
						String sdt = txtSdt.getText();
						Customer cus = new Customer(1, ten, sdt);
						dao.addCustomer(cus);
						CustomOptionPane.showNotice("Thêm Khách Hàng Thành Công!");
						dispose();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		bottom.add(btnXacNhan);
		btnXacNhan.setLayout(new BorderLayout(0, 0));
		btnXacNhan.setBackground(backGround_Color.bg_color);
		btnXacNhan.setPreferredSize(new Dimension(250, 30));
		
		lblNewLabel_1 = new JLabel("Xác Nhận");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnXacNhan.add(lblNewLabel_1, BorderLayout.CENTER);
	}

}
