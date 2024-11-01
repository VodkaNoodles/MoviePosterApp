package com.example.movieposterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostersListener {

    private Button buttonAddToWatchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.posterRecyclerView);
        buttonAddToWatchList = findViewById(R.id.buttonAddToWatchlist);

        //prep data

        List<Poster> posterList = new ArrayList<>();

        Poster madmax = new Poster();
        madmax.image = R.drawable.madmax;
        madmax.name = "Mad Max: Fury Road";
        madmax.createdBy = "George Miller";
        madmax.rating =5f;
        madmax.story = "In a post-apocalyptic wasteland ravaged by a nuclear holocaust, Max Rockatansky, a lone survivor haunted by a tragic past," +
                       " is captured by the tyrannical Immortan Joe and his army of fanatical War Boys. Forced to become a blood donor for a dying War Boy," +
                       " Max finds himself entangled in a desperate escape plan led by Imperator Furiosa, a fearless warrior who seeks to liberate Joe's five wives from his oppressive rule.";
        posterList.add(madmax);

        Poster drift = new Poster();
        drift.image = R.drawable.drift;
        drift.name = "The Fast & Furious: Tokyo Drift";
        drift.createdBy = "Justin Lin";
        drift.rating =5f;
        drift.story = "Sean Boswell (Lucas Black) always feels like an outsider, but he defines himself through his victories as a street racer." +
                      " His hobby makes him unpopular with the authorities, so he goes to live with his father in Japan. Once there and even more alienated," +
                      " he learns about an exciting, but dangerous, new style of the sport. The stakes are high when Sean takes on the local champion and falls for the man's girlfriend.";
        posterList.add(drift);

        Poster t34 = new Poster();
        t34.image = R.drawable.t34;
        t34.name = "T-34";
        t34.createdBy = "Aleksey Sidorov";
        t34.rating =5f;
        t34.story = "The film follows the story of Nikolai Ivushkin, a tank commander who is captured by the Germans" +
                    " during World War II and plans his escape three years later. " +
                    "The escape is carried out with the help of a half-destroyed T-34 tank and a Russian translator named Anya.";
        posterList.add(t34);

        Poster sicarioPoster = new Poster();
        sicarioPoster.image = R.drawable.sicMov;
        sicarioPoster.name = "Sicario";
        sicarioPoster.createdBy = "Denis Villeneuve";
        sicarioPoster.rating =5f;
        sicarioPoster.story = " Recruited by mysterious government official Matt Graver (Josh Brolin), Kate (Emily Blunt)joins a task force for the escalating war against drugs." +
                              " Led by the intense and shadowy Alejandro (Benicio del Toro), the team travels back-and-forth across the U.S.-Mexican border, using one " +
                              "cartel boss (Bernardo Saracino) to flush out a bigger one (Julio Cesar Cedillo).";
        posterList.add(sicarioPoster);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList,this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();
                for (int i=0;i<selectPosters.size();i++){
                    if(i==0){
                        posterNames.append(selectPosters.get(i).name);
                    }else{
                        posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this,posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddToWatchList.setVisibility(View.VISIBLE);
        }else{
            buttonAddToWatchList.setVisibility(View.GONE);
        }
    }
}