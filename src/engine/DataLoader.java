package engine;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/**
 *
 * @author dpoumakis
 */
public class DataLoader
{
    File file;
    FileInputStream instream;
    DataInputStream dataFile;

    String line;
    StringTokenizer stringTok;

    public DataLoader()
    {
        file = new File("src/UserData.txt");
        try
        {
            
            instream = new FileInputStream(file);
            dataFile = new DataInputStream(instream);
            
            while ((line = (String) dataFile.readLine()) != null)
            {
                stringTok = new StringTokenizer(line);
                while (stringTok.hasMoreTokens())
                {
                    System.out.print(stringTok.nextToken());
                    System.out.print(" ");
                }
                System.out.println("");
            }
            instream.close();
        } 
        catch (Exception e)
        {
            System.out.println("Error");
        }

    }

}