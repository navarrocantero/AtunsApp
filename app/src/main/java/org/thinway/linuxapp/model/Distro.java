package org.thinway.linuxapp.model;

/**
 * Created by fdelgado on 30/11/17.
 */

public class Distro {

    public int id;
    public String image;
    public String name;
    public String ostype;
    public String basedon;
    public String origin;
    public String architecture;
    public String desktop;
    public String category;
    public String status;
    public String version;
    public String web;
    public String doc;
    public String forums;
    public String error_tracker;
    public String description;
    public String created_at;
    public String updated_at;

    @Override
    public String toString() {
        return name;
    }
}
