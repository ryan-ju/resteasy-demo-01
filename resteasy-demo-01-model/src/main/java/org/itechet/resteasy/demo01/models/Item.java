/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.demo01.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Created by ryan on 24/11/15.
 */
@XmlRootElement
public class Item {
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof Item) {
                Item o = (Item) other;
                return Objects.equals(id, o.id) && Objects.equals(name, o.name) && Objects.equals(description, o.description);
            }
        }
        return false;
    }
}
