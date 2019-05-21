package thesis;
import java.io.Serializable;
import java.util.*;
public class Teacher implements Serializable{
    private  String Name;
    private  String LastName;
    private  String Field;
    private  String AcademicOrientation;
    private  String TeacherID;
    private  int    Position ;
    
    public static Data data1[]; // supervisor
    public static int data_num1;
    public static Data data2[]; //adviser
    public static int data_num2;
    public static Data data3[]; //manager
    public static int data_num3;
    
    public Teacher(String Name , String LastName , String Field , String AcademicOrientation , String TeacherID , int Position ){
    this.Name = Name;
    this.LastName = LastName;
    this.Field = Field; 
    this.AcademicOrientation = AcademicOrientation;
    this.TeacherID = TeacherID; 
    this.Position = Position;
    data1=new Data[50];
    data_num1=0;
    data2=new Data[50];
    data_num2=0;
    data3=new Data[50];
    data_num3 =0;
}
   
    public String getName(){
        return this.Name;
    }
    
    public String getLastName(){
        return this.LastName;
    }
    
    public String getField(){
        return this.Field;
    }
    
    public String getAcademicOrientation(){
        return this.AcademicOrientation;
    }
    
    public String getTeacherID(){
        return this.TeacherID;
    }
    
    public int getPosition() {
        return Position;
    }
    
    
    public void Request_Supervisor (Data s ){
        data1[data_num1++]=s;
        
    }
    
    public void ShowRequest_Supervisor(String Supervisor_LastName){
       
        for(int i=0;(i<data_num1)&&(data1[i].getSupervisor_LastName().equalsIgnoreCase(Supervisor_LastName)); i++){
            System.out.println("********\n"+data1[i].getName() + "\n" + data1[i].getLastName() 
            + "\n" + data1[i].getID() + "\n" + data1[i].getSubject()
            +"\n" + data1[i].getSummary());
          
           }
    }
    
    public String Accept_BySupervisor (String StudentID){
        String sti=null;
    for ( int i=0;i<data_num1; i++){
        if (data1[i].getID().equalsIgnoreCase(StudentID)){
         sti= StudentID ;
        }
    }
    return sti;    
    }
    
    public String Decline_BySupervisor(String StudentID){
        //String sti = null;
    for ( int i=0;i<data_num1; i++){
        if (data1[i].getID().equalsIgnoreCase(StudentID)){
         //sti= StudentID ;
         data1[i].setAdviser_LastName(null);
         data1[i].setID(null);
         data1[i].setLastName(null);
         data1[i].setName(null);
         data1[i].setSupervisor_LastName(null);
       //data1[i].setStatus(null);
         data1[i].setSubject(null);
         data1[i].setSummary(null);
        }
     }
      return StudentID;
    }
    
    
    public void Request_Adviser (Data a ){
        data2[data_num2++]=a;
        
    }
    
    public void ShowRequest_Adviser(String Adviser_LastName){
       
        for(int i=0;(i<data_num2)&&(data2[i].getAdviser_LastName().equalsIgnoreCase(Adviser_LastName)) ; i++){
            System.out.println("********\n"+data2[i].getName() + "\n" + data2[i].getLastName() 
            + "\n" + data2[i].getID() + "\n" + data2[i].getSubject()
            +"\n" + data2[i].getSummary());
          
           }
    }
    
    public String Accept_ByAdviser(String StudentID){
        String ati=null;
        for ( int i=0;i<data_num2; i++){
            if (data2[i].getID().equalsIgnoreCase(StudentID)){
             ati= StudentID ;
            }
        }
      return ati;    
    }
    
    public String Decline_ByAdviser(String StudentID){
        String ati = null;
    for ( int i=0;i<data_num2; i++){
        if (data2[i].getID().equalsIgnoreCase(StudentID)){
         ati= StudentID ;
         data_num2 -- ;
        }
    }
    return ati ;
    }
   
    public void SendRequest_ToManager_Bysupervisor(Data m){
         data3[data_num3++]=m;
    }
    
    public void ShowRequest_Manager(int Position ){
       
        for(int i=0;(i<data_num3)&&(2 == Position) ; i++){
            System.out.println("********\n"+data3[i].getName() + "\n" + data3[i].getLastName() 
            + "\n" + data3[i].getID() + "\n" + data3[i].getSubject()
            +"\n" + data3[i].getSummary() + "\n"+ "Supervisor's Lastname:\t"+data3[i].getSupervisor_LastName());
           }
    }
    
