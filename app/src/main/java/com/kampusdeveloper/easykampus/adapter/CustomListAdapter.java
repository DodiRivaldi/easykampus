package com.kampusdeveloper.easykampus.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kampusdeveloper.easykampus.R;

/**
 * Created by Dodi Rivaldi on 19/08/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] telp;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] itemname,String[] telp, Integer[] imgid) {
        super(context, R.layout.kontak_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.telp=telp;
        this.imgid=imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.kontak_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_nama);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.gambar);
        TextView extratxt = (TextView) rowView.findViewById(R.id.tv_nomor);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(telp[position]);
        return rowView;

    };
}
