package fulfillment.model;

public class Shipment {

    private String MsgDateTime;
    private String Sender;
    private String Receiver;
    ShipmentDetails[] ShipmentDetails;

    public Shipment(String MsgDateTime,
                    String Sender,
                    String Receiver,
                    fulfillment.model.ShipmentDetails[] ShipmentDetails) {
        this.MsgDateTime = MsgDateTime;
        this.Sender = Sender;
        this.Receiver = Receiver;
        this.ShipmentDetails = ShipmentDetails;
    }

    public String getMsgDateTime() {
        return MsgDateTime;
    }

    public void setMsgDateTime(String MsgDateTime) {
        this.MsgDateTime = MsgDateTime;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String Sender) {
        this.Sender = Sender;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }

    public fulfillment.model.ShipmentDetails[] GetShipmentDetails() {
        return ShipmentDetails;
    }

    public void setShipmentDetails(fulfillment.model.ShipmentDetails[] ShipmentDetails) {
        this.ShipmentDetails = ShipmentDetails;
    }


    public static final class Builder {
        fulfillment.model.ShipmentDetails[] ShipmentDetails;
        private String MsgDateTime;
        private String Sender;
        private String Receiver;

        private Builder() {
        }

        public static Builder aShipment() {
            return new Builder();
        }

        public Builder withMsgDateTime(String MsgDateTime) {
            this.MsgDateTime = MsgDateTime;
            return this;
        }

        public Builder withSender(String Sender) {
            this.Sender = Sender;
            return this;
        }

        public Builder withReceiver(String Receiver) {
            this.Receiver = Receiver;
            return this;
        }

        public Builder withShipmentDetails(ShipmentDetails[] ShipmentDetails) {
            this.ShipmentDetails = ShipmentDetails;
            return this;
        }

        public Shipment build() {
            return new Shipment(MsgDateTime, Sender, Receiver, ShipmentDetails);
        }
    }
}