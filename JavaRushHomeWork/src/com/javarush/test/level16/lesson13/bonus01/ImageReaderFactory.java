package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 *
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes types)
    {
        if(types == null){
            throw new IllegalArgumentException("Неизвестный тип картинки");

        }
        switch (types)
        {
            case JPG:
                return new JpgReader();
            case BMP:
                return new BmpReader();
            case PNG:
                return new PngReader();
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");

        }

    }
}
