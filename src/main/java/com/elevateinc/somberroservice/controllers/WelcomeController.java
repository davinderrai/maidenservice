package com.elevateinc.somberroservice.controllers;

import com.elevateinc.somberroservice.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeDebug.map;

@RestController
@RequestMapping("/v1/service")
public class WelcomeController {

    @RequestMapping("welcome")
    public Map<String, String> printresponse()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig conf = context.getBean(AppConfig.class);

        String hostname = this.runCommand("hostname");
        String whoami = this.runCommand("whoami");

        HashMap<String, String> map = new HashMap<>();
        map.put("App", conf.getName());
        map.put("Hostname", hostname.trim());
        map.put("Whoami", whoami.trim());

        return map;
    }

    public String runCommand(String cmd)
    {
        StringBuilder output = new StringBuilder();

        try {

            // Run a shell command
            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
