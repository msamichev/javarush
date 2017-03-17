package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            String host = url.getHost();
            int port = url.getPort() == -1 ? 80 : url.getPort();

            Socket socket = new Socket(host, port);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("GET " + url.getFile());
            printWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            printWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}