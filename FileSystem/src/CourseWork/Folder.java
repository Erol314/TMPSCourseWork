package CourseWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Folder implements IFileFolder {

    String Name;
    FileFormat FileFormat;
    FileAllowedOperations FileAllowedOperations;
    List <IFileFolder> Files = new ArrayList<IFileFolder>();
    private Object obj;

    public Folder(String name,String FileType) {
        FileFactory folderFactory = ThreadSafeLazyLoadedFolderFactory.getInstance();
        this.FileAllowedOperations = folderFactory.createFileAllowedOperations();
        this.FileFormat = folderFactory.createFileFormat();
        this.Name = name;
    }


//    public String gerName();
    @Override
    public void add(IFileFolder fileFolder){
        Files.add(fileFolder);

    }

    @Override
    public void remove(IFileFolder fileFolder){
        Files.remove(fileFolder);

    }

    @Override
    public IFileFolder getChild(int i){
        return Files.get(i);
    }


    @Override
    public List<IFileFolder> getItems() {
        return Files;
    }

    public Memento save(){
        return new Memento(
                this.Name,
                this.FileAllowedOperations,
                this.FileFormat,
                this.Files);
    }

    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.Name = memento.Name;
        this.FileAllowedOperations= memento.FileAllowedOperations;
        this.FileFormat= memento.FileFormat;
        this.Files= memento.Files;
    }
    private class Memento{

        String Name;
        FileFormat FileFormat;
        FileAllowedOperations FileAllowedOperations;
        List <IFileFolder> Files = new ArrayList<IFileFolder>();
        public Memento(String name, FileAllowedOperations operations, FileFormat format, List <IFileFolder> files ) {
            this.Name = name;
            this.FileAllowedOperations = operations;
            this.FileFormat = format;
            this.Files = files;
        }
    }
}

