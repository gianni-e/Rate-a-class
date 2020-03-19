package com.example.rateaclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder> implements Filterable
{
    public class RatingViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mCourseName;
        public TextView mCourseNumber;
        public TextView mProfessor;
        public TextView mComments;
        public TextView mRating;

        public RatingViewHolder(View itemView)
        {
            super(itemView);
            mCourseName = itemView.findViewById(R.id.nameTextView);
            mCourseNumber = itemView.findViewById(R.id.numberTextView);
            mProfessor = itemView.findViewById(R.id.professorTextView);
            mComments = itemView.findViewById(R.id.commentsTextView);
            mRating = itemView.findViewById(R.id.ratingTextView);
        }
    }

    private Context mContext;
    private List<Rating> ratingList;
    private List<Rating> ratingListFull;

    public RatingAdapter(Context context, ArrayList<Rating> ratings)
    {
        mContext = context;
        this.ratingList = ratings;
        ratingListFull = new ArrayList<>();
        ratingListFull.addAll(ratingList);
    }

    @Override
    public RatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(mContext).inflate(R.layout.items, parent, false);
        return new RatingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RatingViewHolder holder, int position)
    {
        Rating currentItem = ratingList.get(position);

        String name = currentItem.getCourseName();
        String number = currentItem.getCourseNumber();
        String rating = currentItem.getStarRating();
        String professor = currentItem.getInstructor();
        String comments = currentItem.getComments();

        holder.mCourseName.setText(name);
        holder.mCourseNumber.setText(number);
        holder.mProfessor.setText("Professor: " + professor);
        holder.mComments.setText("Comments: " + comments);
        holder.mRating.setText("Stars: " + rating + " out of 5.0");
    }

    @Override
    public int getItemCount() {
        return ratingList.size();
    }

    @Override
    public Filter getFilter() {
        return ratingFilter;
    }

    private Filter ratingFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Rating> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ratingListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Rating item : ratingListFull) {
                    if (item.getCourseName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ratingList.clear();
            ratingList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}