    public String Accept_ByManager(String StudentID){
        String ati=null;
        for ( int i=0;i<data_num3; i++){
            if (data3[i].getID().equalsIgnoreCase(StudentID)){
             ati= StudentID ;
            }
        }
      return ati;    
    }
    
    public String Decline_ByManager(String StudentID){
        String ati = null;
    for ( int i=0;i<data_num3; i++){
        if (data3[i].getID().equalsIgnoreCase(StudentID)){
         ati= StudentID ;
         data_num3 -- ;
        }
    }
    return ati ;
    }
    

    public String Request_InternalExaminer_ByManager( int numTeacher , Teacher[] teacher , int numStudent , Student[] student , String studentid)// Internal_Examiner TeacherID
    {  
        
        String Request_1 = null; // request for Internal Examiner
        int i2=0;
        Scanner s = new Scanner (System.in);
        
        System.out.println("Select a InternalExaminer :");
        for (int o=0 ; o <numStudent ; o++){
            if (student[o].getStudentID().equalsIgnoreCase(studentid)){
                for ( int i=0 ; i < numTeacher ; i++){
                    if (teacher [i].getLastName().equalsIgnoreCase(student[o].getData().getSupervisor_LastName())== false ){
                        if(teacher [i].getLastName().equalsIgnoreCase(student[o].getData().getAdviser_LastName() ) == false ){
                            System.out.println(teacher[i].getName() +"\t"+ teacher[i].getLastName() +"\t"+ teacher[i].getTeacherID());
                        }
                    }
                }
            }
        }
        boolean Exit_1 = true;
        while(Exit_1 == true){
            System.out.println("Enter Internal_Examiner 's TeacherID");
            String EETID = s.next(); // Internal_Examiner's TeacherID
            int i=0 ;
            while( i < numTeacher && i2 !=1000 ){
                            if ( teacher[i].getTeacherID().equalsIgnoreCase(EETID)==true){
                               Request_1= teacher[i].getTeacherID();
                               i2=1000;                  
                            }
                            i++;
            }
            
            if ( i2==1000){
                Exit_1 = false ;
            }
            if(i== (numTeacher+1)) {
                System.out.println("*** Invalid ! ***");
            }        
        }
        return Request_1;
    }
    
    public void ShowRequest_for_InternalExaminer(String IETID , Student[] student , int numStudent){ //Internal_Examiner_TeacherID
     
        for ( int i=0;  i<numStudent  ; i++){
            if (student[i].getData().getInternal_Examiner_ID().equalsIgnoreCase(IETID)){
                    System.out.println("********\n"
                    +student[i].getData().getName() + "\n" + student[i].getData().getLastName() 
                    + "\n" + student[i].getData().getID() + "\n" + student[i].getData().getSubject()
                    +"\n" + student[i].getData().getSummary());
            }
        }
    }
    
    public String Request_ExternalExaminer_ByManager_1( int numTeacher , Teacher[] teacher ){ //First One
        
        String Request_2 = null; // request for Internal Examiner
        int i2=0;
        Scanner s = new Scanner (System.in);
        System.out.println("Select a ExternalExaminer :");
        for ( int i=0 ; i < numTeacher ; i++){
                    if (teacher[i].getPosition() == 3){
                            System.out.println(teacher[i].getName() +"\t"+ teacher[i].getLastName() +"\t"+ teacher[i].getTeacherID());
                    }
        }
        boolean Exit_1 = true;
        while(Exit_1 == true){
            System.out.println("Enter External_Examiner 's TeacherID");
            String EETID = s.next(); // External_Examiner's TeacherID
            int i=0 ;
            while( i < numTeacher && i2 !=1000 ){
                            if ( teacher[i].getTeacherID().equalsIgnoreCase(EETID)==true){
                               Request_2= teacher[i].getTeacherID();
                               i2=1000;                  
                            }
                            i++;
            }
            if ( i2==1000){
                Exit_1 = false ;
            }
            if(i== (numTeacher+1)) {
                System.out.println("*** Invalid ! ***");
            }        
        }
        return Request_2;
    }       
    
