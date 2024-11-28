import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        String filename;
        String filename2;

        do
        {
            addToList(sc, list);
            done = SafeInput.getYNConfirm(sc, "Do you want to quit inputting records? (Y/N)");
        }  while (!done);

        filename = SafeInput.getNonZeroLenString(sc, "Enter the desired filename");
        filename2 = filename + ".csv";
        System.out.println(filename2);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src", filename2);

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : list)
            {
                writer.write(rec, 0, rec.length());

                writer.newLine();
            }
            writer.close();
            System.out.println("Everything has been printed");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //Here is a method to add everything
    public static void addToList (Scanner sc, ArrayList<String> list)
    {
        String firstName= SafeInput.getNonZeroLenString(sc, "Please enter your first name");
        String lastName= SafeInput.getNonZeroLenString(sc, "Please enter your last name");
        String idNumber= SafeInput.getNonZeroLenString(sc, "Please enter your 6 digit id number (000001-999999)"); //I could probably put in a regex function here, but I have like 40 hours of work to do this week.
        String email = SafeInput.getNonZeroLenString(sc, "Please enter your email"); //Dont have time to regex this.
        int birthYear = SafeInput.getRangedInt(sc, "Please enter the year of your birth", 1900,2024);

        String listRecord = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + birthYear;

        list.add(listRecord);
    }
}
