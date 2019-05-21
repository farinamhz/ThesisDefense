package thesis;

import java.io.Serializable;

public class Data implements Serializable
{
 private String Subject,ID,Name,LastName,Summary , Status  , Supervisor_LastName 
              , Adviser_LastName ,Internal_Examiner_ID , External_Examiner_1_ID , External_Examiner_2_ID, Observer_ID , Time , Date , Location;
 public Data(String Subject,String Summary,String Name,String LastName,String ID ) 
    {
        setID(ID);
        setLastName(LastName);
        setName(Name);
        setSubject(Subject);
        setSummary(Summary);
        setStatus("Decline");
        setSupervisor_LastName("");
        setAdviser_LastName("");
        setInternal_Examiner_ID("");
        setExternal_Examiner_1_ID("");
        setExternal_Examiner_2_ID("");
        setObserver_ID("");
        setTime ("");
        setDate ("");
        setLocation("");
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getObserver_ID() {
        return Observer_ID;
    }

    public void setObserver_ID(String Observer_ID) {
        this.Observer_ID = Observer_ID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getInternal_Examiner_ID() {
        return Internal_Examiner_ID;
    }

    public String getExternal_Examiner_1_ID() {
        return External_Examiner_1_ID;
    }

    public String getExternal_Examiner_2_ID() {
        return External_Examiner_2_ID;
    }

    public void setInternal_Examiner_ID(String Internal_Examiner_ID) {
        this.Internal_Examiner_ID = Internal_Examiner_ID;
    }

    public void setExternal_Examiner_1_ID(String External_Examiner_1_ID) {
        this.External_Examiner_1_ID = External_Examiner_1_ID;
    }
    
    public void setExternal_Examiner_2_ID(String External_Examiner_2_ID) {
        this.External_Examiner_2_ID = External_Examiner_2_ID;
    }
    public String getStatus(){
        return Status;
    }
    
    public void setStatus(String Status){
        this.Status=Status;
    }
    
    public String getSupervisor_LastName(){
        return Supervisor_LastName;
    }
    
    public void setSupervisor_LastName(String Supervisor_LastName){
        this.Supervisor_LastName = Supervisor_LastName;
    }
            
    public String getAdviser_LastName(){
        return Adviser_LastName;
    }
    
    public void setAdviser_LastName(String Adviser_LastName){
        this.Adviser_LastName = Adviser_LastName;
    }
    
    public String getSubject() {
        return Subject;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

}