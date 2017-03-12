package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 *
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        Provider provider1 = new Provider(new HHStrategy());
        Provider provider2 = new Provider(new MoikrugStrategy());


        View view = new HtmlView();
        Model model = new Model(view, provider1, provider2);
        Controller controller = new Controller(model);

        view.setController(controller);
        ((HtmlView) view).userCitySelectEmulationMethod();
    }
}
