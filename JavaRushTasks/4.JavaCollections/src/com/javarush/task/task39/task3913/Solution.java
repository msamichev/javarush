package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("C:\\prj\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, new SimpleDateFormat("dd.MM.yyyy").parse("21.12.2012"), new SimpleDateFormat("dd.MM.yyyy").parse("14.10.2021")));
//        System.out.println(logParser.getIPsForStatus(Status.OK, null, null));
//        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko", null, null));
//        System.out.println(logParser.getUniqueIPs(new SimpleDateFormat("dd.MM.yyyy").parse("21.12.2012"), new SimpleDateFormat("dd.MM.yyyy").parse("14.10.2021")));
//        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin", null, null));
//        System.out.println(logParser.execute("get ip"));
//        System.out.println(logParser.execute("get user"));
//        System.out.println(logParser.execute("get date"));
//        System.out.println(logParser.execute("get event"));
//        System.out.println(logParser.execute("get status"));
//        System.out.println(logParser.execute("get ip for ip = \"120.120.120.122\""));
//        System.out.println(logParser.execute("get ip for user = \"Amigo\""));
//        System.out.println(logParser.execute("get ip for date = \"13.09.2013 5:04:50\""));
//        System.out.println(logParser.execute("get ip for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get ip for status = \"OK\""));
//        System.out.println(logParser.execute("get user for ip = \"120.120.120.122\""));
//        System.out.println(logParser.execute("get user for user = \"Amigo\""));
//        System.out.println(logParser.execute("get user for date = \"13.09.2013 5:04:50\""));
//        System.out.println(logParser.execute("get user for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get user for status = \"OK\""));
//        System.out.println(logParser.execute("get date for ip = \"120.120.120.122\""));
//        System.out.println(logParser.execute("get date for user = \"Amigo\""));
//        System.out.println(logParser.execute("get date for date = \"13.09.2013 5:04:50\""));
//        System.out.println(logParser.execute("get date for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get date for status = \"OK\""));
//
//        System.out.println(logParser.execute("get event for ip = \"120.120.120.122\""));
//        System.out.println(logParser.execute("get event for user = \"Amigo\""));
//        System.out.println(logParser.execute("get event for date = \"13.09.2013 5:04:50\""));
//        System.out.println(logParser.execute("get event for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get event for status = \"OK\""));
//
//        System.out.println(logParser.execute("get status for ip = \"120.120.120.122\""));
//        System.out.println(logParser.execute("get status for user = \"Amigo\""));
//        System.out.println(logParser.execute("get status for date = \"13.09.2013 5:04:50\""));
//        System.out.println(logParser.execute("get status for event = \"LOGIN\""));
//        System.out.println(logParser.execute("get status for status = \"OK\""));
//
//
//        System.out.println(logParser.execute("get ip for ip = \"120.120.120.122\" and date between \"11.12.2013 0:00:00\" and \"03.01.2029 23:59:59\""));
//        System.out.println(logParser.execute("get ip for user = \"Amigo\" and date between \"11.12.2011 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get ip for date = \"13.09.2013 5:04:50\" and date between \"11.1.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"LOGIN\" and date between \"03.01.2014 03:45:24\" and \"14.10.2021 11:38:21\""));
//        System.out.println(logParser.execute("get ip for status = \"OK\" and date between \"11.12.2013 0:00:00\" and \"03.01.2017 23:59:59\""));
//
//        System.out.println(logParser.execute("get user for ip = \"120.120.120.122\" and date between \"11.12.2013 0:00:00\" and \"03.01.2029 23:59:59\""));
//        System.out.println(logParser.execute("get user for user = \"Amigo\" and date between \"11.12.2011 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get user for date = \"13.09.2013 5:04:50\" and date between \"11.1.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get user for event = \"LOGIN\" and date between \"11.12.2013 0:00:00\" and \"03.01.2024 23:59:59\""));
//        System.out.println(logParser.execute("get user for status = \"OK\" and date between \"11.12.2013 0:00:00\" and \"03.01.2017 23:59:59\""));
//
//        System.out.println(logParser.execute("get date for ip = \"120.120.120.122\" and date between \"11.12.2013 0:00:00\" and \"03.01.2029 23:59:59\""));
//        System.out.println(logParser.execute("get date for user = \"Amigo\" and date between \"11.12.2011 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get date for date = \"13.09.2013 5:04:50\" and date between \"11.1.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get date for event = \"LOGIN\" and date between \"11.12.2013 0:00:00\" and \"03.01.2024 23:59:59\""));
//        System.out.println(logParser.execute("get date for status = \"OK\" and date between \"11.12.2013 0:00:00\" and \"03.01.2017 23:59:59\""));
//
//        System.out.println(logParser.execute("get event for ip = \"120.120.120.122\" and date between \"11.12.2013 0:00:00\" and \"03.01.2029 23:59:59\""));
//        System.out.println(logParser.execute("get event for user = \"Amigo\" and date between \"11.12.2011 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get event for date = \"13.09.2013 5:04:50\" and date between \"11.1.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get event for event = \"LOGIN\" and date between \"11.12.2013 0:00:00\" and \"03.01.2024 23:59:59\""));
//        System.out.println(logParser.execute("get event for status = \"OK\" and date between \"11.12.2013 0:00:00\" and \"03.01.2017 23:59:59\""));
//
//        System.out.println(logParser.execute("get status for ip = \"120.120.120.122\" and date between \"11.12.2013 0:00:00\" and \"03.01.2029 23:59:59\""));
//        System.out.println(logParser.execute("get status for user = \"Amigo\" and date between \"11.12.2011 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get status for date = \"13.09.2013 5:04:50\" and date between \"11.1.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get status for event = \"LOGIN\" and date between \"11.12.2013 0:00:00\" and \"03.01.2024 23:59:59\""));
//        System.out.println(logParser.execute("get status for status = \"OK\" and date between \"11.12.2013 0:00:00\" and \"03.01.2017 23:59:59\""));
//
//
//        System.out.println(logParser.execute(null));
//        System.out.println(logParser.execute("sadfwergwe vqrverv"));


    }
}