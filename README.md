Welcome to JKExchange!
===================      


This is an exchange API for 07, based on the OSBuddy API.
Besides the RSBuddy API, this API is also using the JSON Simple API to parse the results from RSBuddy.

### How to use it?

The API is made in mind to keep it simple, which is why the functionality might seem very limited too.
Exchange takes care of all the data gathering you'll need, an example (to gather information about a mind rune) will be: 
```
Item mindRune = Exchange.getPrice(558, true);
```
With this item object, you are capable of gathering all the data you need, including the store price, item name, item id and all the exchange rates.
The ItemPrice object, you get from #getItemPrices is an array full of all prices, relying on the timestamp of a certain date.
```
for (ItemPrice price : mindRune.getItemPrices()){
    System.out.println(
        "Timestamp: " + price.getTimestamp() + "\n" +
            "\tBuying price: " + price.getBuyPrice() + "\n" +
            "\tSelling price: " + price.getSellPrice() + "\n" +
            "\tOverall price: " + price.getOverallPrice()
    );
}
```

### TODO

- [x] Gathering all data split into 12 hours
- [ ] Timestamp selection
- [ ] Caching certain values into filesystem
- [ ] Add documentation (JavaDocs)
- [ ] Add more functionality like methods to get a price at a certain timestamp or date