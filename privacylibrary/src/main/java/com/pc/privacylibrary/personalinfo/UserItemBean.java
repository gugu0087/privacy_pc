package com.pc.privacylibrary.personalinfo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: xyc
 * @date: 2022/3/29
 * @describe：
 */
public class UserItemBean implements Parcelable {
    private String key;
    private String value;

    protected UserItemBean(Parcel in) {
        key = in.readString();
        value = in.readString();
    }

    public static final Creator<UserItemBean> CREATOR = new Creator<UserItemBean>() {
        @Override
        public UserItemBean createFromParcel(Parcel in) {
            return new UserItemBean(in);
        }

        @Override
        public UserItemBean[] newArray(int size) {
            return new UserItemBean[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeString(value);
    }
}
