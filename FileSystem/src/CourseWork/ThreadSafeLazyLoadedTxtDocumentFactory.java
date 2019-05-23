package CourseWork;

public class ThreadSafeLazyLoadedTxtDocumentFactory implements FileFactory,Cloneable {



    private static ThreadSafeLazyLoadedTxtDocumentFactory instance;

    private ThreadSafeLazyLoadedTxtDocumentFactory(){
        //To prevent instantiating by Reflection call
        if (instance != null){
            throw new IllegalStateException("Already initialized.");
        }
    }

    //The instance gets created only when it is called for the first time. Lazy-loading.

    public static synchronized ThreadSafeLazyLoadedTxtDocumentFactory getInstance(){

        if (instance == null){
            instance = new ThreadSafeLazyLoadedTxtDocumentFactory();
        }
        return instance;
    }
    public FileFormat createFileFormat() {
        return new TxtDocumentFormat();
    }

    public FileAllowedOperations createFileAllowedOperations() {

        return new TxtAllowedOperations();
    }

    @Override
    public ThreadSafeLazyLoadedTxtDocumentFactory clone() throws CloneNotSupportedException{
        return new ThreadSafeLazyLoadedTxtDocumentFactory();
    }
}
