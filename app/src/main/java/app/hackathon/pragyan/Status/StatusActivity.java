package app.hackathon.pragyan.Status;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import app.hackathon.pragyan.R;

public class StatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_view);

        Intent i = getIntent();
        try {
            JSONArray list = new JSONArray(i.getStringExtra("order_list"));
            Log.i("STatus Acttyyyyy value", "" + list);
            UpdateView(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void UpdateView(JSONArray array) throws JSONException {

        ArrayList<JSONObject> listdata = new ArrayList<JSONObject>();

        if (array != null) {
            for (int i=0;i<array.length();i++){
                listdata.add(array.getJSONObject(i));
            }
        }

        ListView listView = findViewById(R.id.listview);
        ListAdapter adapter = new ListAdapter(StatusActivity.this,R.layout.list_item,listdata);
        listView.setAdapter(adapter);
    }

}
