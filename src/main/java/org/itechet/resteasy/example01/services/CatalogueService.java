/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.example01.services;

import org.itechet.resteasy.example01.models.Item;
import org.itechet.resteasy.example01.models.ItemList;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ryan on 24/11/15.
 */
@ApplicationScoped
public class CatalogueService {
    ItemList itemList;
    Map<String, Item> map;

    public CatalogueService() {
        itemList = new ItemList();
        map = new HashMap<String, Item>();

        List<Item> list = new ArrayList<Item>();
        Item item = new Item();
        item.setId("00001");
        item.setName("Scala for the Impatient");
        item.setDescription("Awesome Scala book");
        list.add(item);
        map.put(item.getId(), item);

        item = new Item();
        item.setId("00002");
        item.setName("Java Concurrent in Practice");
        item.setDescription("Great threading book");
        list.add(item);
        map.put(item.getId(), item);

        item = new Item();
        item.setId("00003");
        item.setName("C Programming: A Modern Approach");
        item.setDescription("The C book");
        list.add(item);
        map.put(item.getId(), item);

        itemList.setItems(list);
    }

    public ItemList getItemList() {
        return itemList;
    }

    public Item getItem(String itemId) {
        return map.get(itemId);
    }
}
