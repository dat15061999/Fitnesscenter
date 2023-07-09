package models;

import eNum.eRole;
import eNum.eStatusTrainer;

import java.io.Serializable;
import java.util.Arrays;

public class Trainer extends User implements Serializable {
    private static final long serialVersionUID = -340910112562114070L;
    private String role = String.valueOf(eRole.PT);
    private int salary;
    private double revenueBonus;
    private double totalPrice;
    private double exp;
    private int level;
    private String skill;
    private String degree;
    private String coachingStyle;
    private String[] schedule;
    private String status ;

    public Trainer(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
    }

    public Trainer(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role, int salary, double revenueBonus, double totalPrice, double exp, String skill, String degree, String coachingStyle, String[] schedule) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
        this.role = role;
        this.salary = salary;
        this.revenueBonus = revenueBonus;
        this.totalPrice = totalPrice;
        this.exp = exp;
        this.level = getLevel();
        this.skill = skill;
        this.degree = degree;
        this.coachingStyle = coachingStyle;
        this.status =  status;
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

    public String[] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[] schedule) {
        this.schedule = schedule;
    }

    public String getStatus() {
        this.status =  eStatusTrainer.AVAILABLE.getName();
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-10s | %-10s | %-10s |  %-4s  | %-20s | %-10s | %-10s | %-20s | %-10s | %-10s | %-10s | %-15s | %-10s | %-15s |\n",
                id, name, userName, passWord,String.valueOf(age), email, role, phone, address, gender, skill, degree, coachingStyle, Arrays.toString(schedule),getStatus(), level, exp, revenueBonus, totalPrice);
    }
}
