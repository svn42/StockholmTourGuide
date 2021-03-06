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

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String tabTitles[];


    public SimpleFragmentPagerAdapter(FragmentManager fm, Context con) {
        super(fm);
        context = con;
        Resources res = con.getResources();
        tabTitles = new String[] { res.getString(R.string.category_islands),res.getString(R.string.category_sights),res.getString(R.string.category_parks), res.getString(R.string.category_museums) };
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new IslandsFragment();
        } else if (position == 1) {
            return new SightsFragment();
        } else if (position == 2) {
            return new ParksFragment();
        } else {
            return new MuseumsFragment();
        }
    }

        @Override
        public int getCount () {
            return 4;
        }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
    }
