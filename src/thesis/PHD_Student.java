package thesis;
public class PHD_Student extends Student {
    private final String EndYear_BSC;
    private final String EndYear_MSC;
 
    public PHD_Student(String Name , String LastName , String StudentID , String EntryYear , String NationalID 
                     , String Field , String AcademicOrientation , String Subject ,
                     String Summary , String  EndYear_BSC , String EndYear_MSC ){
        super(Name,LastName,StudentID,EntryYear,NationalID,Field,AcademicOrientation,Subject ,Summary);
        this.EndYear_BSC = EndYear_BSC;
        this.EndYear_MSC = EndYear_MSC;
    }
    public String getEndYear_BSC(){
        return this.EndYear_BSC;
    }
    public String getEndYear_MSC(){
        return this.EndYear_MSC;
    }

}