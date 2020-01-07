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

    public boolean newFile(String fileName, String fileExtension){
        if (findFile(fileName,fileExtension)<0) {
            if(fileExtension.equals("enh")) currentFile = EnhancedFile.createNewFile(fileName, fileExtension);
                else currentFile = File.createNewFile(fileName, fileExtension);
            return true;
        }
        return false;
    }

    public void openFile(int fileNr) {

        ArrayList<String> filedetails = new ArrayList<>();
        File fileToOpen = getFileByIndex(fileNr);

        if(fileToOpen != null ) {
            filedetails.add(fileToOpen.getFileName());
            filedetails.add(fileToOpen.getFileExtension());
            filedetails.add(fileToOpen.getFileContent());

            if (fileToOpen instanceof EnhancedFile) {
                filedetails.addAll(((EnhancedFile) fileToOpen).getImages());
                currentFile = new EnhancedFile();
                currentFile.read(filedetails);
            } else {
                currentFile = new File();
                currentFile.read(filedetails);
            }
        }
     }

    public void editFile(String text) {
        currentFile.writeToFile(text);
    }

    public void closeFile (){
        currentFile = null;
    }

    public boolean saveFile(){
        ArrayList<String> fileDetailsToSave = currentFile.save();
        int existsFile = findFile(currentFile.getFileName(),currentFile.getFileExtension());

        if (existsFile < 0 ) {   // Save new file on disk
                if (currentFile instanceof EnhancedFile)  {
                    EnhancedFile saveNewFile = EnhancedFile.createNewFile(fileDetailsToSave.get(0), fileDetailsToSave.get(1));
                    saveNewFile.writeToFile(currentFile.getFileContent());
                    for (int i=3;i<fileDetailsToSave.size();i++) {
                        saveNewFile.addImage(fileDetailsToSave.get(i));
                    }
                    return diskToSaveFiles.add(saveNewFile);
                }
                       else {
                           File saveNewFile = File.createNewFile(fileDetailsToSave.get(0), fileDetailsToSave.get(1));
                           saveNewFile.writeToFile(currentFile.getFileContent());
                           return diskToSaveFiles.add(saveNewFile);
                }
            } else
                { //Add new content to the disk file if content changed
                 String textDiff =  textDiff(diskToSaveFiles.get(existsFile).getFileContent(),currentFile.getFileContent());
                 if (textDiff!=null) {
                     diskToSaveFiles.get(existsFile).writeToFile(textDiff);
                     return true;
                 } else {
                     return false;
                 }
                }
     }

    public void listFiles(){
        for (int i=0;i<diskToSaveFiles.size();i++){
            System.out.println(i+1 + ". " + diskToSaveFiles.get(i).toString());
        }
    }

    private int findFile(String fileName, String fileExtension){
        for (int i=0;i<diskToSaveFiles.size();i++){
            File f = diskToSaveFiles.get(i);
            if (f.getFileName().equals(fileName) && f.getFileExtension().equals(fileExtension)) return i;
        }
        return -1;
    }

    public int getNumberOfSavedFiles(){
        return diskToSaveFiles.size();
    }

    private String textDiff(String currentFileContent, String textAdded) {
        if (currentFileContent.length()<textAdded.length()) {
            return textAdded.substring(currentFileContent.length());
        }
        return null;
    }

    public File getFileByIndex(int fileNr){
        if (fileNr<0 || fileNr>=diskToSaveFiles.size()) return null;
        return diskToSaveFiles.get(fileNr);
    }
    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }
}
