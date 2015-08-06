package nl.jketelaar.exchange.items;

import nl.jketelaar.exchange.data.Configuration;

import java.util.ArrayList;

/**
 * @author JKetelaar
 */
public class Item {

    private String name;
    private int itemID;
    private long storePrice;
    private String imageURL;
    private ArrayList<ItemPrice> itemPrices;

    public Item(String name, int itemID, long storePrice, String imageURL) {
        this.name = name;
        this.itemID = itemID;
        this.storePrice = storePrice;
        this.imageURL = imageURL;
        this.itemPrices = new ArrayList<ItemPrice>();
    }

    public Item(String name, int itemID, String imageURL) {
        this.name = name;
        this.itemID = itemID;
        this.imageURL = imageURL;
        this.itemPrices = new ArrayList<ItemPrice>();
    }

    public Item(int itemID) {
        this.itemID = itemID;
        this.imageURL = String.format(Configuration.IMAGE_URL, itemID);
        this.itemPrices = new ArrayList<ItemPrice>();
    }

    public Item(int itemID, String name) {
        this.itemID = itemID;
        this.name = name;
        this.itemPrices = new ArrayList<ItemPrice>();
    }

    public void addItemPrice(ItemPrice itemPrice){
        this.itemPrices.add(itemPrice);
    }

    public String getName() {
        return name;
    }

    public int getItemID() {
        return itemID;
    }

    public long getStorePrice() {
        return storePrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ArrayList<ItemPrice> getItemPrices() {
        return itemPrices;
    }
}
