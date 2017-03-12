package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }


    public List<Vacancy> getJavaVacancies(String searchString)
    {
        List<Vacancy> vacancies = strategy.getVacancies(searchString);
        return strategy.getVacancies(searchString) == null ? Collections.<Vacancy>emptyList() : strategy.getVacancies(searchString);
    }
}
