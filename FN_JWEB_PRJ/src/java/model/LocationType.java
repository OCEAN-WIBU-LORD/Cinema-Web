/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class LocationType {
    private int location_type_id;
    private String location_type;

    public LocationType() {
    }

    public LocationType(int location_type_id, String location_type) {
        this.location_type_id = location_type_id;
        this.location_type = location_type;
    }

    public int getLocation_type_id() {
        return location_type_id;
    }

    public void setLocation_type_id(int location_type_id) {
        this.location_type_id = location_type_id;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }
    
    
    
}
