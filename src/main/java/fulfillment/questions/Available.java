package fulfillment.questions;

import fulfillment.model.Lot;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static fulfillment.constants.Constants.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Available {

    private final static WebDriver hisBrowser = getDriver();

    public static Question<Boolean> value(Lot lot) {

        getItems(lot);
        return actor -> Boolean.TRUE;
    }


    public static void getItems(Lot lot) {

        List<String> cols = getHeader();
        List<List<String>> table = getTable(cols.size());

        List<List<String>> items = table.stream()
                .filter(e -> e.get(cols.indexOf("Location")).contains("AV"))
                .filter(e -> !e.get(cols.indexOf("Available")).contains("-"))
                .filter(e -> e.get(cols.indexOf("Available")).trim().length() > 0)
                .collect(Collectors.toList());

        if (items.size()==0) {
            lot.setAvailable(0);
            lot.setLotNumber("");
        } else {
            lot.setAvailable((int) Double.parseDouble(items.get(0).get(getHeader().indexOf("Available"))));
            lot.setLotNumber(items.get(0).get(getHeader().indexOf("Lot/Serial")));
        }
    }

    public static List<String> getHeader() {

        List<WebElement> header = hisBrowser.findElements(By.cssSelector(HEADER_LOT_INFO_TABLE_CSS));
        List<String> cols = header.stream()
                .map(e -> e.getText().replaceAll("\n", " "))
                .collect(Collectors.toList());
        return cols;
    }

    public static List<List<String>> getTable(int offset) {

        List<List<String>> table = new ArrayList<>();
        List<WebElement> rows = getRows();
        List<String> cells = getCells();

        for (int i = 0; i < rows.size(); i++) {
            table.add(cells.subList(i * offset, ((i + 1) * offset)));
        }
        return table;
    }

    public static List<WebElement> getRows() {

        List<WebElement> rows = hisBrowser.findElements(By.cssSelector(ROWS_LOT_INFO_TABLE_CSS));
        return rows;
    }

    public static List<String> getCells() {

        List<WebElement> row = hisBrowser.findElements(By.cssSelector(CELLS_LOT_INFO_TABLE_CSS));
        List<String> cells = row.stream()
                .map(e -> e.getText().replaceAll("\n", " ").trim())
                .collect(Collectors.toList());
        return cells;
    }
}
