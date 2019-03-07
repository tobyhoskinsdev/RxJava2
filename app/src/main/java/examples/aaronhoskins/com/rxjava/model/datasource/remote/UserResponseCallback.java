package examples.aaronhoskins.com.rxjava.model.datasource.remote;

import examples.aaronhoskins.com.rxjava.model.user.UserResponse;

public interface UserResponseCallback {
    void OnSucess(UserResponse userResponse);
}
