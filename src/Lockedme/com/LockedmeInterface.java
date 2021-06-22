package Lockedme.com;

import java.io.IOException;

public interface LockedmeInterface
{
    //Main operations
    public void listingFilesInOrder();
    public void addFile(String filename);
    public void deleteFile(String name) throws IOException;
    public void searchFile(String filename);


    //Helper methods
    public void mainMenu() throws IOException;
    public void businessOperation() throws IOException;

}
