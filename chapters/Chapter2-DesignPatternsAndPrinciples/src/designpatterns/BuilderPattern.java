package designpatterns;

public class BuilderPattern {

	public static void main(String[] args) {
		Person person = new Person.PersonBuilder()
				.setFirstName("Joel")
				.setLastName("Ruelos")
				.setAge(27)
				.build();
		System.out.println(person);
	}

}

class Person {
	private String firstName;
	private String secondName;
	private String middleName;
	private String lastName;
	private String shortName;
	private String englishName;
	private int age;

	// make constructor private so clients are forced to use the Builder!
	private Person(String firstName, String secondName, String middleName, String lastName, String shortName,
			String englishName, int age) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.shortName = shortName;
		this.englishName = englishName;
		this.age = age;
	}

	// getters and setters

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", secondName=" + secondName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", shortName=" + shortName + ", englishName=" + englishName + ", age="
				+ age + "]";
	}

	static class PersonBuilder {
		private String firstName;
		private String secondName;
		private String middleName;
		private String lastName;
		private String shortName;
		private String englishName;
		private int age;

		public PersonBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PersonBuilder setSecondName(String secondName) {
			this.secondName = secondName;
			return this;
		}

		public PersonBuilder setMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}

		public PersonBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonBuilder setShortName(String shortName) {
			this.shortName = shortName;
			return this;
		}

		public PersonBuilder setEnglishName(String englishName) {
			this.englishName = englishName;
			return this;
		}

		public PersonBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public Person build() {
			return new Person(firstName, secondName, middleName, lastName, shortName, englishName, age);
		}

	}

}