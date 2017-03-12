package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";


    private FileOutputStream outputStream;

    public AmigoOutputStream(FileOutputStream outputStream) throws IOException
    {
        super(fileName);
        this.outputStream = outputStream;
    }

    public static void main(String[] args) throws IOException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException
    {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        outputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException
    {
        byte[] b = "JavaRush © 2012-2013 All rights reserved.".getBytes();

        outputStream.flush();
        outputStream.write(b);
        outputStream.close();
    }

    @Override
    public FileChannel getChannel()
    {
        return outputStream.getChannel();
    }

    @Override
    public void flush() throws IOException
    {
        outputStream.flush();
    }
}
