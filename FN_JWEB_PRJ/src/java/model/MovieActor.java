/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class MovieActor {
    private int actor_id,movie_id;
    private String actor_role_name;

    public MovieActor() {
    }

    public MovieActor(int actor_id, int movie_id, String actor_role_name) {
        this.actor_id = actor_id;
        this.movie_id = movie_id;
        this.actor_role_name = actor_role_name;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getActor_role_name() {
        return actor_role_name;
    }

    public void setActor_role_name(String actor_role_name) {
        this.actor_role_name = actor_role_name;
    }
    
    
    
}
