package CourseWork;

public class ThreadSafeLazyLoadedFolderFactory implements FileFactory,Cloneable {

    private static ThreadSafeLazyLoadedFolderFactory instance;

    private ThreadSafeLazyLoadedFolderFactory(){
        //To prevent instantiating by Reflection call
        if (instance != null){
            throw new IllegalStateException("Already initialized.");
        }
    }

    //The instance gets created only when it is called for the first time. Lazy-loading.

    public static synchronized ThreadSafeLazyLoadedFolderFactory getInstance(){

        if (instance == null){
            instance = new ThreadSafeLazyLoadedFolderFactory();
        }
        return instance;
    }

    public FileFormat createFileFormat() {
        return new PngFileFormat();
    }

    public FileAllowedOperations createFileAllowedOperations() {

        return new PngAllowedOperations();
    }
    @Override
    public ThreadSafeLazyLoadedFolderFactory clone() throws CloneNotSupportedException{
        return new ThreadSafeLazyLoadedFolderFactory();
    }
}
