package examples.aaronhoskins.com.rxjava.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import examples.aaronhoskins.com.rxjava.R;
import examples.aaronhoskins.com.rxjava.model.user.Result;
import examples.aaronhoskins.com.rxjava.model.user.UserResponse;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {
    List<Result> resultList;

    //Constructor for the adapter
    public UserRecyclerViewAdapter(UserResponse userResponse) {
        this.resultList = userResponse.getResults();//pull results from the userResponse
    }

    @NonNull
    @Override
    public UserRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        Result result = resultList.get(i);
        viewHolder.tvName.setText(result.getName().getFirst() + " " + result.getName().getLast());
        viewHolder.tvEmail.setText(result.getEmail());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvEmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvUserName);
            tvEmail = itemView.findViewById(R.id.tvUserEmail);
        }
    }
}
