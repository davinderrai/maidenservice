package com.elevatedemo.maidenservice.controllers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/serviceone")
public class WelcomeController
{

    @GetMapping("welcome")
    public String printresponse()
    {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppInfo.class);
        AppInfo appInfo = context.getBean(AppInfo.class);

        String hostname = this.runCommand("hostname");
        String whoami = this.runCommand("whoami");

        StringBuilder resp = new StringBuilder();
        resp.append("App: "+appInfo.getName()+"\n");
        resp.append("Hostname: "+hostname);
        resp.append("Whoami: "+whoami);

        return resp.toString();
    }

    public String runCommand(String cmd)
    {
        StringBuilder output = new StringBuilder();

        try {

            // -- Linux --

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
