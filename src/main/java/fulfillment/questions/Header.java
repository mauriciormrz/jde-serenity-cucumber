package fulfillment.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static fulfillment.ui.CustomerServiceInquiryPage.ROW_NUMBERS;


public class Header {

    public static Question<String> amount() {

        return actor -> Text.of(ROW_NUMBERS)
                .viewedBy(actor).asString().trim();
    }
}

