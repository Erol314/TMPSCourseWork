package CourseWork;

public interface IFileFolder {
//    public String gerName();
    public void add(IFileFolder fileFolder);
    public void remove(IFileFolder fileFolder);
    public IFileFolder getChild(int i);

}
