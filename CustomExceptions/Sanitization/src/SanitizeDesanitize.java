

public class SanitizeDesanitize implements PrivacyMechanismInterface<Double> {
	private PrivateClass classC1 = new PrivateClass("c1");
	private PrivateClass classC2 = new PrivateClass("c2");
	
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
				return null;
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
			return null;
		}	
	}
}
