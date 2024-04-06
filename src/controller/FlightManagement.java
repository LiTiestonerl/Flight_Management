/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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

    private static int ReIdCounter = 1;
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
            String departure = ip.inputDepartureCity();
            String destination = ip.inputDestinationCity();
            LocalDate departTime = ip.inputDepartureTime();
            LocalDate arriTime = ip.inputArrivalTime();
            int avaSeats = ip.inputAvailableSeats();
            Flight fl = new Flight(flNum, departure, destination, departTime, arriTime, avaSeats);
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
                        if (flight.getAvaSeats() <= 0) {
                            throw new Exception("Your flight does not have any slots to booking.");
                        }
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
            if (reFound == null) {
                throw new Exception("Your Reservation is not exist.");
            } else {
                System.out.println("Founded your reservation, please check your information to check-in");
                System.out.println("Reservation ID: " + reFound.getReservationId());
                System.out.println("Your Name: " + reFound.getName());
                System.out.println("Your Phone: " + reFound.getPhone());
                System.out.println("Your Flight: " + reFound.getFlNum());
                Flight fl = flMap.findFlByNum(reFound.getFlNum());
                System.out.println("Available Seat for you to chocie");
                System.out.println("please choice the number for seat from 1 to " + (fl.getAvaSeats() + 1));
                int orderSeat = ip.inputOrderSeat();
                Reservation re = new Reservation(reId, reFound.getFlNum(), orderSeat, reFound.getName(), reFound.getPhone());
                System.out.println("your card to boarding is :");
                System.out.println("Reservation ID: " + re.getReservationId());
                System.out.println("Your Name: " + re.getName());
                System.out.println("Your Phone: " + re.getPhone());
                System.out.println("Your Flight: " + re.getFlNum());
                System.out.println("Your Number of seat: " + re.getOrderSeat());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void crewManagement() {
        ArrayList<String> reNameList = new ArrayList<>();
        int count;
        try {
            System.out.println("input key to find all:");
            String key = ip.inputName().toLowerCase();
            for (Reservation re : reMap.getValuesRe()) {
                String reName = re.getName().toLowerCase();
                if (reName.contains(key)){
                    reNameList.add(re.getName());                   
                }                
            }
            if(reNameList != null){
                Collections.sort(reNameList);
                System.out.println(reNameList);
            }
            
          
        } catch (Exception e) {
        }

    }

    @Override
    public void administratorAcess() {
        try {
            System.out.println("input key word to find: ");
            String nameKey = ip.inputName().toLowerCase();
            boolean found = false;
            for (Reservation re : reMap.getValuesRe()) {
                String nameguest = re.getName().toLowerCase();
                if (nameguest.contains(nameKey)){
                    System.out.println("Find: ");
                    System.out.println(re.getName());
                    found = true;
                }             
            }
            if (!found){
                throw new Exception("There is no name matching.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dataStorage() {
        String filePath = "C:\\Users\\Admin\\Desktop\\IOT102\\FlightManagement\\flight.txt";
        try {            
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bfWriter = new BufferedWriter(fw);
            
            for (Flight fl : flMap.getValueFl()) {
                LocalDate departTime = fl.getDeparTime();
                LocalDate arrTime = fl.getArriTime();
                bfWriter.write(fl.getFlNum());
                bfWriter.write(",");
                bfWriter.write(fl.getDeparture());
                bfWriter.write(",");
                bfWriter.write(fl.getDestination());
                bfWriter.write(",");
                bfWriter.write(departTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                bfWriter.write(",");
                bfWriter.write(arrTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                bfWriter.write(",");
                bfWriter.write(String.valueOf(fl.getAvaSeats()));
                bfWriter.write("\n");         
            }
            bfWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
// in ra tat ca chuyen bay chua chu al , departure 
    @Override
    public void loadData() {
        String filePath = "C:\\Users\\Admin\\Desktop\\IOT102\\FlightManagement\\flight.txt";
        ArrayList<Flight> flTxt = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader bfRead = new BufferedReader(fr);
            String line;
            while ((line = bfRead.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String flNum = parts[0].trim();
                    String departure = parts[1].trim();
                    String destination = parts[2].trim();
                    LocalDate deparTime = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate arriTime = LocalDate.parse(parts[4], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    int avaSeats = Integer.parseInt(parts[5]);
                    Flight fl = new Flight(flNum, departure, destination, deparTime, arriTime, avaSeats);
                    flMap.addFl(fl);
                    flTxt.add(fl);
                }
            }
            bfRead.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
             
        if (!flTxt.isEmpty()) {
            System.out.println("List of flight from flight.txt: ");
            for (Flight flight : flTxt) {
                if (flight.getDeparture().contains("c")){
                    System.out.println(flight.getFlNum());
                    System.out.println(flight.getDeparture());
                    System.out.println(flight.getDestination());
                    System.out.println(flight.getArriTime());
                    System.out.println(flight.getDeparTime());
                    System.out.println(flight.getAvaSeats());
                    System.out.println("=======================");
                }              
            }
        } else {
            System.out.println("There is no flight.");
        }
    }

}
