package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 *
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }
}
