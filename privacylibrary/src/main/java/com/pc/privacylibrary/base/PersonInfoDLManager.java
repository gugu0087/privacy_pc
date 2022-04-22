package com.pc.privacylibrary.base;

/**
 * author : liaominggui
 * e-mail : liaominggui@pconline.com.cn
 * date   : 2022/4/2 17:38
 * desc   :
 */
public class PersonInfoDLManager {

    private PersonInfoDLManager() {

    }

    private static class PersonInfoDLManagerHolder {
        private static final PersonInfoDLManager instance = new PersonInfoDLManager();
    }

    public static PersonInfoDLManager getInstance() {
        return PersonInfoDLManagerHolder.instance;
    }

    private DownInfoListener downInfoListener;

    public void addListener(DownInfoListener listener) {
        downInfoListener = listener;
    }

    public void removeListener() {
        downInfoListener = null;
    }

    public void notifyListener(String email, DownInfoSuccessListener listener) {
        if (downInfoListener == null) {
            return;
        }
        downInfoListener.onClick(email, listener);
    }

}
