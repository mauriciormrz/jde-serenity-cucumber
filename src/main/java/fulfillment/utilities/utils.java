package fulfillment.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import fulfillment.constants.Constants;
import net.serenitybdd.core.pages.PageObject;

import static fulfillment.model.Color.RED;
import static fulfillment.model.Color.RESET;
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
        body = Constants.INDENTATION + body.replaceAll("\n", "\n" + Constants.INDENTATION);
        System.out.println(RED + body + RESET);
    }

    public static void format(String body) {

        body = Constants.INDENTATION + body.replaceAll("\n", "\n" + Constants.INDENTATION);

        System.out.println(RED + body + RESET);
    }
}
