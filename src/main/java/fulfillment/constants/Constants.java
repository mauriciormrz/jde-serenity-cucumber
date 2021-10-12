package fulfillment.constants;

public class Constants {

    public  static final String INDENTATION = "   ";

    public static final String AUTHENTICATION_KEY = "Authentication";
    public static final String PUBLIC_KEY_PRO_STAR ="9A3A91E6D825D";
    public static final String PRIVATE_KEY_PRO_STAR ="E23A59D9A9ED8";
    public static final String TIMESTAMP_KEY = "Timestamp";
    public static final String ACCEPT_KEY = "Accept";
    public static final String ACCEPT_VALUE = "application/json";
    public static final String CONTENT_TYPE = "application/json";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";

    public static final String URL = "/rest/logistics/shipments-v2";
    public static final String GET_METHOD = "GET";
    public static final String PUT_METHOD = "PUT";
    public static final String POST_METHOD = "POST";

    public static final String P4210 = "p4210";
    public static final String BV = "bv";
    public static final String P41202 = "p41202";

    public static final String MENU_APP_IFRAME = "e1menuAppIframe";
    public static final String ROW_NUMBERS_TEXT = "Row numbers";

    public static final String CONSOLIDATE_LEFT_OPERAND = "Reference (F4211) (VR01) [BC]";
    //public static final String PICK_SLIP_LEFT_OPERAND = "Reference (F4201) (VR01) [BC]";
    public static final String LOT_CLEAN_UP_LEFT_OPERAND = "Pull Signal (F47132) (PSIG) [BC]";
    public static final String SHIP_CONFIRMATION_LEFT_OPERAND = "EDI - Document Number (F47131) (EDOC) [BC]";

    public static final String COMPARISON = "is equal to";
    public static final String RIGHT_OPERAND = "Literal";

    public static final String OPERATORS_TABLE_XPATH = "//*[@id='e1formDiv']/form/table/tbody/tr";

    //public static final String ORDER_INFO_TABLE_CSS = "#jdeGridData0_1";  //Table =1
    public static final String HEADER_ORDER_INFO_TABLE_CSS = "#hdrRow0_1 td.JSGridHeaderCell span"; // Header Cols =18
    public static final String ROWS_ORDER_INFO_TABLE_CSS = "#jdeGridData0_1 tr [realrow]"; // Rows =7
    public static final String CELLS_ORDER_INFO_TABLE_CSS = "#jdeGridData0_1 tr[realrow] td.textModifier div"; // Cells =126

    public static final String HEADER_LOT_INFO_TABLE_CSS = "#hdrRow0_319 td.JSGridHeaderCell"; // Header Cols =15 #hdrRow0_319 td.JSGridHeaderCell span
    public static final String ROWS_LOT_INFO_TABLE_CSS = "#jdeGridData0_319 tr [realrow]"; // Rows =x
    public static final String CELLS_LOT_INFO_TABLE_CSS = "#jdeGridData0_319 tr [realrow] td.JSGridCell"; // Cells =135 #jdeGridData0_319 tr [realrow] td.textModifier div

}



/*  Columns Table
0. 'Order Number'
1. 'Line Number'
2. 'Sold To'
3. 'Description 1'
4. 'Quantity'
5. 'Request Date'
6. 'Ship To'
7. '2nd Item Number'
8. 'Last Status'
9. 'Next Status'
10. 'Unit Price'
11. 'Order Date'
12. 'Short Item No'
13. 'Sls Cd1'
14. 'Sls Cd2'
15. 'Mod Trn'
16. 'Location'
17. 'Pull Signal'
 */

/*
0. Location
1. Branch/Plant
2. On Hand
3. Secondary On Hand
4. Commited
5. Secondary Commited
6. Available
7. On Receipt
8. SecondaryOn Receipt
9. Lot Status Code
10. Lot/Serial
11. Secondary Available
12. Last Rcpt Date
 */
