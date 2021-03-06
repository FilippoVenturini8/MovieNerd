package com.example.movienerd.FilmRecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movienerd.Film;
import com.example.movienerd.FilmDiffCallback;
import com.example.movienerd.R;

import java.util.ArrayList;
import java.util.List;

public class SearchedFilmAdapter extends RecyclerView.Adapter<SearchedFilmViewHolder>{
    private Activity activity;

    private  OnItemListener listener;

    private List<Film> filmList = new ArrayList<>();

    private List<Film> filmListNotFiltered = new ArrayList<>();

    public SearchedFilmAdapter(OnItemListener listener, Activity activity){
        this.activity = activity;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchedFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.searched_element, parent, false);
        return new SearchedFilmViewHolder(layoutView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchedFilmViewHolder holder, int position) {
        Film current  = filmList.get(position);

        Glide.with(activity)
                .load(current.getUrlPosterImg())
                .into(holder.filmImage);
        holder.title.setText(current.getTitle());
        holder.year.setText(current.getYear());
    }

    public void setData(List<Film> list){
        this.filmList = new ArrayList<>(list);
        this.filmListNotFiltered = new ArrayList<>(list);

        final FilmDiffCallback diffCallback = new FilmDiffCallback(this.filmList, list);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        diffResult.dispatchUpdatesTo(this);
        notifyDataSetChanged();
    }

    public Film getFilmSelected(int position){
        return filmList.get(position);
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
