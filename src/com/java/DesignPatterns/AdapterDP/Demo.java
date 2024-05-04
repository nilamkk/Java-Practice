package com.java.DesignPatterns.AdapterDP;

import java.util.*;

// PPS Client Purchase Requisition Data
class PurchaseReqnPPSData{
	private int purchaseReqn;
	private String supplier;
	private String purchasingOrg;
	
	public PurchaseReqnPPSData(int purchaseReqn, String supplier, String purchasingOrg) {
		this.purchaseReqn = purchaseReqn;
		this.supplier = supplier;
		this.purchasingOrg = purchasingOrg;
	}
	
	public int getPurchaseReqn() {
		return purchaseReqn;
	}

	public void setPurchaseReqn(int purchaseReqn) {
		this.purchaseReqn = purchaseReqn;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getPurchasingOrg() {
		return purchasingOrg;
	}

	public void setPurchasingOrg(String purchasingOrg) {
		this.purchasingOrg = purchasingOrg;
	}	
}

// Client interface
interface PurchaseReqnPPSDataProcessing{
	List<String> validatePurchaseReqnData( PurchaseReqnPPSData prData );
	void savePurchaseReqnData(PurchaseReqnPPSData prData);
}

// Standard PR data/ Legacy data
class PurchaseReqnStandardData{
	private int banfn;
	private String lifnr;
	private String ekorg;
	
	public PurchaseReqnStandardData(int banfn, String lifnr, String ekorg) {
		this.banfn = banfn;
		this.lifnr = lifnr;
		this.ekorg = ekorg;
	}
	
	public int getBanfn() {
		return banfn;
	}

	public void setBanfn(int banfn) {
		this.banfn = banfn;
	}

	public String getLifnr() {
		return lifnr;
	}

	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}

	public String getEkorg() {
		return ekorg;
	}

	public void setEkorg(String ekorg) {
		this.ekorg = ekorg;
	}
}


// Standard PR data Processing/ Legacy data processing -- Adaptee
class PurchaseReqnStandardDataProcessing{

	private boolean validateLifnr(String lifnr) {
		return lifnr.length() == 4;
	}
	
	private boolean validateEkorg(String ekorg) {
		return ekorg.length() == 4;
	}
	
	private boolean validateBanfn(int banfn) {
		return banfn > 0;
	}
	
	public void saveData(PurchaseReqnStandardData standardPR) {
		System.out.println("Saving the data in DB - ");
		System.out.println( standardPR.getBanfn() + " "+ standardPR.getLifnr() + " "+ standardPR.getEkorg());
	}
	
	public List<String> validatePurchaseReqnData(PurchaseReqnStandardData standardPR){
		List<String> errorMessages = new ArrayList<String>();
		
		if( !this.validateBanfn(standardPR.getBanfn()) ) {
			errorMessages.add("Invalid banfn");
		}
		
		if( !this.validateLifnr(standardPR.getLifnr()) ) {
			errorMessages.add("Invalid lifnr");
		}
		
		if( !this.validateEkorg(standardPR.getEkorg()) ) {
			errorMessages.add("Invalid ekorg");
		}
		
		return errorMessages;
	}
	
}

// Adapter
class PurchaseReqnStandardAdapter implements PurchaseReqnPPSDataProcessing{
	
	private PurchaseReqnStandardDataProcessing standardPRDataProcessing;
	
	// For mapping standard message to PPS message
	private Map<String, String> msgMapping;
	
	public PurchaseReqnStandardAdapter(){
		msgMapping = new HashMap<String, String>();
		
		msgMapping.put( "Invalid banfn", "Invalid Purchase Requisition Number");
		msgMapping.put( "Invalid lifnr", "Invalid Supplier");
		msgMapping.put( "Invalid ekorg", "Invalid Purchasing Organization");
		
		this.standardPRDataProcessing = new PurchaseReqnStandardDataProcessing();
	}
	
	private PurchaseReqnStandardData convertPPStoStandard(PurchaseReqnPPSData prData) {
		return new PurchaseReqnStandardData(prData.getPurchaseReqn(), prData.getSupplier(), prData.getPurchasingOrg());
	}
	
	private List<String> mapMessage(List<String> standardMsgs){
		List<String> ppsMsg = new ArrayList<String>();
		for(int i=0; i< standardMsgs.size(); i++) {
			String standardMsg = standardMsgs.get(i);
			ppsMsg.add( this.msgMapping.get(standardMsg) );
		}
		return ppsMsg;
	}

	@Override
	public List<String> validatePurchaseReqnData(PurchaseReqnPPSData prData) {
		
		PurchaseReqnStandardData standardPr = this.convertPPStoStandard(prData);
		
		List<String> stdErrMsgs = this.standardPRDataProcessing.validatePurchaseReqnData(standardPr);
		
		List<String> ppsErrMsgs = this.mapMessage(stdErrMsgs);

		return ppsErrMsgs;
	}

	@Override
	public void savePurchaseReqnData(PurchaseReqnPPSData prData) {
		PurchaseReqnStandardData standardPr =  this.convertPPStoStandard(prData);
		this.standardPRDataProcessing.saveData(standardPr);
	}
	
}



public class Demo {

	public static void main(String[] args) {
		
		// PPS Client - somewhere in the code
		PurchaseReqnPPSData ppsPrData = new PurchaseReqnPPSData(1000453, "PS02", "0001");
		
		// Standard
		PurchaseReqnStandardDataProcessing stdPrProcess = new PurchaseReqnStandardDataProcessing();
		// stdPrProcess.validatePurchaseReqnData(ppsPrData); --> client wants this but not possible so using adapter
		// stdPrProcess.saveData(ppsPrData); --> client wants this but not possible so using adapter
		
		// PurchaseReqnStandardData stdPrData = new PurchaseReqnStandardData(1000453, "PS02", "0001"); --> client don't want this
		// stdPrProcess.validatePurchaseReqnData(stdPrData); --> client don't want this
		
		
		// So we are using the Adapter
		PurchaseReqnPPSDataProcessing ppsPRProcess = new PurchaseReqnStandardAdapter();
		
		List<String> errMsgs = ppsPRProcess.validatePurchaseReqnData(ppsPrData);
		
		if( errMsgs.size() == 0) {
			System.out.println("All is well!");
			ppsPRProcess.savePurchaseReqnData(ppsPrData);			
		}

		
		
		
		// Testing standard class
		PurchaseReqnStandardData stdPrDataTest = new PurchaseReqnStandardData(1000453, "PS021", "00012"); 
		List<String> testStdMsgs = stdPrProcess.validatePurchaseReqnData(stdPrDataTest);
		System.out.println(testStdMsgs);
		
		// Testing PPS class
		PurchaseReqnPPSData ppsPrDataTest = new PurchaseReqnPPSData(1000453, "PS021", "00012");
		List<String> testPPSMsgs = ppsPRProcess.validatePurchaseReqnData(ppsPrDataTest);
		System.out.println(testPPSMsgs);
	}

}
