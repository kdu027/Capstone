public class PrivateClass {
		private String description;
		public PrivateClass (String description){
			this.description = description;		
		}
		public String getClassName() {
			return this.description;
		}

		public void setClassName(String description) {
			this.description = description;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof PrivateClass)) { //allow obj to be a subclass of privateclass
				return false;
			}
			PrivateClass other = (PrivateClass) obj;
			if (description == null) {
				if (other.description != null) {
					return false;
				}
			} else if (!description.equals(other.description)) {
				return false;
			}
			return true;
		}
	    
//	    @Override
//	    public boolean equals(Object o) {
//	        return true;
//	        
//	    }
//	    
//	    @Override
//	    public int hashCode() {
//	        return getClassName().hashCode();
//	    }

		
}
