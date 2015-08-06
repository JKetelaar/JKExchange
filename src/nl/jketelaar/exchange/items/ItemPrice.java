package nl.jketelaar.exchange.items;

/**
 * @author JKetelaar
 */
public class ItemPrice {

    private long timestamp;
    private long buyPrice;
    private long sellPrice;
    private long overallPrice;

    public ItemPrice(long timestamp, long buyPrice, long sellPrice, long overallPrice) {
        this.timestamp = timestamp;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.overallPrice = overallPrice;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public long getOverallPrice() {
        return overallPrice;
    }
}
