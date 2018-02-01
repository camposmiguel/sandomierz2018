package com.miguelcr.remotecontrolapp;

import io.realm.RealmObject;

/**
 * Created by miguelcampos on 31/1/18.
 */

public class AirConditionerItem extends RealmObject {
    String name;
    String turnOnCode;
    String turnOffCode;
    String increaseCode;
    String decreaseCode;

    public AirConditionerItem() {
    }

    public AirConditionerItem(String name, String turnOnCode, String turnOffCode, String increaseCode, String decreaseCode) {
        this.name = name;
        this.turnOnCode = turnOnCode;
        this.turnOffCode = turnOffCode;
        this.increaseCode = increaseCode;
        this.decreaseCode = decreaseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTurnOnCode() {
        return turnOnCode;
    }

    public void setTurnOnCode(String turnOnCode) {
        this.turnOnCode = turnOnCode;
    }

    public String getTurnOffCode() {
        return turnOffCode;
    }

    public void setTurnOffCode(String turnOffCode) {
        this.turnOffCode = turnOffCode;
    }

    public String getIncreaseCode() {
        return increaseCode;
    }

    public void setIncreaseCode(String increaseCode) {
        this.increaseCode = increaseCode;
    }

    public String getDecreaseCode() {
        return decreaseCode;
    }

    public void setDecreaseCode(String decreaseCode) {
        this.decreaseCode = decreaseCode;
    }
}
