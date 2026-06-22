package com.mnemosyne.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

class MnemosyneEngineTest {

    @Test
    void testSomeLibraryMethod() {
        MnemosyneEngine engine = new MnemosyneEngine();
        assertTrue(engine.someLibraryMethod(), "Method should return true");
    }

    @Test
    void testReadDatasetSuccessfully(@TempDir Path tempDir) throws IOException {
        // Arrange: Create mock text files inside our temporary test folder
        java.io.File file1 = tempDir.resolve("file1.txt").toFile();
        java.io.File file2 = tempDir.resolve("file2.txt").toFile();

        try (FileWriter fw1 = new FileWriter(file1); FileWriter fw2 = new FileWriter(file2)) {
            fw1.write("Hello ");
            fw2.write("World!");
        }

        MnemosyneEngine engine = new MnemosyneEngine();

        // Act: Read from the temporary folder path
        String result = engine.readDataset(tempDir.toString());

        // Assert: Ensure both files were read and stitched together seamlessly
        assertEquals("Hello World!", result, "The dataset reader should correctly stitch file strings together");
    }

    @Test
    void testReadDatasetWithEmptyFolder(@TempDir Path tempDir) {
        MnemosyneEngine engine = new MnemosyneEngine();
        
        // Act: Pass an empty directory
        String result = engine.readDataset(tempDir.toString());

        // Assert: It should handle it gracefully without throwing an exception
        assertEquals("", result, "An empty folder should return an empty string");
    }
}