package com.example.bhuiyan.myfinal1;

import java.util.ArrayList;

/**
 * Created by BHUIYAN on 13/03/2018.
 */

/**
 * getting and setting event details
 * java object class
 */
public class ListItem {

    public static ArrayList<Double> xLat = new ArrayList<>();
    public static ArrayList<Double> yLng = new ArrayList<>();
    public static ArrayList<String> myName = new ArrayList<>();


    private String number,name,address,position,position1,banking,bonus,status,contract_name,
            bike_stands,available_bike_stands,available_bikes,last_update;



    public ListItem(String number,String name,String address,String position,String position1,
                    String banking, String bonus, String status, String contract_name, String bike_stands,
                    String available_bike_stands, String available_bikes, String last_update)
    {
        this.setNumber(number);
        this.setName(name);
        this.setAddress(address);
       this.setPosition(position);
       this.setBanking(banking);
       this.setBonus(bonus);
       this.setStatus(status);
        this.setContract_name(contract_name);
        this.setBike_stands(bike_stands);
        this.setAvailable_bike_stands(available_bike_stands);
        this.setAvailable_bikes(available_bikes);
       this.setLast_update(last_update);
       this.setPosition1(position1);

    }

    //all getter and setter
     public String getPosition1() { return position1;}

      public void setPosition1(String position1) { this.position1 = position1;}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     public void setPosition(String position) {
       this.position = position;
    }

     public String getBanking() {
         return banking;
    }

   public void setBanking(String banking) {
        this.banking = banking;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getBike_stands() {
        return bike_stands;
    }

    public void setBike_stands(String bike_stands) {
        this.bike_stands = bike_stands;
    }

    public String getAvailable_bike_stands() {
        return available_bike_stands;
    }

    public void setAvailable_bike_stands(String available_bike_stands) {
        this.available_bike_stands = available_bike_stands;
    }

    public String getAvailable_bikes() {
        return available_bikes;
    }

    public void setAvailable_bikes(String available_bikes) {
        this.available_bikes = available_bikes;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }


    public String getPosition() {
        return position;
    }
}

