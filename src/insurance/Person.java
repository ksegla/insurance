package insurance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Person {
	String firstName;
	String lastName;
	String address;
	String zipcode;
	Date birthDate;
	
	String gender;
	int age;
	boolean married;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/*
	 * La compagnie n'accepte que des personnes entre 16 et 80 ans
	 * La prime de base est de 500$
	 * Les hommes célibataires de moins de 25 ans paient 1500$ de plus
	 * Les personnes mariées et les femmes paient 200$ de moins
	 * Les personnes agées entre 45 et 65 ans paient 100$ de moins.
	 */
	public static int computePremium(String gender, int age, boolean married) {
		int prime = 500; // prime de base
		if (!gender.equals("Male") & !gender.equals("Female")) {
			prime = -1;
		}
		if (age < 16 | age >= 80) {
			prime = -1;
		}
		else 
		if ((age <= 25) & !married & gender.equals("Male")) {
			prime += 1500;
		} else {
			if (married || gender.equals("Female")) {
				prime -= 200;
			}
			if ((age >= 45) & (age <= 65)) {
				prime -= 100;
			}
		}
		return prime;
	}
	
	public void registerPerson(String fName, String lName, String addr, String zip, String _gender, String _age, boolean _married)
	{		
		firstName = fName;
		lastName = lName;
		address = addr;
		zipcode = zip;
		gender = _gender;
		age = Integer.parseInt(_age);
		
		String toAppend = fName + "," + lName + "," + addr + "," + zip;
		toAppend += "," + _gender + "," + _age + "," + married;		
		try {
			FileWriter f = new FileWriter(RegisterGUI.TEMP_FILE);
			
			f.write(toAppend);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
