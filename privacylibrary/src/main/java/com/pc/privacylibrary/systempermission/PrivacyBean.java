package com.pc.privacylibrary.systempermission;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import androidx.annotation.DrawableRes;

/**
 * @author: xyc
 * @date: 2022/3/22
 * @describe：
 */
public class PrivacyBean implements Parcelable {
    private String name;///权限名称
    private String id;// 不填也行
    private int leftIcon;// 暂时用不上
    private int rightIcon;// 暂时不需要填
    private String manifest;// 读写XX权限  比如：write_storage
    private String manifestExtra;//读写XX权限  这里就写：read_storage
    private boolean isGranted = false;//是否授权，
    private String introduce;//权限介绍

    protected PrivacyBean(Parcel in) {
        name = in.readString();
        id = in.readString();
        leftIcon = in.readInt();
        rightIcon = in.readInt();
        manifest = in.readString();
        manifestExtra = in.readString();
        isGranted = in.readByte() != 0;
        introduce = in.readString();

    }

    public static final Creator<PrivacyBean> CREATOR = new Creator<PrivacyBean>() {
        @Override
        public PrivacyBean createFromParcel(Parcel in) {
            return new PrivacyBean(in);
        }

        @Override
        public PrivacyBean[] newArray(int size) {
            return new PrivacyBean[size];
        }
    };

    public String getManifestExtra() {
        return manifestExtra;
    }

    public void setManifestExtra(String manifestExtra) {
        this.manifestExtra = manifestExtra;
    }

    public PrivacyBean() {
    }

    public String getManifest() {
        return manifest;
    }

    public void setManifest(String manifest) {
        this.manifest = manifest;
    }

    public int getLeftIcon() {
        return leftIcon;
    }

    public void setLeftIcon(@DrawableRes int leftIcon) {
        this.leftIcon = leftIcon;
    }

    public int getRightIcon() {
        return rightIcon;
    }

    public void setRightIcon(@DrawableRes int rightIcon) {
        this.rightIcon = rightIcon;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public void setGranted(boolean granted) {
        isGranted = granted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeString(id);
        parcel.writeInt(leftIcon);
        parcel.writeInt(rightIcon);
        parcel.writeString(manifest);
        parcel.writeString(manifestExtra);
        parcel.writeByte((byte) (isGranted ? 1 : 0));
        parcel.writeString(introduce);
    }

}
