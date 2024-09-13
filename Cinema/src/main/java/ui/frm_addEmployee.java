package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import service.CustomOptionPane;
import service.RoundedPanel;
import service.backGround_Color;
import service.control_Image;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import com.raven.datechooser.*;

import dao.DAO_Employee;
import dao.DAO_Movie;
import enities.Employee;
import enities.EmployeeType;
import enities.Movie;
import enities.MovieStatus;
import javax.swing.DefaultComboBoxModel;

public class frm_addEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel head;
	private JPanel body;
	private JPanel content;
	private JPanel btnAdd;
	private JComboBox<String> txtGenre;
	private JTextField txtmaNV;
	private JTextField txtTenNV;
	private JTextField txtNgay;
	private JButton btnDay;
	private JLabel lbl_Add;
	private DateChooser dateChooser;
	private JTextField txtSDT;
	private JTextField txt_Email;
	private JTextField txt_TK;
	private List<Employee> list;
	private DAO_Employee dao;

	/**
	 * Create the panel.
	 */
	public frm_addEmployee(DAO_Employee dao) {
		this.dao = dao;
		setSize(700, 500);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		head = new JPanel();
		head.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(head, BorderLayout.NORTH);
		head.setLayout(new BorderLayout(0, 0));
		head.setBackground(backGround_Color.bg_color);
		JLabel lbl_addNV = new JLabel("Thêm Nhân Viên");
		lbl_addNV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_addNV.setForeground(new Color(255, 255, 255));
		lbl_addNV.setFont(new Font("Tahoma", Font.BOLD, 24));
		head.add(lbl_addNV, BorderLayout.CENTER);

		body = new JPanel();
		body.setBorder(new EmptyBorder(0, 30, 0, 30));
		getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(new BorderLayout(0, 0));

		content = new JPanel();
		body.add(content, BorderLayout.CENTER);

		String[] movieGenres = { "Khoa học viễn tưởng", "Hành động", "Lãng mạn", "Kinh dị", "Tâm lý", "Tội phạm" };

		btnAdd = new RoundedPanel(15);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBounds(106, 349, 250, 40);
		btnAdd.setBackground(backGround_Color.bg_color_deep);

		content.setLayout(null);
		content.add(btnAdd);
		btnAdd.setLayout(new BorderLayout(0, 0));

		lbl_Add = new JLabel("");
		lbl_Add.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Add.setIcon(new ImageIcon(frm_addEmployee.class.getResource("/icon/icons8-plus-30.png")));
		btnAdd.add(lbl_Add, BorderLayout.CENTER);

		JLabel lbl_maNV = new JLabel("Mã nhân viên:");
		lbl_maNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_maNV.setBounds(22, 40, 142, 20);
		content.add(lbl_maNV);

		txtmaNV = new JTextField();
		txtmaNV.setBounds(10, 70, 200, 30);
		content.add(txtmaNV);
		txtmaNV.setColumns(10);

		JLabel lbl_TenNV = new JLabel("Tên nhân viên:");
		lbl_TenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TenNV.setBounds(232, 40, 142, 20);
		content.add(lbl_TenNV);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(232, 70, 200, 30);
		content.add(txtTenNV);

		JLabel lbl_Date = new JLabel("Ngày sinh:");
		lbl_Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Date.setBounds(232, 110, 142, 20);
		content.add(lbl_Date);

		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(232, 140, 169, 30);
		content.add(txtNgay);

		dateChooser = new DateChooser();
		dateChooser.setTextRefernce(txtNgay);

		txtGenre = new JComboBox<>(movieGenres);
		txtGenre.setModel(new DefaultComboBoxModel(new String[] { "Quản lý", "Nhân viên" }));
		txtGenre.setBounds(81, 281, 275, 30);
		content.add(txtGenre);

		btnDay = new JButton("...");
		btnDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateChooser.showPopup();
			}
		});
		btnDay.setBounds(402, 139, 30, 30);
		content.add(btnDay);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(10, 140, 200, 30);
		content.add(txtSDT);

		JLabel lbl_SDT = new JLabel("Số điện thoại:");
		lbl_SDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SDT.setBounds(22, 110, 142, 20);
		content.add(lbl_SDT);

		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(22, 196, 142, 20);
		content.add(lbl_email);

		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		txt_Email.setBounds(10, 226, 200, 30);
		content.add(txt_Email);

		JLabel lbl_TK = new JLabel("Tài khoản:");
		lbl_TK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TK.setBounds(244, 196, 142, 20);
		content.add(lbl_TK);

		txt_TK = new JTextField();
		txt_TK.setColumns(10);
		txt_TK.setBounds(232, 226, 200, 30);
		content.add(txt_TK);

		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addEmployee();
			}

			private void addEmployee() {
			    try {
			        
			        int employeeId = Integer.parseInt(txtmaNV.getText().trim());  
			        String name = txtTenNV.getText().trim();
			        String birthDate = txtNgay.getText().trim();
			        String phone = txtSDT.getText().trim();
			        String email = txt_Email.getText().trim();
			        int employeeTypeId = txtGenre.getSelectedItem().equals("Quản lý") ? 1 : 2;

			      
			        EmployeeType employeeType = new EmployeeType(employeeTypeId);
			        Employee employee = new Employee(employeeId, name, employeeType, birthDate, phone, email);

			     
			        dao.addEmployee(employee);

			        CustomOptionPane.showMess("Thêm nhân viên thành công!");
			    } catch (NumberFormatException ex) {
			        CustomOptionPane.showMess("Mã nhân viên không hợp lệ: " + ex.getMessage());
			    } catch (Exception ex) {
			        CustomOptionPane.showMess("Có lỗi xảy ra: " + ex.getMessage());
			    }
			}

		});

	}

}
