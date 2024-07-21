/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classpackage;

import java.io.*;

public class AddEmployees {
     Filesystem ad = new Filesystem("Workers.txt");
    
    private String Employeeid;
    private String Employeename;
    private String EmployeeAddress;
    private String Contact;
    private String DepartmentName;

    public AddEmployees() {
    }

    public AddEmployees(String Employeeid, String Employeename, String EmployeeAddress,String Contact,String DepartmentName ) {
        this.Employeeid = Employeeid;
        this.Employeename = Employeename;
        this.EmployeeAddress = EmployeeAddress;
        this.Contact = Contact;
        this.DepartmentName = DepartmentName;
        
    }

    public String getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(String Employeeid) {
        this.Employeeid = Employeeid;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String Employeename) {
        this.Employeename = Employeename;
    }

    public String getEmployeeAddress() {
        return EmployeeAddress;
    }

    public void setEmployeeAddress(String EmployeeAddress) {
        this.EmployeeAddress = EmployeeAddress;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
      public boolean AddEmployees()
    {
        if (!ad.createANewFile()) 
        {
          String record = Employeeid+"/"+Employeename+"/"+EmployeeAddress+"/"+Contact+"/"+DepartmentName;
          System.err.println(Employeeid+"/"+Employeename+"/"+EmployeeAddress+"/"+Contact+"/"+DepartmentName);
          return ad.writeDataToFile(record);
        }
        return false;
    
    }
     public boolean searchEmployeesdetails(String Employeeid) {
     boolean isFound = false;
        try {
            String[] words = null;
            BufferedReader emp = ad.readFile();
            String Employees;
            outerloop:
            while ((Employees = emp.readLine()) != null) {
                words = Employees.split("/");
                for (String word : words) {
                    if (word.equals(Employeeid)) {
                        isFound = true;
                        this.setEmployeeid(words[0]);
                        this.setEmployeename(words[1]);
                        this.setEmployeeAddress(words[2]);
                        this.setContact(words[3]);
                        this.setDepartmentName(words[4]);
                        break outerloop;
                    }
                }
            }
        } 
        catch (Exception e)
        {
            
        }
        return isFound;
    
    }
      public String viewEmployeesdetails() 
    {
        String Employeees, allEmployeees = "";
        String[] words = null;
        

        BufferedReader emp = ad.readFile();

        try {
            while ((Employeees = emp.readLine()) != null) {
                words = Employeees.split("/");
                allEmployeees += words[0]+"\t"+words[1]+"\t"+ words[2]+"\t"+ words[3]+"\t"+ words[4]+"\n";
               
                

            }
        } 
        
        catch (Exception e)
        {
        }
        
        return allEmployeees;
    }
    
}
