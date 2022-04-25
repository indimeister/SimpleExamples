package com.indimeister.examples;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Solution {

    public static String DATE_TIME = "MM-dd-yyyy HH:mm";

    /**
     * return between dates
     * @param initHr
     * @param endHr
     * @return
     */
    public static String betweenDates(String initHr, String endHr) {
        LocalDateTime ldtInit = LocalDateTime.parse(initHr, DateTimeFormatter.ofPattern(DATE_TIME));
        LocalDateTime ldtEnd = LocalDateTime.parse(endHr, DateTimeFormatter.ofPattern(DATE_TIME));

        Duration dt = Duration.between(ldtInit, ldtEnd);

        return String.valueOf(dt);

    }

    /**
     * Tax
     * @param income
     * @return
     */
    public static String callTax(float income) {
        if (Objects.nonNull(income)) {
            if (Float.compare(income, new Float(1)) == 0 || Float.compare(income, new Float(18.000)) == 0) {
                return "nil";
            } else if (Float.compare(income, new Float(18.001)) == 0 || Float.compare(income, new Float(27.000)) == 0) {
                return calCents(income, new Float(10));
            } else if (Float.compare(income, new Float(27.001)) == 0 || Float.compare(income, new Float(37.000)) == 0) {
                return calCents(income, new Float(15.5));
            } else {
                return calCents(income, new Float(21));
            }
        }
        return null;
    }

    /**
     * calc cents
     * @param income
     * @param cents
     * @return
     */
    public static String calCents(float income, float cents){
        float vlr = income * cents;
// float vlr1 = income * cents / 100;
        return String.format("%.02f", vlr);

        //TODO Delete
// int i = Math.round(income);
// for(int x = 0; x<= i; x++){
// vlr = valor + cents;
// }
    }

    public static void main(String[] args) {

        System.out.println("============ TEST TAX ============");
        System.out.println("Test TAX 1: " + callTax(new Float(1)));
        System.out.println("Test TAX 2: " + callTax(new Float(18.0001)));


        //dates
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_TIME);
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime currentDateEnd =currentDate.plus(6,ChronoUnit.HOURS);

        String dtInit = currentDate.format(fmt);
        String dtEnd = currentDateEnd.format(fmt);

        System.out.println("============ TEST Dates ============");
        System.out.println("Test Dates 1: " + betweenDates(dtInit,dtEnd));

    }
}
