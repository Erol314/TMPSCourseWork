package CourseWork;

public class TxtDocumentFormat implements DocumentFormat{
    static final String  description = "These are TXT formats allowed";
    @Override
    public String getDescription(){
        return description;
    }

}
