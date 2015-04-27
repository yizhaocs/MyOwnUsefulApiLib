package main.java;

import java.awt.Window.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*
 * Reference: https://sites.google.com/site/gson/gson-user-guide
 * */
public class Main {
    static Gson gson = new Gson();

    public static void main(String[] args) {
        SerializationPrimitives();
        DeserializationPrimitives();
        SerializationObject();
        DeserializationObject();
        SerializationArray();
        DeserializationArray();
        SerializationCollections();
        DeserializationCollections();
        NestedJsonObject();

    }

    private static void SerializationPrimitives() {
        System.out.println(gson.toJson(1)); // 1
        System.out.println(gson.toJson("abcd")); // "abcd"
        System.out.println(gson.toJson(new Long(10))); // 10
        System.out.println(gson.toJson(true)); // true
    }

    private static void DeserializationPrimitives() {
        int oneInt = gson.fromJson("1", int.class);
        Integer oneInteger = gson.fromJson("1", Integer.class);
        Long oneLong = gson.fromJson("1", Long.class);
        Boolean falseBoopean = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        // String anotherStr = gson.fromJson("[\"abc\"]", String.class);

        System.out.println(oneInt); // 1
        System.out.println(oneInteger); // 2
        System.out.println(oneLong); // 2
        System.out.println(falseBoopean); // false
        System.out.println(str); // abc
        // System.out.println(anotherStr);
    }

    private static void SerializationObject() {
        BagOfPrimitives obj = new BagOfPrimitives();
        String json = gson.toJson(obj);
        System.out.println(json); // {"value1":1,"value2":"abc","value3":[1,2,3,4]}
    }

    private static void DeserializationObject() {
        BagOfPrimitives obj = new BagOfPrimitives();
        String json = gson.toJson(obj);
        System.out.println(json); // {"value1":1,"value2":"abc","value3":[1,2,3,4]}
        BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
        String json2 = gson.toJson(obj2);
        System.out.println(json2); // {"value1":1,"value2":"abc","value3":[1,2,3,4]}
    }

    private static void SerializationArray() {
        int[] ints = { 1, 2, 3, 4, 5 };
        String[] strings = { "abc", "def", "ghi" };
        int[][] doubleArray = { { 1 }, { 2, 3 } };
        System.out.println(gson.toJson(ints)); // [1,2,3,4,5]
        System.out.println(gson.toJson(strings)); // ["abc","def","ghi"]
        System.out.println(gson.toJson(doubleArray)); // [[1],[2,3]]
    }

    private static void DeserializationArray() {
        int[] ints = gson.fromJson("[1,2,3,4,5]", int[].class);
        String[] strings = gson.fromJson("[\"abc\",\"def\",\"ghi\"]", String[].class);
        int[][] doubleArray = gson.fromJson("[[1],[2,3]]", int[][].class);
        System.out.println(Arrays.toString(ints)); // [1,2,3,4,5]
        System.out.println(Arrays.toString(strings)); // ["abc","def","ghi"]
        for (int[] singleArray : doubleArray) {
            // [1]
            // [2, 3]
            System.out.println(Arrays.toString(singleArray));
        }
    }

    private static void SerializationCollections() {
        List<Integer> ints = new LinkedList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        String json = gson.toJson(ints);
        System.out.println(json); // [1,2,3,4,5]
    }

    private static void DeserializationCollections() {
        List<Integer> ints = new LinkedList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        String json = gson.toJson(ints);
        java.lang.reflect.Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
        List<Integer> ints2 = gson.fromJson(json, collectionType);
        System.out.println(ints2); // [1, 2, 3, 4, 5]
    }

    private static void NestedJsonObject() {
        NestedJsonObject obj = new NestedJsonObject();
        String json = gson.toJson(obj);
        System.out.println(json); // {"user":{"firstName":"Yi","lastName":"Zhao","email":"yizhao.cs@gmail.com","password":"123456"}}

        NestedJsonObject obj2 = gson.fromJson(json, NestedJsonObject.class);
        String json2 = gson.toJson(obj2);
        System.out.println(json2); // {"user":{"firstName":"Yi","lastName":"Zhao","email":"yizhao.cs@gmail.com","password":"123456"}}
    }
}