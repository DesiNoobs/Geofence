package com.example.geofencing;

public class GeoData {
    private  String geoID;
    private double lat;
    private double lon;
    private float radius;

    public GeoData(String geoID, double lat, double lon, float radius) {
        this.geoID = geoID;
        this.lat = lat;
        this.lon = lon;
        this.radius = radius;
    }

    public String getGeoID() {
        return geoID;
    }

    public void setGeoID(String geoID) {
        this.geoID = geoID;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
