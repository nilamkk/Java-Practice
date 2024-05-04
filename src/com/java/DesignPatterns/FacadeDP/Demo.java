package com.java.DesignPatterns.FacadeDP;

class User{
	String name;
	String email;
	String phoneNumber;
	
	public User(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}

class TicketSystem{
	public boolean validateAvailability(String movie) {
		if(movie.equals(""))
			return false;
		return true;
	}
	public int createTicket(String movie, String theatre) {
		return 100;
	}
}

class PaymentSystem{
	public void chargeCard() {
		System.out.println("Payment successful!");
	}
}

class NotificationSystem{
	public void sendEmail(int ticketNumber, String email, String movie) {
		System.out.println("Ticket booked for movie - "+ movie);
		System.out.println("Ticket number - "+ ticketNumber);
		System.out.println("Email sent to - " + email);
	}
}

class BookingFacade{
	public void createBooking(User user) {
		TicketSystem ts = new TicketSystem();
		PaymentSystem ps = new PaymentSystem();
		NotificationSystem ns = new NotificationSystem();
		
		if( ts.validateAvailability("Migration") ) {
			int ticketNumber = ts.createTicket("Migration", "PVR MG Road");
			ps.chargeCard();
			ns.sendEmail(ticketNumber, user.email, "Migration");
		}	
	}
}


public class Demo {

	public static void main(String[] args) {
		
		User user = new User("Zenny", "zenny@cmail.sum", "9876543210");
		
		// Instead of client doing the things, Facade will do everything
		BookingFacade boFa = new BookingFacade();
		boFa.createBooking(user);

	}

}
