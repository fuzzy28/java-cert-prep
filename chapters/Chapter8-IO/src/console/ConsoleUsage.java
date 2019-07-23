package console;

import java.io.Console;

public class ConsoleUsage {

	static void interact() {
		Console c = System.console();
		if (c != null) {
			c.writer().println("Hello!");
			String name = c.readLine("What's your name?");
			c.writer().println("Oh hello " + name);

			char[] pass;
			boolean result = false;
			do {
				pass = c.readPassword("What's the password?");
				result = String.valueOf(pass).equals("12345");
				if(!result) {
					c.writer().println("Sorry " + name + ", wrong password!");
				}				
			} while (!result);

			c.writer().println("Hello master " + name + "!");
		} else {
			System.out.println("Console is not available!");
		}
	}

	public static void main(String[] args) {
		interact();
	}
}
