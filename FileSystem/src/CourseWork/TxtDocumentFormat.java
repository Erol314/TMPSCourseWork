package CourseWork;

import java.util.HashMap;

public class TxtDocumentFormat implements FileFormat {
    static final String  description = "These are TXT formats allowed";
    static final HashMap<String, Boolean> map = new HashMap<>();
    @Override
    public String getDescription(){
        return description;
    }

}
