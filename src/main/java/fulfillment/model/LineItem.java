package fulfillment.model;

public class LineItem {

    private int LineNumber;
    private String OrderId;
    private String PartNumber;
    private int Quantity;
    private String Name;
    private String LineType;
    private String ParentKitItem;
    private String Remarks;

    public LineItem(int LineNumber
            , String OrderId
            , String PartNumber
            , int Quantity
            , String Name
            , String LineType
            , String ParentKitItem
            , String Remarks) {
        this.LineNumber = LineNumber;
        this.OrderId = OrderId;
        this.PartNumber = PartNumber;
        this.Quantity = Quantity;
        this.Name = Name;
        this.LineType = LineType;
        this.ParentKitItem = ParentKitItem;
        this.Remarks = Remarks;
    }

    public int getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(int LineNumber) {
        this.LineNumber = LineNumber;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(String PartNumber) {
        this.PartNumber = PartNumber;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLineType() {
        return LineType;
    }

    public void setLineType(String LineType) {
        this.LineType = LineType;
    }

    public String getParentKitItem() {
        return ParentKitItem;
    }

    public void setParentKitItem(String ParentKitItem) {
        this.ParentKitItem = ParentKitItem;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }


}