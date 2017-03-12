package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 */
public class HtmlView implements View
{
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    private Controller controller;


    @Override
    public void update(List<Vacancy> vacancies)
    {
        System.out.println(vacancies.size());

        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }


    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        Document doc = null;
        try
        {
            doc = getDocument();

            Element template = doc.select("tr.template").first();

            Elements elements = doc.select("tr:not(.template).vacancy");
            for (Element element : elements)
            {
                element.remove();
            }

            for (Vacancy vacancy : vacancies)
            {
                Element newVacancy = template.clone().removeClass("template");
                newVacancy.removeAttr("style");

                newVacancy.select(".city").first().text(vacancy.getCity());
                newVacancy.select(".companyName").first().text(vacancy.getCompanyName());
                newVacancy.select(".salary").first().text(vacancy.getSalary());
                newVacancy.select(".salary").first().text(vacancy.getSalary());
                newVacancy.select("a").first().text(vacancy.getTitle()).attr("href", vacancy.getUrl());

                template.before(newVacancy);
            }
            return doc.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Some exception occurred";
        }


    }

    private void updateFile(String s)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write(s);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    protected Document getDocument() throws IOException
    {
        File input = new File(filePath);
        Document doc = Jsoup.parse(input, "UTF-8");

        return doc;
    }

}
