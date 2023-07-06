package models;

import eNum.eRole;

import java.io.Serializable;

public class Trainer extends User implements Serializable {
    private String role = String.valueOf(eRole.PT);
    private int salary;
    private int dayOff;
    private double revenueBonus;
    private double totalPrice;
    private double exp;
    private int level;
    private String skill;
    private String degree;
    private String coachingStyle;
    private String schedule;

    public Trainer(String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender) {
        super(name, userName, passWord, phone, cccd, address, email, gender);
    }

    public Trainer(String name, String userName, String passWord, int phone, int cccd, String address, String email, String gender, String role, int salary, int dayOff, double revenueBonus, double totalPrice, double exp, int level, String skill, String degree, String coachingStyle, String schedule) {
        super(name, userName, passWord, phone, cccd, address, email, gender);
        this.role = role;
        this.salary = salary;
        this.dayOff = dayOff;
        this.revenueBonus = revenueBonus;
        this.totalPrice = totalPrice;
        this.exp = exp;
        this.level = getLevel();
        this.skill = skill;
        this.degree = degree;
        this.coachingStyle = coachingStyle;
        this.schedule = schedule;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public double getRevenueBonus() {
        return revenueBonus;
    }

    public void setRevenueBonus(double revenueBonus) {
        this.revenueBonus = revenueBonus;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public int getLevel() {
        if(exp > 5 ) {
            return level = 3;
        } else if ( exp > 2) {
            return level = 2;
        }
        return level = 1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCoachingStyle() {
        return coachingStyle;
    }

    public void setCoachingStyle(String coachingStyle) {
        this.coachingStyle = coachingStyle;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
