/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Slide {
    private int slide_id;
    private String image;
    private int movie;

    public Slide() {
    }

    public Slide(int slide_id, String image, int movie) {
        this.slide_id = slide_id;
        this.image = image;
        this.movie = movie;
    }

    public int getSlide_id() {
        return slide_id;
    }

    public void setSlide_id(int slide_id) {
        this.slide_id = slide_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }
    
    
}
