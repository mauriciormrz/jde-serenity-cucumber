package fulfillment.model;

public class ShipmentToShip {
    private String ShipmentId;
    private String CustomerEmail;
    private String CustId;
    private String ShipPhone;
    private String ShipName;
    private String ShipAddr1;
    private String ShipAddr2;
    private String ShipAddr3;
    private String ShipAddr4;
    private String ShipCity;
    private String ShipState;
    private String ShipZip;
    private String ShipCountryIso;
    private String ShipMethod;
    private String ShipCarrier;
    private String BatchId;
    private String ContractDate;
    private LineItem LineItems[];

    public ShipmentToShip(String ShipmentId
            , String CustomerEmail
            , String CustId
            , String ShipPhone
            , String ShipName
            , String ShipAddr1
            , String ShipAddr2
            , String ShipAddr3
            , String ShipAddr4
            , String ShipCity
            , String ShipState
            , String ShipZip
            , String ShipCountryIso
            , String ShipMethod
            , String ShipCarrier
            , String BatchId
            , String ContractDate
            , LineItem[] LineItems) {
        this.ShipmentId = ShipmentId;
        this.CustomerEmail = CustomerEmail;
        this.CustId = CustId;
        this.ShipPhone = ShipPhone;
        this.ShipName = ShipName;
        this.ShipAddr1 = ShipAddr1;
        this.ShipAddr2 = ShipAddr2;
        this.ShipAddr3 = ShipAddr3;
        this.ShipAddr4 = ShipAddr4;
        this.ShipCity = ShipCity;
        this.ShipState = ShipState;
        this.ShipZip = ShipZip;
        this.ShipCountryIso = ShipCountryIso;
        this.ShipMethod = ShipMethod;
        this.ShipCarrier = ShipCarrier;
        this.BatchId = BatchId;
        this.ContractDate = ContractDate;
        this.LineItems = LineItems;
    }

    public String getShipmentId() {
        return ShipmentId;
    }

    public void setShipmentId(String ShipmentId) {
        this.ShipmentId = ShipmentId;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String CustId) {
        this.CustId = CustId;
    }

    public String getShipPhone() {
        return ShipPhone;
    }

    public void setShipPhone(String ShipPhone) {
        this.ShipPhone = ShipPhone;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String ShipName) {
        this.ShipName = ShipName;
    }

    public String getShipAddr1() {
        return ShipAddr1;
    }

    public void setShipAddr1(String ShipAddr1) {
        this.ShipAddr1 = ShipAddr1;
    }

    public String getShipAddr2() {
        return ShipAddr2;
    }

    public void setShipAddr2(String ShipAddr2) {
        this.ShipAddr2 = ShipAddr2;
    }

    public String getShipAddr3() {
        return ShipAddr3;
    }

    public void setShipAddr3(String ShipAddr3) {
        this.ShipAddr3 = ShipAddr3;
    }

    public String getShipAddr4() {
        return ShipAddr4;
    }

    public void setShipAddr4(String ShipAddr4) {
        this.ShipAddr4 = ShipAddr4;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public void setShipCity(String ShipCity) {
        this.ShipCity = ShipCity;
    }

    public String getShipState() {
        return ShipState;
    }

    public void setShipState(String ShipState) {
        this.ShipState = ShipState;
    }

    public String getShipZip() {
        return ShipZip;
    }

    public void setShipZip(String ShipZip) {
        this.ShipZip = ShipZip;
    }

    public String getShipCountryIso() {
        return ShipCountryIso;
    }

    public void setShipCountryIso(String ShipCountryIso) {
        this.ShipCountryIso = ShipCountryIso;
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

    public String getBatchId() {
        return BatchId;
    }

    public void setBatchId(String BatchId) {
        this.BatchId = BatchId;
    }

    public String getContractDate() {
        return ContractDate;
    }

    public void setContractDate(String ContractDate) {
        this.ContractDate = ContractDate;
    }

    public LineItem[] getLineItems() {
        return LineItems;
    }

    public void setLineItems(LineItem[] LineItems) {
        this.LineItems = LineItems;
    }


    public static final class Builder {
        private String ShipmentId;
        private String CustomerEmail;
        private String CustId;
        private String ShipPhone;
        private String ShipName;
        private String ShipAddr1;
        private String ShipAddr2;
        private String ShipAddr3;
        private String ShipAddr4;
        private String ShipCity;
        private String ShipState;
        private String ShipZip;
        private String ShipCountryIso;
        private String ShipMethod;
        private String ShipCarrier;
        private String BatchId;
        private String ContractDate;
        private LineItem LineItems[];

        private Builder() {
        }

        public static Builder aShipmentToShip() {
            return new Builder();
        }

        public Builder withShipmentId(String ShipmentId) {
            this.ShipmentId = ShipmentId;
            return this;
        }

        public Builder withCustomerEmail(String CustomerEmail) {
            this.CustomerEmail = CustomerEmail;
            return this;
        }

        public Builder withCustId(String CustId) {
            this.CustId = CustId;
            return this;
        }

        public Builder withShipPhone(String ShipPhone) {
            this.ShipPhone = ShipPhone;
            return this;
        }

        public Builder withShipName(String ShipName) {
            this.ShipName = ShipName;
            return this;
        }

        public Builder withShipAddr1(String ShipAddr1) {
            this.ShipAddr1 = ShipAddr1;
            return this;
        }

        public Builder withShipAddr2(String ShipAddr2) {
            this.ShipAddr2 = ShipAddr2;
            return this;
        }

        public Builder withShipAddr3(String ShipAddr3) {
            this.ShipAddr3 = ShipAddr3;
            return this;
        }

        public Builder withShipAddr4(String ShipAddr4) {
            this.ShipAddr4 = ShipAddr4;
            return this;
        }

        public Builder withShipCity(String ShipCity) {
            this.ShipCity = ShipCity;
            return this;
        }

        public Builder withShipState(String ShipState) {
            this.ShipState = ShipState;
            return this;
        }

        public Builder withShipZip(String ShipZip) {
            this.ShipZip = ShipZip;
            return this;
        }

        public Builder withShipCountryIso(String ShipCountryIso) {
            this.ShipCountryIso = ShipCountryIso;
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

        public Builder withBatchId(String BatchId) {
            this.BatchId = BatchId;
            return this;
        }

        public Builder withContractDate(String ContractDate) {
            this.ContractDate = ContractDate;
            return this;
        }

        public Builder withLineItems(LineItem[] LineItems) {
            this.LineItems = LineItems;
            return this;
        }

        public ShipmentToShip build() {
            return new ShipmentToShip(ShipmentId, CustomerEmail, CustId, ShipPhone, ShipName, ShipAddr1, ShipAddr2, ShipAddr3, ShipAddr4, ShipCity, ShipState, ShipZip, ShipCountryIso, ShipMethod, ShipCarrier, BatchId, ContractDate, LineItems);
        }
    }
}

