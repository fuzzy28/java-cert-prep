package generics;

public class SampleGenerics {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		GenericClass<String> genericClass1 = new GenericClass<>();
		genericClass1.setVariable1("First name");
		genericClass1.setVariable2("Last name");
		System.out.println(genericClass1);

		GenericClass2<Integer, String> genericClass2 = new GenericClass2<>();
		genericClass2.setVariable1(1);
		genericClass2.setVariable2(2);
		genericClass2.setVariable3("third");
		genericClass2.setVariable4("fourth");
		System.out.println(genericClass2);

		GenericClass rawGenericClass = new GenericClass(); // warnings suppressed!
		rawGenericClass.setVariable1(new SampleGenerics());
		rawGenericClass.setVariable2(new SampleGenerics());
		System.out.println(rawGenericClass);

		GenericClass<?> gc = new GenericClass<String>(); // if wildcard(?), right hand can be of any type

	}

}

class GenericClass<T> {

	T variable1;
	T variable2;

	public T getVariable1() {
		return variable1;
	}

	public void setVariable1(T variable1) {
		this.variable1 = variable1;
	}

	public T getVariable2() {
		return variable2;
	}

	public void setVariable2(T variable2) {
		this.variable2 = variable2;
	}

	@Override
	public String toString() {
		return "GenericClass [variable1=" + variable1 + ", variable2=" + variable2 + "]";
	}

}

class GenericClass2<T, U> extends GenericClass<T> {

	U variable3;
	U variable4;

	public U getVariable3() {
		return variable3;
	}

	public void setVariable3(U variable3) {
		this.variable3 = variable3;
	}

	public U getVariable4() {
		return variable4;
	}

	public void setVariable4(U variable4) {
		this.variable4 = variable4;
	}

	@Override
	public String toString() {
		return "GenericClass2 [variable3=" + variable3 + ", variable4=" + variable4 + ", variable1=" + variable1
				+ ", variable2=" + variable2 + "]";
	}

}