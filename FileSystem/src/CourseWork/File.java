package CourseWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class File implements IFileFolder {

    String Name;
    FileFormat FileFormat;
    FileAllowedOperations FileAllowedOperations;
    List<IFileFolder> files = new ArrayList<IFileFolder>();
    private Map<String,File> map;

    public File(String name, String FileType){

        this.Name = name;

        File file = map.get(FileType);
        if (file != null){
            this.FileAllowedOperations = file.FileAllowedOperations;
            this.FileFormat = file.FileFormat;}
        else{
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

    }

    @Override
    public void add(IFileFolder fileFolder){

    }
    @Override
    public void remove(IFileFolder fileFolder){

    }

    @Override
    public IFileFolder getChild(int i){
        return null;
    }

    @Override
    public List<IFileFolder> getItems() {
        return null;
    }

}

