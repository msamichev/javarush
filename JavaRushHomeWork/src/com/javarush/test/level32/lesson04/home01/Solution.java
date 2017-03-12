package com.javarush.test.level32.lesson04.home01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/temp/testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException
    {

        StringWriter sw = new StringWriter();
        if (is != null)
        {
            while (is.available() > 0)
            {
                byte[] b = new byte[is.available()];
                is.read(b);
                sw.write(new String(b));
            }
        }
        return sw;
    }
}
