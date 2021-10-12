package com.youngliving.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import net.serenitybdd.core.pages.PageObject;

import static com.youngliving.constants.Constants.INDENTATION;
import static com.youngliving.model.Color.RED;
import static com.youngliving.model.Color.RESET;
import static java.lang.Thread.sleep;

public class utils extends PageObject {

    public static void wait(int millis) {

        try {
            sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void print(Object object) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(object);

        String body = new GsonBuilder().setPrettyPrinting().create().toJson(JsonParser.parseString(jsonString));
        body = INDENTATION + body.replaceAll("\n", "\n" + INDENTATION);
        System.out.println(RED + body + RESET);
    }

    public static void format(String body) {

        body = INDENTATION + body.replaceAll("\n", "\n" + INDENTATION);

        System.out.println(RED + body + RESET);
    }
}
