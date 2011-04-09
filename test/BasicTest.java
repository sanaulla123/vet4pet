import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void addVetCenter(){
    	Address location = new Address("128, 1st Floor, 2nd Cross, Karnataka Layout 1st Stage","Bangalore","Karnataka","India","560086");
    	location.save();
    	String clinicName = "AnimalCare";
    	new VetCenter(clinicName, location, "9880674926", "10-6 on weekdays, 10-3 on weekends", "Private", "Clinic").save();
    	VetCenter center = VetCenter.find("byName", clinicName).first();
    	assertNotNull(center);
    	assertEquals(center.name, clinicName);
    	
    }
    
    @Test
    public void getVetCenterByName(){
    	Address location = new Address("128, 1st Floor, 2nd Cross, Karnataka Layout 1st Stage","Bangalore","Karnataka","India","560086");
    	location.save();
    	String clinicName = "AnimalCare";
    	new VetCenter(clinicName, location, "9880674926", "10-6 on weekdays, 10-3 on weekends", "Private", "Clinic").save();
    	VetCenter center = VetCenter.find("byName", clinicName).first();
    	assertNotNull(center);
    	assertEquals(center.name, clinicName);
    }
    
    @Test
    public void addReview(){
    	Address location = new Address("128, 1st Floor, 2nd Cross, Karnataka Layout 1st Stage","Bangalore","Karnataka","India","560086");
    	location.save();
    	String clinicName = "AnimalCare";
    	VetCenter center = new VetCenter(clinicName, location, "9880674926", "10-6 on weekdays, 10-3 on weekends", "Private", "Clinic");
    	Review review = new Review("This is an awesome place for pets", "Sanaulla");
    	center = center.addReview(review);
    	ArrayList<Review> reviewList = VetCenter.find("byName", clinicName).first();
    	assertEquals(reviewList.size(), 1);
    	assertEquals(reviewList.get(0).content, "This is an awesome place for pets");	
    }
    

}
