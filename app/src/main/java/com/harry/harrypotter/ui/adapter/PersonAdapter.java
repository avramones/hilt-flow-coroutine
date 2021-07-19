package com.harry.harrypotter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.harry.harrypotter.R;
import com.harry.harrypotter.model.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PersonAdapter  extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private PersonAdapter.ItemClickListener mClickListener;
    private List<Person> list;

    public PersonAdapter(Context context, List<Person> list) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;

    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_person, parent, false);
        return new PersonAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        holder.name.setText(list.get(position).name);
        Picasso.get().load(list.get(position).image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }


    }

    public void setOnItemClickListener(PersonAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }




}