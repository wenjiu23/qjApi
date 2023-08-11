package com.common.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvokeRequest implements Serializable {
    String name;

    private String ip;

    private String  sourceText;

    private String qq;

    private String url;

    private String text;

    private String phone;
}
