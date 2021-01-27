package com.company.songsassignment;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<Song> songs;
MyAdapter adapter;
SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);

        searchView=findViewById(R.id.search);

        songs=new ArrayList<>();
        songs.add(new Song("We are the champions","Queen",R.drawable.download));
        songs.add(new Song("Nightmare","Halsey",R.drawable.download4));
        songs.add(new Song("Future (with Quavo)","Madonna",R.drawable.download2));
        songs.add(new Song("Hello","Adelle",R.drawable.download3));
        songs.add(new Song("I don't care","Ed Sheeran",R.drawable.download4));
        songs.add(new Song("تملى معاك","Amr Diab",R.drawable.download5));

        adapter=new MyAdapter(this,songs);
        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                String userInput=newText.toLowerCase();

                ArrayList<Song> filteredList=new ArrayList<>();

                for(int i=0;i<songs.size();i++) {
                    String text = songs.get(i).getTitle().toLowerCase();
                    if(text.contains(userInput)){
                        filteredList.add(songs.get(i));
                        adapter = new MyAdapter(MainActivity.this, filteredList);
                        listView.setAdapter(adapter);

                    }
                }

                return true;
            }
        });
    }
}
