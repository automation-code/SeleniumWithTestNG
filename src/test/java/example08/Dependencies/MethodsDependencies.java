package example08.Dependencies;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class MethodsDependencies {

	@Test
	public void createTicket() {
		System.out.println("User is create the ticket");
	}
	
	@Test(dependsOnMethods = {"createTicket"})
	public void assignTicket() {
		System.out.println("Ticket assign on agent");
	}

	@Test(dependsOnMethods = {"assignTicket"})
	public void workingOnTicket() {
		System.out.println("Agent working on ticket");
	}

	@Test(dependsOnMethods = {"assignTicket", "workingOnTicket"})
	public void closeTicket() {
		System.out.println("Ticket has been closed");
	}
}
