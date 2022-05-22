package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InternetPack {
    private final StringProperty firstName = new SimpleStringProperty(this,"firstName",null);
    private final StringProperty lastName = new SimpleStringProperty(this,"lastName",null);
    private final StringProperty address = new SimpleStringProperty(this,"address",null);
    private final IntegerProperty speed = new SimpleIntegerProperty(this,"speed",0);
    private final IntegerProperty bandWidth = new SimpleIntegerProperty(this,"bandWidth",0);
    private final IntegerProperty  duration = new SimpleIntegerProperty(this,"duration",0);

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public int getSpeed() {
        return speed.get();
    }

    public IntegerProperty speedProperty() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed.set(speed);
    }


    public int getBandWidth() {
        return bandWidth.get();
    }

    public IntegerProperty bandWidthProperty() {
        return bandWidth;
    }

    public void setBandWidth(int bandWidth){
        this.bandWidth.set(bandWidth);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }


}
