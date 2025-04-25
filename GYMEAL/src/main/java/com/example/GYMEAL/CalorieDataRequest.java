package com.example.GYMEAL;

public class CalorieDataRequest {
    // with all variables to hold the values from json
private  double maintenance ;
private  double mildDeficit ;
private  double moderateDeficit ;
private  double aggressiveDeeficit ;
private  double mildGain ;
private  double moderateGain ;
private double aggressiveGain;
private  double protein ;
private String bmi;
private String goal;

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

    public void setMildGain(double mildGain) {
        this.mildGain = mildGain;
    }

    public void setModerateGain(double moderateGain) {
        this.moderateGain = moderateGain;
    }

    public void setAggressiveGain(double aggressiveGain) {
        this.aggressiveGain = aggressiveGain;
    }

    public double getMildGain() {
        return mildGain;
    }

    public double getModerateGain() {
        return moderateGain;
    }

    public double getAggressiveGain() {
        return aggressiveGain;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getBmi() {
        return bmi;
    }

    public String getGoal() {
        return goal;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }


    @Override
    public String toString() {
        return "CalorieDataRequest{" +
                "maintenance=" + maintenance +
                ", mildDeficit=" + mildDeficit +
                ", moderateDeficit=" + moderateDeficit +
                ", aggressiveDeeficit=" + aggressiveDeeficit +
                ", mildGain=" + mildGain +
                ", moderateGain=" + moderateGain +
                ", aggressiveGain=" + aggressiveGain +
                ", protein=" + protein +
                ", bmi='" + bmi + '\'' +
                ", goal='" + goal + '\'' +
                '}';
    }

}
