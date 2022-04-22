package com.pc.privacylibrary.base;

/**
 * author : liaominggui
 * e-mail : liaominggui@pconline.com.cn
 * date   : 2022/4/2 17:48
 * desc   :
 */
public interface DownInfoSuccessListener {
    void onSuccess(boolean isSuccess);

    void onFail(String error);
}
