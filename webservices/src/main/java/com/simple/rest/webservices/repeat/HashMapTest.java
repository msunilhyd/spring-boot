package com.simple.rest.webservices.repeat;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {

        HashMap<Product, Integer> hashMap = new HashMap<>();

        Product product1 = new Product(1, "Honey");
        Product product2 = new Product(2, "Almond");
        Product product3 = new Product(1, "Honey");

        hashMap.put(product1, 1);
        hashMap.put(product2, 2);
        hashMap.put(product3, 3);

        System.out.println(product1.equals(product3));

    }
}
