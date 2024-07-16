package com.springbootmail.service;

public interface IPurchaseOrder {
    String purchase(String[] items,Double price[],String toEmails []) throws Exception;
}
