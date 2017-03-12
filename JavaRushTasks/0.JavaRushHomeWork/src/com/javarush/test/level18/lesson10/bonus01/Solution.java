package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import javax.xml.bind.DatatypeConverter;
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        String key = args[0];
        String sf = args[1];
        String df = args[2];

        byte[] b = readFile(sf);
        byte[] r = new byte[0];
        switch (key)
        {
            case "-e":
            {
                r = DatatypeConverter.printBase64Binary(b).getBytes();
                break;
            }
            case "-d":
            {
                r = DatatypeConverter.parseBase64Binary(new String(b));
                break;
            }

        }

        writeFile(r, df);

    }

    private static byte[] readFile(String sf) throws IOException
    {
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(sf));
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();

        return b;
    }

    private static void writeFile(byte[] b, String of) throws IOException
    {
        BufferedOutputStream os = new BufferedOutputStream (new FileOutputStream(of));
        os.write(b);
        os.close();
    }

}
