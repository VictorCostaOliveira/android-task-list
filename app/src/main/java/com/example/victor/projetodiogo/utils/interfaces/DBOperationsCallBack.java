package com.example.victor.projetodiogo.utils.interfaces;

import com.example.victor.projetodiogo.Model.User;

/**
 * Created by victor on 17/06/18.
 */

public interface DBOperationsCallBack {
    void savedUser(Boolean success);

    void userExists(Boolean exists, User user);
}