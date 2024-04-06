/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Collection;
import java.util.HashMap;
import model.Flight;

/**
 *
 * @author Admin
 */
public class FlightMap {

    private HashMap<String, Flight> flMap;

    public FlightMap() {
        flMap = new HashMap<>();
    }

    public boolean checkEmptyFlMap() {
        return flMap.isEmpty();
    }

    public HashMap<String, Flight> getFlightMap() {
        return flMap;
    }

    public int getsizeFl() {
        return flMap.size();
    }

    public Collection<Flight> getValueFl() {
        return flMap.values();
    }

    public boolean removeFlByNum(Flight fl) {
        if (flMap != null) {
            String flNum = fl.getFlNum();
            flMap.remove(flNum);
            return true;
        }
        return false;
    }

    public boolean addFl(Flight fl) {
        if (flMap != null) {
            String flNum = fl.getFlNum();
            flMap.put(flNum, fl);
            return true;
        }
        return false;
    }

    public Flight findFlByNum(String flNum) {
        return flMap.get(flNum);
    }

}
