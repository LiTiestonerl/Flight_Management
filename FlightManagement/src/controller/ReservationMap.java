/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Collection;
import java.util.HashMap;
import model.Reservation;

/**
 *
 * @author Admin
 */
public class ReservationMap {
    private HashMap<Integer,Reservation> reservationMap;
    
    public ReservationMap(){
        reservationMap = new HashMap<>();
    }
    
    public boolean checkEmptyReservation(){
        return reservationMap.isEmpty();
    }
    
    public Collection<Reservation> getValuesRe(){
        return reservationMap.values();
    }
    
    public int getsizeReservation() {
        return reservationMap.size();
    }

    public boolean removeReByNum(Reservation re) {
        if (reservationMap != null) {
            int reId = re.getReservationId();
            reservationMap.remove(reId);
            return true;
        }
        return false;
    }

    public boolean addReservation(Reservation re) {
        if (reservationMap != null) {
            int reId = re.getReservationId();
            reservationMap.put(reId, re);
            return true;
        }
        return false;
    }

    public Reservation findReByNum(int reId) {
        return reservationMap.get(reId);
    }
    
}
