/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipproject;

import java.util.Scanner;

/**
 *
 * @author absm5
 */
public class Employee {
    
   private String name;
   private int id;
   protected double BasicSalary;
   private Task [] Jobs;
   private final int AmountPerJobs;

    public Employee(String name, int id, double BasicSalary, int AmountPerJobs) {
        this.name = name;
        this.id = id;
        this.BasicSalary = BasicSalary;
        this.AmountPerJobs = AmountPerJobs;
    }

    public int getAmountPerJobs(){
       return AmountPerJobs;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(double BasicSalary) {
        this.BasicSalary = BasicSalary;
    }

    public  void assign_Jobs() {
        Scanner sc = new Scanner(System.in);
        Jobs =  new Task[7];

        for(int i=0;i<3;i++)
        {
            Jobs[i] = new Task(); 
            System.out.println("Enter task ID : ");
            int id = sc.nextInt();
            Jobs[i].setTaskID(id);
            
            System.out.println("Enter task name : ");
            sc.nextLine();
            Jobs[i].setTaskName(sc.nextLine());
            
            System.out.println("Enter task status");
            Jobs[i].setTaskStatus(Status.valueOf(sc.nextLine().toUpperCase()));       
        }
    }

    public void setJobs(Task[] Jobs) {
        this.Jobs = Jobs;
    }
    
    public double computeTotalSalary(){
     return 0;
    }
    
    public int getJobsCount(Status s){
        int counter = 0;
        
        for(int i =0; i<3; i++)
        {
            Status status =  Jobs[i].getTaskStatus();
            if(s.equals(status))
            {
                counter++;
            }
        }
       return counter; 
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", BasicSalary=" + BasicSalary + ", Jobs=" + Jobs + ", AmountPerJobs=" + AmountPerJobs + '}';
    }

}
