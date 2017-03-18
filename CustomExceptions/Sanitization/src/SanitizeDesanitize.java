import java.util.Scanner;
import org.junit.Test;

public class SanitizeDesanitize implements PrivacyMechanism<Double> {
	private PrivateClass classC1 = new PrivateClass("c1");
	private PrivateClass classC2 = new PrivateClass("c2");
	public Double Sanitize(PrivateClass c, Double original) throws PrivacyMechanismException {
			try {
				if (classC.contains(c)) {
					if (c.equals(classC.getter(0))) {
						return 2 * original;
					} else {
						return -2 * original;
					}
				} else {
					throw new PrivacyMechanismException();
				}
			} catch (PrivacyMechanismException i) {
				System.out.println("Error! Your choice is not in the list");
				System.out.println("Enter your choice: ");
				Scanner scanner = new Scanner(System.in); // how can I close
															// scanner?
				c = scanner.nextLine(); // Should I return anything if I put
										// this code outside of this method?
			}
	}

	public Double Desanitize(String c, Double sanitized) throws PrivacyMechanismException {
		classC.setter("c1");
		classC.setter("c2");
		do {
			try {
				if (classC.contains(c)) {
					if (c.equals(classC.getter(0))) {
						return (1.0 / 2) * sanitized;
					} else {
						return (-1.0 / 2) * sanitized;
					}
				} else {
					throw new PrivacyMechanismException();
				}
			} catch (PrivacyMechanismException i) {
				System.out.println("Error! Your choice is not in the list(c1 or c2)");
				System.out.println("Enter your choice: ");
				Scanner scanner = new Scanner(System.in);
				c = scanner.nextLine();
			}
		} while (true);
	}

	@Test
	public void test() {
		SanitizeDesanitize t1 = new SanitizeDesanitize();
		String category = "c1";
		double t1_Sanitize = t1.Sanitize(category, 2.0);
		System.out.println(t1_Sanitize);
		double t1_Desanitize = t1.Desanitize(category, t1_Sanitize);
		System.out.println(t1_Desanitize);
		System.out.println(t1.Sanitize("c2", 2.0));
		System.out.println(t1.Sanitize("c", 2.0));

	}
}
