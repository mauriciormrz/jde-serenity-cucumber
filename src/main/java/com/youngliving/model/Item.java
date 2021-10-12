package com.youngliving.model;

public class Item {

  private String OrderId;
  private int OrderLineNumber;
  private String PartNumber;
  private String TrackingNo;
  private int QtyOrdered;
  private int QtyShipped;
  private String ReasonCode;
  private String ShipDateTime;
  private String LotNumber;

    public Item(String OrderId
            , int OrderLineNumber
            , String PartNumber
            , String TrackingNo
            , int QtyOrdered
            , int QtyShipped
            , String ReasonCode
            , String ShipDateTime
            , String LotNumber) {
        this.OrderId = OrderId;
        this.OrderLineNumber = OrderLineNumber;
        this.PartNumber = PartNumber;
        this.TrackingNo = TrackingNo;
        this.QtyOrdered = QtyOrdered;
        this.QtyShipped = QtyShipped;
        this.ReasonCode = ReasonCode;
        this.ShipDateTime = ShipDateTime;
        this.LotNumber = LotNumber;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public int getOrderLineNumber() {
        return OrderLineNumber;
    }

    public void setOrderLineNumber(int OrderLineNumber) {
        this.OrderLineNumber = OrderLineNumber;
    }

    public String getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(String PartNumber) {
        this.PartNumber = PartNumber;
    }

    public String getTrackingNo() {
        return TrackingNo;
    }

    public void setTrackingNo(String TrackingNo) {
        this.TrackingNo = TrackingNo;
    }

    public int getQtyOrdered() {
        return QtyOrdered;
    }

    public void setQtyOrdered(int QtyOrdered) {
        this.QtyOrdered = QtyOrdered;
    }

    public int getQtyShipped() {
        return QtyShipped;
    }

    public void setQtyShipped(int QtyShipped) {
        this.QtyShipped = QtyShipped;
    }

    public String getReasonCode() {
        return ReasonCode;
    }

    public void setReasonCode(String ReasonCode) {
        this.ReasonCode = ReasonCode;
    }

    public String getShipDateTime() {
        return ShipDateTime;
    }

    public void setShipDateTime(String ShipDateTime) {
        this.ShipDateTime = ShipDateTime;
    }

    public String getLotNumber() {
        return LotNumber;
    }

    public void setLotNumber(String LotNumber) {
        this.LotNumber = LotNumber;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "OrderId='" + OrderId + '\'' +
                ", OrderLineNumber=" + OrderLineNumber +
                ", PartNumber='" + PartNumber + '\'' +
                ", TrackingNo='" + TrackingNo + '\'' +
                ", QtyOrdered=" + QtyOrdered +
                ", QtyShipped=" + QtyShipped +
                ", ReasonCode='" + ReasonCode + '\'' +
                ", ShipDateTime='" + ShipDateTime + '\'' +
                ", LotNumber='" + LotNumber + '\'' +
                '}';
    }

    public static final class Builder {
        private String OrderId;
        private int OrderLineNumber;
        private String PartNumber;
        private String TrackingNo;
        private int QtyOrdered;
        private int QtyShipped;
        private String ReasonCode;
        private String ShipDateTime;
        private String LotNumber;

        private Builder() {
        }

        public static Builder anItem() {
            return new Builder();
        }

        public Builder withOrderId(String OrderId) {
            this.OrderId = OrderId;
            return this;
        }

        public Builder withOrderLineNumber(int OrderLineNumber) {
            this.OrderLineNumber = OrderLineNumber;
            return this;
        }

        public Builder withPartNumber(String PartNumber) {
            this.PartNumber = PartNumber;
            return this;
        }

        public Builder withTrackingNo(String TrackingNo) {
            this.TrackingNo = TrackingNo;
            return this;
        }

        public Builder withQtyOrdered(int QtyOrdered) {
            this.QtyOrdered = QtyOrdered;
            return this;
        }

        public Builder withQtyShipped(int QtyShipped) {
            this.QtyShipped = QtyShipped;
            return this;
        }

        public Builder withReasonCode(String ReasonCode) {
            this.ReasonCode = ReasonCode;
            return this;
        }

        public Builder withShipDateTime(String ShipDateTime) {
            this.ShipDateTime = ShipDateTime;
            return this;
        }

        public Builder withLotNumber(String LotNumber) {
            this.LotNumber = LotNumber;
            return this;
        }

        public Item build() {
            return new Item(OrderId
                    , OrderLineNumber
                    , PartNumber
                    , TrackingNo
                    , QtyOrdered
                    , QtyShipped
                    , ReasonCode
                    , ShipDateTime
                    , LotNumber);
        }
    }
}



