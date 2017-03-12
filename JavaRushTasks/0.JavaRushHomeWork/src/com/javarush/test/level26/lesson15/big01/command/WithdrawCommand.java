package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 *
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            try
            {
                int amount = Integer.parseInt(s);
                if (currencyManipulator.isAmountAvailable(amount))
                {
                    Map<Integer, Integer> amountMap = currencyManipulator.withdrawAmount(amount);
                    List<Integer> keys = new ArrayList(amountMap.keySet());
                    Collections.sort(keys, new Comparator<Integer>()
                    {
                        @Override
                        public int compare(Integer o1, Integer o2)
                        {
                            return o2 - o1;
                        }
                    });

                    for (Integer key : keys)
                    {
                        ConsoleHelper.writeMessage("\t" + key + " - " + amountMap.get(key));
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));


                    break;
                } else
                {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                }
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));

            }
        }


    }
}
