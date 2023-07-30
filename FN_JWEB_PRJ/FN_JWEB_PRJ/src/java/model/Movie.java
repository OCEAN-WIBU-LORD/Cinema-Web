/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Movie {
    private int movie_id;
    private String title,description,time_show,subtitle,poster,request;
    private double rated;
    private int viewer;
    private String premiere,country,directed_by,status_movie;

    public Movie() {
    }

    public Movie(int movie_id, String title, String description, String time_show, String subtitle, String poster, String request, double rated, int viewer, String premiere, String country, String directed_by, String status_movie) {
        this.movie_id = movie_id;
        this.title = title;
        this.description = description;
        this.time_show = time_show;
        this.subtitle = subtitle;
        this.poster = poster;
        this.request = request;
        this.rated = rated;
        this.viewer = viewer;
        this.premiere = premiere;
        this.country = country;
        this.directed_by = directed_by;
        this.status_movie = status_movie;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime_show() {
        return time_show;
    }

    public void setTime_show(String time_show) {
        this.time_show = time_show;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public double getRated() {
        return rated;
    }

    public void setRated(double rated) {
        this.rated = rated;
    }

    public int getViewer() {
        return viewer;
    }

    public void setViewer(int viewer) {
        this.viewer = viewer;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirected_by() {
        return directed_by;
    }

    public void setDirected_by(String directed_by) {
        this.directed_by = directed_by;
    }

    public String getStatus_movie() {
        return status_movie;
    }

    public void setStatus_movie(String status_movie) {
        this.status_movie = status_movie;
    }

    @Override
    public String toString() {
        return "Movie{" + "movie_id=" + movie_id + ", title=" + title + ", description=" + description + ", time_show=" + time_show + ", subtitle=" + subtitle + ", poster=" + poster + ", request=" + request + ", rated=" + rated + ", viewer=" + viewer + ", premiere=" + premiere + ", country=" + country + ", directed_by=" + directed_by + ", status_movie=" + status_movie + '}';
    }

    
}
