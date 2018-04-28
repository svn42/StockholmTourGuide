/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.stockholmtourguide;


public class Location {

    private String mLocationName;

    private String mLocationInformation;

    private String mLocationAddress;
    private boolean mHasAddress;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;




    public Location(String locationName, String locationAddress, String locationInformation, boolean hasAddress) {
        mLocationName = locationName;
        mLocationInformation = locationInformation;
        mLocationAddress = locationAddress;
        mHasAddress = hasAddress;
    }
    public Location(String locationName, String locationAddress, String locationInformation, int imageResourceId, boolean hasAddress) {
        mLocationName = locationName;
        mLocationInformation = locationInformation;
        mImageResourceId = imageResourceId;
        mLocationAddress = locationAddress;
        mHasAddress = hasAddress;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationInformation() {
        return mLocationInformation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getLocationAddress() {
        return mLocationAddress;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean getHasAddress() {
        return mHasAddress;
    }
}