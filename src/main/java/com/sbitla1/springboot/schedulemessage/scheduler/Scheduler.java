package com.sbitla1.springboot.schedulemessage.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class Scheduler {
    @Scheduled(cron = "0 * * * * *") //Runs every 1 minute
    public void cronJobSch() throws IOException {
        URL url = new URL("http://localhost:8088/api/messages");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();

        InputStreamReader isr = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        {
            br.lines().forEach(line -> System.out.println(line));

        }
    }
}