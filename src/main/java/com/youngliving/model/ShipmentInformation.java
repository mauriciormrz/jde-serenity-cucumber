package com.youngliving.model;

public class ShipmentInformation {
    private int UnbatchedShipmentsCount;
    private int UnacknowledgedShipmentsCount;
    private ShipmentToShip[] ShipmentsToShip;

    public ShipmentInformation(int UnbatchedShipmentsCount, int UnacknowledgedShipmentsCount, ShipmentToShip[] ShipmentsToShip) {
        this.UnbatchedShipmentsCount = UnbatchedShipmentsCount;
        this.UnacknowledgedShipmentsCount = UnacknowledgedShipmentsCount;
        this.ShipmentsToShip = ShipmentsToShip;
    }

    public int getUnbatchedShipmentsCount() {
        return UnbatchedShipmentsCount;
    }

    public void setUnbatchedShipmentsCount(int UnbatchedShipmentsCount) {
        this.UnbatchedShipmentsCount = UnbatchedShipmentsCount;
    }

    public int getUnacknowledgedShipmentsCount() {
        return UnacknowledgedShipmentsCount;
    }

    public void setUnacknowledgedShipmentsCount(int UnacknowledgedShipmentsCount) {
        this.UnacknowledgedShipmentsCount = UnacknowledgedShipmentsCount;
    }

    public ShipmentToShip[] getShipmentsToShip() {
        return ShipmentsToShip;
    }

    public void setShipmentsToShip(ShipmentToShip[] ShipmentsToShip) {
        this.ShipmentsToShip = ShipmentsToShip;
    }


    public static final class Builder {
        private int UnbatchedShipmentsCount;
        private int UnacknowledgedShipmentsCount;
        private ShipmentToShip[] ShipmentsToShip;

        private Builder() {
        }

        public static Builder aShipmentInformation() {
            return new Builder();
        }

        public Builder withUnbatchedShipmentsCount(int UnbatchedShipmentsCount) {
            this.UnbatchedShipmentsCount = UnbatchedShipmentsCount;
            return this;
        }

        public Builder withUnacknowledgedShipmentsCount(int UnacknowledgedShipmentsCount) {
            this.UnacknowledgedShipmentsCount = UnacknowledgedShipmentsCount;
            return this;
        }

        public Builder withShipmentsToShip(ShipmentToShip[] ShipmentsToShip) {
            this.ShipmentsToShip = ShipmentsToShip;
            return this;
        }

        public ShipmentInformation build() {
            return new ShipmentInformation(UnbatchedShipmentsCount, UnacknowledgedShipmentsCount, ShipmentsToShip);
        }
    }
}