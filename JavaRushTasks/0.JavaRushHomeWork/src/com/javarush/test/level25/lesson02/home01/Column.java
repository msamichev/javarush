package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable
{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private static int[] realOrder;
    private String columnName;

    private Column(String columnName)
    {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder)
    {
        realOrder = new int[values().length];
        for (Column column : values())
        {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++)
            {
                if (column == newOrder[i])
                {
                    if (isFound)
                    {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }


    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns()
    {


        Column[] newOrder = new Column[realOrder.length];


        for (Column column : values())
        {
            if (realOrder[column.ordinal()] != -1) newOrder[realOrder[column.ordinal()]] = column;
        }

        List<Column> result = new LinkedList<>();
        for (Column column : newOrder)
        {
            if (column != null) result.add(column);
        }

        return result;
    }

    @Override
    public String getColumnName()
    {
        return columnName;
    }

    @Override
    public boolean isShown()
    {
        if (realOrder[this.ordinal()] != -1)
        {
            return true;
        }
        return false;
    }

    @Override
    public void hide()
    {
        realOrder[this.ordinal()] = -1;
    }
}
