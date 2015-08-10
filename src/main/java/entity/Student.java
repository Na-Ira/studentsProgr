package entity;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 20.07.2015.
 */
public class Student {
    private int id;
    private String name = "name";
    private String sername = "sername";
    private Date date = getDate();
    private String grope = "grope";
    private List<Student> students = new LinkedList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGrope() {
        return grope;
    }

    public void setGrope(String grope) {
        this.grope = grope;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
