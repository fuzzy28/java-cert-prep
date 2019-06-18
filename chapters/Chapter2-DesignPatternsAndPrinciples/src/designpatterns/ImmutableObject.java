package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ImmutableObject {

	public static void main(String[] args) {
		List<String> certs = new ArrayList<>();
		certs.add("OCA7");
		certs.add("OCP7");
		Immutable i = new Immutable("Joel", 27, certs);
		certs.add("OCP8"); // it won't be added!
		i.getCertifications().add("OCP11"); // it won't be added!
		System.out.println(i.getCertifications().size() == 2);
		System.out.println(i);
	}
}

final class Immutable {

	// Mark all of the instance variables private and final
	private final String name;
	private final int age;
	private final List<String> certifications;

	// Use a constructor to set all properties of the object
	public Immutable(String name, int age, List<String> certifications) {
		this.name = name;
		this.age = age;
		this.certifications = new ArrayList<>(certifications);
	}

	// Don't define any setter methods
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getCertifications() {
		return new ArrayList<>(certifications);
	}

	@Override
	public String toString() {
		return "Immutable [name=" + name + ", age=" + age + ", certifications=" + certifications + "]";
	}

}