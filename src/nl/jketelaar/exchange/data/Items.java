package nl.jketelaar.exchange.data;

import nl.jketelaar.exchange.items.Item;
import nl.jketelaar.exchange.web.WebUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JKetelaar
 */
public class Items {

    private static final HashMap<Integer, Item> items = getItems();

    public static HashMap<Integer, Item> getItems(){
        HashMap<Integer, Item> items = new HashMap<Integer, Item>();
        JSONObject object = null;
        try {
            object = (JSONObject) WebUtil.getJsonParser().parse(WebUtil.getReader(Configuration.NAMES_URL));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (object != null){
            for (Object mapObject : object.entrySet()){
                Map.Entry<String, JSONObject> map = (Map.Entry<String, JSONObject>) mapObject;
                int itemID = Integer.parseInt(map.getKey());
                long storePrice = (Long) map.getValue().get("store");
                String itemName = (String) map.getValue().get("name");
                items.put(itemID, new Item(itemName, itemID, storePrice, String.format(Configuration.IMAGE_URL, itemID)));
            }
        }
        return items;
    }
}
