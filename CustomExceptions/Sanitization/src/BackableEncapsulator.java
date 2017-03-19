import java.util.ArrayList;



public class BackableEncapsulator {
	private PrivacyMechanismInterface<Double> pdi = new SanitizeDesanitize();
	private ArrayList<Double> mData = new ArrayList<Double>();

	public BackableEncapsulator() {

	}

	// what is dataID
	public BackableEncapsulator(Double dataID, PrivacyMechanismInterface<Double> pdi) {
		this.pdi = pdi;
	}

	public void addData(double datapoint) throws PrivacyMechanismException{
		PrivateClass c1 = new PrivateClass("c1");
		addData(datapoint, c1);
	}

	public void addData(double datapoint, PrivateClass c) throws PrivacyMechanismException, NullPointerException {
		try 
		{
			if(this.pdi.Sanitize(c, datapoint) == null)
			{
				throw new NullPointerException();
			}else{
				double data = this.pdi.Sanitize(c, datapoint);
				mData.add(data);
			}
		} catch(NullPointerException e){
			return;
		}
		
	}

	public Object getData(int dataIndex) throws PrivacyMechanismException{
		PrivateClass c1 = new PrivateClass("c1");
		return getData(dataIndex, c1);
	}

	public Object getData(int dataIndex, PrivateClass c) throws PrivacyMechanismException, NullPointerException {
		try 
		{
	
				double data = mData.get(dataIndex);
				if(	this.pdi.Desanitize(c, data) == null){
						throw new NullPointerException();
				}else{	
					return this.pdi.Desanitize(c, data);
				}
		} catch(NullPointerException f){
			return null;
	}
	}
}