package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 *
 */
class LoginCommand implements Command
{

    private long cardNumber = 123456789012L;
    private long cardPin = 1234L;
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));

        while (true)
        {
            String n1 = ConsoleHelper.readString();
            String p1 = ConsoleHelper.readString();

            try
            {
                long card = Long.parseLong(n1);
                long pin = Long.parseLong(p1);

                if (n1.length() == 12 && p1.length() == 4)
                {
                    if (validCreditCards.containsKey(String.valueOf(card)) && pin == Long.parseLong(validCreditCards.getString(String.valueOf(card))))
                    {
                        ConsoleHelper.writeMessage(res.getString("success.format"));
                        break;
                    } else
                    {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), String.valueOf(card)));
                    }
                }
            }
            catch (NumberFormatException e)
            {
            }
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }

    }
}
