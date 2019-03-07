package examples.aaronhoskins.com.rxjava.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import examples.aaronhoskins.com.rxjava.R;
import examples.aaronhoskins.com.rxjava.model.datasource.remote.UserResponseCallback;
import examples.aaronhoskins.com.rxjava.model.datasource.remote.UserResponseRepository;
import examples.aaronhoskins.com.rxjava.model.user.UserResponse;
import examples.aaronhoskins.com.rxjava.view.adapters.UserRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements UserResponseCallback {
    RecyclerView rvUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserResponseRepository userResponseRepository = new UserResponseRepository();
        userResponseRepository.getUserResponse("20", "female", this);
    }

    @Override
    public void OnSucess(UserResponse userResponse) {
        initializeRecyclerView(userResponse);
    }

    private void initializeRecyclerView(UserResponse userResponse) {
        rvUserList = findViewById(R.id.rvUsersList);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        rvUserList.setAdapter(new UserRecyclerViewAdapter(userResponse));
    }
}
