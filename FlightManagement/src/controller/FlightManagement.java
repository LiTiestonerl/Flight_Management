/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import model.Flight;
import model.Reservation;
import validate.Input;
import validate.Validation;
import view.IFlightManagement;

/**
 *
 * @author Admin
 */
public class FlightManagement implements IFlightManagement {

    private static int ReIdCounter = 0;
    private FlightMap flMap;
    private ReservationMap reMap;
    private Input ip;
    private Validation vl;

    public FlightManagement() {
        flMap = new FlightMap();
        reMap = new ReservationMap();
        ip = new Input();
        vl = new Validation();
    }

    public static int getNextReservationID() {
        return ReIdCounter++;
    }

    @Override
    public void flightSchedule() {
        try {
            String flNum = ip.inputFlNum(flMap, "add");
            String departure_1 = ip.inputDepartureCity();
            String destination_1 = ip.inputDestinationCity();
            LocalDate departTime_1 = ip.inputDepartureTime();
            LocalDate arriTime = ip.inputArrivalTime();
            int avaSeats = ip.inputAvailableSeats();
            Flight fl = new Flight(flNum, departure_1, destination_1, departTime_1, arriTime, avaSeats);
            boolean check = flMap.addFl(fl);
            if (check) {
                throw new Exception("ADDED SUCCESSFULLY.");
            } else {
                throw new Exception("ADDED NOT SUCCESSFULLY.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void passengerBooking() {
        try {
            String departure = ip.inputDepartureCity();
            String destination = ip.inputDestinationCity();
            LocalDate departTime = ip.inputDepartureTime();
            boolean flFound = false;
            
            for (Flight flight : flMap.getValueFl()) {
                if (flight.getDeparture().equalsIgnoreCase(departure) && flight.getDestination().equalsIgnoreCase(destination) && flight.getDeparTime().isEqual(departTime)) {
                    int availableSeats = flight.getAvaSeats();
                    if (availableSeats > 0) {
                        String getflNumForRe = flight.getFlNum();
                        flight.setAvaSeats(flight.getAvaSeats() - 1);
                        int idRe = FlightManagement.getNextReservationID();
                        String nameRe = ip.inputName();
                        String phoneRe = ip.inputPhone();
                        Reservation re = new Reservation(idRe, getflNumForRe, nameRe, phoneRe);
                        reMap.addReservation(re);
                        System.out.println("Reservation Id: " + idRe);
                        System.out.println("Reservation successful.");
                        flFound = true;
                        break;
                    }
                }
            }
            if (!flFound) {
                throw new Exception("No available flights found for the given.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void passengerCheckIn() {
        try {
            int reId = ip.inputReId();
            Reservation reFound = reMap.findReByNum(reId);           
            if (reFound ==null){
                throw new Exception("Your Reservation is not exist.");
            }else{
                System.out.println("Founded your reservation, please check your information to check-in");
                System.out.println(reFound.getReservationId());
                System.out.println(reFound.getName());
                System.out.println(reFound.getPhone());
                System.out.println(reFound.getFlNum());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void crewManagement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveToFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printAllFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
