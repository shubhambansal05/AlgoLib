package com.shubham.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class FileUtils {

    public static BufferedWriter getFileWriter(String filePath) {
        try {
            Path file = new File(filePath).toPath();
            if (Files.notExists(file))
                file = Files.createFile(file);
            if (!Files.isWritable(file)) {
                Set<PosixFilePermission> permissions = new HashSet();
                permissions.add(PosixFilePermission.OWNER_WRITE);
                permissions.add(PosixFilePermission.GROUP_WRITE);
                permissions.add(PosixFilePermission.OWNER_WRITE);
                Files.setPosixFilePermissions(file, permissions);
            }
            return Files.newBufferedWriter(file, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void appendWithNewLine(BufferedWriter fileWriter, String text) {
        try {
            fileWriter.append(text);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWriter(BufferedWriter fileWriter) {
        try {
            if (fileWriter != null)
                fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
