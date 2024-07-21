/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classpackage;

import java.io.*;

public class AddDepartments {
     Filesystem ad = new Filesystem("Departments.txt");
    
    private String Departmentid;
    private String Departmentname;
    private String Departmentlocation;
    

    public AddDepartments() {
    }

    public AddDepartments(String Departmentid, String Departmentname, String Departmentlocation) {
        this.Departmentid = Departmentid;
        this.Departmentname = Departmentname;
        this.Departmentlocation = Departmentlocation;
        
    }

    public String getDepartmentid() {
        return Departmentid;
    }

    public void setDepartmentid(String Departmentid) {
        this.Departmentid = Departmentid;
    }

    public String getDepartmentname() {
        return Departmentname;
    }

    public void setDepartmentname(String Departmentname) {
        this.Departmentname = Departmentname;
    }

    public String getDepartmentlocation() {
        return Departmentlocation;
    }

    public void setDepartmentlocation(String Departmentlocation) {
        this.Departmentlocation = Departmentlocation;
    }
      public boolean AddDepartments()
    {
        if (!ad.createANewFile()) 
        {
          String record = Departmentid+"/"+Departmentname+"/"+Departmentlocation;
          System.err.println(Departmentid+"/"+Departmentname+"/"+Departmentlocation);
          return ad.writeDataToFile(record);
        }
        return false;
    
    }
     public boolean searchDepartmentsdetails(String Departmentid) {
     boolean isFound = false;
        try {
            String[] words = null;
            BufferedReader emp = ad.readFile();
            String Departments;
            outerloop:
            while ((Departments = emp.readLine()) != null) {
                words = Departments.split("/");
                for (String word : words) {
                    if (word.equals(Departmentid)) {
                        isFound = true;
                        this.setDepartmentid(words[0]);
                        this.setDepartmentname(words[1]);
                        this.setDepartmentlocation(words[2]);
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
      public String viewDepartmentsdetails() 
    {
        String Departments, allDepartments = "";
        String[] words = null;
        

        BufferedReader emp = ad.readFile();

        try {
            while ((Departments = emp.readLine()) != null) {
                words = Departments.split("/");
                allDepartments += words[0]+"\t"+words[1]+"\t"+ words[2]+"\n";
               
                

            }
        } 
        
        catch (Exception e)
        {
        }
        
        return allDepartments;
    }
}
