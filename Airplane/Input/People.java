package Input;
import java.util.Scanner;

public class People {
    public String name;
    public String email;
    public String address;
    public char sex;
    public String phone;
    public int age;

    public People(String name, String email, String address, char sex, String phone, int age) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.phone = phone;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    public char getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }
    Scanner scanner = new Scanner(System.in);

    public void setNameFromInput() {
        {
            while (true) {
                System.out.print("Enter Your Name :- ");
                String inputName = scanner.nextLine().trim();

                if (inputName.matches("[a-zA-Z]+") && inputName.length() >= 2 && inputName.length() <= 30) {
                    name = inputName;
                    break;
                } else {
                    System.out.println("Invalid name format. Please enter a valid name (2-30 characters, only alphabets).");
                }
            }
             
         }
     }
     

     public void setEmailFromInput() {
        while (true) {
            System.out.print("Enter Your Email Address :- ");
            email = scanner.nextLine();

          
            int counter = 0;
            int counter_2 = 0;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    counter++;
                } else if (email.charAt(i) == '.') {
                    counter_2++;
                }
            }

            if (counter == 1 && counter_2 >= 1) {
                break;
            } else {
                System.out.println("Please enter a Valid Email Address");
            }
        }
    }


    public void setAddressFromInput() {
        {
           System.out.print("Enter address: ");
           String input = scanner.nextLine();
           this.address = input;
       }
   }

   public void setSexFromInput() {
    while (true) {
        try {
            System.out.print("Enter sex (M/F): ");
            char input = scanner.next().toUpperCase().charAt(0);

            // Validate input
            if (input != 'M' && input != 'F') {
                throw new IllegalArgumentException("Invalid input! Please enter M or F.");
            }

            this.sex = input;
            break; // Exit loop if input is valid
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

  public void setPhoneFromInput() {
    while (true) {
        try {
            System.out.print("Enter Your Phone Number (0911121314): ");
            String input = scanner.next();

            // Check if input consists of digits only
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException("Please enter a valid phone number with digits only.");
            }

            // Check if the length of the input is 10 (assuming the country code is added later)
            if (input.length() != 10) {
                throw new IllegalArgumentException("Phone number should be 10 digits long.");
            }

            // Check if the phone number starts with "09" or "07"
            String firstTwoDigits = input.substring(0, 2);
            if (!firstTwoDigits.equals("09") && !firstTwoDigits.equals("07")) {
                throw new IllegalArgumentException("Phone number should start with 09 or 07.");
            }

            // If all criteria are met, add the country code "+251"
            this.phone = "+251" + input;
            break;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


public void setAgeFromInput() {
    while (true) {
        try {
            System.out.print("Enter Your Age: ");
            if (scanner.hasNextInt()) {
                int inputAge = scanner.nextInt();
                scanner.nextLine();

                if (inputAge <= 0) {
                    throw new IllegalArgumentException("Age cannot be negative or zero.");
                }

                this.age = inputAge;
                break;
            } else {
                throw new IllegalArgumentException("Please enter a valid age.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            scanner.nextLine(); // Clear invalid input from the scanner
        }
    }
}

}

