/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.demo01;

import org.itechet.resteasy.demo01.models.Item;
import org.itechet.resteasy.demo01.models.ItemList;
import org.itechet.resteasy.demo01.services.CatalogueService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by ryan on 27/11/15.
 */
public class CatalogueServiceTest {

    static CatalogueService fixture;

    @BeforeClass
    public static void setup() {
        fixture = new CatalogueService();
    }

    @Test
    public void testGetItem() {
        Item item = fixture.getItem("00001");
        Assert.assertEquals("00001", item.getId());
        Assert.assertEquals("Scala for the Impatient", item.getName());
        Assert.assertEquals("Awesome Scala book", item.getDescription());

        item = fixture.getItem("00002");
        Assert.assertEquals("00002", item.getId());
        Assert.assertEquals("Java Concurrent in Practice", item.getName());
        Assert.assertEquals("Great threading book", item.getDescription());

        item = fixture.getItem("00003");
        Assert.assertEquals("00003", item.getId());
        Assert.assertEquals("C Programming: A Modern Approach", item.getName());
        Assert.assertEquals("The C book", item.getDescription());
    }

    @Test
    public void testGetItemList() {
        ItemList itemList = fixture.getItemList();

        Item item = itemList.getItems().get(0);
        Assert.assertEquals("00001", item.getId());
        Assert.assertEquals("Scala for the Impatient", item.getName());
        Assert.assertEquals("Awesome Scala book", item.getDescription());

        item = itemList.getItems().get(1);
        Assert.assertEquals("00002", item.getId());
        Assert.assertEquals("Java Concurrent in Practice", item.getName());
        Assert.assertEquals("Great threading book", item.getDescription());

        item = itemList.getItems().get(2);
        Assert.assertEquals("00003", item.getId());
        Assert.assertEquals("C Programming: A Modern Approach", item.getName());
        Assert.assertEquals("The C book", item.getDescription());
    }
}
