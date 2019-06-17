package enumsswitch;

public class SwitchTest {

	public static void main(String[] args) {

		int i = 20;

		switch (i) {
		case 1:
//		case i: // NOT FINAL
		default: {
			System.out.println("Default message");
		}
		case 22: {

		}
		case 23:
			System.out.println("23");
		case 24:
			System.out.println("24");
		}
	}
}
