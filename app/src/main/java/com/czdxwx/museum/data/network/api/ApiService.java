package com.czdxwx.museum.data.network.api;

import com.czdxwx.museum.data.db.entities.Artifact;
import com.czdxwx.museum.data.db.entities.CreativeProduct;
import com.czdxwx.museum.data.db.entities.Order;
import com.czdxwx.museum.data.db.entities.User;
import com.czdxwx.museum.data.network.model.SyncDataRequest;
import com.czdxwx.museum.data.network.model.SyncDataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {

    // 上传同步数据
    @POST("sync")
    Call<SyncDataResponse> syncData(@Body SyncDataRequest request);

    // 获取文物数据
    @GET("artifacts")
    Call<List<Artifact>> getArtifacts();

    // 获取文创商品数据
    @GET("creative_products")
    Call<List<CreativeProduct>> getCreativeProducts();

    // 获取用户数据
    @GET("users")
    Call<List<User>> getUsers();

    // 获取订单数据
    @GET("orders")
    Call<List<Order>> getOrders();

    @GET("orderDetails")
    Call<List<OrderDetail>> getOrderDetails();
}
