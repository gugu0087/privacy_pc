package com.pc.privacylibrary.systempermission;

import android.os.Parcel;

import androidx.annotation.DrawableRes;

/**
 * @author: xyc
 * @date: 2022/3/22
 * @describe：
 */
public class PrivacyBean {
    private String name;
    private String id;
    private int leftIcon;
    private int rightIcon;
    private String manifest;
    private String manifestExtra;

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


}
