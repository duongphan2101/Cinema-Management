package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import enities.Employee;
import enities.EmployeeType;
import service.CustomOptionPane;

public class DAO_Employee {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<Employee>();
        String query = "SELECT * FROM Employee";
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt(1), 
                    rs.getString(2), 
                    new EmployeeType(rs.getInt(3)),  
                    rs.getString(4), 
                    rs.getString(5), 
                    rs.getString(6))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    
    public Employee getEmployeeByID(int id) {
        String query = "SELECT * FROM Employee WHERE employee_id = ?";
        Employee employee = null;
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    new EmployeeType(rs.getInt(3)),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

   
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (employee_id, name, employee_type_id, birth_date, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId()); 
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getEmployeeType().getTypeId());  
            ps.setString(4, employee.getBirthDate());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                CustomOptionPane.showMess("Thêm nhân viên thành công!");
            } else {
                CustomOptionPane.showMess("Không có nhân viên nào được thêm.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET name = ?, employee_type_id = ?, birth_date = ?, phone = ?, email = ? WHERE employee_id = ?";
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getEmployeeType().getTypeId());  
            ps.setString(3, employee.getBirthDate());
            ps.setString(4, employee.getPhone());
            ps.setString(5, employee.getEmail());
            ps.setInt(6, employee.getEmployeeId()); 

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                CustomOptionPane.showMess("Cập nhật nhân viên thành công!");
            } else {
                CustomOptionPane.showMess("Cập nhật nhân viên không thành công.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   
    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM Employee WHERE employee_id = ?";
        try {
            new DBConnect();
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, employeeId);  

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                CustomOptionPane.showMess("Xóa nhân viên thành công!");
            } else {
                CustomOptionPane.showMess("Xóa nhân viên không thành công.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
}
