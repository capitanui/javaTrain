package com.icapitanu.interfaces;

import java.util.ArrayList;

class EnhancedFile extends File implements IsSaveAble {
    private ArrayList<String> images;

    public EnhancedFile() {
        this.images = new ArrayList<>();
    }

    public EnhancedFile(File f) {
        super(f.getFileName(), f.getFileExtension());
        this.images = new ArrayList<>();
    }

    public EnhancedFile(String fileName, String extension) {
        super(fileName, extension);
        this.images = new ArrayList<>();
    }

    public void addImage(String imageName) {
        images.add(imageName);
    }

    @Override
    public ArrayList<String> save() {
        ArrayList<String> fileDetails = new ArrayList<>();
        fileDetails = super.save();
        //add also images
        fileDetails.addAll(images);
        return fileDetails;
    }

    @Override
        public void read(ArrayList<String> savedData) {
            super.read(savedData);
            if (savedData.size()>2) {
                for (int i = 3; i < savedData.size(); i++) {
                    images.add(savedData.get(i));
                }
            }
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public static EnhancedFile createNewFile (String fileName, String fileExtension) {
        return new EnhancedFile (fileName,fileExtension);
    }

}
