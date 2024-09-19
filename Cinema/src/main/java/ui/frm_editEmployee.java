package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EmptyBorder;
import service.CustomOptionPane;
import service.RoundedPanel;
import service.backGround_Color;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import com.raven.datechooser.*;

import dao.DAO_Account;
import dao.DAO_Employee;
import enities.Account;
import enities.Employee;
import enities.EmployeeType;
import javax.swing.JPasswordField;

public class frm_editEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel head;
	private JPanel body;
	private JPanel content;
	private JPanel btnEdit;
	private JComboBox<String> txtGenre;
	private JTextField txtUserName;
	private JTextField txtTenNV;
	private JTextField txtNgay;
	private JButton btnDay;
	private JLabel lbl_Edit;
	private DateChooser dateChooser;
	private JTextField txtSDT;
	private JTextField txt_Email;
	@SuppressWarnings("unused")
	private List<Employee> list;
	private DAO_Employee dao;
	private JPasswordField txtPass;

	/**
	 * Create the panel.
	 */
	public frm_editEmployee() {
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
		JLabel lbl_addNV = new JLabel("Sửa Nhân Viên");
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

		btnEdit = new RoundedPanel(15);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBounds(192, 351, 250, 40);
		btnEdit.setBackground(backGround_Color.bg_color_deep);

		content.setLayout(null);
		content.add(btnEdit);
		btnEdit.setLayout(new BorderLayout(0, 0));

		lbl_Edit = new JLabel("Sửa");
		lbl_Edit.setForeground(new Color(255, 255, 255));
		lbl_Edit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_Edit.setHorizontalAlignment(SwingConstants.CENTER);
		btnEdit.add(lbl_Edit, BorderLayout.CENTER);

		JLabel lbl_user = new JLabel("Tên Tài Khoản:");
		lbl_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_user.setBounds(22, 40, 142, 20);
		content.add(lbl_user);

		txtUserName = new JTextField();
		txtUserName.setBounds(10, 70, 250, 30);
		content.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lbl_TenNV = new JLabel("Tên nhân viên:");
		lbl_TenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TenNV.setBounds(10, 115, 142, 20);
		content.add(lbl_TenNV);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(10, 145, 372, 30);
		content.add(txtTenNV);

		JLabel lbl_Date = new JLabel("Ngày sinh:");
		lbl_Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Date.setBounds(416, 185, 142, 20);
		content.add(lbl_Date);

		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(416, 215, 169, 30);
		content.add(txtNgay);

		dateChooser = new DateChooser();
		dateChooser.setTextRefernce(txtNgay);

		String[] chucvu = { "Quản lý", "Nhân viên" };
		txtGenre = new JComboBox<>(chucvu);
		txtGenre.setBounds(10, 272, 214, 30);
		content.add(txtGenre);

		btnDay = new JButton("...");
		btnDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateChooser.showPopup();
			}
		});
		btnDay.setBounds(586, 214, 30, 30);
		content.add(btnDay);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(416, 145, 200, 30);
		content.add(txtSDT);

		JLabel lbl_SDT = new JLabel("Số điện thoại:");
		lbl_SDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SDT.setBounds(428, 115, 142, 20);
		content.add(lbl_SDT);

		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(22, 185, 142, 20);
		content.add(lbl_email);

		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		txt_Email.setBounds(10, 215, 372, 30);
		content.add(txt_Email);

		JLabel lbl_mk = new JLabel("Mật Khẩu:");
		lbl_mk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_mk.setBounds(378, 40, 142, 20);
		content.add(lbl_mk);

		txtPass = new JPasswordField();
		txtPass.setBounds(366, 70, 250, 30);
		content.add(txtPass);

		RoundedPanel btn_Xoa = new RoundedPanel(15);
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_Xoa.setBackground(new Color(190, 6, 43));
		btn_Xoa.setBounds(511, 351, 86, 40);
		content.add(btn_Xoa);
		btn_Xoa.setLayout(new BorderLayout(0, 0));

		JLabel lbl_Xoa = new JLabel("Xóa");
		lbl_Xoa.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Xoa.setForeground(Color.WHITE);
		lbl_Xoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_Xoa.add(lbl_Xoa, BorderLayout.CENTER);
		btn_Xoa.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int confirm = CustomOptionPane.showDialog("Bạn có chắc chắn muốn xóa nhân viên này?");
		        if (confirm == JOptionPane.YES_OPTION) { 
		            deleteEmployee(); 
		            parentForm.refreshTable(); 
		            dispose(); 
		        }
		    }

		    private void deleteEmployee() {
		        try {
		            dao = new DAO_Employee();		           
		            dao.deleteAccountByEmployeeId(employeeId); 
		            dao.deleteEmployee(employeeId);	         
		            CustomOptionPane.showMess("Xóa nhân viên thành công!");
		        } catch (Exception ex) {
		            CustomOptionPane.showMess("Có lỗi xảy ra: " + ex.getMessage());
		        }
		    }
		});
		btnEdit.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        updateEmployee(); 
		        parentForm.refreshTable(); 
		        dispose(); 
		    }
			
			  private void updateEmployee() {
			        try {
			            String name = txtTenNV.getText().trim();
			            String birthDate = txtNgay.getText().trim();
			            String phone = txtSDT.getText().trim();
			            String email = txt_Email.getText().trim();
			            int employeeTypeId = txtGenre.getSelectedItem().equals("Quản lý") ? 1 : 2;

			            EmployeeType employeeType = new EmployeeType(employeeTypeId);
			            Employee employee = new Employee(employeeId, name, employeeType, birthDate, phone, email); // Sử dụng employeeId đã lưu

			            dao = new DAO_Employee();
			            dao.updateEmployee(employee);

			            CustomOptionPane.showMess("Cập nhật nhân viên thành công!");
			        } catch (Exception ex) {
			            CustomOptionPane.showMess("Có lỗi xảy ra: " + ex.getMessage());
			        }
			    }

		});

	}
	private frmEmployee parentForm;
	private int employeeId; 
	public frm_editEmployee(int employeeId, String employeeName, String employeeType, String birthDate, String phone, String email, String username, frmEmployee parent) {
	    this();
	    this.employeeId = employeeId; 
	    this.parentForm = parent; 

	    txtUserName.setText(username);
	    txtTenNV.setText(employeeName);
	    txtNgay.setText(birthDate);
	    txtSDT.setText(phone);
	    txt_Email.setText(email);
	    txtGenre.setSelectedItem(employeeType.equals("Quản lý") ? "Quản lý" : "Nhân viên");
	}
}
