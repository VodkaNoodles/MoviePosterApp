package com.example.movieposterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.makeramen.roundedimageview.RoundedImageView;
public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder>{

    /**
     * Creates and returns new PosterViewHolder instance.
     *
     * @param parent   The parent ViewGroup in which the ViewHolder will be added.
     * @param viewType The view type of the new View.
     * @return A new instance of PosterViewHolder.
     */
    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PosterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_poster, parent, false));
    }
    /**
     * Binds data to specified PosterViewHolder.
     *
     * @param holder   The PosterViewHolder to bind data to.
     * @param position The position of the item within the data set.
     */
    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        holder.bindPosters(posterList.get(position));


    }
    /**
     * Returns the total number of items in the poster list.
     *
     * @return The size of the poster list.
     */
    @Override
    public int getItemCount() {
        return posterList.size();
    }
    private List<Poster> posterList;
    private PostersListener postersListener;
    /**
     * Returns list of currently selected posters.
     *
     * @return A list of selected Poster objects.
     */
    public List<Poster> getSelectedPosters() {
        List<Poster> selectedPosters = new ArrayList<>();
        for(Poster poster : this.posterList){
            if(poster.isSelected){
                selectedPosters.add(poster);
            }
        }
        return selectedPosters;
    }
    /**
     * Initializes a new instance of the PosterAdapter.
     *
     * @param posterList       The list of Poster objects to display.
     * @param postersListener  The listener for handling poster interactions.
     */
    public PosterAdapter(List<Poster> posterList, PostersListener postersListener) {
        this.posterList = posterList;
        this.postersListener = postersListener;
    }

    class PosterViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout layoutPosters;
        View viewBackground;

        RoundedImageView imagePoster;
        TextView textName, textCreatedBy, textStory;
        RatingBar ratingBar;
        ImageView imageSelected;
        /**
         * Creates a new PosterViewHolder to hold and manage a poster view.
         *
         * @param itemView The view representing a single poster item.
         */
        public PosterViewHolder(@NonNull View itemView){
            super(itemView);
            layoutPosters = itemView.findViewById(R.id.layoutPosters);
            viewBackground = itemView.findViewById(R.id.viewBackground);
            imagePoster = itemView.findViewById(R.id.imagePosters);
            textName = itemView.findViewById(R.id.textName);
            textCreatedBy = itemView.findViewById(R.id.textCreateBy);
            textStory = itemView.findViewById(R.id.textStory);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageSelected = itemView.findViewById(R.id.imageSelected);
        }
        /**
         * Binds data from the specified Poster to the view.
         *
         * @param poster The Poster object containing data to display.
         */
        void bindPosters(final Poster poster){
            imagePoster.setImageResource(poster.image);
            textName.setText(poster.name);
            textCreatedBy.setText(poster.createdBy);
            textStory.setText(poster.story);
            ratingBar.setRating(poster.rating);
            if (poster.isSelected){
                viewBackground.setBackgroundResource(R.drawable.poster_selected_background);
                imageSelected.setVisibility(View.VISIBLE);

            }else{
                viewBackground.setBackgroundResource(R.drawable.poster_background);
                imageSelected.setVisibility(View.GONE);
            }

            layoutPosters.setOnClickListener(new View.OnClickListener() {
                /**
                 * Handles the click event for the view.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    if(poster.isSelected){
                        viewBackground.setBackgroundResource(R.drawable.poster_background);
                        imageSelected.setVisibility(View.GONE);
                        poster.isSelected = false;
                        if(getSelectedPosters().isEmpty()) {
                            postersListener.onPosterAction(false);
                        }
                    }else{
                        viewBackground.setBackgroundResource(R.drawable.poster_selected_background);
                        imageSelected.setVisibility(View.VISIBLE);
                        poster.isSelected=true;
                        postersListener.onPosterAction(true);
                    }

                }
            });


        }







    }
}
