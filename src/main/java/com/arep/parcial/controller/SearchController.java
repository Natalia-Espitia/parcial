package com.arep.parcial.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arep.parcial.SearchResponse;

@RestController
public class SearchController {

    @GetMapping("/linearsearch")
    public SearchResponse linearSearch(@RequestParam String list, @RequestParam String value) {
        List<String> inputList = Arrays.asList(list.split(","));
        int index = linearSearch(inputList, value);
        return new SearchResponse("linearSearch", list, value, String.valueOf(index));
    }

    @GetMapping("/binarysearch")
    public SearchResponse binarySearch(@RequestParam String list, @RequestParam String value) {
        List<String> inputList = Arrays.asList(list.split(","));
        inputList.sort(String::compareTo); 
        int index = binarySearch(inputList, value, 0, inputList.size() - 1);
        return new SearchResponse("binarySearch", list, value, String.valueOf(index));
    }

    private int linearSearch(List<String> list, String value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(List<String> list, String value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (list.get(mid).equals(value)) {
            return mid;
        }
        if (list.get(mid).compareTo(value) > 0) {
            return binarySearch(list, value, left, mid - 1);
        }
        return binarySearch(list, value, mid + 1, right);
    }
}