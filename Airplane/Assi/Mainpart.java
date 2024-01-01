package Assi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Input.Employee;
import Flight.Flight;
import Input.Booking;

public class Mainpart {
    
    public static void writeToFile(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(data + "\n");
            // System.out.println("Data written to " + filename + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t      //////////////     //////////////     //          //");
        System.out.println("\t\t\t      //                       //           //          //");
        System.out.println("\t\t\t      //                       //           //          //");
        System.out.println("\t\t\t      //                       //           //          //");
        System.out.println("\t\t\t      //////////////           //           //////////////");
        System.out.println("\t\t\t      //                       //           //          //");
        System.out.println("\t\t\t      //                       //           //          //");
        System.out.println("\t\t\t      //                       //           //          //");
        System.out.println("\t\t\t      //////////////           //           //          //");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\t\t\t                            //////////////////////////");
        System.out.println("\t\t\t                           //  YEAR-III SEMESTER-I //");
        System.out.println("\t\t\t                          ///////////////////////////");
        System.out.println("\n\n");
        System.out.println("\t\t\t                    //////////////////////////////////////");
        System.out.println("\t\t\t                   //   AIRLINE RESERVATION SYSTEM     //");
        System.out.println("\t\t\t                  //////////////////////////////////////");
        System.out.println("\n");
        System.out.println("\t\t\t                        Press Enter to Continue .....");
        new Scanner(System.in).nextLine();
        clearConsole();
        
        int choice;
        do {
            System.out.println("\n");
            System.out.println("\t\t\t               Welcome to ETHIOPEAN AIRLINE SERVICES   \n");
            System.out.println("1. Booking(Customer)");
            System.out.println("2. Flight");
            System.out.println("3. Employee");
            System.out.println("4. Available flights");
            System.out.println("5. Passenger list");
            System.out.println("6. Payment");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            try{
            choice = scanner.nextInt();
            scanner.nextLine(); 
            clearConsole();

            switch (choice) {
                case 1:
                    System.out.println("You are in the booking section.");
                    Booking booking = new Booking("", "", "", ' ', "", '\0', "", 0, 0,  0, ""); 

                    booking.setNameFromInput();
                    booking.setEmailFromInput();
                    
                    booking.setAddressFromInput();
                    booking.setSexFromInput();
                    booking.setDateFromInput();
                    booking.departureinput();
                    booking.arrivalinput();
                    booking.setAgeFromInput();
                    booking.setUserFlightNoFromInput();
                    booking.setPhoneFromInput();
                   
                    
                    System.out.println("\nEntered Details:");
                    System.out.println("\nName\tSex\tDate\t\tDeparture\t\tArrival\t\tFlight No.\tPhone No.\t\tEmail\t\tAddress");
                    System.out.println("------\t---\t----\t\t---------\t\t-------\t\t----------\t---------\t\t-----\t\t-------");
                    System.out.println(booking.name+"\t"+booking.sex+"\t"+booking.date+"\t"+booking.departure +"\t\t"+booking.arrival +"\t\t"+booking.userFlightNo +"\t\t"+booking.phone + "\t\t"+booking.email+"\t"+booking.address);
                     writeToFile("booking_details.txt", booking.toString());
                     System.out.println("\n");
                    
                    //   booking.displayAllValues();
                    // booking.readFromFile("booking_details.txt");
                    break;
                    
                case 2:
                    String password = "Group3";
                    int maxAttempts = 3;
                    int attempts = 0;
            
                    while (attempts < maxAttempts) {
                        System.out.print("Enter password to access flight: ");
                        String enteredPassword = scanner.nextLine();
                        if (enteredPassword.equals(password)) {
                            System.out.println("Access granted. You are now in the flight section.");
                          
                            Flight flight = new Flight(null, null, null, null, 0, 0, 0.0f, 0.0f, 0.0f, 0, 0, "",null,null);
            
                            flight.setFlightNameFromInput();
                            flight.setSeatNoFromInput();
                            flight.setFlightOriginInput();
                            flight.setFlightDestinationInput();
                            flight.setflightNoFromInput();
                            flight.businessFareFromInput();
                            flight.fareEconomyFromInput();
                            flight.seatBusinessFromInput();
                            flight.seatEconomyFromInput();
                            flight.setflightDateFromInput();
                            flight.setDepartureTimeFromInput();
                            flight.setArrivalTimeFromInput();
                            
                            flight.displayAllValues();
                            writeToFile("flight_details.txt", flight.toString());
                           
                            //flight.readFromFile("flight_details.txt");
                            break;
                        } else {
                            attempts++;
                            int remainingAttempts = maxAttempts - attempts;
                            if (remainingAttempts > 0) {
                                System.out.println("Incorrect password. You have " + remainingAttempts + " attempt(s) left.");
                            } else {
                                System.out.println("Incorrect password. No attempts remaining. Shutting down...");
                               
                                System.exit(0); 
                            }
                        }
                    }
                    break;

                 case 3:
                 String pass = "Group3";
                    int maxAttempt = 3;
                    int attempt = 0;
            
                    while (attempt < maxAttempt) {
                        System.out.print("Enter password to access Employee: ");
                        String enteredPassword = scanner.nextLine();
                        if (enteredPassword.equals(pass)) {
                            System.out.println("Access granted. You are now in the Employee section.");
                          
                	  Employee employee = new Employee("","", "", ' ', "",0, 0, "", 0);
                	  employee.setEmployeeId();
                	  employee.setNameFromInput();
                      employee.setEmailFromInput();
                      employee.setDepartment();
                       employee.setSalary();
                       employee.setAddressFromInput();
                      employee.setSexFromInput();
                      employee.setPhoneFromInput();
                      employee.setAgeFromInput();                                          
                
                      System.out.println("\nDetails entered:");
                      System.out.println("Person Information:");
                      System.out.println("Employee ID \t Name \t Email \t Depatment\t \t Address \t Sex \t Phone \t Age " );
                      System.out.println(employee.getEmployeeId()+"\t "+ employee.name +"\t "+ employee.email+"\t "+employee.getDepartment()+"\t "+employee.address +"\t "+employee.sex+"\t "+employee.phone+"\t "+employee.age);
                    } else {
                            attempt++;
                            int remainingAttempts = maxAttempt - attempt;
                            if (remainingAttempts > 0) {
                                System.out.println("Incorrect password. You have " + remainingAttempts + " attempt(s) left.");
                            } else {
                                System.out.println("Incorrect password. No attempts remaining. Shutting down...");
                               
                                System.exit(0); 
                            }
                        }
                }
                case 4:
 Flight f = new Flight(null, null, null, null, 0, 0, 0.0f, 0.0f, 0.0f, 0, 0, "",null,null);
 f.displayAllValues();
    break;


                case 5:
                Booking passengerList = new Booking("", "", "", ' ', "", '\0', "", 0, 0,  0, "");
                passengerList.displayAllValues(); 
                 passengerList.readFromFile("booking_details.txt");
                break;
                
                case 6:
    System.out.println("Payment Options:");
    System.out.println("1. Tele Birr");
    System.out.println("2. CBE Birr");
    System.out.println("3. BOA");
    int paymentChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
                        switch (paymentChoice) {
                             case 1:
                           System.out.println("Tele Birr payment selected.");
                           System.out.println("Enter Tele Birr account number:");
                           String teleBirrAccount = scanner.nextLine();
                           System.out.println("Enter amount to be paid:");
                           float amountTeleBirr = scanner.nextFloat();
                           System.out.println("Payment of " + amountTeleBirr + " Birr made using Tele Birr from account: " + teleBirrAccount);
                             break;

                             case 2:
                           System.out.println("CBE Birr payment selected.");
                           System.out.println("Enter CBE Birr account number:");
                           String cbeBirrAccount = scanner.nextLine();
                           System.out.println("Enter amount to be paid:");
                           float amountCbeBirr = scanner.nextFloat();
                           System.out.println("Payment of " + amountCbeBirr + " Birr made using CBE Birr from account: " + cbeBirrAccount);
                             break;

                             case 3:
           
                           System.out.println("BOA payment selected.");
                           System.out.println("Enter BOA account number:");
                           String boaAccount = scanner.nextLine();
                           System.out.println("Enter amount to be paid:");
                           float amountBoa = scanner.nextFloat();
                           System.out.println("Payment of " + amountBoa + " Birr made using BOA from account: " + boaAccount);
                             break;
                             default:
                           System.out.println("Invalid payment option.");
                     }
                    break;

                case 7:
                    System.out.println("Exiting the menu. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1; // Set choice to an invalid option to continue the loop
            }
           
       
        } while (choice != 7);
          clearConsole();
        
        scanner.close();
    }
}
