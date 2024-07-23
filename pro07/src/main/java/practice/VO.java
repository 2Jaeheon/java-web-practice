package practice;

import java.util.Date;

public class VO {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date joinDate;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setJoinDate(Date date) {
        this.joinDate = date;
    }

    public Date getJoinDate() {
        return joinDate;
    }

}