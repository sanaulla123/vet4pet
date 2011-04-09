package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;
import play.libs.Time;

import javax.persistence.*;
import java.util.*;

@Entity
public class VetCenter extends Model {
	@Required
	public String name;
	
	@Required
	public Address location;
	
	public String contactNumber;
	public String visitingTime;
	public String ownership; //This is either Private/Public 
	public String type;      //This is either Hospital/Clinic
	public ArrayList<String> doctorsAvailable;
	public ArrayList<Review> reviews;
	
	public VetCenter(String name, Address location, String number, String time, String owner, String type) {
		this.name = name;
		this.location = location;
		this.contactNumber = number;
		this.visitingTime = time;
		this.ownership = owner;
		this.type = type;
		doctorsAvailable  = new ArrayList<String>();
		reviews = new ArrayList<Review>();
	}
	
	public VetCenter addDoctor(String doctor){
		this.doctorsAvailable.add(doctor);
		this.save();
		return this;
	}
	
	public VetCenter addReview(Review review){
		this.reviews.add(review);
		this.save();
		return this;
	}
}
