package com.epam.lab.File200MB;

import java.io.File;

public class Paths {
    private File file100KB = new File("file100KB.txt");
    private File file200KB = new File("file200KB.txt");
    private File filew100KB = new File("filew100KB.txt");
    private File filew200KB = new File("filew200KB.txt");

    public File getFile100KB() {
        return file100KB;
    }

    public File getFile200KB() {
        return file200KB;
    }

    public File getFilew100KB() {
        return filew100KB;
    }

    public File getFilew200KB() {
        return filew200KB;
    }
}


