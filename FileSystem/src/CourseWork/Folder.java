package CourseWork;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFileFolder {

    FileFormat FileFormat;
    FileAllowedOperations FileAllowedOperations;

    public Folder(String FileType) {
        FileFactory folderFactory = ThreadSafeLazyLoadedFolderFactory.getInstance();
        this.FileAllowedOperations = folderFactory.createFileAllowedOperations();
        this.FileFormat = folderFactory.createFileFormat();
    }

    List <IFileFolder> files = new ArrayList<IFileFolder>();

//    public String gerName();
    @Override
    public void add(IFileFolder fileFolder){
        files.add(fileFolder);

    }
    @Override
    public void remove(IFileFolder fileFolder){
        files.remove(fileFolder);

    }

    @Override
    public IFileFolder getChild(int i){
        return files.get(i);
    }

}

