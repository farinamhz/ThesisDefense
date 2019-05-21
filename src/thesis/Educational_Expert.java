package thesis;

import java.io.Serializable;

public class Educational_Expert implements Serializable {
    private final String Name;
    private final String LastName;
    private final String ID;

    public Educational_Expert(String Name , String LastName , String ID){
        this.Name = Name;
        this.LastName = LastName;
        this.ID=ID;
        
    }
    public String getName(){
        return this.Name;
    }
  
    public String getLastName(){
        return this.LastName;
    }
    public String getID() {
        return ID;
    }
    
}
