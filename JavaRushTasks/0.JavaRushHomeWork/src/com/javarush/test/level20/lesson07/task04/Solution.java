package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    String string;
    transient private Date currentDate;
    transient private int temperature;
    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;
        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args)
    {
        System.out.println(new Solution(4));
        Solution savedObject = new Solution(5);
        OutputStream outputStream = null;
        ObjectOutputStream objectOutput = null;
        try
        {
            outputStream = new FileOutputStream("c:/temp/file1.txt");
            objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(savedObject);
        }
        catch (IOException i)
        {
        }
        finally
        {
            try
            {
                outputStream.close();
                objectOutput.close();
            }
            catch (IOException o)
            {
            }
        }
        InputStream inputStream = null;
        ObjectInputStream objectInput = null;
        Solution loadedObject = new Solution(6);
        try
        {
            inputStream = new FileInputStream("c:/temp/file1.txt");
            objectInput = new ObjectInputStream(inputStream);
            loadedObject = (Solution) objectInput.readObject();
        }
        catch (Exception ex)
        {
        }
        finally
        {
            try
            {
                inputStream.close();
                objectInput.close();
            }
            catch (IOException e)
            {
            }
        }
    }

    @Override
    public String toString()
    {
        return this.string;
    }

}
