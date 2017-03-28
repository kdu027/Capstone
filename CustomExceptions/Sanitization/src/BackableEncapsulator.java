import java.util.ArrayList;
public class BackableEncapsulator {
	private PrivacyMechanismInterface<Double> pdi = new SanitizeDesanitize();
	private ArrayList<Double> mData = new ArrayList<Double>();
	private static int globalUserSerial = 0; //will change to be long later 
	private static int popIndex = 0;

	public BackableEncapsulator() {

	}

	// what is dataID
	public BackableEncapsulator(Double dataID, PrivacyMechanismInterface<Double> pdi) {
		this.pdi = pdi;
	}

	public int addData(double datapoint) throws PrivacyMechanismException{
		this.mData.add(datapoint);
		int userSerial = this.globalUserSerial;
		(this.globalUserSerial)++;
		return userSerial;
	}

	public int addData(double datapoint, PrivateClass c) throws PrivacyMechanismException{
		int userSerial = this.globalUserSerial;  //why we need to use long? 
		(this.globalUserSerial)++;
		double data = this.pdi.sanitize(c, datapoint);
		this.mData.add(data);
		return userSerial;
	}

	public Double getData(int dataIndex) throws PrivacyMechanismException{
		if (!this.mData.isEmpty()) {
			return this.mData.get(dataIndex);
		} else{
			throw new PrivacyMechanismException("Encapsulator is empty");
		}
	}

	public Double getData(int dataIndex, PrivateClass c) throws PrivacyMechanismException {
		if (!this.mData.isEmpty()) {
			double data = this.mData.get(dataIndex);
			return this.pdi.desanitize(c, data);
		} else{
			throw new PrivacyMechanismException("Encapsulator is empty");
		}
	}
	
	public Double popFirst() throws PrivacyMechanismException {
		if (!this.mData.isEmpty() && this.globalUserSerial != 0 ) {
			Double dataPoint = this.getData(0);
			removeData(dataPoint);
			(this.globalUserSerial)--;
			return dataPoint;
		} else {
			throw new PrivacyMechanismException("Encapsulator is empty");
		}
	}
	
	public Double popFirst(PrivateClass c) throws PrivacyMechanismException {
		if (!this.mData.isEmpty() && this.globalUserSerial != 0) {
			Double dataPoint = this.getData(0);
			removeData(dataPoint);
			(this.globalUserSerial)--;
			return this.pdi.desanitize(c, dataPoint);
		} else {
			throw new PrivacyMechanismException("Encapsulator is empty");
		}
	}
	
	public void removeData(Double dataPoint) throws PrivacyMechanismException {
		if (!this.mData.isEmpty() && this.mData.contains(dataPoint)) {
			this.mData.remove(dataPoint);
		} else {
			throw new PrivacyMechanismException("The serial number doesn't exist.");
		}
	}
	
}