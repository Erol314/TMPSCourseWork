package CourseWork;

import java.util.List;

public class FileIterator implements IFileIterator {

    private int idx;
    private IFileFolder folder;

    public FileIterator(int idx, IFileFolder folder) {
        this.idx = idx;
        this.folder = folder;
    }

    @Override
    public boolean hasNext(){
        return findNextIdx() != -1;
    }

    @Override
    public IFileFolder next() {

        idx = findNextIdx() ;
        if (idx != -1){
            return folder.getItems().get(idx);
        }
        return null;
    }

    private int findNextIdx(){
        List<IFileFolder> items = folder.getItems();
        boolean found = false;
        int tempIdx = idx;
        while (!found) {
            tempIdx++;
            if (tempIdx >= items.size()){
                tempIdx = -1;
                break;
            }
        }
        return tempIdx;
    }

}
