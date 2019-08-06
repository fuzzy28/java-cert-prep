package console;

import java.io.Console;
import java.time.LocalDate;

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
			c.printf("Terminating process at %s...", LocalDate.now().toString());
			c.format("Goodbye %s", name);
		} else {
			System.out.println("Console is not available!");
		}
	}

	public static void main(String[] args) {
		interact();
	}
}
