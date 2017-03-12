package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String in = args[0];
        String fou = args[1];
        FileInputStream fin = new FileInputStream(in);
        FileOutputStream fout = new FileOutputStream(fou);
        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        byte[] buffer = new byte[fin.available()];
        fin.read(buffer);
        String s = new String(buffer, utf);
        buffer = s.getBytes(win1251);
        fout.write(buffer);
        fin.close();
        fout.close();
    }
}
