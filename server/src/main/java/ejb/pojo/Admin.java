package ejb.pojo;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Admins")
public class Admin {
    private Integer id;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, length = 50, unique = true)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false, length = 30)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
