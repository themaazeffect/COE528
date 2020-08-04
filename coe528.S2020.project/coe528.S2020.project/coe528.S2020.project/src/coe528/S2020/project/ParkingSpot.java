/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.S2020.project;

/**
 *
 * @author User
 */
public class ParkingSpot {
    
    private String parkingType;
    private ParkingTicket t; 
    private Boolean isUsed;

    public ParkingSpot(String parkingType){
        this.parkingType=parkingType;
        isUsed=false;
    }    

    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
        isUsed=false;
    }

    public ParkingTicket getTicket() {
        return t;
    }

    public void setTicket(ParkingTicket t) {
        if(isUsed==true){
        System.out.println("That Parking Spot is currently in use");
        }
        else{
        this.t = t;
        isUsed=true;
    }
        if(t==null){
            this.t=t;
        this.isUsed=false;
        
        }
    }
    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }


}
