package org.egar.auction.model.comparators;

import org.egar.auction.model.Item;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item>{

    @Override
    public int compare(Item item1, Item item2) {
        return (int) (item1.getPrice() - item2.getPrice());
    }
}
