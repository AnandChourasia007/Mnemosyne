package com.mnemosyne.library;

import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;


public class MnemosyneEngine {
    

    // Returns number of occurences of `searchString` in the files in the path `directoryPath`. Operates on file by file basis
    public int readDataset(String directoryPath, String searchString) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        if (files == null) return 0;

        double filesize = 0;
        int totalCount = 0;
        for (File f : files) {
            StringBuilder readText = new StringBuilder();
            if (f.isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(f))) { 
                    String line;
                    while ((line = br.readLine()) != null) { 
                        readText.append(line);
                    }
                    totalCount += returnCount(readText.toString(), searchString);
                
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long bytes = (readText.toString()).getBytes(StandardCharsets.UTF_16).length;
            System.out.println("Size of this file in KB: " + (double) bytes /1024);
            filesize += (double) bytes / (1024 * 1024);
        }
        System.out.println("Total filesize in MB: " + filesize);
        return totalCount;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("Reading the dataset.");
        
        MnemosyneEngine engine = new MnemosyneEngine();
        int totalCount = engine.readDataset(AppConfig.searchPath, AppConfig.searchString);

        Instant end = Instant.now();
        System.out.println("Reading and processing per file took: " + Duration.between(start, end).toMillis() + "ms");
        System.out.println("Word frequency: " + totalCount);
    }

    public boolean someLibraryMethod() {
        return true;
    }

    // test function that returns the count of str in text
    private static int returnCount(String text, String str) {
        Instant start = Instant.now();
        int cnt = 0;
        str = str.toLowerCase();
        String[] words = text.split("\\W+");
        for(String word: words) {
            if((word.toLowerCase()).equals(str)) cnt++;
        }
        Instant end = Instant.now();
        System.out.println("returnCount() took: " + Duration.between(start, end).toMillis() + "ms");
        return cnt;
    }
}