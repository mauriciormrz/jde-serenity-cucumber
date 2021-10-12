package fulfillment.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class DataSelectionPage extends PageObject {

    public static final Target DROPDOWN_LEFT_OPERAND = Target.the("Dropdown Left Operand")
            .locatedBy("//select[@id='LeftOperand{0}']");

    public static final Target DROPDOWN_COMPARISON = Target.the("Dropdown Comparison")
            .locatedBy("//select[@id='Comparison{0}']");

    public static final Target DROPDOWN_RIGHT_OPERAND = Target.the("Dropdown Right Operand")
            .locatedBy("//select[@id='RightOperand{0}']");

}
