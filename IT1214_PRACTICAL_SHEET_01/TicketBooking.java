import java.util.*;
class Ticket
{
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) 
	{
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() 
	{
        return ticketNumber;
    }

    public String getCustomerName() 
	{
        return customerName;
    }

    public int getSeatNumber() 
	{
        return seatNumber;
    }

    
    public String toString() 
	{
        return "Ticket #" + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
    }
}

class BookingSystem 
{
    private Ticket[] tickets;
    private int ticketCount;

    public BookingSystem() 
	{
        tickets = new Ticket[10]; 
        ticketCount = 0;
    }

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) 
	{
        if (seatNumber < 1 || seatNumber > 10) 
		{
            System.out.println("Invalid seat number. Must be between 1 and 10.");
            return;
        }

        if (isSeatTaken(seatNumber)) 
		{
            System.out.println("Seat " + seatNumber + " is already booked.");
            return;
        }

        if (ticketCount >= tickets.length) 
		{
            System.out.println("All tickets are booked.");
            return;
        }

        tickets[ticketCount++] = new Ticket(ticketNumber, customerName, seatNumber);
        System.out.println("Ticket booked successfully for " + customerName + " at seat " + seatNumber);
    }

    public void cancelTicket(int ticketNumber) 
	{
        boolean found = false;
        for (int i = 0; i < ticketCount; i++) 
		{
            if (tickets[i].getTicketNumber() == ticketNumber) 
			{
                for (int j = i; j < ticketCount - 1; j++) 
				{
                    tickets[j] = tickets[j + 1];
                }
                tickets[--ticketCount] = null;
                found = true;
                System.out.println("Ticket #" + ticketNumber + " cancelled.");
                break;
            }
        }
        if (!found) 
		{
            System.out.println("Ticket #" + ticketNumber + " not found.");
        }
    }

    private boolean isSeatTaken(int seatNumber) 
	{
        for (int i = 0; i < ticketCount; i++) 
		{
            if (tickets[i].getSeatNumber() == seatNumber) 
			{
                return true;
            }
        }
        return false;
    }

    public void displayBookings() 
	{
        System.out.println("Current Bookings:");
        for (int i = 0; i < ticketCount; i++)
			{
            System.out.println(tickets[i]);
        }
        if (ticketCount == 0)
			{
            System.out.println("No bookings available.");
        }
    }
}

class Main 
{
    public static void main(String[] args) 
	{
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Carol", 3);

        
        system.cancelTicket(2);

        
        system.bookTicket(4, "David", 2);

        
        system.displayBookings();
    }
}