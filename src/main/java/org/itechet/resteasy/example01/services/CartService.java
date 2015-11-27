package org.itechet.resteasy.example01.services;

import org.apache.commons.lang3.StringUtils;
import org.itechet.resteasy.example01.models.Item;
import org.itechet.resteasy.example01.models.ItemList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ryan on 24/11/15.
 */
@ApplicationScoped
public class CartService {
    CatalogueService catalogueService;

    List<String> ids = new ArrayList<>();

    public CartService() {
    }

    @Inject
    public CartService(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    public synchronized ItemList getContent() {
        List<Item> items = new ArrayList<>();
        for (String id : ids) {
            items.add(catalogueService.getItem(id));
        }
        ItemList result = new ItemList();
        result.setItems(items);
        return result;
    }

    public synchronized void add(String itemId) {
        if (catalogueService.getItem(itemId) != null) {
            ids.add(itemId);
        }
    }

    public synchronized boolean delete(String itemId) {
        Iterator<String> it = ids.iterator();
        while (it.hasNext()) {
            if (StringUtils.equals(itemId, it.next())) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
