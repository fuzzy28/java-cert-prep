package importstatement;

//import static importstatement.Importstatements2.*; //CAN USE ALL STATIC FROM THIS CLASS
import static importstatement.Importstatements2.staticVoid1;
import static importstatement.Importstatements2.staticVoid2;
import static importstatement.Importstatements2.staticAttribute;

public class Importstatement {

	public static void main(String[] args) {
		staticAttribute = "123";
		staticVoid1();
		staticVoid2();
	}
}
