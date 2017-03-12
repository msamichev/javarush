package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 *
 */
class InfoCommand implements Command
{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");


    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean noMoney = true;

        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        for (CurrencyManipulator currencyManipulator : collection)
        {
            if (currencyManipulator.hasMoney())
            {
                noMoney = false;
                ConsoleHelper.writeMessage(String.format("%s - %d", currencyManipulator.getCurrencyCode(), currencyManipulator.getTotalAmount()));
            }
        }

        if (noMoney) ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
