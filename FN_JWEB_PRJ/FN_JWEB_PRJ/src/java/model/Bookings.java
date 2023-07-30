/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Bookings {
    private  int booking_id;
    private int acc_id,location_id;
    private String booking_date;
    private int movie_id;
    private String title;
    

    public Bookings() {
    }

    public Bookings(int booking_id, int acc_id, int location_id, String booking_date, int movie_id, String title) {
        this.booking_id = booking_id;
        this.acc_id = acc_id;
        this.location_id = location_id;
        this.booking_date = booking_date;
        this.movie_id = movie_id;
        this.title = title;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Bookings{" + "booking_id=" + booking_id + ", acc_id=" + acc_id + ", location_id=" + location_id + ", booking_date=" + booking_date + ", movie_id=" + movie_id + ", title=" + title +'}';
    }

   
    
    
}
