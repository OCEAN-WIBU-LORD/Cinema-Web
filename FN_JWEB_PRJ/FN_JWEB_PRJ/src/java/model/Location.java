/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Location {
    private int location_id;
    private String location_name;
    private int location_type_id,position_id,movie_id;
    private String movie_show_time,movie_show_date;
    private int ticket_count;

    public Location() {
    }

    public Location(int location_id, String location_name, int location_type_id, int position_id, int movie_id, String movie_show_time, String movie_show_date, int ticket_count) {
        this.location_id = location_id;
        this.location_name = location_name;
        this.location_type_id = location_type_id;
        this.position_id = position_id;
        this.movie_id = movie_id;
        this.movie_show_time = movie_show_time;
        this.movie_show_date = movie_show_date;
        this.ticket_count = ticket_count;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public int getLocation_type_id() {
        return location_type_id;
    }

    public void setLocation_type_id(int location_type_id) {
        this.location_type_id = location_type_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_show_time() {
        return movie_show_time;
    }

    public void setMovie_show_time(String movie_show_time) {
        this.movie_show_time = movie_show_time;
    }

    public String getMovie_show_date() {
        return movie_show_date;
    }

    public void setMovie_show_date(String movie_show_date) {
        this.movie_show_date = movie_show_date;
    }

    public int getTicket_count() {
        return ticket_count;
    }

    public void setTicket_count(int ticket_count) {
        this.ticket_count = ticket_count;
    }
    
    
}
