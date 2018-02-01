package entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Piopo on 14.10.2017.
 */
@Entity
@Table(name="APP_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column
    private String email;

    @Column
    private Date birthsday;

    @Column(name="LAST_UPDATED")
    private Date lastUpdated;

    @ElementCollection
    @CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name="USER_ID"))
    @Column(name = "NAME")
    //Dla mapy trzeba dodać jeszcze @MapKeyColumn, gdzie będzie zapisany klucz
    // W ten sam sposób możesz mapować do list Embedded Types jak np Address poniżej (jego anotacje zoatają)
    private Collection<String> contacts = new ArrayList<String>();

    @Embedded //napisałem jeden argument, drugi zostawiłem defaultowy
    @AttributeOverrides({@AttributeOverride(name="street", column = @Column(name = "USR_STREET"))})
    private Address address;

    @OneToOne
    @JoinColumn(name = "CREDENTIALS_ID")
    @Cascade(CascadeType.ALL)
    private Credentials credentials;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Collection<String> getContacts() {
        return contacts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthsday() {
        return birthsday;
    }

    public void setBirthsday(Date birthsday) {
        this.birthsday = birthsday;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
