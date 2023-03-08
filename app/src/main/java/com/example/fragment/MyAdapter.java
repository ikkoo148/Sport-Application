package com.example.fragment;

import android.annotation.SuppressLint;
import android.database.MatrixCursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final String[] sports_name;
    private final String[] coach_name;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sport;
        private TextView coach;
        ImageButton cricket_btn,football_btn,athletics_btn,badminton_btn;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            sport = (TextView) view.findViewById(R.id.coach_name);
            coach = (TextView) view.findViewById(R.id.sports_name);
            cricket_btn = view.findViewById(R.id.cric_btn);
            football_btn = view.findViewById(R.id.foot_btn);
            badminton_btn = view.findViewById(R.id.bad_btn);
            athletics_btn = view.findViewById(R.id.athl_btn);
        }

        public TextView getTvsport_name() {
            return sport;
        }
        public TextView getTvcoach_name() {
            return coach;
        }

        public ImageButton getCricket_btn(){return cricket_btn;}
        public ImageButton getFootball_btn(){return football_btn;}
        public ImageButton getBadminton_btn(){return badminton_btn;}
        public ImageButton getAthletics_btn(){return athletics_btn;}
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param sportData String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(String[] sportData, String[] coachData  ) {
        sports_name = sportData;
        coach_name = coachData;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sports_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTvsport_name().setText(sports_name[position]);
        viewHolder.getTvcoach_name().setText(coach_name[position]);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.cric_btn:
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        Fragment_Cricket fragment_cricket = new Fragment_Cricket();
                        activity.getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragment_container, fragment_cricket).addToBackStack(null).commit();
                }
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        Fragment_Cricket fragment_cricket = new Fragment_Cricket();
                        activity.getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragment_container, fragment_cricket).addToBackStack(null).commit();
                        break;
                        case 1:
                        AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                        Fragment_Football fragment_football = new Fragment_Football();
                        activity2.getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragment_container, fragment_football).addToBackStack(null).commit();
                        break;
                        case 2:
                        AppCompatActivity activity3 = (AppCompatActivity) view.getContext();
                        Fragment_Badminton fragment_badminton = new Fragment_Badminton();
                        activity3.getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragment_container, fragment_badminton).addToBackStack(null).commit();
                        break;
                        case 3:
                        AppCompatActivity activity4 = (AppCompatActivity) view.getContext();
                        Fragment_Athletics fragment_athletics = new Fragment_Athletics();
                        activity4.getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragment_container, fragment_athletics).addToBackStack(null).commit();
                        break;
                }
            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sports_name.length;
    }
}
