/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Van Ky
 */
public class LocationPosition {
    private String location_id,location_name,position_name,location_type,movie_id,time,date,ticket_count;

    public LocationPosition() {
    }

    public LocationPosition(String location_id, String location_name, String position_name, String location_type, String movie_id, String time, String date, String ticket_count) {
        this.location_id = location_id;
        this.location_name = location_name;
        this.position_name = position_name;
        this.location_type = location_type;
        this.movie_id = movie_id;
        this.time = time;
        this.date = date;
        this.ticket_count = ticket_count;
    }

    

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTicket_count() {
        return ticket_count;
    }

    public void setTicket_count(String ticket_count) {
        this.ticket_count = ticket_count;
    }
    
    
    
}
