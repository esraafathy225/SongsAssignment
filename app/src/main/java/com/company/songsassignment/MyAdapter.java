package com.company.songsassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class MyAdapter extends ArrayAdapter<Song> {


    public MyAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
        TextView title=convertView.findViewById(R.id.txt);
        TextView author=convertView.findViewById(R.id.txt1);
        ImageView img=convertView.findViewById(R.id.img);

        Song song=getItem(position);

        title.setText(song.getTitle());
        author.setText(song.getAuthor());
        img.setImageResource(song.getImageId());
        return convertView;
    }
}
