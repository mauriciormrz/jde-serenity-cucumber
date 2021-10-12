package com.youngliving.model;

public class Lot {

    private String lotNumber;
    private final String partNumber;
    private int available;

    public Lot(String partNumber, String lotNumber, int available) {
        this.partNumber = partNumber;
        this.lotNumber = lotNumber;
        this.available = available;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getLotNumber() {

        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "{" +
                "partNumber='" + partNumber + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", available=" + available +
                '}';
    }

    public static final class Builder {
        private String partNumber;
        private String lotNumber;
        private int available;

        private Builder() {
        }

        public static Builder aLot() {
            return new Builder();
        }

        public Builder withPartNumber(String partNumber) {
            this.partNumber = partNumber;
            return this;
        }

        public Builder withLotNumber(String lotNumber) {
            this.lotNumber = lotNumber;
            return this;
        }

        public Builder withAvailable(int available) {
            this.available = available;
            return this;
        }

        public Lot build() {
            return new Lot(partNumber, lotNumber, available);
        }
    }
}
