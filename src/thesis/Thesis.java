package thesis;

import java.io.*;
import java.util.*;

public class Thesis {
    
    public static void Print(String s){
        System.out.println(s);
    }
    
    static Student student [] = new Student [100];
    static Teacher teacher [] = new Teacher [50];
    static int numStudent = 0 , numTeacher = 0 ;
    static Educational_Expert e_e[] = new Educational_Expert[1];
    static String path="./data.txt";
    public static void saveToFile() {
        try{
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(path)));
        ArrayList<Object[]> data=new ArrayList<>();
        data.add(student);
        data.add(teacher);
        data.add(e_e);
        data.add(Teacher.data1);
        data.add(Teacher.data2);
        data.add(Teacher.data3);
       
        oos.writeObject(data);
        oos.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }   
    public static void loadFile(){
        try{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        ArrayList<Object[]> data=(ArrayList < Object[] >)ois.readObject();
        Thesis.student=(Student[])data.get(0);
        Thesis.teacher=(Teacher[])data.get(1);
        Thesis.e_e=(Educational_Expert[])data.get(2);
        for(int i=0;i<Thesis.student.length;i++){
           if (Thesis.student[i] != null){
               numStudent++;
           }
        }
        for(int i=0;i<Thesis.teacher.length;i++){
           if (Thesis.teacher[i] != null){
               numTeacher++;
           }   
        }
       
        Teacher.data1=(Data[])data.get(3);
        Teacher.data2=(Data[])data.get(4);
        Teacher.data3=(Data[])data.get(5);
       
        for(int i=0;i<Teacher.data1.length;i++){
           if (Teacher.data1[i] != null){
               Teacher.data_num1++;
           }
        }
        
        for(int i=0;i<Teacher.data2.length;i++){
           if (Teacher.data2[i] != null){
               Teacher.data_num2++;
           }
        }
         
        for(int i=0;i<Teacher.data3.length;i++){
           if (Teacher.data3[i] != null){
               Teacher.data_num3++;
           }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        String Request_1 ="";//for Internal_Examiner
        String Request_2 ="";//for first External_Examiner
        String Request_3 ="";//for second External_Examiner
        String Request_4 ="";//for Observer
        int i=0,j=0,k=0;
        Scanner s = new Scanner(System.in);
        Print ("***Welcom!***");
        
        loadFile();
        
        while (true ) { 
        Print("\n1:SignUp \n" + "2:LogIn\n"+ "3:Events\n");
        int Input= s.nextInt();
        if(Input==1){
            
            Print ("\nWho Are You?");
            Print("1:Student\n" + "2:Teacher\n" + "3:Educational_Expert\n");
        
            int t = s.nextInt();
            switch(t){
                case 1:
                    Print("\n1:BSC_Student\n" + "2:MSC_Student\n" + "3:PHD_Student\n");
                    int t2= s.nextInt();
                    switch (t2)
                    {
                        case 1:
                           Print("\nWelcome to BSC_Student !");
                           Print ("Enter Name ,LastName, StudentID,EntryYear,NationalID,Field,"
                                   + "AcademicOrientation,Subject , Summary");
                           student[numStudent++] = new BSC_Student(s.next() , s.next() , s.next() , s.next() , s.next()
                                                                    ,s.next() , s.next() , s.next(), s.next()); 
                            
                            break;
                        case 2:
                           Print("\nWelcome to BSC_Student !");
                           Print ("Enter Name,LastName,StudentID,EntryYear,NationalID,Field,"
                                   + "AcademicOrientation,Subject , Summary ,EndYear_BSC");
                           student[numStudent++] = new MSC_Student(s.next() , s.next() , s.next() , s.next() , s.next()
                                                                    ,s.next() , s.next() , s.next(), s.next() , s.next()); 
                            break;
                        case 3:
                           Print("\nWelcome to BSC_Student !");
                           Print ("Enter Name,LastName,StudentID,EntryYear,NationalID,Field"
                                   + ",AcademicOrientation,Subject ,Summary ,EndYear_BSC , EndYear_MSC ");
                           student[numStudent++] = new PHD_Student(s.next() , s.next() , s.next() , s.next() , s.next()
                                                                    ,s.next() , s.next() , s.next(), s.next() , s.next() , s.next()); 
                            break;
                    }
                saveToFile();    
                break;
        
            case 2:
                  Print ("\nWelcome to Teacher !");
                  Print ("Enter Name,LastName,Field,AcademicOrientation,TeacherID,Position :( 1.Teacher  2.Manager  3.External_Examiner )");
                  
                  teacher[numTeacher++]=new Teacher (s.next() , s.next() , s.next(), s.next() , s.next() , s.nextInt());
                saveToFile();  
                break;
            
            
            case 3:
                Print ("\n Welcome to Educational_Expert!");
                Print ("Enter Name,LastName , ID");
                e_e [0] =new Educational_Expert(s.next() , s.next() , s.next());
               
                saveToFile();
                break;
        }
    }
        else if(Input==2){ //LOGIN
           String Request1, Request2;
           Print ("\nWho Are You?");
           
           Print("1:Student\n" + "2:Teacher\n" + "3:Educational_Expert");
           int q=s.nextInt();
           switch(q){
                case 1:
                    try {
                        
                        Print("Enter StudentID");
                        String StudentID = s.next(); 
                        for (j=0 ; j <numStudent ; j++ ){
                        if ( student[j].getStudentID().equalsIgnoreCase(StudentID) ){
                            
                            boolean Exit4=true; 
                             while(Exit4==true){
                             Print ( "\nwhich one ?\n"
                                         + "1.Supervisor\n"
                                         + "2.Adviser\n"
                                         + "3.Accept/Decline Status\n"
                                         + "4.Exit" );
                             int r = s.nextInt();
                             switch (r){
                                 case 1:
                                    Request1= student[j].Supervisor_Request_ByStudent(numTeacher, teacher);
                                    for (int g=0 ; g<numTeacher ; g++){
                                        if (teacher[g].getLastName().equalsIgnoreCase(Request1)){
                                           student[j].getData().setSupervisor_LastName(Request1);
                                           teacher[g].Request_Supervisor(student[j].getData());
                                        }
                                    }
                                     break;
                                 case 2:
                                    Request2= student[j].Adviser_Request_ByStudent(numTeacher, teacher);
                                    for (int l= 0 ; l<numTeacher ;l++){
                                        if (teacher [l].getLastName().equalsIgnoreCase(Request2)){
                                            student[j].getData().setAdviser_LastName(Request2);
                                            teacher[l].Request_Adviser(student[j].getData());
                                        }
                                    }
                                    break;
                                 case 3:
                                  Print ( student[j].getData().getStatus());
                                        break;
                                 case 4:
                                    Exit4=false;
                                    break;
                                }
                            }
                             j=numStudent+1;
                        }
                        }
                      if (j==numStudent ){
                          Print("**Invalid ID !**");
                      }
                          
                    }
                    catch (NullPointerException e){
                         Print ("SignUp Please !");
                         e.printStackTrace();
                         
                    }
                    break;
           
                case 2: //Teacher
                   try{
                        Print("Enter TeacherID");
                        String TeacherID = s.next();
                        for ( k=0; k <numTeacher ; k++){
                            if ( teacher[k].getTeacherID().equalsIgnoreCase(TeacherID)){
                                boolean Exit5 = true;
                                while(Exit5==true){
                                        Print ("\nwhich one ?\n"
                                       + "1.Supervisor\n"
                                       + "2.Adviser\n"
                                       + "3.Manager \n"
                                       + "4.Observer\n"
                                       + "5.Internal_Examiner\n"
                                       + "6.External_Examiner\n"
                                       + "7.Exit\n");

                                    int w=s.nextInt();
                                    if (w==1){ //Supervisor
                                       boolean Exit6=true;
                                       teacher[k].ShowRequest_Supervisor(teacher[k].getLastName());
                                       while (Exit6){
                                       Print ("Which one ?\n"
                                               + "1.Accept\n"
                                               + "2.Decline\n"
                                               + "3.Exit\n");
                                       int z= s.nextInt();
                                       switch (z){
                                           case 1:
                                               Print ("Enter StudentID :");
                                               String SIA = s.next();//SID = 
                                               String Result1=teacher[k].Accept_BySupervisor(SIA);
                                               for (i = 0; i <numStudent ; i++){
                                                   if (student[i].getStudentID().equalsIgnoreCase(Result1)){
                                                       student[i].getData().setStatus(student[i].Student_Status("(Supervisor)\tAccept! \n" , teacher[k].getLastName()));
                                                       teacher[k].SendRequest_ToManager_Bysupervisor(student[i].getData());
                                                   }       
                                               }
                                               break;
                                           case 2 :
                                               
                                               Print ("Enter StudentID :");
                                               String SID = s.next();
                                               String Result_1=teacher[k].Decline_BySupervisor(SID);
                                               for (i = 0; i <numStudent ; i++){
                                                   if (student[i].getStudentID().equalsIgnoreCase(Result_1)){
                                                       student[i].getData().setStatus(student[i].Student_Status("(Supervisor)\tDecline! \n"
                                                               + "Please Select another Supervisor!\n" , teacher[k].getLastName()));
                                                   }
                                               }
                                                       break;
                                           case 3:
                                               Exit6=false;
                                               break;
                                       }
                                     }
                                    }
                                    else if (w==2){ //Adviser
                                        
                                       boolean Exit7=true;
                                       teacher[k].ShowRequest_Adviser(teacher[k].getLastName());
                                       while (Exit7){
                                            Print ("Which one ?\n"
                                               + "1.Accept\n"
                                               + "2.Decline\n"
                                               + "3.Exit\n");
                                            int z= s.nextInt();
                                            switch (z){
                                                case 1:
                                                    Print ("Enter StudentID :");
                                                    String AIA = s.next();//SID = 
                                                    String Result2=teacher[k].Accept_ByAdviser(AIA);
                                                    for (i = 0; i <numStudent ; i++){
                                                        if (student[i].getStudentID().equalsIgnoreCase(Result2)){
                                                            student[i].getData().setStatus(student[i].Student_Status("(Adviser)\tAccept! \n" , teacher[k].getLastName()));
                                                        }
                                                       
                                                    }
                                                 break;
                                                case 2 :

                                                    Print ("Enter StudentID :");
                                                    String SID = s.next();
                                                    String Result_2=teacher[k].Decline_ByAdviser(SID);
                                                    for (i = 0; i <numStudent ; i++){
                                                        if (student[i].getStudentID().equalsIgnoreCase(Result_2)){
                                                            student[i].getData().setStatus(student[i].Student_Status("(Adviser)\tDecline! \n"
                                                                    + "Please Select another Adviser!\n" , teacher[k].getLastName()));
                                                        }
                                                    }
                                         
                                                 break;
                                                case 3:
                                                    Exit7=false;
                                                 break;
                                            }
                                        }
                                    }
                                    else if (w==3){ //Manager
                                        
                                        boolean Exit8=true;
                                        teacher[k].ShowRequest_Manager(teacher[k].getPosition());
                                        while (Exit8){
                                            Print ("Which one ?\n"
                                                   + "1.Accept\n"
                                                   + "2.Decline\n"
                                                   + "3.Select a Internal_Examiner \n"
                                                   + "4.Select a External_Examiner \n"
                                                   + "5.Set_Time\n"
                                                   + "6.Exit\n");
                                            int z= s.nextInt();
                                            switch (z){
                                                case 1: //Accept for Manager
                                                   Print ("Enter StudentID :");
                                                   String MIA = s.next(); //Manager ID Accept 
                                                   String Result3=teacher[k].Accept_ByManager(MIA);
                                                   for (i = 0; i <numStudent ; i++){
                                                       if (student[i].getStudentID().equalsIgnoreCase(Result3)){
                                                           student[i].getData().setStatus(student[i].Student_Status("(Manager)\tAccept! \n" ,
                                                                   teacher[k].getLastName()));
                                                       }

                                                   }
                                                   break;
                                                case 2 : //Decline for Manager

                                                   Print ("Enter StudentID :");
                                                   String SID = s.next();
                                                   String Result_3=teacher[k].Decline_ByManager(SID);
                                                   for (i = 0; i <numStudent ; i++){
                                                       if (student[i].getStudentID().equalsIgnoreCase(Result_3)){
                                                           student[i].getData().setStatus(student[i].Student_Status("(Manager)\tDecline! \n"
                                                                   + "Try again!\n" , teacher[k].getLastName()));
                                                       }
                                                   }

                                                   break;
                                                case 3 :
                                                  Print ("Enter StudentID :");
                                                   String IESID = s.next(); //INTERNAL EXAMINER <-for- STUDENT ID 
                                                   for (i = 0; i <numStudent ; i++){
                                                       if (student[i].getStudentID().equalsIgnoreCase(IESID)){
                                                         Request_1 = teacher[k].Request_InternalExaminer_ByManager(numTeacher,teacher , numStudent,student, IESID );
                                                         student[i].getData().setInternal_Examiner_ID(Request_1);
                                                       
                                                       }
                                                    }
                                                    break;
                                                case 4 :  //select External_Examiner
                                                    Print ("Enter StudentID :");
                                                    String EESID = s.next(); //EXTERNAL EXAMINER <-for- STUDENT ID 
                                                    for (i = 0; i <numStudent ; i++){
                                                       if (student[i].getStudentID().equalsIgnoreCase(EESID)){
                                                            if (student[i] instanceof MSC_Student) {
                                                                
                                                                Request_2=teacher[k].Request_ExternalExaminer_ByManager_1(numTeacher, teacher);
                                                                student[i].getData().setExternal_Examiner_1_ID(Request_2);
                                                            
                                                            }
                                                            if (student[i] instanceof PHD_Student) {
                                                                
                                                                Request_2=teacher[k].Request_ExternalExaminer_ByManager_1(numTeacher, teacher );
                                                                student[i].getData().setExternal_Examiner_1_ID(Request_2);
                                                                
                                                                Request_3=teacher[k].Request_ExternalExaminer_ByManager_2(numTeacher, teacher , Request_2);
                                                                student[i].getData().setExternal_Examiner_2_ID(Request_3);
                                                            
                                                            }
                                                        }
                                                   }
                                                break;

                                                case 5 : //Set Time
                                                    
                                                    Print ("( For BSC )Enter StudentID :");
                                                    String STID = s.next();
                                                    for (i = 0; i <numStudent ; i++){
                                                       if (student[i].getStudentID().equalsIgnoreCase(STID) && student[i] instanceof BSC_Student){
                                                            
                                                            Print ("Enter Suitable Date");
                                                            student[i].getData().setDate(s.next());
                                                            Print ("********");
                                                            Print ("Enter Suitable Time");
                                                            student[i].getData().setTime(s.next());
                                                            Print ("********");
                                                            Print ("Enter Suitable Location");
                                                            student[i].getData().setLocation(s.next());
                                                        }
                                                        
                                                    }
                                                    break;
                                                case 6: //Exit
                                                   Exit8=false;
                                                   break;
                                            }
                                        }
                                    }
                                    else if(w==4){ //Observer
                                        teacher[k].ShowRequest_for_Observer(teacher[k].getTeacherID(), student, numStudent);
                                    }
                                    
                                    else if(w==5){ //Internal_Examiner
                                        teacher[k].ShowRequest_for_InternalExaminer(teacher[k].getTeacherID(),student , numStudent);
                                    }
                                    
                                    else if(w==6){ //External_Examiner
                                        teacher[k].ShowRequest_for_ExternalExaminer(teacher[k].getTeacherID(), student, numStudent);
                                    }
                                    
                                    else if(w==7){ //Exit
                                        Exit5=false;
                                    }
                                }
                                  k= numTeacher+1;
                            }
                        }
                        if (k== numTeacher) {
                            Print ("**Invalid ID !**");
                        }   
                   }
                    catch (NullPointerException e2){
                     Print ("SignUp Please !");
                     e2.printStackTrace();
                    }
                break;
                
            case 3 : // Login of Educational_Expert
                try {
                    boolean Exit_ee = true;
                    Print("Enter ID");
                    String ID = s.next(); 
                    if ( e_e[0].getID().equalsIgnoreCase(ID) ){
                        while (Exit_ee == true){
                        
                            Print ("Which one ?\n"
                                    + "1.Select a Observer\n"
                                    + "2.Set time\n"
                                    + "3.Exit");
                            switch ( s.nextInt()){
                                
                                case 1://observer
                                    for (int zz= 0 ; zz<numStudent ; zz++){
                                        if (student[zz] instanceof PHD_Student || student[zz] instanceof MSC_Student){
                                        Print("Name & LastName & ID:\t"+student[zz].getName()+" "
                                              +student[zz].getLastName()+" "+student[zz].getStudentID()+"\n"
                                              +"Subject :\t"+student[zz].getData().getSubject());
                                        Print("********");
                                        }
                                    }
                                        //sending The Request to Observer
                                        Print ("Enter StudentID :");
                                        String ORSID = s.next(); //Observer <-for- STUDENT ID 
                                        for (i = 0; i <numStudent ; i++){
                                            if (student[i].getStudentID().equalsIgnoreCase(ORSID)){
                                                System.out.println("Select a Observer:");
                                                for ( int r=0 ; r < numTeacher ; r++){
                                                    if(teacher [r].getLastName().equalsIgnoreCase(student[i].getData().getSupervisor_LastName())== false){
                                                        if(teacher [r].getLastName().equalsIgnoreCase(student[i].getData().getAdviser_LastName() ) == false){
                                                            if(teacher [r].getTeacherID().equalsIgnoreCase(student[i].getData().getInternal_Examiner_ID()) == false){
                                                                if(teacher [r].getTeacherID().equalsIgnoreCase(student[i].getData().getExternal_Examiner_1_ID()) == false){
                                                                    if(teacher [r].getTeacherID().equalsIgnoreCase(student[i].getData().getExternal_Examiner_2_ID()) == false){
                                                                        System.out.println(teacher[r].getName() +"\t"+ teacher[r].getLastName() +"\t"+ teacher[r].getTeacherID());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                
                                            System.out.println("Enter Observer TeacherID");
                                            String ORTID = s.next(); // Observer TeacherID
                                            student[i].getData().setObserver_ID(ORTID);
                                            }
                                        }
                                
                                break;
                                
                                case 2://time
                                
                                    for (int a1=0 ; a1<numStudent ; a1++){
                                    
                                        if (student[a1] instanceof MSC_Student || student[a1] instanceof PHD_Student){
                                             Print("********\n"+student[a1].getName()+ "\t" + student[a1].getLastName() 
                                                    +"\t" +student[a1].getStudentID()+ "\n" + student[a1].getData().getSubject()
                                                    +"\t" +student[a1].getData().getSummary() +"\n"+"********");
                                        }
                                    }
                                    Print ("Enter Student ID : ");
                                    String SETID = s.next();
                                    for (int a2=0 ; a2<numStudent ; a2++){
                                        if (student[a2].getStudentID().equalsIgnoreCase(SETID)){
                                            Print ("Enter Suitable Date");
                                            student[a2].getData().setDate(s.next());
                                            Print ("********");
                                            Print ("Enter Suitable Time");
                                            student[a2].getData().setTime(s.next());
                                            Print ("********");
                                            Print ("Enter Suitable Location");
                                            student[a2].getData().setLocation(s.next());
                                        }
                                    }
                                    break;
                                case 3: // Exit
                                
                                    Exit_ee =false;   
                            
                                break;
                            }
                        }
                    }   
                }catch (NullPointerException e3){
                           
                           
                }
             break ;
            
            }
        }
        else if (Input == 3) { //Events 
                Print("Enter Date : ");
                String Date= s.next();
                for (int v=0 ; v<numStudent ; v++){
                    if (student[v].getData().getDate().equalsIgnoreCase(Date)){
                        Print("Subject:\t"+student[v].getData().getSubject());
                        Print("Supervisor:\t"+student[v].getData().getSupervisor_LastName());
                        for (int c=0 ; c<numTeacher ; c++){
                            if ( teacher[c].getTeacherID().equalsIgnoreCase(student[v].getData().getInternal_Examiner_ID())){
                                Print("Internal Examiner :\t"+teacher[c].getLastName());
                            }
                        }
                        for (int c=0 ; c<numTeacher ; c++){
                            if ( teacher[c].getTeacherID().equalsIgnoreCase(student[v].getData().getExternal_Examiner_1_ID()) ){
                                Print("External Examiner 1 :\t"+teacher[c].getLastName());
                            }
                        }
                        for (int c=0 ; c<numTeacher ; c++){
                            if ( teacher[c].getTeacherID().equalsIgnoreCase(student[v].getData().getExternal_Examiner_2_ID()) ){
                                Print("External Examiner 2 :\t"+teacher[c].getLastName());
                            }
                        }
                        
                        Print("Date: "+student[v].getData().getDate()+" /Time: "+student[v].getData().getTime()+" /Location: "+ student[v].getData().getLocation());
                        
                        Print("********");
                    }
                }
            }
        }
    }
}