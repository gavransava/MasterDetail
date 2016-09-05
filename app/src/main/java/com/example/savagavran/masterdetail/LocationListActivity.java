package com.example.savagavran.masterdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.savagavran.masterdetail.dummy.DummyContent;

import java.util.List;

public class LocationListActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        if (findViewById(R.id.location_detail_container) != null) {
            mTwoPane = true;
        }

        DummyContent.createDummyItems(this);
        final ListView listView = (ListView) findViewById(R.id.location_list);
        setupListView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String location = (String) ((TextView) view
                        .findViewById(android.R.id.text1)).getText();
                if (mTwoPane) {
                    replaceDetailFragment(location);
                } else {
                    startDetailActivity(location);
                }
            }
        });

        if (mTwoPane && savedInstanceState == null) {
            replaceDetailFragment(DummyContent.ITEM_LIST.get(0));
        }
    }

    private void setupListView(ListView listView) {
        List<String> items = DummyContent.ITEM_LIST;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout
                .simple_list_item_1,
                items);
        listView.setAdapter(adapter);
    }

    private void replaceDetailFragment(String item) {
        Bundle arguments = new Bundle();
        arguments.putString(LocationDetailFragment.ARG_LOCATION, item);
        LocationDetailFragment fragment = new LocationDetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.location_detail_container, fragment)
                .commit();
    }

    private void startDetailActivity(String item) {
        Intent intent = new Intent(LocationListActivity.this, LocationDetailActivity
                .class);
        intent.putExtra(LocationDetailFragment.ARG_LOCATION, item);
        startActivity(intent);
    }
}
