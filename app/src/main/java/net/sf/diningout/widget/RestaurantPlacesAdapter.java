/*
 * Copyright 2013 pushbit <pushbit@gmail.com>
 *
 * This file is part of Dining Out.
 *
 * Dining Out is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Dining Out is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Dining Out. If not,
 * see <http://www.gnu.org/licenses/>.
 */

package net.sf.diningout.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import net.sf.diningout.R;
import net.sf.diningout.provider.Contract.RestaurantPhotos;
import net.sf.sprockets.google.Place;
import net.sf.sprockets.view.ViewHolder;
import net.sf.sprockets.widget.GooglePlacesAdapter;

/**
 * Translates {@link Place}s to Views.
 */
public class RestaurantPlacesAdapter extends GooglePlacesAdapter {
    private final GridView mView;
    private final int mCellHeight;

    public RestaurantPlacesAdapter(GridView view) {
        mView = view;
        mCellHeight = view.getResources().getDimensionPixelSize(R.dimen.grid_row_height);
    }

    @Override
    public View getView(int position, Place place, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.restaurants_adapter, parent, false);
        }
        String url = RestaurantPhotos.url(place, mView.getColumnWidth(), mCellHeight);
        ViewHolder.get(view, RestaurantHolder.class)
                .photo(url, mView).name(place.getName()).rating(place.getRating());
        return view;
    }
}
