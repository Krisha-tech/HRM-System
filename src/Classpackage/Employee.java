/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classpackage;

import java.io.*;

public class Employee {
     Filesystem fs = new Filesystem("Employees.txt");
    
    private String UserId;
    private String Password;
    private String Role;
   

    public Employee(String UserId, String Password) {
        this.UserId = UserId;
        this.Password = Password;
    }

    public Employee(String UserId, String Password, String Role) {
        this.UserId = UserId;
        this.Password = Password;
        this.Role = Role;
    }

    public Employee() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
     public boolean addNewUser(){
    if(!fs.createANewFile())
    {
        String record = UserId+"/"+Password+"/"+Role;
        return fs.writeDataToFile(record);
    }
    return false;
    }
     
      public boolean validateLogin() 
    {
        try {
            String[] words = null;
            BufferedReader Employees = fs.readFile();
            String Employee;

            while ((Employee = Employees.readLine()) != null) {
                words = Employee.split("/");
                if (words[0].equals(UserId) && words[1].equals(Password) && words[2].equals(Role)) {
                    this.setUserId(words[0]);
                    this.setPassword(words[1]);
                    this.setRole(words[2]);
                    return true;
                }
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println("Something went wrong creating file"+e);
        }

        return false;
    }
       public String viewAllEmployees() 
     {
        String Employees, allUsers = "";
        String[] words = null;
       
        BufferedReader user = fs.readFile();
        try {
            while ((Employees = user.readLine()) != null) {
                words = Employees.split("/");
                
                allUsers += words[0]+"\t"+words[2]+"\n";
                
            }
        } 
        
        catch (Exception e) 
        {}
        
        
        return allUsers;
    }
    
}
