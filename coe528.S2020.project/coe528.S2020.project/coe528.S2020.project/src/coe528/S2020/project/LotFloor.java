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
public class LotFloor {
    private int floorNumber;
    private ParkingSpot[] spot= new ParkingSpot[5];
    
public LotFloor(int floorNumber){
    this.floorNumber=floorNumber;
    fillLot();
    
}  

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingSpot[] getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot[] spot) {
        this.spot = spot;
    }
    public ParkingSpot getParkingSpot(int i ){
        return spot[i];
    }

public void fillLot(){
    this.spot[0]= new ParkingSpot("Compact");
    this.spot[1]= new ParkingSpot("Large");
    this.spot[2]= new ParkingSpot("Handicapped");
    this.spot[3]= new ParkingSpot("Motorcycle");
    this.spot[4]= new ParkingSpot("Electric");
}
}
