package fulfillment.model;

public class ShipmentDetails {
    private String ShipmentId;
    private String ShipMethod;
    private String ShipCarrier;
    private int TotalWeight;
    private int FreightCharges;
    private int QtyPackages;
    private String WeightUoM;
    private String CurrCode;
    private Item[] ItemDetails;

    public ShipmentDetails(String ShipmentId
            , String ShipMethod
            , String ShipCarrier
            , int TotalWeight
            , int FreightCharges
            , int QtyPackages
            , String WeightUoM
            , String CurrCode
            , Item[] ItemDetails) {
        this.ShipmentId = ShipmentId;
        this.ShipMethod = ShipMethod;
        this.ShipCarrier = ShipCarrier;
        this.TotalWeight = TotalWeight;
        this.FreightCharges = FreightCharges;
        this.QtyPackages = QtyPackages;
        this.WeightUoM = WeightUoM;
        this.CurrCode = CurrCode;
        this.ItemDetails = ItemDetails;
    }

    public String getShipmentId() {
        return ShipmentId;
    }

    public void setShipmentId(String ShipmentId) {
        this.ShipmentId = ShipmentId;
    }

    public String getShipMethod() {
        return ShipMethod;
    }

    public void setShipMethod(String ShipMethod) {
        this.ShipMethod = ShipMethod;
    }

    public String getShipCarrier() {
        return ShipCarrier;
    }

    public void setShipCarrier(String ShipCarrier) {
        this.ShipCarrier = ShipCarrier;
    }

    public int getTotalWeight() {
        return TotalWeight;
    }

    public void setTotalWeight(int TotalWeight) {
        this.TotalWeight = TotalWeight;
    }

    public int getFreightCharges() {
        return FreightCharges;
    }

    public void setFreightCharges(int FreightCharges) {
        this.FreightCharges = FreightCharges;
    }

    public int getQtyPackages() {
        return QtyPackages;
    }

    public void setQtyPackages(int QtyPackages) {
        this.QtyPackages = QtyPackages;
    }

    public String getWeightUoM() {
        return WeightUoM;
    }

    public void setWeightUoM(String WeightUoM) {
        this.WeightUoM = WeightUoM;
    }

    public String getCurrCode() {
        return CurrCode;
    }

    public void setCurrCode(String CurrCode) {
        this.CurrCode = CurrCode;
    }

    public Item[] getItemDetails() {
        return ItemDetails;
    }

    public void setItemDetails(Item[] ItemDetails) {
        this.ItemDetails = ItemDetails;
    }

    public static final class Builder {
        private String ShipmentId;
        private String ShipMethod;
        private String ShipCarrier;
        private int TotalWeight;
        private int FreightCharges;
        private int QtyPackages;
        private String WeightUoM;
        private String CurrCode;
        private Item[] ItemDetails;

        private Builder() {
        }

        public static Builder aShipmentDetails() {
            return new Builder();
        }

        public Builder withShipmentId(String ShipmentId) {
            this.ShipmentId = ShipmentId;
            return this;
        }

        public Builder withShipMethod(String ShipMethod) {
            this.ShipMethod = ShipMethod;
            return this;
        }

        public Builder withShipCarrier(String ShipCarrier) {
            this.ShipCarrier = ShipCarrier;
            return this;
        }

        public Builder withTotalWeight(int TotalWeight) {
            this.TotalWeight = TotalWeight;
            return this;
        }

        public Builder withFreightCharges(int FreightCharges) {
            this.FreightCharges = FreightCharges;
            return this;
        }

        public Builder withQtyPackages(int QtyPackages) {
            this.QtyPackages = QtyPackages;
            return this;
        }

        public Builder withWeightUoM(String WeightUoM) {
            this.WeightUoM = WeightUoM;
            return this;
        }

        public Builder withCurrCode(String CurrCode) {
            this.CurrCode = CurrCode;
            return this;
        }

        public Builder withItemDetails(Item[] ItemDetails) {
            this.ItemDetails = ItemDetails;
            return this;
        }

        public ShipmentDetails build() {
            return new ShipmentDetails(ShipmentId, ShipMethod, ShipCarrier, TotalWeight, FreightCharges, QtyPackages, WeightUoM, CurrCode, ItemDetails);
        }
    }
}