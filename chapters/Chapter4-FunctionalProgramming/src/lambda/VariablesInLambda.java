package lambda;

import java.util.function.UnaryOperator;

public class VariablesInLambda {

	private String instanceVar = "123";

	public VariablesInLambda() {
		boolean localBoolean = false;
		String ss = "123";
		UnaryOperator<String> s1 = (s) -> instanceVar;
		UnaryOperator<String> s2 = (s) -> localBoolean ? instanceVar : ss;
//		UnaryOperator<String> s3 = (ss) -> ""; // DOES NOT COMPILE, cannot use ss as variable name since it is used as local variable name 
		UnaryOperator<String> s4 = (s) -> ss;
//		ss = ""; Above reference to ss will not compile.
	}

	public static void main(String[] args) {

		new VariablesInLambda();
	}
}
