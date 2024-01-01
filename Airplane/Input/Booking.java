   
package Input;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Booking extends People {
	    public static int bookingCounter = 1000;
	    public String departure;
	    public String arrival;
	    public int bookingId;
	    public int userFlightNo;
	    public String date;
	    public String[] locations = new String[6];
	    
	    public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                // Process and display the data as per your requirement
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
	    public Booking(String name, String email, String address, char sex, String phone, int age,
		               String departure, int i, int bookingId, int userFlightNo, String date) {
			super(name, email, address, sex, phone, age);
	        this.departure = departure;
	        this.arrival = arrival;
	        this.bookingId = generateBookingId();
	        this.userFlightNo = userFlightNo;
	        this.date = date;
	    }
		

		public String getDeparture() {
			return departure;
		}

		public String getArrival() {
			return arrival;
		}		
		public int getBookingId() {
			return bookingId;
		}

		public int generateBookingId() {
			return ++bookingCounter; 
		}

		public int getUserFlightNo() {
			return userFlightNo;
		}

		public String getDate() {
			return date;
		}
	    Scanner scanner = new Scanner(System.in);

		public void setDateFromInput() {
			while (true) {
				try {
					System.out.print("Enter a date (yyyy-MM-dd): ");
					String inputDate = scanner.nextLine();
	
					// Validate input format
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate date = LocalDate.parse(inputDate, dateFormatter);
	
					// Validate year greater than 2016
					if (date.getYear() < 2016) {
						throw new IllegalArgumentException("Please enter a date after 2016 (yyyy-MM-dd).");
					}
	
					this.date = inputDate;
					break; // Exit loop if input is valid
				} catch (Exception e) {
					System.out.println("Invalid date format or year. Please enter a valid date (yyyy-MM-dd) after 2016.");
				}
			}
		}

	        public void displaylocation()
	        {
	        	locations[0] = "ADDIS ABABA" ;
        		locations[1] = "HAWASSA" ; 
        		locations[2] = "BAHIR DAR" ;
        	   	locations[3] = "DIRE DAWA" ;
        	   	locations[4] = "MEKELLE" ;
        		locations[5] = "ARBA MINCH" ;
				System.out.println("\n");
	            // System.out.println("The locations are:\n  ");
	        	for(int i=0;i<=5;i++){
	                System.out.println( (i+1) + "."+ locations[i] );
	    			}
	        }
	        
	        public void departureinput()
		        {
	        		
		            System.out.print("Your place of depature is:  ");
		            displaylocation();
		            {
		            int input = scanner.nextInt();
		            this.departure = locations[input-1];}
	        }
	        
			public void arrivalinput() {
				try {
					System.out.print("Your place of arrival is: ");
					displaylocation();
					
					int input = scanner.nextInt();
					String selectedArrival = locations[input - 1];
					
					if (selectedArrival.equals(departure)) {
						throw new IllegalArgumentException("Arrival place cannot be the same as departure place. please choose again!");
					}
					
					this.arrival = selectedArrival;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid location selection.");
					scanner.nextLine(); // Consume the invalid input
					arrivalinput(); // Call arrivalinput() again for valid input
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					arrivalinput(); // Call arrivalinput() again for a different arrival place
				}
			}
			
	
	        public void setUserFlightNoFromInput() {
	 
	            while (true) {
	                System.out.print("Enter Your Flight Number: ");
	                if (scanner.hasNextInt()) {
	                    this.userFlightNo = scanner.nextInt();
	                    scanner.nextLine();
	                    break;
	                } else {
	                    System.out.println("Please enter a valid flight number.");
	                    scanner.next();
	                }
	            }
	        }
			@Override
    public String toString() {
        return name +
               "  " + sex +
               " \t " + date +
               " \t " + departure +
			   " \t " + arrival +
               " \t " + userFlightNo +
			   " \t " + phone +
			   "\t " + email +
               "\t " + address;
        
    }

	         public void displayAllValues() {
    try {
        File file = new File("booking_details.txt");
        Scanner scanner = new Scanner(file);

		System.out.print("\n");
        System.out.println("Displaying Booking Details:");

		System.out.println("\nName\tSex\tDate\t\tDeparture\tArrival\t\tFlight No.\tPhone No.\t\tEmail\t\tAddress");
        System.out.println("------\t---\t----\t\t---------\t-------\t\t----------\t---------\t\t-----\t\t-------");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    } catch (IOException e) {
        System.out.println("An error occurred while reading the booking details: " + e.getMessage());
    }
}


	}

