import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FileInspector
{
    public static void main(String[] args)
    {
        //copied a lot of code from the provided sample project
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> myWordList = new ArrayList<>(); //Tried to make an array list work so it could read text documents of variable size, but its not worth it anymore.

        try {

            //Had no idea how to use the get property command correctly.
            File workingDirectory = new File("C:\\Users\\jhott\\IdeaProjects\\Lab_12_File_Away\\src");


            chooser.setCurrentDirectory(workingDirectory);


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int wordNum = 0;
                int charNum = 0;
                int line = 0;
                String[] wordsPresent = new String [200];
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;
                    wordsPresent = rec.split("\\s+"); //The suggestion in the video of "\\w" didn't work for me. Had to get help.
                    //myWordList = rec.split("\\s+");
                    wordNum += wordsPresent.length;
                    //wordNum += myWordList.size();
                    charNum += rec.length();


                    System.out.printf("\nLine %4d %-60s ", line, rec);
                }
                reader.close();
                System.out.println("\n\nData file read! File: " + selectedFile.getName());
                System.out.println("The Line Count was " + line + ". The number of words read was " + wordNum + ". The number of characters read was " + charNum + ".");
                //for (int i = 0; i < wordsPresent.length; i++) {
                  //  System.out.println(wordsPresent[i]); //Tested to see what words were in the array when the split wasn't working.
                //}

            } else
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}