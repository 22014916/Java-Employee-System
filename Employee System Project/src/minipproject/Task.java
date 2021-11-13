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
public class Task {
   private int TaskID;
   private String TaskName;
   private Status TaskStatus;


    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int TaskID) {
        this.TaskID = TaskID;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String TaskName) {
        this.TaskName = TaskName;
    }

    public Status getTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(Status TaskStatus) {
        this.TaskStatus = TaskStatus;
    }
   
    public String getDate(){
       SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date today = Calendar.getInstance().getTime();
        String dateToString = formatter.format(today);
        return (dateToString);
        
    } 
}
