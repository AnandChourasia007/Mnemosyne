package com.mnemosyne.library;

import java.time.Duration;
import java.time.Instant;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

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
        String result = engine.readDataset("dataset_10");
        
        Instant end = Instant.now();
        Duration elapsed = Duration.between(start, end);
        System.out.println("Seconds elapsed: " + elapsed.toSeconds());
    }

    public boolean someLibraryMethod() {
        return true;
    }
}