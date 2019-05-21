package CourseWork;

public class ThreadSafeLazyLoadedPngFileFactory implements FileFactory {

    private static ThreadSafeLazyLoadedPngFileFactory instance;

    private ThreadSafeLazyLoadedPngFileFactory(){
    //To prevent instantiating by Reflection call
        if (instance != null){
            throw new IllegalStateException("Already initialized.");
        }
    }

    //The instance gets created only when it is called for the first time. Lazy-loading.

    public static synchronized ThreadSafeLazyLoadedPngFileFactory getInstance(){

        if (instance == null){
            instance = new ThreadSafeLazyLoadedPngFileFactory();
        }
        return instance;
    }

    public FileFormat createFileFormat() {
        return new PngFileFormat();
    }

    public FileAllowedOperations createFileAllowedOperations() {

        return new PngAllowedOperations();
    }
}
