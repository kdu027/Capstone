import java.util.ArrayList;

import org.junit.Test;

public class BackableEncapsulator{
	//How to instantiate an interface? 
	//private PrivacyMechanism <Double> pdi = new PrivacyMechanism();
	private SanitizeDesanitize pdi = new SanitizeDesanitize();
	private ArrayList<Double> mData = new ArrayList<Double>();
	// public BackableEncapsulator(long dataID, PrivacyMechanism pdi){
	// }

	public void addData(double datapoint) {
		addData(datapoint, "c1");
	}

	public void addData(double datapoint, String c) throws PrivacyMechanismException {
		double data = pdi.Sanitize(c, datapoint);
		mData.add(data);
	}

	public double getData(int dataIndex) {
		return getData(dataIndex, "c1");
	}

	public double getData(int dataIndex, String c) throws PrivacyMechanismException {

		double data = mData.get(dataIndex);
		return pdi.Desanitize(c, data);
	}
	public void pringData(int Index) {
		System.out.println( mData.get(Index));
	}
	
	@Test
    public void test (){
		BackableEncapsulator t1 = new BackableEncapsulator();
		t1.addData(1.0);
		t1.pringData(0);
		t1.addData(2.0, "c2");
		t1.pringData(1);
		t1.addData(3.0, "c3");
		t1.pringData(2);
		System.out.println(t1.getData(0, "c1"));
		System.out.println(t1.getData(1, "c2"));
		System.out.println(t1.getData(2, "c3"));
	}
}