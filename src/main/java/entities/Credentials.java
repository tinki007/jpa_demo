package entities;

import javax.persistence.*;

/**
 * Created by Piopo on 15.10.2017.
 */

@Entity
@Table(name = "USER_CREDENTIALS")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CREDENTIALS_ID")
    private long credentialsId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @OneToOne(mappedBy = "credentials")
    //@JoinColumn(name = "USER_ID") -> i jak jeszcze wywaisz mappedBy, to będziesz miał foreign keys zarówno w jednej i drugiej tabeli.
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCredentialsId() {
        return credentialsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
