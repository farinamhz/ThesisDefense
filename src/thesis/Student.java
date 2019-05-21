package thesis;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable{
    int i=0;
    private final String Name;
    private final String LastName;
    private final String StudentID;
    private final String EntryYear;
    private final String NationalID;
    private final String Field;
    private final String AcademicOrientation;
    private final Data data;


    public Student(String Name , String LastName , String StudentID , String EntryYear , String NationalID , String Field 
                   , String AcademicOrientation , String Subject , String Summary){
     this.Name = Name ; 
     this.LastName = LastName;
     this.StudentID = StudentID;
     this.EntryYear = EntryYear;
     this.NationalID = NationalID;
     this.Field = Field;
     this.AcademicOrientation = AcademicOrientation;
     data=new Data(Subject,Summary,getName(),getLastName(),getStudentID());    
    }
    public Data getData() {
        return data;
    }
    public String getName(){
        return this.Name;
    }
    public String getLastName(){
        return this.LastName;
    }
    public String getStudentID(){
        return this.StudentID;
    }
    public String getEntryYear(){
        return this.EntryYear;
    }
    public String getNationalID(){
        return this.NationalID;
    }
    public String getField(){
        return this.Field;
    }
    public String getAcademicOrientation(){
        return this.AcademicOrientation;
    }
    
    public String Adviser_Request_ByStudent (int numTeacher , Teacher [] teacher){
                int i3=0;
                String Request1 = null;
                Scanner s = new Scanner (System.in);
                System.out.println("Select a Adviser");
                for ( i=0 ; i < numTeacher ; i++){
                    System.out.println(teacher[i].getName() + teacher[i].getLastName());
                }
                boolean Exit3=true;
                while ( Exit3==true){
                        
                        System.out.println("Enter Teacher's Lastname :");
                        String TN = s.next();
                        i=0;
                        while( i < numTeacher && i3 !=1000 ){
                           if ( teacher[i].getLastName().equalsIgnoreCase(TN)==true){
                               Request1= teacher[i].getLastName();
                               i3=1000;
                           }
                           i++;
                        }
                        if ( i3==1000){
                         Exit3 = false ;
                        }
                        if(i== (numTeacher+1)) {
                               System.out.println("*** Invalid ! ***");
                         }

                    }
      return Request1;
    }
    
    public String Supervisor_Request_ByStudent(int numTeacher , Teacher[] teacher) {
            int i2=0;
            String Request2 = null ;
            Scanner s = new Scanner (System.in);
                    System.out.println("Select a Supervisor");
                    for ( i=0 ; i < numTeacher ; i++){
                            System.out.println(teacher[i].getName() + teacher[i].getLastName());
                    }
                    boolean Exit2=true ;
                    while ( Exit2==true){   
                        System.out.println("Enter Teacher's Lastname :");
                        String TN = s.next();
                        i=0;
                        while( i < numTeacher && i2 !=1000 ){
                           if ( teacher[i].getLastName().equalsIgnoreCase(TN)==true){
                               Request2= teacher[i].getLastName();
                               i2=1000;
                               
                           }
                           i++;
                        }
                        if ( i2==1000){
                         Exit2 = false ;
                        }
                        if(i== (numTeacher+1)) {
                               System.out.println("*** Invalid ! ***");
                         }

                    }
       return Request2;
  }
    
    public String Student_Status (String status , String Teacher_LastName){
            
        StringBuilder b = new StringBuilder("********\n");
        b.append(Teacher_LastName);
        b.append("\t");
        b.append(status);
        b.append("\n********\n");
        String s=b.toString();
        return s;
    }
    
}