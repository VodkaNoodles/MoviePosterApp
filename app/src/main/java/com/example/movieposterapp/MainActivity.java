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
        sicarioPoster.image = R.drawable.movieposter_en;
        sicarioPoster.name = "Sicario";
        sicarioPoster.createdBy = "Denis Villeneuve";
        sicarioPoster.rating =5f;
        sicarioPoster.story = " Recruited by mysterious government official Matt Graver (Josh Brolin), Kate (Emily Blunt)joins a task force for the escalating war against drugs." +
                              " Led by the intense and shadowy Alejandro (Benicio del Toro), the team travels back-and-forth across the U.S.-Mexican border, using one " +
                              "cartel boss (Bernardo Saracino) to flush out a bigger one (Julio Cesar Cedillo).";
        posterList.add(sicarioPoster);

        Poster sicario2Poster = new Poster();
        sicario2Poster.image = R.drawable.sicario2;
        sicario2Poster.name = "Sicario: Day of the Soldado";
        sicario2Poster.createdBy = "Stefano Sollima";
        sicario2Poster.rating =5f;
        sicario2Poster.story = " FBI agent Matt Graver calls on mysterious operative Alejandro Gillick when Mexican drug cartels start to smuggle terrorists across the U.S. border." +
                               " The war escalates even further when Alejandro kidnaps a top kingpin's daughter to deliberately increase the tensions. When the young girl is seen as " +
                               "collateral damage, the two men will determine her fate as they question everything that they are fighting for.";
        posterList.add(sicario2Poster);

        Poster terminator1 = new Poster();
        terminator1.image = R.drawable.terminator1;
        terminator1.name = "Terminator";
        terminator1.createdBy = "James Cameron";
        terminator1.rating =5f;
        terminator1.story = " A cyborg (part man, part machine) is sent from the 21st century to present-day Los Angeles to assassinate a seemingly innocent women" +
                            " whose child will play an important part in the world from which the killer came.";
        posterList.add(terminator1);


        Poster terminatorSal = new Poster();
        terminatorSal.image = R.drawable.g137;
        terminatorSal.name = "Terminator Salvation";
        terminatorSal.createdBy = "McG";
        terminatorSal.rating =5f;
        terminatorSal.story = " Judgment Day has come and gone. Modern civilization has been destroyed. An army of Terminators roams the post-apocalyptic landscape," +
                              " killing or collecting humans where they hide. But small groups of survivors have organized into a Resistance, hiding in underground bunkers" +
                              " and striking when they can against an enemy force that vastly outnumbers them. Only one man saw Judgment Day coming, a man whose destiny has" +
                              " always been intertwined with the fate of human existence: John Connor. But something totally new has shaken Connor's belief that humanity has a" +
                              " chance of winning this war: the appearance of Marcus Wright, a stranger from the past whose last memory is of being on death row before awakening" +
                              " in this strange, new world. If humanity is to survive, Connor must decide whether Marcus can be trusted, and the two must find common ground to make" +
                              " a stand against the onslaught and meet the enemy head on.\n";
        posterList.add(terminatorSal);

        Poster theTown = new Poster();
        theTown.image = R.drawable.movieposter;
        theTown.name = "The Town";
        theTown.createdBy = "Ben Affleck";
        theTown.rating =5f;
        theTown.story = " Academy Award® winner Ben Affleck writes, directs and stars in this crime drama/romance. Based on the novel The Prince of Thieves by Chuck Hogan, Affleck's" +
                        " film follows a career criminal (Affleck) who finds himself romantically involved with the manager of a bank (Rebecca Hall) he held up. A high-stakes love triangle " +
                        "develops when an equally infatuated FBI agent (Mad Men's Jon Hamm) arrives in the pursuit of justice. Stolen cash and a stolen heart lead to a relationship that could" +
                        " destroy this prince of thieves.";
        posterList.add(theTown);

        Poster dunkirk = new Poster();
        dunkirk.image = R.drawable.dunkirk;
        dunkirk.name = "Dunkirk";
        dunkirk.createdBy = "Christopher Nolan";
        dunkirk.rating =5f;
        dunkirk.story = " “Dunkirk” opens as hundreds of thousands of British and Allied troops are surrounded by enemy forces. Trapped on the beach with their backs to the sea they face an impossible" +
                        " situation as the enemy closes in.";
        posterList.add(dunkirk);

        Poster endWatch = new Poster();
        endWatch.image = R.drawable.movieposterwatch;
        endWatch.name = "End of Watch";
        endWatch.createdBy = "David Ayer";
        endWatch.rating =5f;
        endWatch.story = " In their mission to abide by their oath to serve and protect, Officers Brian Taylor (Jake Gyllenhaal) and Mike Zavala (Michael Pe̱a) have formed a powerful brotherhood to" +
                         " ensure they both go home at the end of watch. But nothing can prepare them for the violent backlash that happens after they pull over the members of a notorious drug cartel" +
                         " for a routine traffic stop. Seen from the point of view of the officers, gang members, surveillance cameras, dash cams and citizens caught in the line of fire, a 360 perspective" +
                         " creates a gritty, compassionate and intense portrait of the city's darkest streets, and the brave men and women patrolling them.";
        posterList.add(endWatch);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList,this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchList.setOnClickListener(new View.OnClickListener() {
            /**
             * Handles click events for the respective view.
             *
             * @param view The view that was clicked.
             */
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
    /**
     * Handles the action performed on a poster, indicating its selection state.
     *
     * @param isSelected True if the poster is selected, false otherwise.
     */
    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddToWatchList.setVisibility(View.VISIBLE);
        }else{
            buttonAddToWatchList.setVisibility(View.GONE);
        }
    }
}