import org.junit.Test;

public class SanitizeDesanitize implements PrivacyMechanismInterface<Double> {
	private PrivateClass classC1 = new PrivateClass("c1");
	private PrivateClass classC2 = new PrivateClass("c1");
	
	public Double Sanitize(PrivateClass c, Double original) throws PrivacyMechanismException {
			try {
				//System.out.println(c.equals(classC1));
				if (c.getClassName().equals(classC1.getClassName())) {
					return 2 * original;
				} else if (c.getClassName().equals(classC2.getClassName())){
					return -2 * original;
				} else {
					throw new PrivacyMechanismException();
				}
			} catch (PrivacyMechanismException i) {
				System.out.println("Error! Your choice is not in the list");
				return original;
			}
	}

	public Double Desanitize(PrivateClass c, Double sanitized) throws PrivacyMechanismException {
		try {
			if (c.getClassName().equals(classC1.getClassName())) {
				return 1.0/2 * sanitized;
			} else if (c.getClassName().equals(classC2.getClassName())){
				return -1.0/2 * sanitized;
			} else {
				throw new PrivacyMechanismException();
			}
		} catch (PrivacyMechanismException i) {
			System.out.println("Error! Your choice is not in the list");
			return sanitized;
		}	
	}

	@Test
	public void test() {
		SanitizeDesanitize t1 = new SanitizeDesanitize();
		PrivateClass c1 = new PrivateClass("c1");
		PrivateClass c2 = new PrivateClass("c2");
		PrivateClass c3 = new PrivateClass("c3");
		double t1_Sanitize = t1.Sanitize(c1, 2.0);
		System.out.println(t1_Sanitize);
		double t1_Desanitize = t1.Desanitize(c1, t1_Sanitize);
		System.out.println(t1_Desanitize);
		System.out.println(t1.Sanitize(c2, 2.0));
		System.out.println(t1.Sanitize(c3, 2.0));

	}
}
