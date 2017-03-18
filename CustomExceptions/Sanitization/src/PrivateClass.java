public class PrivateClass {
		private String classC;
		public PrivateClass (String description){
			setClassName(description);		
		}
		public String getClassName() {
			return classC;
		}

		public void setClassName(String description) {
			this.classC = description;
		}

}
