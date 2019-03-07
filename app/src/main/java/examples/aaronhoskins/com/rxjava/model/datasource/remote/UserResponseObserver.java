package examples.aaronhoskins.com.rxjava.model.datasource.remote;

import android.util.Log;

import examples.aaronhoskins.com.rxjava.model.user.UserResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserResponseObserver implements Observer<UserResponse> {
    private static final String TAG = "TAG_OBSERVER";
    UserResponse returnUserResponse;
    UserResponseCallback userResponseCallback;

    //Constructor for the observer
    public UserResponseObserver(UserResponseCallback userResponseCallback) {
        this.userResponseCallback = userResponseCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //When the observer subscribes to the observable, do anything
        //     needed to set up for the response once it is received
        Log.d(TAG, "onSubscribe: SUBSCRIBED TO OBSERVABLE");
    }

    @Override
    public void onNext(UserResponse userResponse) {
        //This is where our responses will be received
        Log.d(TAG, "onNext: RESPONSE RECEIVED ");
        returnUserResponse = userResponse;
    }

    @Override
    public void onError(Throwable e) {
        //Something went wrong, take some action
        Log.e(TAG, "onError: ERROR RETURNED", e);
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: TASK IS COMPLETE RETURNING USER RESPONSE");
        //pass the user response that was received back along the callback
        userResponseCallback.OnSucess(returnUserResponse);
    }
}
