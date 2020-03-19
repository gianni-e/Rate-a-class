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
import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder>
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
    private ArrayList<Rating> mRatings;
    private ArrayList<Rating> ratingListFull;

    public RatingAdapter(Context context, ArrayList<Rating> ratings)
    {
        mContext = context;
        mRatings = ratings;
    }

    RatingAdapter(ArrayList<Rating> mRatings)
    {
        this.mRatings = mRatings;
        ratingListFull = new ArrayList<>(mRatings);
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
        Rating currentItem = mRatings.get(position);

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
        return mRatings.size();
    }
}
