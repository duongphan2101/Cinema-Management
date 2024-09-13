package ui;

import javax.swing.*;
import java.awt.*;

public class CinemaLogin extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CinemaLogin() {
        // Thiết lập cửa sổ chính
        setTitle("Cinema Star - Login");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo panel bên trái với logo và tiêu đề
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(700, 700));
        leftPanel.setBackground(new Color(211, 47, 47));
        leftPanel.setLayout(new GridBagLayout());
        
        // Logo ngôi sao giả định (dùng JLabel với Icon)
        JLabel starLogo = new JLabel(new ImageIcon("star_logo.png")); // Thay bằng đường dẫn logo ngôi sao
        JLabel cinemaTitle = new JLabel("CINEMA STAR");
        cinemaTitle.setFont(new Font("Arial", Font.BOLD, 40));
        cinemaTitle.setForeground(Color.WHITE);

        // Thêm logo và tiêu đề vào leftPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        leftPanel.add(starLogo, gbc);
        
        gbc.gridy = 1;
        leftPanel.add(cinemaTitle, gbc);

        // Tạo panel bên phải với form đăng nhập
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(500, 700));
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);

        // Tiêu đề "Login"
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 40));
        loginLabel.setForeground(new Color(211, 47, 47));
        loginLabel.setBounds(200, 50, 150, 50);
        rightPanel.add(loginLabel);

        // Nhãn và trường nhập "Tên Đăng Nhập"
        JLabel usernameLabel = new JLabel("Tên Đăng Nhập");
        usernameLabel.setBounds(100, 150, 150, 30);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rightPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 180, 300, 50);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        rightPanel.add(usernameField);

        // Nhãn và trường nhập "Mật Khẩu"
        JLabel passwordLabel = new JLabel("Mật Khẩu");
        passwordLabel.setBounds(100, 250, 150, 30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rightPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 280, 300, 50);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        rightPanel.add(passwordField);

        // Nút "Đăng Nhập"
        JButton loginButton = new JButton("Đăng Nhập");
        loginButton.setBounds(100, 350, 320, 50);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(211, 47, 47));
        rightPanel.add(loginButton);

        // Thêm các panel vào frame
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CinemaLogin loginForm = new CinemaLogin();
            loginForm.setVisible(true);
        });
    }
}

