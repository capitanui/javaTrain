package com.icapitanu.interfaces;
/*
* @author ionutcapitanu on 2019-12-09 
*/
public class FileFactory {
    public  IsSaveAble getNewFile( String extension ) {
            if (extension == null) return null;
            if (!extension.equals("txt") && !extension.equals("log") && !extension.equals("csv"))  return new File();
                else  if (extension.equals("enh"))
                        return new EnhancedFile();
                          else return null;
    }
}
