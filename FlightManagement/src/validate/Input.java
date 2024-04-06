/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import controller.FlightMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
import model.Flight;

/**
 *
 * @author Admin
 */
public class Input {

    private Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    public String inputFlNum(FlightMap flMap, String type) {
        String flNum;
        do {
            try {
                System.out.println("Flight Num:");
                flNum = sc.nextLine();
                if (Validation.checkNullString(flNum)) {
                    throw new Exception("DO NOT EMPTY.");
                }
                if (!Validation.checkNumPattern(flNum)) {
                    throw new Exception("MUST BE FOLLOW AS: Fxyzt, with xyzt is a number and no spaces, ex: F0001");
                }
                if (type.equals("add")) {
                    if (flMap.findFlByNum(flNum) == null) {
                    }
                }
                return flNum;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String inputDepartureCity() {
        String departure;
        do {
            try {
                System.out.println("Departure city:");
                departure = sc.nextLine();
                if (Validation.checkNullString(departure)) {
                    throw new Exception("DO NOT EMPTY.");
                }
                return departure;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String inputDestinationCity() {
        String destinate;
        do {
            try {
                System.out.println("Destination city:");
                destinate = sc.nextLine();
                if (Validation.checkNullString(destinate)) {
                    throw new Exception("DO NOT EMPTY.");
                }
                return destinate;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public LocalDate inputDepartureTime() {
        LocalDate departTime;
        String departTimeString;
        do {
            try {
                System.out.println("Departure time:");
                departTimeString = sc.nextLine();
                if (Validation.checkNullString(departTimeString)) {
                    throw new Exception("DO NOT EMPTY.");
                }
                if (!Validation.checkDatePattern(departTimeString)) {
                    throw new Exception("MUST FOLLOW FOMART 'DD/MM/YYYY'.");
                }
                departTime = LocalDate.parse(departTimeString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                return departTime;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public LocalDate inputArrivalTime() {
        LocalDate arrTime;
        String arrTimeString;
        do {
            try {
                System.out.println("Arrival time:");
                arrTimeString = sc.nextLine();
                if (Validation.checkNullString(arrTimeString)) {
                    throw new Exception("DO NOT EMPTY.");
                }
                if (!Validation.checkDatePattern(arrTimeString)) {
                    throw new Exception("MUST FOLLOW FOMART 'DD/MM/YYYY'.");
                }
                arrTime = LocalDate.parse(arrTimeString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                return arrTime;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public int inputAvailableSeats() {
        int seats;
        do {
            try {
                System.out.println("Available seats:");
                seats = sc.nextInt();
                if (Validation.checkNullString(String.valueOf(seats))) {
                    throw new Exception("DO NOT EMPTY.");
                }
                if (seats <= 1 || seats >=32){
                    throw new Exception("Slots must available from 2 to 31");
                }
                return seats;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public boolean getYesNo(String str) {
        String choice;
        do {
            try {
                System.out.println("Do you want to continue to " + str);
                System.out.println("Please enter yes/y/no/n");
                choice = sc.nextLine();
                if (choice.trim().toLowerCase().equals("y|yes")) {
                    return true;
                } else if (choice.trim().toLowerCase().equals("n|no")) {
                    return false;
                } else {
                    throw new Exception("must enter yes/no/y/n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    public String inputName(){
        String name;
        do {            
            try {
                System.out.println("Input your name: ");
                name = sc.nextLine();
                if (Validation.checkNullString(name)){
                    throw new Exception("DO NOT EMPTY.");
                }
                return name;
            } catch (Exception e) {
            }
        } while (true);
    }
    
    public String inputPhone(){
        String phone;
        do {            
            try {
                System.out.println("Input phone:");
                phone = sc.nextLine();
                if (Validation.checkNullString(phone)){
                    throw new Exception("DO NOT EMPTY.");
                }
                return phone;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    public int inputReId(){
        int Reid;
        do {            
            try {
                System.out.println("Input Reservation Id: ");
                Reid = sc.nextInt();
                if (Validation.checkNullString(String.valueOf(Reid))){
                    throw new Exception("DO NOT EMPTY.");
                }
            } catch (Exception e) {
            }
        } while (true);
    }
}
