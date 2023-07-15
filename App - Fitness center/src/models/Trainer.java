package models;
import eNum.eRole;
import eNum.eStatusTrainer;
import java.io.Serializable;
import java.util.List;
import static utils.CurrencyFormat.covertPriceToString;

public class Trainer extends User implements Serializable {
    private static final long serialVersionUID = -340910112562114070L;
    private String role = String.valueOf(eRole.PT);
    private int salary;
    private double revenueBonus = 1000000;
    private double totalPrice;
    private double exp;
    private int level;
    private String skill;
    private String degree;
    private double priceCoach = 1000000;
    private double priceCoachHire;
    private String coachingStyle;
    private List<String> schedule;
    private String status ;
    private List<Integer> workDay;


    public Trainer(int id, String name, int age, int phone, String gender, double exp, int level, String skill, String degree,String coachingStyle, List<String> schedule,String status ,double priceCoachHire) {
        super(id,name,age,phone,gender);
        this.role = role;
        this.exp = exp;
        this.level = getLevel();
        this.skill = skill;
        this.degree = degree;
        this.coachingStyle = coachingStyle;
        this.schedule = schedule;
    }

    public Trainer(int id,String name, String userName, String passWord,int age, int phone, int cccd, String address, String email, String gender, String role, int salary, double totalPrice, double exp, String skill, String degree, String coachingStyle, List<String> schedule,List<Integer> workDay) {
        super(id,name, userName, passWord,age, phone, cccd, address, email, gender);
        this.role = role;
        this.salary = salary;
        this.totalPrice = totalPrice;
        this.exp = exp;
        this.level = getLevel();
        this.skill = skill;
        this.degree = degree;
        this.coachingStyle = coachingStyle;
        this.schedule = schedule;
        this.workDay = workDay;
    }
    public Trainer() {}

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
        int index = getSchedule().size();
        return (index == 2 )? 0 : (index == 1) ? revenueBonus /2 : revenueBonus;
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
        return (exp>5)? 3 : (exp>2) ? 2: 1;
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

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String>schedule) {
        this.schedule = schedule;
    }

    public String getStatus() {
        int index = getSchedule().size();
        return (index > 0 )? eStatusTrainer.AVAILABLE.getName():eStatusTrainer.UNAVAILABLE.getName() ;
    }

    public double getPriceCoach() {
        return priceCoach;
    }

    public void setPriceCoach(double priceCoach) {
        this.priceCoach = priceCoach;
    }

    public double getPriceCoachHire() {
        double level = getLevel();
        return (priceCoach * level);
    }

    public void setPriceCoachHire(double priceCoachHire) {
        this.priceCoachHire = priceCoachHire;
    }

    public double getTotalPrice() {
        return totalPrice = (((getSalary() + getRevenueBonus())/(26))*(getWorkDay().size()));
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getWorkDay() {
        return workDay;
    }

    public void setWorkDay(List<Integer> workDay) {
        this.workDay = workDay;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-17s | %-10s | %-10s | %-8s | %-20s | %-10s | %-8s | %-20s | %-10s | %-20s | %-15s | %-15s | %-24s | %-10s | %-8s | %-10s | %-14s | %-14s | %-14s | %-14s | %-12s | %-14s | \n",
                id, name, username, password.getPasscode(),String.valueOf(age), email, role, phone, address, gender, skill, degree, coachingStyle, getSchedule(),getStatus(), level, exp,covertPriceToString(priceCoach),covertPriceToString(getPriceCoachHire()),covertPriceToString(salary), covertPriceToString(getRevenueBonus()),workDay.size(), covertPriceToString(getTotalPrice()));
    }
}
