package com.icapitanu.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

/*
* @author ionutcapitanu on 2019-12-05 
*/
public class FileEditorMain {
    private static FileEditor editor = new FileEditor();
    private static Scanner input = new Scanner(System.in);
    private static String editorTitle;

    public static void main(String[] args) {
        boolean quit = false;

        openEditor();

        while (!quit) {
            int choice;
            printMenu();
            System.out.print("Press : ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 0:
                     if (editor.getNumberOfSavedFiles() <=0 ) System.out.println("No files saved");
                      else editor.listFiles();
                     break;

                case 1:
                    System.out.print("Enter the new file name  : ");
                    String fileName = input.nextLine();
                    if (fileName.equals("")) {
                        System.out.println("Invalid file name!");
                        break;
                    }
                    System.out.print("Enter the new file extension [txt, log, csv, enh ]: ");
                    String fileExtension = input.nextLine();
                    if (!fileExtension.equals("txt") && !fileExtension.equals("log") && !fileExtension.equals("csv") && !fileExtension.equals("enh"))
                        System.out.println("Invalid file extension, pick one from the list provided");
                        else if (editor.newFile(fileName,fileExtension))  setEditorTitle("\t< Currently working on file: " + fileName + "." + fileExtension + " >");
                            else System.out.println("Error while creating the new file!!!");
                    break;

                case 2:
                     editor.listFiles();
                     System.out.print("Enter file number to open : ");
                     int fileNr = input.nextInt(); input.nextLine();
                     if (fileNr<=0 || fileNr> editor.getNumberOfSavedFiles()) {
                         System.out.println("Invalid file selected ! ");
                         break;
                     } else   {
                         editor.openFile(fileNr-1);
                         setEditorTitle("\t< Currently working on file: " + editor.getCurrentFile().getFileName() + "." + editor.getCurrentFile().getFileExtension() + " >");
                     }
                     break;

                case 3:
                    // Use the common interface to handle both type of files
                    IsSaveAble fileThroughInterface = editor.getCurrentFile();

                    if (fileThroughInterface != null) {
                    ArrayList<String> fileDetails = fileThroughInterface.save();
                        // Display content of the file
                        System.out.println("\n>> Text: ");
                        System.out.println(fileDetails.get(2));
                        if (fileDetails.get(1).equals("enh")) {
                            System.out.println(" >> Images : ");
                            for (int i = 3; i < fileDetails.size(); i++)
                                System.out.println(fileDetails.get(i));
                        }
                    }
                     break;

                case 4:
                    System.out.println("Enter text : ");
                    String text = input.nextLine();
                    editor.editFile("\n" + text);
                    break;

                case 5:
                    File f = editor.getCurrentFile();
                    if (f instanceof EnhancedFile){
                        System.out.print("Enter image name : ");
                        String imageName = input.nextLine();
                        ((EnhancedFile) f).addImage(imageName);
                    } else System.out.println("Images can only be added to files of type .enh");
                    break;

                 case 6:
                      if (editor.saveFile()) System.out.println("File " + editor.getCurrentFile().toString() + " was saved successfully." );
                        else System.out.println("An error occurred while saving file");
                     break;
                case 7:
                     editor.closeFile();
                     setEditorTitle("\n\t< No file opened >");
                     break;
                case 8:
                    quit=true;
                    break;
            }
        }

    }

    public static void openEditor(){
        if (editor.getCurrentFile() == null) setEditorTitle("\n\t< No file opened >");
          else  setEditorTitle("\t\n< Currently working on file: " + editor.getCurrentFile().getFileName() + " >");
    }

    public static void printMenu() {
            System.out.println("\t\t\n "+ editorTitle);
            System.out.println("\nMenu Options :");
            System.out.println("\t 0  - List Saved Files");
            System.out.println("\t 1  - New File");
            System.out.println("\t 2  - Open File");
            System.out.println("\t 3  - Show File Content");
            System.out.println("\t 4  - Write text to file");
            System.out.println("\t 5  - Insert image into file");
            System.out.println("\t 6  - Save File");
            System.out.println("\t 7  - Close File");
            System.out.println("\t 8  -  Quit");
    }

    public static void setEditorTitle(String title){
          editorTitle = title;
    }
}
