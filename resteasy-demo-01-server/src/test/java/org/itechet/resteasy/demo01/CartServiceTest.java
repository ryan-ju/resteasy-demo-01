/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.demo01;

import org.itechet.resteasy.demo01.models.Item;
import org.itechet.resteasy.demo01.models.ItemList;
import org.itechet.resteasy.demo01.services.CartService;
import org.itechet.resteasy.demo01.services.CatalogueService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryan on 27/11/15.
 */
public class CartServiceTest {
    CartService fixture;

    @Before
    public void setup() {
        fixture = new CartService(new CatalogueService());
    }

    @Test
    public void test() {
        fixture.add("00001");
        ItemList itemList = fixture.getContent();
        Assert.assertEquals(1, itemList.getItems().size());
        Item item = itemList.getItems().get(0);
        Assert.assertEquals("00001", item.getId());

        fixture.add("00003");
        itemList = fixture.getContent();
        Assert.assertEquals(2, itemList.getItems().size());
        item = itemList.getItems().get(0);
        Assert.assertEquals("00001", item.getId());
        item = itemList.getItems().get(1);
        Assert.assertEquals("00003", item.getId());

        fixture.delete("00001");
        itemList = fixture.getContent();
        Assert.assertEquals(1, itemList.getItems().size());
        item = itemList.getItems().get(0);
        Assert.assertEquals("00003", item.getId());
    }
}
