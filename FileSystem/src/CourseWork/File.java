package CourseWork;

public class File {

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

}
