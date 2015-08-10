package database;

import constants.Constants;
import entity.Role;
import entity.Student;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.*;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Natalia Lysenko on 20.06.2015.
 */
public class DBConnection {

    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
    private Connection conn = null;
    private ResultSet rs = null;

    private static PreparedStatement getRoleById;
    private static PreparedStatement loadRoles;
    private static PreparedStatement userValidate;
    private static PreparedStatement listStudents;
    private static PreparedStatement deleteStudent;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Constants.CONNECTING_URL);
            loadPreparedStatements();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadPreparedStatements() {
        try {
            getRoleById = conn.prepareStatement("SELECT * FROM role WHERE id = ?");
            loadRoles = conn.prepareStatement("SELECT * FROM role");
            userValidate = conn.prepareStatement("SELECT * FROM user.user as TABUser join user.user_role as TABUser_role on TABUser.id = TABUser_role.id_user where (TABUser.login = ?) and (TABUser.password = ?) and (TABUser_role.id_role = ?)");
            listStudents = conn.prepareStatement("SELECT name, sername, date, grope FROM user.student");
            deleteStudent = conn.prepareStatement("DELETE * FROM user.student WHERE id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closePreparedStatements() {
        try {
            getRoleById.close();
            loadRoles.close();
            userValidate.close();
            listStudents.close();
            deleteStudent.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Role getRoleById(int id) {
        rs = null;
        Role role = new Role();
        try { // SELECT * FROM role WHERE id = ?
            getRoleById.setInt(1, id);
            rs = getRoleById.executeQuery();
            while (rs.next()) {
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    public List<Role> loadRoles() {
        rs = null;
        List<Role> roles = new LinkedList();
        try { // SELECT * FROM role
            rs = loadRoles.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    public boolean userService(String login, String password, int roleID) {
        rs = null;
        boolean result = false;
        try { // Select * FROM user.user as TABUser join user.user_role as TABUser_role on TABUser.id = TABUser_role.id_user where (TABUser.login = ?) and (TABUser.password = ?)
            userValidate.setString(1, login);
            userValidate.setString(2, password);
            userValidate.setInt(3, roleID);
            rs = userValidate.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<Student> listStudents() {
        rs = null;
        List<Student> students = new LinkedList();
        try { // SELECT name, sername, date, grope FROM user.student
            rs = listStudents.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setSername(rs.getString("sername"));
                student.setName(rs.getString("name"));
                student.setDate(rs.getDate("date"));
                student.setGrope(rs.getString("grope"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student deleteStudent (int id) {
        rs = null;
        Student student = new Student();
        try { // DELETE * FROM user.student WHERE id=?
            deleteStudent.setInt(1, id);
            rs = deleteStudent.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

//    public Student userStudent(String name, String sername, Date date, String grope) {
//        rs = null;
//        Student student = new Student();
//        try { // SELECT * FROM user.student where name=? sername=? date=? grope=?
//            listStudent.setString(1, name);
//            listStudent.setString(2, sername);
//            listStudent.setString(3, String.valueOf(date));
//            listStudent.setString(4, grope);
//            rs = listStudent.executeQuery();
//            while (rs.next()) {
//                student.setName(rs.getString("name"));
//                student.setSername(rs.getString("sername"));
//                student.setDate(rs.getDate("date"));
//                student.setGrope(rs.getString("grope"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return student;
//    }


//
//    public City getCityById(int idCity) {
//        rs = null;
//        City city = new City();
//        try {// SELECT * FROM city WHERE id = ?
//            getCityById.setInt(1, idCity);
//            rs = getCityById.executeQuery();
//            while (rs.next()) {
//                city.setId(rs.getInt("id"));
//                city.setName(rs.getString("name"));
//                city.setLinkToFacebook(rs.getString("facebook"));
//                city.setLinkToGoogle(rs.getString("google+"));
//                city.setLinkToLinkedin(rs.getString("linkedin"));
//                city.setLinkToVk(rs.getString("vk"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return city;
//    }


}


