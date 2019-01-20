package app.hackathon.pragyan.Status;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import app.hackathon.pragyan.R;

public class ListAdapter extends ArrayAdapter<JSONObject> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListItemView = convertView;
        if (ListItemView == null) {
            ListItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        JSONObject current = getItem(position);

        TextView name = ListItemView.findViewById(R.id.name);
        TextView quantity = ListItemView.findViewById(R.id.quantity);
        TextView slot = ListItemView.findViewById(R.id.slot);
        TextView costView = ListItemView.findViewById(R.id.costView);
        TextView paymentsat = ListItemView.findViewById(R.id.paymentsat);

        try {
            Log.i("Data: ",""+current.getJSONObject("Stock"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Log.i("Data: ",""+current.getJSONObject("Stock").getString("StockName"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Log.i("Data: ",""+current.getString("Quantity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Log.i("Data: ",""+current.getString("Cost"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Log.i("Data: ",""+current.getString("PaymentMode"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            name.setText(current.getJSONObject("Stock").getString("StockName"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            quantity.setText(current.getString("Quantity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            slot.setText(current.getString("SlotId"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            costView.setText(current.getString("Cost"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            if(current.getString("PaymentMode").equals("1")){
                paymentsat.setText("Paid");
            } else {
                paymentsat.setText("Payment Pending");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ListItemView;
    }

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<JSONObject> objects) {
        super(context, resource, objects);
    }
}