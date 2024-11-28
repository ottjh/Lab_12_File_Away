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

        while
        {

            done = SafeInput.getYNConfirm(sc, "Do you want to quit inputting records? (Y/N)");
        } (!done)

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getAbsolutePath() + "\\src\\main\\java\\DataSaver");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : recs) {
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
    public static void addToList (Scanner sc, ArrayList<String> list)
    {
        String firstName= SafeInput.getNonZeroLenString(sc, "Please enter your first name: ");

    }
}
