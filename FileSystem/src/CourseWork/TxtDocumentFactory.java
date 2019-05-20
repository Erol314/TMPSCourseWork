package CourseWork;

public class TxtDocumentFactory implements DocumentFactory {
public DocumentFormat createDocumentFormat(){
    return new TxtDocumentFormat();
}
}
