package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 *
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            int currCount = denominations.get(denomination);
            denominations.put(denomination, currCount + count);
        } else
        {
            denominations.put(denomination, count);
        }

    }

    public int getTotalAmount()
    {
        int res = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            res += entry.getKey() * entry.getValue();
        }
        return res;
    }

    public boolean hasMoney()
    {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> res = new HashMap<>();

        List<Integer> keys = new ArrayList(denominations.keySet());
        Collections.sort(keys, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        int balance = expectedAmount;
        for (Integer key : keys)
        {
            int count = denominations.get(key);
            while (count > 0)
            {
                if (balance >= key)
                {
                    balance -= key;
                    if (res.containsKey(key))
                    {
                        res.put(key, res.get(key) + 1);
                    } else
                    {
                        res.put(key, 1);
                    }
                } else
                {
                    break;
                }
            }
        }

        if (balance != 0)
        {
            throw new NotEnoughMoneyException();
        }

        Iterator<Map.Entry<Integer, Integer>> it = denominations.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<Integer, Integer> entry = it.next();
            if(res.containsKey(entry.getKey())){
                if(entry.getValue().equals(res.get(entry.getKey()))){
                    it.remove();
                }else{
                    entry.setValue(entry.getValue() - res.get(entry.getKey()));
                }
            }
        }
        return res;
    }
}


