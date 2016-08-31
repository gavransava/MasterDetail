package com.example.savagavran.masterdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.savagavran.masterdetail.dummy.DummyContent;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.location_detail_container) != null) {
            mTwoPane = true;
        }

        DummyContent.createDummyItems(this);
        final ListView listView = (ListView) findViewById(R.id.location_list);
        setupListView(listView);
    }

    private void setupListView(ListView listView) {
        List<String> items = DummyContent.ITEM_LIST;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout
                .simple_list_item_1,
                items);
        listView.setAdapter(adapter);
    }
}
