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
public class VisitingEmployee extends Employee {
    private int numHours;
    private int perHourRate;
    private static int bonusRate;

    public VisitingEmployee(String name, int id, double BasicSalary, int AmountPerJobs, int numHours, int perHourRate, int bonusRate) {
        super(name,id, BasicSalary, AmountPerJobs);
        this.numHours = numHours;
        this.perHourRate = perHourRate;
        this.bonusRate = bonusRate;
    }

    public int getNumHours() {
        return numHours;
    }

    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    public int getPerHourRate() {
        return perHourRate;
    }

    public void setPerHourRate(int perHourRate) {
        this.perHourRate = perHourRate;
    }

    public static int getBonusRate() {
        return bonusRate;
    }

    public static void setBonusRate(int bonusRate) {
        VisitingEmployee.bonusRate = bonusRate;
    }
    
    @Override
    public void setBasicSalary(double salary){
       this.BasicSalary = salary;
    }
    
   public int computeBonus(){
       int bonusamount = getAmountPerJobs()*bonusRate;
       bonusamount = bonusamount/100;

       if(getJobsCount(Status.COMPLETED) > 3 && numHours > 30){
           int bonus = getJobsCount(Status.COMPLETED)-3;
           bonus = (bonus*bonusamount)+ 5000;
           return bonus ;
       }
       else if (getJobsCount(Status.COMPLETED) > 3 && numHours <= 30){
           int bonus = getJobsCount(Status.COMPLETED)-3; 
           bonus = bonus * bonusamount;
           return bonus;
       }
       else if (getJobsCount(Status.COMPLETED) <= 3 && numHours >= 30)
       {
           return 5000;
       }
       else
       {
           return 0;
       }
   }
   
    @Override
   public double computeTotalSalary(){
       
       double TotalSalary = 0+ numHours * perHourRate + getJobsCount(Status.COMPLETED) * 
                     getAmountPerJobs()+ computeBonus();
       
       return TotalSalary;
   }
   
    @Override
    public String toString() {
        return "VisitingEmployee{" + "numHours=" + numHours + ", perHourRate=" + perHourRate + '}';
    }
    
    public void Print_Stats()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Num Hours: " + getNumHours());
        System.out.println("Per Hour Rate : " + getPerHourRate());
        System.out.println("Bonus Rate : " + getBonusRate());
        System.out.println("Bonus Amount : " + computeBonus());
        System.out.println("Total completed jobs :" + getJobsCount(Status.COMPLETED));
        System.out.println("TotalSalary : " + computeTotalSalary());
    }
}
