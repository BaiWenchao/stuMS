package ejb.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "Students")
public class Student implements Serializable {
    private Integer id;
    private String stuNum;
    private String name;
    private boolean sex;
    private Date birthday;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, length = 30)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Column(nullable = false, length = 20, unique = true)
    public String getStuNum() {
        return stuNum;
    }
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.getId()+
                ","+this.getStuNum()+
                ","+this.getName()+
                ","+this.isSex()+
                ","+this.getBirthday();
    }
}
