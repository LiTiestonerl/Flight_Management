/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Flight {
    private String flNum;
    private String departure;
    private String destination;
    private LocalDate deparTime;
    private LocalDate arriTime;
    private int avaSeats;

    public Flight() {
    }

    public Flight(String flNum, String departure, String destination, LocalDate deparTime, LocalDate arriTime, int avaSeats) {
        this.flNum = flNum;
        this.departure = departure;
        this.destination = destination;
        this.deparTime = deparTime;
        this.arriTime = arriTime;
        this.avaSeats = avaSeats;
    }

    public String getFlNum() {
        return flNum;
    }

    public void setFlNum(String flNum) {
        this.flNum = flNum;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDeparTime() {
        return deparTime;
    }

    public void setDeparTime(LocalDate deparTime) {
        this.deparTime = deparTime;
    }

    public LocalDate getArriTime() {
        return arriTime;
    }

    public void setArriTime(LocalDate arriTime) {
        this.arriTime = arriTime;
    }

    public int getAvaSeats() {
        return avaSeats;
    }

    public void setAvaSeats(int avaSeats) {
        this.avaSeats = avaSeats;
    }

    @Override
    public String toString() {
        return "flight{" + "flNum=" + flNum + ", departure=" + departure + ", destination=" + destination + ", deparTime=" + deparTime + ", arriTime=" + arriTime + ", avaSeats=" + avaSeats + '}';
    }
    
    
    
    
    
}
