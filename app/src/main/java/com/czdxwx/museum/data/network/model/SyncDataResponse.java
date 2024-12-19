package com.czdxwx.museum.data.network.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyncDataResponse {
    private boolean success;
    private String message;


}

