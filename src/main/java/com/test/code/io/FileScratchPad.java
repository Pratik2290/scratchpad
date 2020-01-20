package com.test.code.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileScratchPad {


    public static void main(String[] args) throws IOException {

        String filePath = "/Users/pratikbajaj/Desktop/PratikBajaj/testFile.csv";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject("sx.exeStatus");
        oos.close();
        fileOutputStream.close();

    }

}
