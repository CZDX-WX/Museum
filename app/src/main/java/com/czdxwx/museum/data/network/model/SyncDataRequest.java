package com.czdxwx.museum.data.network.model;

import com.czdxwx.museum.data.db.entities.Artifact;
import com.czdxwx.museum.data.db.entities.CreativeProduct;
import com.czdxwx.museum.data.db.entities.Order;
import com.czdxwx.museum.data.db.entities.User;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyncDataRequest {
    private List<User> users;
    private List<Artifact> artifacts;
    private List<CreativeProduct> creativeProducts;
    private List<Order> orders;

}