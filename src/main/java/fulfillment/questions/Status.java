package fulfillment.questions;

import fulfillment.model.Lot;
import fulfillment.constants.Constants;
import fulfillment.model.Color;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Status {

    private final static WebDriver hisBrowser = getDriver();
    private static List<List<String>> items;
    private static List<Lot> lots;

    public static Question<Boolean> value() {

        int maxPadLength = 6;
        String paddingCharacter = " ";

        items = getItems();

        System.out.print(Color.RED);
        System.out.print(StringUtils.leftPad(Constants.INDENTATION + Color.RED_BOLD + "ITEM", maxPadLength + 2, paddingCharacter));
        System.out.print(StringUtils.leftPad("LAST", maxPadLength, paddingCharacter));
        System.out.println(StringUtils.leftPad("NEXT", maxPadLength, paddingCharacter));

        System.out.print(Color.RED);
        for (List<String> e : items) {
            System.out.print(StringUtils.leftPad(e.get(getHeader().indexOf("2nd Item Number")), maxPadLength + 1, paddingCharacter));
            System.out.print(StringUtils.leftPad(e.get(getHeader().indexOf("Last Status")), maxPadLength, paddingCharacter));
            System.out.println(StringUtils.leftPad(e.get(getHeader().indexOf("Next Status")), maxPadLength, paddingCharacter));
        }
        System.out.print(Color.RESET);
        return actor -> Boolean.TRUE;
    }


    public static List<Lot> getLots() {

        return lots;
    }

    public static String getPullSignal() {

        return items.get(0).get(getHeader().indexOf("Pull Signal"));
    }


    public static List<String> getHeader() {

        List<WebElement> header = hisBrowser.findElements(By.cssSelector(Constants.HEADER_ORDER_INFO_TABLE_CSS));
        List<String> cols = header.stream()
                .map(e -> e.getAttribute("innerHTML").replaceAll("<br>", " "))
                .collect(Collectors.toList());
        return cols;
    }

    public static List<WebElement> getRows() {

        List<WebElement> rows = hisBrowser.findElements(By.cssSelector(Constants.ROWS_ORDER_INFO_TABLE_CSS));
        return rows;
    }

    public static List<String> getCells() {

        List<WebElement> row = hisBrowser.findElements(By.cssSelector(Constants.CELLS_ORDER_INFO_TABLE_CSS));
        List<String> cells = row.stream().map(e -> e.getAttribute("innerHTML").replaceAll("&nbsp;", " ")).collect(Collectors.toList());
        return cells;
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

    public static List<List<String>> getItems() {

        List<String> cols = getHeader();
        List<List<String>> table = getTable(cols.size());
        List<List<String>> items = new ArrayList<>();
        lots = new ArrayList<>();

        for (List<String> strings : table) {
            if (strings.get(cols.indexOf("Mod Trn")).trim().length() > 0) {
                if (!strings.get(cols.indexOf("Description 1")).contains("D. Gary Young Foundation")) {
                    items.add(strings);
                    lots.add(Lot.Builder.aLot().withPartNumber(strings.get(getHeader().indexOf("2nd Item Number"))).build());
                }
            }
        }
        return items;
    }

    public static Question<Boolean> valueFalse() {
        return actor -> Boolean.FALSE;
    }
}
