package org.naca.atunsapp.model;

import java.io.Serializable;

/**
 * Created by navarrocantero on 11/12/2017.
 */

public class Track implements Serializable {
public int id;
public String genre;
public String name;
public String artist;
public String size;
public String location;
public String rating;
public String track_number;
public String bpm;
  public String created_at;
  public String updated_at;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getTrack_number() {
    return track_number;
  }

  public void setTrack_number(String track_number) {
    this.track_number = track_number;
  }

  public String getBpm() {
    return bpm;
  }

  public void setBpm(String bpm) {
    this.bpm = bpm;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }
}
