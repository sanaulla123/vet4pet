package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Address extends Model {
    public String streetArea;
    public String city;
    public String state;
    public String country;
    public String pinCode;
    
    public Address(String streetArea, String city, String state, String country, String pinCode) {
    	this.streetArea = streetArea;
    	this.city = city;
    	this.state = state;
    	this.country = country;
    	this.pinCode = pinCode;
    
	}
}
