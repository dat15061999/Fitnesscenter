package utils;

import models.Bill;

import java.time.LocalDate;
import java.util.List;

public class BillReport {
    public static double calculaterMonthlyRevenue(List<Bill> bill,int year , int month) {
        double monthlyRevenue = 0.0;
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        for (Bill item : bill) {
            if (item.getTimeExp().isAfter(startDate.minusDays(1)) && item.getTimeExp().isBefore(endDate.plusDays(1))) {
                monthlyRevenue += item.getTotal();
            }
        }
        return monthlyRevenue;
    }
    public static double calculateYearlyRevenue(List<Bill> bill, int year) {
        double yearlyRevenue = 0.0;
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfYear());
        for (Bill item : bill) {
            if (item.getTimeExp().isAfter(startDate.minusDays(1)) && item.getTimeExp().isBefore(endDate.plusDays(1))) {
                yearlyRevenue += item.getTotal();
            }
        }
        return yearlyRevenue;
    }
}
