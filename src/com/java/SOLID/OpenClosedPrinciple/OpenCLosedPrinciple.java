package com.java.SOLID.OpenClosedPrinciple;

class Invoice{
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////
// This one is a bad example /////////////////////////////////// ////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
class InvoiceDao{
	private Invoice invoice;
	public InvoiceDao(Invoice invoice) {
		this.setInvoice(invoice);
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	// Method to save invoice in DB
	public void saveToDB() {
		// this method saves invoice to DB
	}
	// Now in future, if any new requirement comes to save the invoice in some other type of db 
	// then we will  have to make changes in this class only.
	// Violating Open-Closed principle
	// Method to save invoice in File
	public void saveToFile() {
		// this method saves invoice to File
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////
// This one is a good example following open closed principle ///////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
interface InvoiceDaoInterface {
	void save(Invoice invoice);
}

// Implementing that interface 
class DatabaseInvoiceDao implements InvoiceDaoInterface{
	@Override
	public void save(Invoice invoice) {
		// saves to DB
	}
}

class FileInvoiceDao implements InvoiceDaoInterface{

	@Override
	public void save(Invoice invoice) {
		// saves to file
	}
}
// So in future if any new requirement comes then we can extend instead of just changing the already perfect class
// The second example follows Open Closed principle


public class OpenCLosedPrinciple {

	public static void main(String[] args) {

	}

}
