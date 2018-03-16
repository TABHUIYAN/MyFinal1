package com.example.bhuiyan.myfinal1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHUIYAN on 13/03/2018.
 */

/**
 * get count fuction
 * get item count
 */
public class ListAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add(ListItem object) {
        super.add(object);
        list.add(object);


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
/*list item holder
Layout inflater
set text function
 */
        View v;
        v = convertView;
        ListItemHolder listItemHolder;

        if(v==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = layoutInflater.inflate(R.layout.row_layout,parent,false);

            listItemHolder = new ListItemHolder();
            listItemHolder.tx_number = (TextView) v.findViewById(R.id.tx_number);
            listItemHolder.tx_name = (TextView) v.findViewById(R.id.tx_name);
            listItemHolder.tx_address = (TextView) v.findViewById(R.id.tx_address);
            listItemHolder.tx_position = (TextView) v.findViewById(R.id.tx_position);
            listItemHolder.tx_position1 = (TextView) v.findViewById(R.id.tx_position1);

            listItemHolder.tx_banking = (TextView) v.findViewById(R.id.tx_banking);
            listItemHolder.tx_bonus = (TextView) v.findViewById(R.id.tx_bonus);
            listItemHolder.tx_status = (TextView) v.findViewById(R.id.tx_status);
            listItemHolder.tx_contract_name = (TextView) v.findViewById(R.id.tx_contract_name);
            listItemHolder.tx_bike_stands = (TextView) v.findViewById(R.id.tx_bike_stands);
            listItemHolder.tx_available_bike_stands = (TextView) v.findViewById(R.id.tx_available_bike_stands);
            listItemHolder.tx_available_bikes = (TextView) v.findViewById(R.id.tx_available_bikes);
            listItemHolder.tx_last_update = (TextView) v.findViewById(R.id.tx_last_update);

            v.setTag(listItemHolder);

        }

        else{

            listItemHolder = (ListItemHolder) v.getTag();
        }

        ListItem listItem = (ListItem) this.getItem(position);

        listItemHolder.tx_number.setText(listItem.getNumber());
        listItemHolder.tx_name.setText(listItem.getName());
        listItemHolder.tx_address.setText(listItem.getAddress());
        listItemHolder.tx_position.setText(listItem.getPosition());
        listItemHolder.tx_position1.setText(listItem.getPosition1());

        listItemHolder.tx_banking.setText(listItem.getBanking());
        listItemHolder.tx_bonus.setText(listItem.getBonus());
        listItemHolder.tx_status.setText(listItem.getStatus());
        listItemHolder.tx_contract_name.setText(listItem.getContract_name());
        listItemHolder.tx_bike_stands.setText(listItem.getBike_stands());
        listItemHolder.tx_available_bike_stands.setText(listItem.getAvailable_bike_stands());
        listItemHolder.tx_available_bikes.setText(listItem.getAvailable_bikes());
        listItemHolder.tx_last_update.setText(listItem.getLast_update());


        return v;
    }

    static class ListItemHolder
    {
        TextView tx_number,tx_name,tx_address,tx_position,tx_position1,tx_banking,tx_bonus,
                tx_status,tx_contract_name,tx_bike_stands,tx_available_bike_stands,tx_available_bikes,tx_last_update;
    }
}
