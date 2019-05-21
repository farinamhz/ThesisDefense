package thesis;
public class MSC_Student extends Student {
    private final String EndYear_BSC;

    public MSC_Student(String Name , String LastName , String StudentID , String EntryYear , String NationalID ,
                       String Field , String AcademicOrientation , String Subject , String Summary ,String EndYear_BSC ){
        super(Name,LastName,StudentID,EntryYear,NationalID,Field,AcademicOrientation,Subject , Summary);
        this.EndYear_BSC = EndYear_BSC;
        
    }
    public String getEndYear_BSC(){
        return this.EndYear_BSC;
    }
}