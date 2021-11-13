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
public class LeaveApplication {
    private MyDate startDate;
    private MyDate endDate;
    private String reason;
    private LeaveType type;
    private int TotalDays;

      public LeaveApplication(MyDate startDate, int TotalDays) 
    {
        this.startDate = startDate;
        this.TotalDays = TotalDays;
    }
    
    public int getTotalDays() 
    {
        return TotalDays;
    }

}
