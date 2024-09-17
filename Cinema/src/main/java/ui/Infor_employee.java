package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import enities.Employee;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Infor_employee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Employee nv;
	private JLabel lbl_ten, lbl_sdt, lbl_Ma;
	private JLabel lbl_diaChi;
	private JLabel lbl_MaLoaiNhanVien;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Infor_employee frame = new Infor_employee(nv);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Infor_employee(Employee nv) throws SQLException, ParseException {
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 473);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Thông Tin Nhân Viên");
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(10, 10, 536, 40);
		contentPane.add(lbl_title);
		
		lbl_ten = new JLabel("Họ Tên Nhân Viên: " + Employee.getName());
		lbl_ten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ten.setBounds(10, 254, 536, 30);
		contentPane.add(lbl_ten);
		
		lbl_sdt = new JLabel("Số Điện Thoại: " + Employee.getPhone());
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_sdt.setBounds(10, 294, 269, 30);
		contentPane.add(lbl_sdt);
		
		lbl_Ma = new JLabel("Mã Nhân Viên: " + Employee.getEmployeeId());
		lbl_Ma.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Ma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Ma.setBounds(277, 294, 269, 30);
		contentPane.add(lbl_Ma);
		
		JLabel lbl_email = new JLabel("Email: " + Employee.getEmail());
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(10, 334, 269, 30);
		contentPane.add(lbl_email);
		
		JLabel avt = new JLabel("");
		avt.setIcon(new ImageIcon(Infor_employee.class.getResource("/imgs/batman128.png")));
		avt.setHorizontalAlignment(SwingConstants.CENTER);
		avt.setBounds(10, 60, 536, 184);
		contentPane.add(avt);
		
		lbl_diaChi = new JLabel("Ngày Sinh: " + Employee.getBirthDate());
		lbl_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_diaChi.setBounds(10, 374, 269, 30);
		contentPane.add(lbl_diaChi);
		
		String lnv = "";
		if(Employee.getEmployeeType().getTypeId()==1) {
			lnv = "Quản Lý";
		}else if(Employee.getEmployeeType().getTypeId()==2) {
			lnv = "Nhân viên bán vé";
		}else {
			lnv = "Kỹ thuật viên";
		}
		lbl_MaLoaiNhanVien = new JLabel("Nhân Viên: " +lnv);
		lbl_MaLoaiNhanVien.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_MaLoaiNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MaLoaiNhanVien.setBounds(277, 374, 269, 30);
		contentPane.add(lbl_MaLoaiNhanVien);
		 
	}
}
