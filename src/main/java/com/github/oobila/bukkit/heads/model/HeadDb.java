package com.github.oobila.bukkit.heads.model;

import com.github.oobila.bukkit.common.utils.JavaUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HeadDb {

    private static final Map<String, Head> headsByName = new HashMap<>();
    private static final List<Head> heads = new ArrayList<>();
    private static final Map<String, List<Head>> headsByTag = new HashMap<>();
    private static final Map<HeadCollection, List<Head>> headsByCollection = new HashMap<>();

    public static void add(Head head) {
        if (headsByName.containsKey(head.getName())) {
            throw new RuntimeException("head with name: " + head.getName() + " already exists!");
        }
        headsByName.put(head.getName(), head);
        if (head.getTags() != null) {
            head.getTags().forEach(tag -> {
                headsByTag.putIfAbsent(tag, new ArrayList<>());
                headsByTag.get(tag).add(head);
            });
        }
        if (head.getCollection() != null) {
            headsByCollection.putIfAbsent(head.getCollection(), new ArrayList<>());
            headsByCollection.get(head.getCollection()).add(head);
        }
        heads.add(head);
    }

    public static Head get(String name) {
        return headsByName.get(name);
    }

    public static Head get(HeadCollection headCollection, char c) {
        return headsByCollection.get(headCollection).stream()
                .filter(head -> head.isChar() && head.getC() == c)
                .collect(JavaUtil.toSingleton());
    }

    public static Head get(HeadCollection headCollection, Symbol s) {
        return headsByCollection.get(headCollection).stream()
                .filter(head -> head.getS().equals(s))
                .collect(JavaUtil.toSingleton());
    }

    public static List<Head> getHeads(HeadCollection headCollection) {
        return headsByCollection.get(headCollection);
    }

    public static List<Head> getHeads(String tag) {
        return headsByTag.get(tag);
    }

    public static List<Head> getHeads(List<String> tags) {
        if (tags.isEmpty()) {
            throw new RuntimeException("tag list is empty");
        }
        String tag = tags.remove(0);
        List<Head> headList = headsByTag.get(tag);

        while (!tags.isEmpty()) {
            String wTag = tags.remove(0);
            headList = headList.stream().filter(head -> head.getTags().contains(wTag)).toList();
        }

        return headList;
    }

    public static Head.HeadBuilder head(String name, String texture) {
        return Head.builder().
                name(name)
                .texture(texture);
    }

}
