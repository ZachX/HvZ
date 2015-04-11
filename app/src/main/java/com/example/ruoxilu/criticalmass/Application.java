package com.example.ruoxilu.criticalmass;

import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Test that the app is imported

       /* ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        */

        ParseObject.registerSubclass(MassUser.class);
        ParseObject.registerSubclass(MassEvent.class);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "xSb3yj5ZcH4I2RGFVMhY9gqJik4DNBFPTzZTkuHe", "VfYW4DSsfkizLml1JUwsxIwQkQjnSc3k46YUs2EH");

        ParseUser.enableAutomaticUser();
        Log.d("CriticalMassApplication", "On start the currentuser is "+ ParseUser.getCurrentUser());
        ParseUser.getCurrentUser().saveInBackground();

        ParseACL defaultACL = new ParseACL();

        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

        // allows read and write access to all users
        ParseACL postACL = new ParseACL(ParseUser.getCurrentUser());
        postACL.setPublicReadAccess(true);
        postACL.setPublicWriteAccess(true);
        Log.d("CriticalMassApplication",  " In anonymousUserLogin, ParseUser is null?"+ ParseUser.getCurrentUser().getObjectId());
        Log.d("CriticalMassApplication",  " In anonymousUserLogin, ParseUser is null?"+ ParseUser.getCurrentUser().getCreatedAt());
        Log.d("CriticalMassApplication",  " In anonymousUserLogin, ParseUser is null?"+ ParseUser.getCurrentUser().getUsername());

    }
}

