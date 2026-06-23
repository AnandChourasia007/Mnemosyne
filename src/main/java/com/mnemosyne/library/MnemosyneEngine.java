package com.mnemosyne.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;


public class MnemosyneEngine {
    
    public String readDataset(String directoryPath) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        if (files == null) return "";

        StringBuilder readText = new StringBuilder(); 
        
        for (File f : files) {
            if (f.isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(f))) { 
                    String line;
                    while ((line = br.readLine()) != null) { 
                        readText.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return readText.toString();
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("Reading the dataset.");
        
        MnemosyneEngine engine = new MnemosyneEngine();
        String result = engine.readDataset(AppConfig.searchPath);
        System.out.println("Size of result: " + result.length());

        Instant end = Instant.now();
        System.out.println("Reading input in main took: " + Duration.between(start, end).toMillis() + "ms");
        
        System.out.println("Invoking search for, " + AppConfig.searchString);
        int rc = returnCount(result, AppConfig.searchString);
        System.out.println("Word frequency: " + rc);
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