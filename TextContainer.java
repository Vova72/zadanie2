package com.company;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

@SaveTo(path = "a.txt")
public class TextContainer {
    String text = "Some text";

    @Saver
    public void save(String path) {
        try {
            PrintWriter pr = new PrintWriter(path);
            pr.println(text);
            pr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
