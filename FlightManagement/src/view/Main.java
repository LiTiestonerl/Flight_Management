/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FlightManagement;
import java.util.Scanner;
import validate.Input;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        FlightManagement flManagement = new FlightManagement();
        Scanner sc = new Scanner(System.in);
        Input ip = new Input();
        int choiceMain;

        do {
            System.out.println("1.Flight schedule management.");
            System.out.println("2.Passenger Reservation and Booking.");
            System.out.println("3.Passenger Check-In and Seat Allocation and Availability.");
            System.out.println("4.Crew Management and Administrator Access.");
            System.out.println("5.Save to file");
            System.out.println("6.Print all lists from file.");
            System.out.println("7.Exit the program.");
            System.out.println("==============================================================");
            choiceMain = sc.nextInt();
            switch (choiceMain) {
                case 1:
                    
                        flManagement.flightSchedule();
                        break;
        
                case 2:
                        flManagement.passengerBooking();
                        break;

                case 3:
                        flManagement.passengerCheckIn();
                        break;

                case 4:

                case 5:

                case 6:
                    
                case 7:
                    System.out.println("Exit.....");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice, Please input again.");
            }

        } while (true);

    }

}
