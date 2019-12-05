package com.icapitanu.interfaces;

 import java.util.ArrayList;
 import java.util.Scanner;

/*
* @author ionutcapitanu on 2019-12-04 
*/
public class File implements IsSaveAble {
    private String fileName;
    private String fileExtension;
    private String fileContent;

    public File(String fileName, String extension) {
        this.fileName = fileName;
        this.fileExtension = extension;
        this.fileContent = "";
    }

    public void writeToFile (String  text) {
        this.fileContent += text;
     }

    public String getFileName() {
        return fileName;
    }

    @Override
    public ArrayList<String> save() {
        ArrayList<String> fileDetails = new ArrayList<>();
        fileDetails.add(fileName);
        fileDetails.add(fileExtension);
        fileDetails.add(fileContent);
        return fileDetails;
    }

    @Override
    public void read(ArrayList<String> savedData) {
        this.fileName=savedData.get(0);
        this.fileExtension =savedData.get(1);
        this.fileContent=savedData.get(2);
    }

    @Override
    public String toString() {
       return "File " + fileName + "." + fileExtension + "  : \n" + fileContent;
    }
}
