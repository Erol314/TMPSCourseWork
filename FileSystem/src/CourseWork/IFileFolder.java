package CourseWork;

import java.util.List;

public interface IFileFolder {
//    public String gerName();
    public void add(IFileFolder fileFolder);
    public void remove(IFileFolder fileFolder);
    public IFileFolder getChild(int i);
    public List<IFileFolder> getItems();

}
