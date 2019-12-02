package com.example.finalproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class VocabListAdapter extends ArrayAdapter<Vocab> {

    private static final String TAG = "VocabListAdapter";

    private Context mContext;
    int mResource;

    public VocabListAdapter(@NonNull Context context, int resource, ArrayList<Vocab> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String word = getItem(position).getWord();
        String def = getItem(position).getDef();

        Vocab vocab = new Vocab(word, def);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvWord = (TextView)convertView.findViewById(R.id.text1);
        TextView tvDef = (TextView)convertView.findViewById(R.id.text2);

        tvWord.setText(word);
        tvDef.setText(def);

        return convertView;
    }
}
