package nl.jketelaar.exchange;

import nl.jketelaar.exchange.data.Configuration;
import nl.jketelaar.exchange.data.Items;
import nl.jketelaar.exchange.items.Item;
import nl.jketelaar.exchange.items.ItemPrice;
import nl.jketelaar.exchange.web.WebUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author JKetelaar
 */
public class Exchange {

    private static ArrayList<Item> cachedItems;

    public static Item getPrice(int itemID, boolean cache) throws IOException, ParseException {
        if (cache){
            if (cachedItems == null) {
                cachedItems = new ArrayList<Item>();
            }else{
                for (Item item : cachedItems){
                    if (item.getItemID() == itemID){
                        return item;
                    }
                }
            }
        }

        Item item;
        if ((item = Items.getItems().get(itemID)) == null){
            item = new Item(itemID);
        }

        JSONArray prices = (JSONArray) WebUtil.getJsonParser().parse(WebUtil.getReader(String.format(Configuration.API_URL, itemID)));
        for (Object object : prices){
            JSONObject itemPrice = (JSONObject) object;

            long ts = (Long) itemPrice.get("ts");
            long buyPrice = (Long) itemPrice.get("buyingPrice");
            long sellPrice = (Long) itemPrice.get("sellingPrice");
            long overallPrice = (Long) itemPrice.get("overallPrice");

            ItemPrice price = new ItemPrice(ts, buyPrice, sellPrice, overallPrice);
            item.addItemPrice(price);
        }

        if (cache){
            cachedItems.add(item);
        }

        return item;
    }
}
