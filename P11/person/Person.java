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
		this.name = String(in);
		this.phone = String(in);
	}
	
	public void save(BufferedWriter out) throws IOException {
		
	}
	
	@Override
	public String toString() {
		
	}
	
	public boolean equals(Person rhs) {
		
	}
	
	public int hashCode() {
		
	}
	
	protected String name;
	protected String phone;
}
