package com.icapitanu.interfaces;

import java.util.ArrayList;

/*
* @author ionutcapitanu on 2019-12-04 
*/
public class FileEditor {
    private File currentFile;
    private ArrayList<File> diskToSaveFiles;

    public FileEditor() {
        this.diskToSaveFiles = new ArrayList<>();
    }

    public void newFile(String fileName, String fileExtension){
        currentFile = new File(fileName,fileExtension);
    }

    private void openFile(File fileToOpen) {
        currentFile = fileToOpen;
    }

    public void editFile(int fileNr) {

    }

    saveFile();
    copyFile();

    public void listFiles(){
        for (int i=0;i<diskToSaveFiles.size();i++){
            System.out.println(i+1 + ". " + diskToSaveFiles.get(i).getFileName();
        }
    }
}
