/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author absm5
 */
public class RegularEmployee extends Employee {
    private final boolean isDeputed;
    private char Grade;
    private double netSalary;
    private MyDate joiningDate;
    private int amountPerYear;

    public RegularEmployee(String name, int id, double BasicSalary, int AmountPerJobs ,int amountPerYear,boolean isDeputed, char Grade, MyDate joiningDate) 
    {
        super(name, id, BasicSalary,AmountPerJobs);
        this.amountPerYear = amountPerYear;
        this.isDeputed = isDeputed;
        this.Grade = Grade;
        this.joiningDate = joiningDate;
    }

    public RegularEmployee(String name, int id, double BasicSalary, int AmountPerJobs ,int amountPerYear,boolean isDeputed,MyDate joiningDate) {
        super(name, id, BasicSalary, AmountPerJobs);
        this.isDeputed = isDeputed;
        this.netSalary = netSalary;
        this.joiningDate = joiningDate;
        this.amountPerYear = amountPerYear;
    }
    
    public int getAmountPerYear() {
        return amountPerYear;
    }

    public void setAmountPerYear(int amountPerYear) {
        this.amountPerYear = amountPerYear;
    }

    public char getGrade() {
        return Grade;
    }

    public void setGrade(char Grade) {
        this.Grade = Grade;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public MyDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(MyDate joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    @Override
    public double computeTotalSalary()
    {
        if(isDeputed == false)
        {
           netSalary = super.getBasicSalary()+(getExperienceYears()*amountPerYear)+(super.getAmountPerJobs()*super.getJobsCount(Status.COMPLETED)) - computeTax(); 
        }
        else 
        {
            netSalary = (super.getBasicSalary() + (super.getJobsCount(Status.COMPLETED)*amountPerYear)) - computeTax();
        }
        return netSalary;
    }
    
    public double computeTax()
    {
       if (isDeputed == false)
       {
           switch (Grade)
           {
             case 'W':
                return 0; 
             case 'X':
                 double salary_x = super.getBasicSalary()+(getExperienceYears()*amountPerYear)+(getAmountPerJobs()*getJobsCount(Status.COMPLETED));
                 return salary_x*0.025;
             case 'Y':
                 double salary_y = super.getBasicSalary()+(getExperienceYears()*amountPerYear)+(getAmountPerJobs()*getJobsCount(Status.COMPLETED));
                 return salary_y*0.050;
             case 'Z':
                 double salary_z = super.getBasicSalary()+(getExperienceYears()*amountPerYear)+(getAmountPerJobs()*getJobsCount(Status.COMPLETED));
                 return salary_z*0.080;
           } 
       }
       else if (isDeputed == true)
       {
           return (super.getBasicSalary()*10)/100;
       }
       return 0;
    }
    public boolean applyForLeave(LeaveApplication LA1)
    {
        if(isDeputed == false && getExperienceYears() >= 3 && getJobsCount(Status.ASSIGNED)==0 && getJobsCount(Status.CONTINUED)== 0 )
        {
            return true;
        }
        return false;
    }
    
    @Override
    public void setBasicSalary(double salary)
    {
        if(isDeputed == false)
        {
          switch (Grade) 
          {
            case 'W':
                this.BasicSalary = 20000;
          break;
           case 'X':
               this.BasicSalary = 50000;
          break;
           case 'Y':
               this.BasicSalary = 70000;
          break;
           case 'Z':
               this.BasicSalary = 120000;
           break;
           default:
               break;
           }
        }
        else if (isDeputed == true)
        {
         if(salary >=70000 && salary <= 150000)
         {
             this.BasicSalary = salary;
         }
        }
    }   
    
    public int getExperienceYears()
    {
        int ExperiencedYears = 0;
        
        Calendar today = Calendar.getInstance();
        int Years = today.get(Calendar.YEAR);
        
        ExperiencedYears = Years - joiningDate.getYear();
        
        return ExperiencedYears;
    }
    
    
    public void Print_Stats()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("BasicSalary: " + getBasicSalary());
        System.out.println("Tax Amount: " + computeTax());
        System.out.println("ExperiencedYears: " + getExperienceYears());
        System.out.println("Total completed jobs :" + getJobsCount(Status.COMPLETED));
        System.out.println("TotalSalary : " + computeTotalSalary());
        
    }
}
