
public interface PrivacyMechanism <T>{
	public T Sanitize(String c, T original);
	public T Desanitize(String c, T sanitized);
}