    public String Request_ExternalExaminer_ByManager_2( int numTeacher , Teacher[] teacher , String Request_1) { //Second one
        int i2=0;
        Scanner s = new Scanner (System.in);
        for ( int i=0 ; i < numTeacher ; i++){
                    if ((teacher[i].getPosition() == 3 ) &&
                        (teacher[i].getTeacherID().equalsIgnoreCase(Request_1) == false ) ){    
                            System.out.println(teacher[i].getName() +"\t"+ teacher[i].getLastName() +"\t"+ teacher[i].getTeacherID());
                    }
        }
        boolean Exit_1 = true;
        String Request_3 = ""; // request for External Examiner
        while(Exit_1 == true){
            System.out.println("Enter Second External_Examiner 's TeacherID");
            String EETID = s.next(); // External_Examiner's TeacherID
            int i=0 ;
            while( i < numTeacher && i2 !=1000 ){
                            if ( teacher[i].getTeacherID().equalsIgnoreCase(EETID)==true){
                               Request_3= teacher[i].getTeacherID();
                               i2=1000;
                            }
                            i++;
            }
            if ( i2==1000){
                Exit_1 = false ;
            }
            if(i== (numTeacher+1)) {
                System.out.println("*** Invalid ! ***");
            }        
        }
        return Request_3;
    }  
    
    public void ShowRequest_for_ExternalExaminer(String EETID , Student[] student , int numStudent){ //Exernal_Examiner_TeacherID
     
        for ( int i=0;  i<numStudent  ; i++){
            if (student[i].getData().getExternal_Examiner_1_ID().equalsIgnoreCase(EETID)){
                    System.out.println("********\n"
                    +student[i].getData().getName() + "\n" + student[i].getData().getLastName() 
                    + "\n" + student[i].getData().getID() + "\n" + student[i].getData().getSubject()
                    +"\n" + student[i].getData().getSummary());
            }
            if(student[i].getData().getExternal_Examiner_2_ID().equalsIgnoreCase(EETID)){
                    System.out.println("********\n"
                    +student[i].getData().getName() + "\n" + student[i].getData().getLastName() 
                    + "\n" + student[i].getData().getID() + "\n" + student[i].getData().getSubject()
                    +"\n" + student[i].getData().getSummary());
            }
        }
    }
    
    public String Request_Observer_ByEducational_Expert( int numTeacher , Teacher[] teacher , int numStudent , Student[] student , String studentid)
    {  
        
        String Request_3 = null; // request for Observer
        int i2=0;
        Scanner s = new Scanner (System.in);
        
        System.out.println("Select a Observer:");
        for (int o=0 ; o <numStudent ; o++){
            if (student[o].getStudentID().equalsIgnoreCase(studentid)){
                for ( int r=0 ; r < numTeacher ; r++){
                    if(teacher [r].getLastName().equalsIgnoreCase(student[o].getData().getSupervisor_LastName())== false){
                        if(teacher [r].getLastName().equalsIgnoreCase(student[o].getData().getAdviser_LastName() ) == false){
                            if(teacher [r].getTeacherID().equalsIgnoreCase(student[o].getData().getInternal_Examiner_ID()) == false){
                                if(teacher [r].getTeacherID().equalsIgnoreCase(student[o].getData().getExternal_Examiner_1_ID()) == false){
                                    if(teacher [r].getTeacherID().equalsIgnoreCase(student[o].getData().getExternal_Examiner_2_ID()) == false){

                                        System.out.println(teacher[r].getName() +"\t"+ teacher[r].getLastName() +"\t"+ teacher[r].getTeacherID());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        boolean Exit_1 = true;
        while(Exit_1 == true){
            System.out.println("Enter Observer TeacherID");
            String EETID = s.next(); // Observer TeacherID
            int i=0 ;
            while( i < numTeacher && i2 !=1000 ){
                            if ( teacher[i].getTeacherID().equalsIgnoreCase(EETID)==true){
                               Request_3= teacher[i].getTeacherID();
                               i2=1000;                  
                            }
                            i++;
            }
            
            if ( i2==1000){
                Exit_1 = false ;
            }
            if(i== (numTeacher+1)) {
                System.out.println("*** Invalid ! ***");
            }        
        }
        return Request_3;
    }
    
    public void ShowRequest_for_Observer(String OB , Student[] student , int numStudent){
     
        for ( int i=0;  i<numStudent  ; i++){
            if (student[i].getData().getObserver_ID().equalsIgnoreCase(OB)){
                    System.out.println("********\n"
                    +student[i].getData().getName() + "\n" + student[i].getData().getLastName() 
                    + "\n" + student[i].getData().getID() + "\n" + student[i].getData().getSubject()
                    +"\n" + student[i].getData().getSummary());
            }
        }
    }
}