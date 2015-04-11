package com.example.ruoxilu.criticalmass;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * User Class
 * Data members/attributes:
 * 1. user
 * 2. status <- Human/Zobie
 * 3. location
 */
@ParseClassName("MassUser")
public class MassUser extends ParseObject{

    public MassUser(){
        setStatus("zombie");
    }


    public void setLocation(ParseGeoPoint value) {
        put("location", value);
    }
    public String getUser() {
        return getString("user");
    }
    public void setStatus(String status){put("status", status);}
    // user field takes ObjectId of Parse User
    public void setUser(ParseUser value) {
        put("user", value.getObjectId());
    }

    // Every MassUser has an event ID (Xin)
    public String getEvent() { return getString("event"); }
    public void setEvent(MassEvent value){ put("event", value.getEvent()); }

    // User Location
    public ParseGeoPoint getLocation() {
        return getParseGeoPoint("location");
    }

    public String getStatus(){
        return getString("status");
    }

    public static ParseQuery<MassUser> getQuery(){
        return ParseQuery.getQuery(MassUser.class);
    }
}
