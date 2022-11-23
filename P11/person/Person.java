package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Person {
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public Person(BufferedReader in) throws IOException {
		this.name = in.readLine();
		this.phone = in.readLine();
	}
	
	public void save(BufferedWriter out) throws IOException {
		out.write(name + '\n');
		out.write(phone + '\n');
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name + ": " + phone);
		return result.toString();
	}
	
/*	@Override
	public boolean equals(Person rhs) {
		
	}
	
	@Override
	public int hashCode() {
		
	}*/
	
	protected String name;
	protected String phone;
}
