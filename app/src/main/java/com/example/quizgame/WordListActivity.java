package com.example.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_word_list);

      // สร้าง Layout manager
      LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);

      // สร้าง Adapter object
      MyAdapter adapter = new MyAdapter();

      // เข้าถึง  RecyclerView ใน layout
      RecyclerView rv = findViewById(R.id.word_list_recycler_view);
      rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
      rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecyclerView
   }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   private WordItem[] items = {
         new WordItem(R.drawable.bts, "BTS" , "มี 7 คน"),
           new WordItem(R.drawable.blackpink, "BLACKPINK","มี 4 คน"),
         new WordItem(R.drawable.exo, "EXO" , "มี 9 คน"),
         new WordItem(R.drawable.g7, "GOT7","มี 7 คน"),
         new WordItem(R.drawable.itzy, "ITZY","มี 5 คน"),
           new WordItem(R.drawable.txt, "TXT","มี 5 คน"),
         new WordItem(R.drawable.nct, "NCT 127","มี 21 คน"),
         new WordItem(R.drawable.redvelvet, "RED VELVET","มี 4 คน"),
         new WordItem(R.drawable.seventeen, "SEVENTEEN","มี 13 คน"),
         new WordItem(R.drawable.twice, "TWICE" ,"มี 9 คน"),
           new WordItem(R.drawable.stk, "STRAY KIDS","มี 9 คน"),
           new WordItem(R.drawable.treasure, "TREASURE","มี 12 คน"),


   };


   MyAdapter() {
   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_word, parent, false);
      MyViewHolder vh = new MyViewHolder(v);
      return vh;
   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.imageView.setImageResource(items[position].imageResId);
      holder.wordTextView.setText(items[position].word);
      holder.countkpop.setText(items[position].countkpop);
   }

   @Override
   public int getItemCount() {
      return items.length;
   }

   static class MyViewHolder extends RecyclerView.ViewHolder {
      ImageView imageView;
      TextView wordTextView;
      TextView countkpop;
      MyViewHolder(@NonNull View itemView) {
         super(itemView);
         imageView = itemView.findViewById(R.id.image_view);
         wordTextView = itemView.findViewById(R.id.word_text_view);
         countkpop = itemView.findViewById(R.id.textView);
      }
   }
}