package com.example;
import java.io.*;
import java.util.*;

public class gitautomation {
   
    public static void main(String[] args) throws Exception {
        String repoUrl = "https://github.com/bishtpriya/technical-assessment.git";

        // Use a unique folder name by adding a timestamp
        String localDir = "cloned-repo-" + System.currentTimeMillis();

        String newFileName = "newfile.txt";
        String newFileContent = "This is a new file.";
        String existingFileName = "README.md";
        String contentToAppend = "\nAppended new content to this repo.";

        cloneRepo(repoUrl, localDir);
        addNewFile(localDir, newFileName, newFileContent);
        commitAndPush(localDir, "Add new file: " + newFileName);
        updateFile(localDir, existingFileName, contentToAppend);
        commitAndPush(localDir, "Update file: " + existingFileName);

    }

    static void runCommand(String command, File dir) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        if (System.getProperty("os.name").startsWith("Windows")) {
            builder.command("cmd.exe", "/c", command);
        } else {
            builder.command("bash", "-c", command);
        }
        builder.directory(dir);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Command failed: " + command);
        }
    }

    static void cloneRepo(String repoUrl, String localDir) throws IOException, InterruptedException {
        runCommand("git clone " + repoUrl + " " + localDir, new File("."));
    }

    static void addNewFile(String dir, String fileName, String content) throws IOException {
        File file = new File(dir + "/" + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    static void updateFile(String dir, String fileName, String content) throws IOException {
        File file = new File(dir + "/" + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
        }
    }

    static void commitAndPush(String dir, String commitMessage) throws IOException, InterruptedException {
        runCommand("git add .", new File(dir));
        runCommand("git commit -m \"" + commitMessage + "\"", new File(dir));
        runCommand("git push", new File(dir));
    }
}


}
