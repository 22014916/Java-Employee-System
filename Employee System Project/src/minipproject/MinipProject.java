/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author absm5
 */
public class MinipProject {
    static ArrayList<RegularEmployee> Regular_Employees = new ArrayList<RegularEmployee>();
    
    static Scanner scanner = new Scanner(System.in);  
    public static char ChoicesGrade()
    {
        System.out.println("Enter the employee grade ");
        char grade = scanner.next().charAt(0); 
        if (grade == 'W' || grade == 'w')
        {
            return 'W';
        }
        else if (grade == 'X' || grade == 'x')
        {
            return 'X';
        }
        else if (grade == 'Y' || grade == 'y')
        {
            return 'Y';
        }
        else if (grade == 'Z' || grade == 'z')
        {
            return 'Z';
        }
        
        return 'A';
    }

    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in); 
         do 
         {
         switch (choice)
         {
             case 1:
                 System.out.println("Enter the employee name ");
                 scanner.nextLine();
                 String name = scanner.nextLine();
                 
                 System.out.println("Enter the ID of the employee ");
                 int id = scanner.nextInt();
                 
                 char grade;
                 do
                 {
                     grade = ChoicesGrade();
                 }
                 while(grade == 'A');
                 
                 System.out.println("How much would you like to assign a pay per job to assign this employee ");
                 int amount_per_job = scanner.nextInt();
                 
                 System.out.println("How much is amount per year ");
                 int amount_per_year = scanner.nextInt();
                 
                 boolean is_Deputed = false;
                 
                 System.out.println("What date did this employee start in the company:  ");
                 System.out.println("Example Format : 10/12/2000 ");
                 
                 System.out.println("Enter Day : ");
                 int day = scanner.nextInt();
                 
                 System.out.println("Enter Month : ");
                 int month = scanner.nextInt();
                 
                 System.out.println("Enter Year : ");
                 int year = scanner.nextInt();
                 
                 RegularEmployee r1 = new RegularEmployee (name,id,0,amount_per_job, amount_per_year, is_Deputed, grade, new MyDate(day,month,year));
                 Regular_Employees.add(r1);
                 
                 r1.assign_Jobs();
                 r1.setBasicSalary(0);
                 r1.computeTax();
                 r1.getExperienceYears();
                 r1.computeTotalSalary();
                         
                 System.out.println("BPS Stats: ");
                 r1.Print_Stats();

                 System.out.println("1. Would you like to apply for leave.");
                 int choice_two = scanner.nextInt();
                 
                 if(choice_two == 1)
                 {
                     System.out.println("Enter start day ");
                     int start_day = scanner.nextInt();
                     
                     System.out.println("Enter start month ");
                     int start_month = scanner.nextInt();
                     
                     System.out.println("Enter start year ");
                     int start_year = scanner.nextInt();
                     
                     System.out.println("How many number of days do you want your leave to be? ");
                     int total_days= scanner.nextInt();
                     
                     LeaveApplication d1 = new LeaveApplication(new MyDate(start_day, start_month,start_year),total_days);
                     
                     boolean leave_status = r1.applyForLeave(d1);
                     
                     if(leave_status)
                     {
                         System.out.println("You leave has been accepted ");
                         System.out.println(d1.getTotalDays() + " is your total leave days");
                     }
                     else
                     {
                         System.out.println("Your leave is denied because you do not meet the requirements ");   
                     }
                 }
                 else
                 {
                     System.out.println("Please pick 1 as your input");
                 }
                 break;
             
             case 2:
                 
                 
                 System.out.println("Enter the employee name ");
                 scanner.nextLine();
                 String name_2 = scanner.nextLine();
                 
                 System.out.println("Enter the ID of the employee ");
                 int id_2 = scanner.nextInt();
                 
                 System.out.println("How much would you like to assign a pay per job to assign this employee ");
                 int amount_per_job_2 = scanner.nextInt();
                 
                 System.out.println("How much is amount per year ");
                 int amount_per_year_2 = scanner.nextInt();
                 
                 boolean is_Deputed_2 = true;
                 
                 System.out.println("What date did this employee start in the company:  ");
                 System.out.println("Example Format : 10/12/2000 ");
                 
                 System.out.println("Enter Day : ");
                 int day_2 = scanner.nextInt();
                 
                 System.out.println("Enter Month : ");
                 int month_2 = scanner.nextInt();
                 
                 System.out.println("Enter Year : ");
                 int year_2 = scanner.nextInt();
                 
                 float basic_salary_2 = 0;
                 
                 do
                 {
                 
                 System.out.println("What is the basic salary of this SPS employee ");
                  basic_salary_2 = scanner.nextFloat();
                 
                 }
                 while(basic_salary_2 < 70000 || basic_salary_2 >150000);
                 
                 RegularEmployee r2 = new RegularEmployee (name_2,id_2,0,amount_per_job_2, amount_per_year_2, is_Deputed_2,new MyDate(day_2,month_2,year_2));
                 Regular_Employees.add(r2);
                 
                 r2.assign_Jobs();
                 r2.setBasicSalary(basic_salary_2);
                 r2.computeTax();
                 r2.getExperienceYears();
                 r2.computeTotalSalary();
                         
                 System.out.println("SPS Stats: ");
                 r2.Print_Stats();
                 
                 break;
             case 3:
                 System.out.println("Please enter the name of the employee ");
                 scanner.nextLine();
                 String name_3 = scanner.nextLine();
                 
                 System.out.println("Please enter the ID of this employee ");
                 int id_3 = scanner.nextInt();
                 
                 System.out.println("How much would you like to assign to this employee per job ");
                 int jobs_amount = scanner.nextInt();
                 
                 System.out.println("How many hours would you like to give this employee");
                 int num_hours = scanner.nextInt();
                 
                 System.out.println("What is the rate per hour for this employee");
                 int per_hour_rate = scanner.nextInt();
                 
                 System.out.println("What bonus rate would you like to set ");
                 int bonus_rate = scanner.nextInt();
                 
                 VisitingEmployee v1 = new VisitingEmployee (name_3, id_3, 1000, jobs_amount, num_hours, per_hour_rate,bonus_rate); 
                 
                 v1.assign_Jobs();
                 v1.computeBonus();
                 v1.computeTotalSalary();
                 v1.Print_Stats();
                 break;
                 
             default:
                 break;
             
         }
         System.out.println("1. Create BPS, 2. Create SPS, 3. Create Visiting, 4. Exit Application ");
        
        choice = scanner.nextInt();
         }
         while(choice >= 1 && choice <=3);
    }
}
