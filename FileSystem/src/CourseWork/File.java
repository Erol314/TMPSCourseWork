package CourseWork;

import java.util.ArrayList;
import java.util.List;

public class File implements IFileFolder {

    FileFormat FileFormat;
    FileAllowedOperations FileAllowedOperations;

    public File(String FileType) {

        switch (FileType) {
            case "txt":

                FileFactory txtFactory = ThreadSafeLazyLoadedTxtDocumentFactory.getInstance();
                this.FileAllowedOperations = txtFactory.createFileAllowedOperations();
                this.FileFormat = txtFactory.createFileFormat();
                break;
            case "png":

                FileFactory pngFactory = ThreadSafeLazyLoadedPngFileFactory.getInstance();
                this.FileAllowedOperations = pngFactory.createFileAllowedOperations();
                this.FileFormat = pngFactory.createFileFormat();
                break;

        }
    }
    List<IFileFolder> files = new ArrayList<IFileFolder>();


    @Override
    public void add(IFileFolder fileFolder){
//        files.add(fileFolder);

    }
    @Override
    public void remove(IFileFolder fileFolder){
//        files.remove(fileFolder);

    }

    @Override
    public IFileFolder getChild(int i){
        return null;
    }

//    public String gerName();
//    public void add(IFileFolder fileFolder);
//    public void remove(IFileFolder fileFolder);
//    public IFileFolder getChild(int i);


}

