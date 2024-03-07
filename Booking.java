package ticketbooking;
import java.util.*;

public class Booking {
	
	public static void book(Flight currentFlight, int tickets, int passengerID) {
		String passengerDetail=" ";
		passengerDetail = "PassengerID" +passengerID +" --" +" Number of Tickets booked " +tickets + " --" + "Total cost "+ currentFlight.price*tickets;
		
		currentFlight.addPassengerDetails(passengerDetail, tickets, passengerID);
		currentFlight.flightSummary();
		currentFlight.printDetails();
	}
	
	public static void cancel(Flight currentFlight, int passengerID) {
		
		currentFlight.cancelTicket(passengerID);
		currentFlight.flightSummary();
		currentFlight.printDetails();
	}
	
	public static void print(Flight f) {
		f.printDetails();
	}


	public static void main(String[] args) {
		
		//creating an ArrayList to store instances of the Flight class
		ArrayList<Flight>flights = new ArrayList<Flight>();
		
		//creating 2 flights as id:1 and id:2
		for(int i=0; i<2; i++) {
			flights.add(new Flight());
		}
		
		//unique ID for passenger alloted at every booking
		int passengerID = 1;
		
		// the while(true) loop is used to repeatedly display a menu and take user input for different actions
		while(true) {
			System.out.println("1.Book  2.Cancel  3.Print");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
			{
				System.out.println("Enter Flight ID: ");
				int fid = sc.nextInt();
				
				if(fid > flights.size()) {
					System.out.println("Invalid flight ID");
					break;
				}
				
				Flight currentFlight = null;
				for(Flight f : flights) {
					if(f.flightID==fid) {
						currentFlight = f;
						f.flightSummary();
						break;
					}
				}
				System.out.println("Enter number of tickets: ");
				int t=sc.nextInt();
				
				if(t>currentFlight.tickets) {
					System.out.println("Not enough tickets");
					break;
				}
				book(currentFlight,t,passengerID);
				
				passengerID= passengerID+1;
				break;
			}
			
			case 2:
			{
				System.out.println("Enter Flight ID: ");
				int fid= sc.nextInt();
				
				if(fid > flights.size()) {
					System.out.println("Invalid flight ID");
					break;
				}
				Flight currentFlight = null;
				for(Flight f : flights) {
					if(f.flightID==fid) {
						currentFlight = f;
						f.flightSummary();
						break;
					}
				}
				int id= sc.nextInt();
				
				cancel(currentFlight, id);
				break;
			}
			
			
			case 3:
			{
			
				for(Flight f: flights) {
					if(f.passengerDetails.size()==0) {
						System.out.println("No passenger details for Flight "+ f.flightID);
					}
					else 
						print(f);
					}
					break;
					
				}
				default:
				{
					break;
				}
			}
		}
	}
}
				
			
		
	

