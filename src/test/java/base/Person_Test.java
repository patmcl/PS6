package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	static PersonDomainModel per1 = new PersonDomainModel();
	static PersonDomainModel per3 = new PersonDomainModel();

	@Test
	public void Test() throws Exception {
		per1.setBirthday(new Date(0));
		per1.setCity("Newak");
		per1.setFirstName("Bob");
		per1.setLastName("Joe");
		per1.setPostalCode(1234);
		per1.setStreet("Main St");
		
		PersonDAL.addPerson(per1);
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getPersonID(), per2.getPersonID());
		
		per3.setBirthday(new Date(0));
		per3.setCity("Newak");
		per3.setFirstName("Mark");
		per3.setLastName("Joe");
		per3.setPostalCode(1234);
		per3.setStreet("Main St");
		
		PersonDAL.updatePerson(per3);
		assertNotEquals(per3.getFirstName(), per1.getFirstName());
		
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
		
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDAL.deletePerson(per3.getPersonID());
		assertNull(PersonDAL.getPerson(per1.getPersonID()));
	}
	
	@BeforeClass
	public static void before() throws Exception {
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDAL.deletePerson(per3.getPersonID());
	}

}
