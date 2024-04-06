/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Reservation extends Passenger {

    private int ReservationId;
    private String flNum;

    public Reservation() {
    }

    public Reservation(String name, String phone) {
        super(name, phone);
    }

    public Reservation(int ReservationId, String flNum, String name, String phone) {
        super(name, phone);
        this.ReservationId = ReservationId;
        this.flNum = flNum;
    }

    public int getReservationId() {
        return ReservationId;
    }

    public void setReservationId(int ReservationId) {
        this.ReservationId = ReservationId;
    }

    public String getFlNum() {
        return flNum;
    }

    public void setFlNum(String flNum) {
        this.flNum = flNum;
    }

    @Override
    public String toString() {
        return "Reservation{" + "flNum=" + flNum + '}';
    }

}
