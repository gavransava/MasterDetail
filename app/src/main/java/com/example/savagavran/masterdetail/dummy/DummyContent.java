package com.example.savagavran.masterdetail.dummy;

/**
 * Created by sava.gavran on 8/31/2016.
 */

import android.content.Context;
import android.content.res.Resources;

import com.example.savagavran.masterdetail.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DummyContent {

    public static List<String> ITEM_LIST;
    public static final Map<String, String> ITEM_MAP = new HashMap<>();

    public static void createDummyItems(Context context) {
        Resources res = context.getResources();
        ITEM_LIST = Arrays.asList(res.getStringArray(R.array.locations_array));
        String [] details = res.getStringArray(R.array.details_array);
        for (int i = 0; i < ITEM_LIST.size(); i++) {
            ITEM_MAP.put(ITEM_LIST.get(i), details[i]);
        }
    }
}
