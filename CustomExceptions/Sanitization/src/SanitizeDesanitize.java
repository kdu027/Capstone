

public class SanitizeDesanitize implements PrivacyMechanismInterface<Double> {
	private PrivateClass classC1 = new PrivateClass("c1");
	private PrivateClass classC2 = new PrivateClass("c2");
	
	public Double sanitize(PrivateClass c, Double original) throws PrivacyMechanismException {
			
				//System.out.println(c.equals(classC1));
				if (c.equals(classC1)) {
					return 2 * original;
				} else if (c.equals(classC2)){
					return -2 * original;
				} else {
					throw new PrivacyMechanismException("Error! Your choice is not in the list");
				}
	}

	public Double desanitize(PrivateClass c, Double sanitized) throws PrivacyMechanismException {
		
			if (c.equals(classC1)) { //Update
				return 1.0/2 * sanitized;
			} else if (c.equals(classC2)){
				return -1.0/2 * sanitized;
			} else {
				throw new PrivacyMechanismException("Error! Your choice is not in the list");
			}	
	}
}
