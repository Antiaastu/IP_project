   
package Flight;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Flight {

	    public String flightName;
	    public String seatNo;
	    public String flightOrigin;
	    public String flightDestination;
	    private int seatEconomy;
	    private int seatBusiness;

	    private float fareEconomy;
	    private float fareBusiness;
		private LocalTime departureTime;
		private LocalTime arrivalTime;
	    public int flightNo;
	    public int userFlightNo;
	    public String flightDate;
	    public String[] locations = new String[6];
		public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
	    
	
	public Flight(String flightName, String seatNo, String flightOrgin, String flightDestination,int seatEconomy, 
	int seatBusiness, float fareEconomy, float fareBusiness,float farePremium, int flightNo, int userFlightNo, 
	String flightDate, LocalTime departureTime, LocalTime arrivalTime)  {
this.flightName = flightName;
this.seatNo = seatNo;
this.flightOrigin = flightOrgin;
this.flightDestination = flightDestination;
this.seatEconomy = seatEconomy;
this.seatBusiness = seatBusiness;

this.fareEconomy = fareEconomy;
this.fareBusiness = fareBusiness;

this.flightNo = flightNo;
this.userFlightNo = userFlightNo;
this.flightDate = flightDate;
this.departureTime = departureTime;
this.arrivalTime = arrivalTime;
}

	    Scanner scanner = new Scanner(System.in);
		public void setDepartureTimeFromInput() {
        try {
            System.out.print("Enter Departure Time (HH:mm): ");
            String input = scanner.nextLine();
            departureTime = LocalTime.parse(input);

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid time format. Please enter time in HH:mm format.");
            setDepartureTimeFromInput(); // Ask for input again
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
	public void setArrivalTimeFromInput() {
        try {
            System.out.print("Enter Arrival Time (HH:mm): ");
            String input = scanner.nextLine();
            arrivalTime = LocalTime.parse(input);

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid time format. Please enter time in HH:mm format.");
            setArrivalTimeFromInput(); // Ask for input again
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

		public void setFlightNameFromInput() {
			while (true) {
				try {
					System.out.print("Enter Name of the flight: ");
					String inputFlightName = scanner.nextLine().trim();
		
					if (inputFlightName.matches("[a-zA-Z]+") && inputFlightName.length() >= 2 && inputFlightName.length() <= 30) {
						flightName = inputFlightName;
						break;
					} else {
						System.out.println("Invalid flightName format. Please enter a valid flightName (2-30 characters, only alphabets).");
					}
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
					
				}
			}
		}
		
		public void setSeatNoFromInput() {
			while (true) {
				try {
					System.out.print("Enter the number of seats available in the flight: ");
					String input = scanner.nextLine();
					int seats = Integer.parseInt(input);
					if (seats > 0) {
						seatNo = input;
						break;
					} else {
						System.out.println("Please enter a valid positive number for the number of seats.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid positive number for the number of seats.");
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
					
				}
			}
		}
		
		
	            

	       
	        public void setflightDateFromInput() {
	            
	        	while (true) {
				try {
					System.out.print("Enter a date (yyyy-MM-dd): ");
					String inputflightDate = scanner.nextLine();
	
					// Validate input format
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate date = LocalDate.parse(inputflightDate, dateFormatter);
	
					// Validate year greater than 2016
					if (date.getYear() < 2016) {
						throw new IllegalArgumentException("Please enter a date after 2016 (yyyy-MM-dd).");
					}
	
					this.flightDate=inputflightDate;
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
	        	for(int i=0;i<=5;i++){
	                System.out.println((i+1) + "."+ locations[i] );
	    			}
	        }
	        
	       public void setFlightOriginInput() {
    try {
        System.out.println("The Origin of the Flight is: ");
        displaylocation();

        int input = scanner.nextInt();

        if (input >= 1 && input <= locations.length) {
            this.flightOrigin = locations[input - 1];
        } else {
            System.out.println("Invalid input. Please enter a valid location number.");
            setFlightOriginInput(); // Ask for input again
            return;
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input type. Please enter a valid location number.");
        scanner.nextLine(); // Clear the input buffer
        setFlightOriginInput(); // Ask for input again
        return;
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}

	        
public void setFlightDestinationInput() {
    try {
        System.out.println("The Destination of the Flight is: ");
        displaylocation();

        int input = scanner.nextInt();

        if (input >= 1 && input <= locations.length) {
            this.flightDestination = locations[input - 1];
        } else {
            System.out.println("Invalid input. Please enter a valid location number.");
            setFlightDestinationInput(); // Ask for input again
            return;
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input type. Please enter a valid location number.");
        scanner.nextLine(); // Clear the input buffer
        setFlightDestinationInput(); // Ask for input again
        return;
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
   
    }
}

	        	
	        public void setflightNoFromInput() {
	            while (true) {
	                System.out.print("Enter the fight Number: ");
	                if (scanner.hasNextInt()) {
	                    this.flightNo = scanner.nextInt();
	                    break;
	                } else {
	                    System.out.println("Please enter a valid flightNo number.");
	                    scanner.next(); 
	                }
	            }
	        }

	      

	        
	        public void businessFareFromInput() {
	        System.out.print("Enter fare for business class: ");
	        float businessFare = scanner.nextFloat();
	        this.fareBusiness=businessFare;
	        }
	        public void fareEconomyFromInput() {
		        System.out.print("Enter fare for Economy class: ");
		        float fareEconomy = scanner.nextFloat();
		        this.fareEconomy= fareEconomy;
		        }
	        
	        public void seatBusinessFromInput() {
	        System.out.print("Enter number of business seats: ");
	        int seatBusiness = scanner.nextInt();
	        this.seatBusiness= seatBusiness;
	        scanner.nextLine();
	   
	        }
	        public void seatEconomyFromInput() {
		        System.out.print("Enter number of economy seats: ");
		        int seatEconomy = scanner.nextInt();
		        this.seatEconomy= seatEconomy;
		        scanner.nextLine();
		   
		        }
				@Override
    public String toString() {
        return  flightName +
               "\t " + seatNo +
               "\t" + flightOrigin +
               "\t " + flightDestination +
               "\t" + flightNo +
               "\t" + flightDate +
               "\t" + fareBusiness +
               "\t\t" + fareEconomy +
               "\t" + seatBusiness +
               "\t" + seatEconomy +
			   "\t" + departureTime +
			   "\t" + arrivalTime;
        
    }
	public void displayAllValues() {
		try {
			File f = new File("flight_details.txt");
			Scanner scanner = new Scanner(f);
	
			System.out.println("\nDisplaying Flight Details:");
			System.out.println("F.Name  Seat.No\tOrigin\t\tDestin.    Flight.No\tDate\t\tBusi.Fare   Eco.Fare   B.Seats   E.Seats   Depart.Time   Arriv.Time");
			System.out.println("------  -------\t------\t\t-------    ---------\t----\t\t---------   --------   -------   -------   ------------  ----------");
			while (scanner.hasNextLine()) {
				String l = scanner.nextLine();
					System.out.println(l);
				}
				scanner.close();
				
			}
	
			
		 catch (IOException e) {
			System.out.println("An error occurred while reading the flight details: " + e.getMessage());
		}
	}
	

	public boolean isEmpty() {
		
		return (flightName == null && seatNo == null /* Add similar checks for other fields */);
	}
	


	}

