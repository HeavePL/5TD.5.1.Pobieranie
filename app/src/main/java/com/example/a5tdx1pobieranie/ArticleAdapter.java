package com.example.a5tdx1pobieranie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private List<Article> articleList;

    public ArticleAdapter(List<Article> articleList){
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article,parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.titleTextView.setText(article.getTitle());
        holder.descriptionTextView.setText(article.getDescription());
        holder.dateTextView.setText(article.getDate());
        holder.authorTextView.setText(article.getAuthor());
        holder.contentTextView.setText(article.getContent());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView, dateTextView, authorTextView, contentTextView;

        public ArticleViewHolder(@NonNull View articleView) {

            super(articleView);
            titleTextView = articleView.findViewById(R.id.titleTextView);
            descriptionTextView = articleView.findViewById(R.id.descriptionTextView);
            dateTextView = articleView.findViewById(R.id.dateTextView);
            authorTextView = articleView.findViewById(R.id.authorTextView);
            contentTextView = articleView.findViewById(R.id.contentTextView);
        }
    }
}

