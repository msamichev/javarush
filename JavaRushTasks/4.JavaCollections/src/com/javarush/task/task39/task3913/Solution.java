package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, new SimpleDateFormat("dd.MM.yyyy").parse("21.12.2012"), new SimpleDateFormat("dd.MM.yyyy").parse("14.10.2021")));
        System.out.println(logParser.getIPsForStatus(Status.OK, null, null));
        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getUniqueIPs(new SimpleDateFormat("dd.MM.yyyy").parse("21.12.2012"), new SimpleDateFormat("dd.MM.yyyy").parse("14.10.2021")));
        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin", null, null));

    }
}