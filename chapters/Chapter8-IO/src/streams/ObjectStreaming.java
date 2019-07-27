package streams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreaming {

	static File file = new File("myobject.data");

	static void serializeObject() throws IOException {
		System.out.println("--------serializeObject--------");

		if (file.exists()) {
			System.out.println("Deleting existing file: " + file.delete());
		}

		MyObject o = new MyObject("Joel", 27);
		o.message = "test";
		o.phoneNumber = 12345;
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(o); // throws NotSerializableException
		}
	}

	static void deserializeObject() throws IOException, ClassNotFoundException {
		System.out.println("--------deserializeObject--------");
		if (file.exists()) {
			MyObject.message = "message modified before deserialization";
			try (InputStream obs = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) { //throws IOException!
//				Object o = obs.readObject(); // read object method won't be available!
				Object o = ((ObjectInputStream) obs).readObject(); //throws ClassNotFoundException!
				if (o instanceof MyObject) {
					MyObject myObject = (MyObject) o;
					System.out.println(myObject);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serializeObject();
		deserializeObject();
	}

}

class MyObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5813668402609932719L;
	String name;
	int age;
	volatile int phoneNumber;
	static String message;

	public MyObject() { // won't be executed on deserialization
		System.out.println("Default constructor invoked"); 
	}

	public MyObject(String name, int age) { // won't be executed on deserialization
		super();
		this.name = name;
		this.age = age;
		System.out.println("Parameterized constructor invoked");
	}

	@Override
	public String toString() {
		return "MyObject [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", message=" + message
				+ "]";
	}

}
