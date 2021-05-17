package com.example.hidoctest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hidoctest.R;
import com.example.hidoctest.model.ArticlesData;
import com.example.hidoctest.model.BookModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.DataHolder>
{
    private ArrayList<BookModel> arrayList;
    private Context context;



    public BookAdapter(Context context, ArrayList<BookModel> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public BookAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books, parent, false);
        BookAdapter.DataHolder dataHolder = new BookAdapter.DataHolder(v);
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.DataHolder holder, final int position)
    {

        holder.txtv_name.setText(arrayList.get(position).getTitle());
        holder.txtv_author.setText(arrayList.get(position).getAuthor());

        if (arrayList.get(position).getImage().equals(""))
        {

        }
        else
        {
            Picasso.get()
                    .load(arrayList.get(position).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imgv_poster);
        }

    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder
    {
        TextView txtv_name ,txtv_author,txtv_year;
        CircleImageView imgv_poster;
        public DataHolder(@NonNull View itemView)
        {
            super(itemView);

            txtv_name=itemView.findViewById(R.id.txtv_name);
            txtv_author=itemView.findViewById(R.id.txtv_author);
            txtv_year=itemView.findViewById(R.id.txtv_year);

            imgv_poster = itemView.findViewById(R.id.imgv_poster);


        }
    }
}
