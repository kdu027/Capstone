import java.util.ArrayList;

import org.junit.Test;

public class BackableEncapsulator{
	private PrivacyMechanismInterface <Double> pdi = new SanitizeDesanitize();
//	private SanitizeDesanitize pdi = new SanitizeDesanitize();
	private ArrayList<Double> mData = new ArrayList<Double>();
	// what is dataID
	public BackableEncapsulator(Double dataID, PrivacyMechanismInterface<Double> pdi){
		this.pdi = pdi;		
	}
	public void addData(double datapoint) {
		PrivateClass c1 = new PrivateClass("c1");
		addData(datapoint, c1);
	}

	public void addData(double datapoint, PrivateClass c) throws PrivacyMechanismException {
		double data = this.pdi.Sanitize(c, datapoint);
		mData.add(data);
	}

	public double getData(int dataIndex) {
		PrivateClass c1 = new PrivateClass("c1");
		return getData(dataIndex, c1);
	}

	public double getData(int dataIndex, PrivateClass c) throws PrivacyMechanismException {

		double data = mData.get(dataIndex);
		return this.pdi.Desanitize(c, data);
	}
	public void pringData(int Index) {
		System.out.println( mData.get(Index));
	}
	
	@Test
    public void test(){
		SanitizeDesanitize pdi = new SanitizeDesanitize();
		BackableEncapsulator t1 = new BackableEncapsulator(1.2, pdi);
		PrivateClass c1 = new PrivateClass("c1");
		PrivateClass c2 = new PrivateClass("c2");
		PrivateClass c3 = new PrivateClass("c3");
		t1.addData(1.0);
		t1.pringData(0);
		t1.addData(2.0, c1);
		t1.pringData(1);
		t1.addData(3.0, c3);
		t1.pringData(2);
		System.out.println(t1.getData(0, c1));
		System.out.println(t1.getData(1, c2));
		System.out.println(t1.getData(2, c3));
	}
}