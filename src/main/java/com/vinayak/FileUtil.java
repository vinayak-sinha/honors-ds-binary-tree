package com.vinayak;

import java.io.*;
import java.util.*;


/**
 * Loads files containing Strings into an Iterator to be processed by
 * the TreeUtil class. Also, saves files from an Iterator to store trees.
 * 
 * @author  Vinayak Sinha
 * @version November 12, 2025
 */
public class FileUtil {

    /**
     * Loads a file line by line, inputting the contents of each line
     * as an entry in an Iterator.
     * 
     * @param   fileName    the name of the file to be loaded
     * 
     * @return  an Iterator containing the contents of the file
     */
    public static Iterator<String> loadFile(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            List<String> list = new ArrayList<>();
            while (in.hasNextLine())
                list.add(in.nextLine());
            return list.iterator();
        }
        catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves a file line by line, inputting each entry of the given Iterator
     * as a line in a new file.
     * 
     * @param   fileName    the name of the file to be saved
     * @param   data        the Iterator containing the tree's info
     */
    public static void saveFile(String fileName, Iterator<String> data) {
        try(PrintWriter out = new PrintWriter(new FileWriter(fileName), true)) {
            while (data.hasNext())
                out.println(data.next());
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}