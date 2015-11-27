package org.itechet.resteasy.example01.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ryan on 24/11/15.
 */
@XmlRootElement
public class ItemList {
    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static ItemList create(Item... items) {
        if (items == null) {
            return new ItemList();
        } else {
            List<Item> list = new ArrayList<Item>();
            for (Item item : items) {
                list.add(item);
            }
            ItemList result = new ItemList();
            result.setItems(list);
            return result;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(items.toArray());
    }

    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof ItemList) {
                ItemList o = (ItemList) other;
                return Objects.equals(items, o.items);
            }
        }
        return false;
    }
}
