package ejb.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private Integer id;
    private String stuNum;
    private String name;
    private boolean sex;
    private Date birthday;

    public Student() {
    }

    public Student(Integer id, String stuNum, String name, boolean sex, Date birthday) {
        this.id = id;
        this.stuNum = stuNum;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNum() {
        return stuNum;
    }
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(birthday);
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.getId()
                + ", " + this.getStuNum()
                + ", " + this.getName()
                + ", " + this.isSex()
                + ", " + this.getBirthday();
    }
}
