/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FlightManagement;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        FlightManagement flManagement = new FlightManagement();
        Scanner sc = new Scanner(System.in);
        int choiceMain;

        do {
            System.out.println("1.Flight schedule management.");
            System.out.println("2.Passenger Reservation and Booking.");
            System.out.println("3.Passenger Check-In and Seat Allocation and Availability.");
            System.out.println("4.Crew Management.");
            System.out.println("5.Administrator Access.");
            System.out.println("6.Data Storage.");
            System.out.println("7.Print All data.");
            System.out.println("8.Exit the program.");
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
                    flManagement.crewManagement();
                    break;
                case 5:
                    flManagement.administratorAcess();
                    break;
                case 6:
                    flManagement.dataStorage();
                    break;
                case 7:
                    flManagement.loadData();
                    break;
                case 8:
                    System.out.println("Exit.....");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice, Please input again.");
            }

        } while (true);

    }

}
