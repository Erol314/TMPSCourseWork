package CourseWork;

import java.util.HashMap;

public class PngFileFormat implements FileFormat {

    static final String  description = "These are PNG formats allowed";
    static final HashMap<String, Boolean> map = new HashMap<>();
    @Override
    public String getDescription(){
        return description;
    }

}
