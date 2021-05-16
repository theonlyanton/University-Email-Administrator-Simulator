import java.util.Scanner;
import java.io.*;

public class Email {
    private String accountName;
    private String individualType;
    private String collegeDepartment;
    private String mainEmail;
    private String alternateEmail;
    private int defaultLength = 10;
    private String password;

    public Email() {

        this.accountName = askForFullname();
        System.out.println();
        this.individualType = schoolPosition();
        System.out.println();

        if(this.individualType.equals("2")) {
            this.collegeDepartment = enteredDepartment();

            String str = this.accountName;
            String [] parts = str.split(" ");
            Scanner fromStr = new Scanner(str);

            int i = 0;
            while(fromStr.hasNext()) {
                parts[i] = fromStr.next();
                i++;
            }
            String firstName = parts[0].toLowerCase();
            String lastName = parts[parts.length - 1].toLowerCase();
            if(lastName.length() > 7) {
                lastName = lastName.substring(0, 8);
            }
            char firstInitial = firstName.charAt(0);

            this.mainEmail = firstInitial + lastName + "@" + this.collegeDepartment + "." + "rutgers.edu";
            System.out.println("\nEMAIL ADDRESS: " + this.mainEmail);
        }
        else {
            String str = this.accountName;
            String [] parts = str.split(" ");
            Scanner fromStr = new Scanner(str);

            int i = 0;
            while(fromStr.hasNext()) {
                parts[i] = fromStr.next();
                i++;
            }
            String firstName = parts[0].toLowerCase();
            String lastName = parts[parts.length - 1].toLowerCase(); 
            if(lastName.length() > 7) {
                lastName = lastName.substring(0, 8);
            }
            char firstInitial = firstName.charAt(0);
            char lastInitial = lastName.charAt(0);

            int randomNumber = ((int) Math.random() * 9999 + 1000);
            this.mainEmail = randomNumber + "@scarletmail.rutgers.edu";
            this.alternateEmail = firstName + "." + lastName + "@" + "rutgers.edu";
            System.out.println("MAIN EMAIL ADDRESS: " + firstInitial + lastInitial + this.mainEmail);
            System.out.println("ALTERNATE EMAIL ADDRESS: " + this.alternateEmail);
            
        }
        System.out.println();

        this.password = randomPassword(defaultLength);
        System.out.println("Your default email password is " + this.password + " .");
        System.out.println();
    }

    private String askForFullname() {

        System.out.println("\nEnter your first name and last name below.");
        System.out.println();
        System.out.print("ACCOUNT NAME: " + " ");
        Scanner in = new Scanner(System.in);
        String userName = in.nextLine();

        String [] hello = userName.split(" ");
        //Scanner toStr = new Scanner(userName);

        //int a = 0;
        //while(toStr.hasNext()) {
            //hello[a] = toStr.next();
            //a++;
        //}
        for(int b = 0; b < hello.length; b++) {
            if(hello[b].length() < 3 || hello.length < 2) {
                System.out.println();
                System.out.println("! INVALID NAME INPUT !");
                System.out.println();
                return "" + askForFullname();
            }
        }

        if(isNumber(userName) == true) {
            System.out.println();
            System.out.println("! INVALID NAME INPUT !");
            System.out.println();
            return "" + askForFullname();
        }
        else {
            return userName;
        }
    }

    private String schoolPosition() {

        System.out.println("Are you a staff member or a student? Please enter one of the following codes found below.");
        System.out.println();
        System.out.println("1 for a Rutgers University student\n2 for a Rutgers University staff member");
        System.out.println();
        System.out.print("Entering a value ...." + " ");
        Scanner inSecond = new Scanner(System.in);
        String userChoice = inSecond.nextLine();
        String [] test = userChoice.split(" ");
        if(test.length > 1) {
            System.out.println();
            System.out.println("! INVALID INPUT FOR SCHOOL POSITION!");
            System.out.println();
            return "" + schoolPosition();
        }
        if(test.length == 1 && test[0].equals("2")) {
            return "2";
        }
        if(test.length == 1 && test[0].equals("1")) {
            return "1";
        }
        if(test.length == 1 && specialExist(test[0]) == true) {
            System.out.println();
            System.out.println("! INVALID INPUT FOR SCHOOL POSITION!");
            System.out.println();
            return "" + schoolPosition();
        }
        else {
            System.out.println();
            System.out.println("! INVALID INPUT FOR SCHOOL POSITION!");
            System.out.println();
            return "" + schoolPosition();
        }        
    }

    private String enteredDepartment() {

        System.out.println("Enter the department you belong to (ex. \"math\", \"business\", \"physics\"): ");
        System.out.println();
        System.out.print("DEPARTMENT: " + " ");
        Scanner inThird = new Scanner(System.in);
        String departmentType = inThird.nextLine();

        String [] check = departmentType.split(" ");
        //Scanner toStr = new Scanner(userName);

        //int a = 0;
        //while(toStr.hasNext()) {
            //hello[a] = toStr.next();
            //a++;
        //}
        for(int g = 0; g < check.length; g++) {
            if(check[g].length() < 4 || check.length > 1) {
                System.out.println();
                System.out.println("! INVALID DEPARTMENT INPUT !");
                System.out.println();
                return "" + enteredDepartment();
            }
        }

        

        if(isNumber(departmentType) == true) {
            System.out.println();
            System.out.println("! INVALID DEPARTMENT INPUT !");
            System.out.println();
            return "" + enteredDepartment();
        }
        else {
            return departmentType.toLowerCase();
        }
    }

    private String randomPassword(int length) {

        String passwordPossibilities = "ABCDEFGHIJKLMOPQRSTUVWXYZ123456789!@#$%^&*";
        char [] password = new char[length];
        for(int i = 0; i < length; i++) {
            int randomValue = (int) (Math.random() * passwordPossibilities.length() );
            password[i] = passwordPossibilities.charAt(randomValue);
        }
        return new String(password);
    }

    private boolean isNumber(String s) {
        String specialCharacterList = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(s.charAt(i)) == true || specialCharacterList.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }


    private boolean specialExist(String s) {
        String specialCharacterList = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(specialCharacterList.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }
}
