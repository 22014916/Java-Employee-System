/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipproject;

/**
 *
 * @author absm5
 */
final class MyDate {
  private int day;
  private int month;
  private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        if(day >= 1 && day <= 31){
          this.day = day;  
        }
        else{
            System.out.println("Please select a day between 1 - 31 : ");
        } 
    }
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month >= 1 && month <= 31){
          this.month = month;  
        }
        else{
            System.out.println("Please select a day between 1 - 12 : ");
        } 
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year <2021 )
        {
           this.year = year; 
        }
        else {
            System.out.println("The year you have chosen is in the future tense ");
        }
    }  
}
