package com.example.GYMEAL;

public class CalorieDataRequest {
    // with all variables to hold the values from json
private  double maintenance ;
private  double mildDeficit ;
private  double moderateDeficit ;
private  double aggressiveDeeficit ;
private  double protein ;

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public double getMildDeficit() {
        return mildDeficit;
    }

    public void setMildDeficit(double mildDeficit) {
        this.mildDeficit = mildDeficit;
    }

    public double getModerateDeficit() {
        return moderateDeficit;
    }

    public void setModerateDeficit(double moderateDeficit) {
        this.moderateDeficit = moderateDeficit;
    }

    public double getAggressiveDeeficit() {
        return aggressiveDeeficit;
    }

    public void setAggressiveDeeficit(double aggressiveDeeficit) {
        this.aggressiveDeeficit = aggressiveDeeficit;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }
}
