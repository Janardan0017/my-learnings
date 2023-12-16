package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileOrganisor {

    static final String DESKTOP = "/Users/janardanchaudhary/Desktop/";
    static final String DOWNLOADS = "/Users/janardanchaudhary/Downloads/";

    public static void main(String[] args) {
        List<File> files = extractFiles();
        files.forEach(file -> System.out.println(file.getName()));
//        moveFiles(files, DESKTOP+"All_Images/IMG_2018/");
    }

    public static List<File> extractFiles() {
        List<File> files = new ArrayList<>();
        File allImages = new File(DESKTOP + "All_Images");
        for (File folder : allImages.listFiles()) {
            System.out.println(folder.getName());
            if(!folder.getName().startsWith("Part"))
                continue;
            for (File file : folder.listFiles()) {
                if (file.getName().matches("\\d+.*")) {
                    files.add(file);
                }
            }
        }
        return files;
    }

    public static void listFiles(File file, List<File> files) {
        if (file != null) {
            if (file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0) {
                for (File childFile : file.listFiles()) {
                    listFiles(childFile, files);
                }
            } else {
                if (isMedia(file)) {
                    files.add(file);
                }
            }
        }
    }

    public static void moveDuplicates() {
        File file = new File("/Users/janardanchaudhary/Desktop/All_Images/");
        for (File f : file.listFiles()) {
            String name = f.getName();
            String[] parts = name.split("\\.");
            if (parts[0].endsWith("_")) {
                File newFile = new File("/Users/janardanchaudhary/Desktop/dupli/" + f.getName());
                try {
                    Files.move(f.toPath(), newFile.toPath());
                } catch (IOException ex) {
                    System.out.println("Not moved: " + f.getName());
                }
            }
        }
    }

    public static boolean isMedia(File file) {
//        return file != null && (file.getName().endsWith("jpg") || file.getName().endsWith("jpeg") || file.getName().endsWith("png"));
        return file != null && (file.getName().endsWith("mp4") || file.getName().endsWith("mkv"));
//        return file != null && (file.getName().endsWith("pdf"));
    }

    public static void moveFiles(List<File> files, String newPath) {
        for (File f : files) {
            File newFile = new File(newPath + f.getName());
            try {
                Files.move(f.toPath(), newFile.toPath());
            } catch (IOException ex) {
                newFile = new File(newPath + "_" + f.getName());
                try {
                    Files.move(f.toPath(), newFile.toPath());
                } catch (IOException e) {

                }
            }
        }
    }

}