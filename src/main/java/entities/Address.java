package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Piopo on 14.10.2017.
 */

@Embeddable
public class Address {

    @Column
    private String street;

    @Column
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
