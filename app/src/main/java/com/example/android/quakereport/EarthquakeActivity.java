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
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<EarthQuake> earthquakes = new ArrayList<>();
        earthquakes.add(new EarthQuake("San Francisco", 4.7f, "26-Jan-2015"));
        earthquakes.add(new EarthQuake("London", 3.6f, "26-Feb-2015"));
        earthquakes.add(new EarthQuake("Tokyo", 3.0f, "27-May-2015"));
        earthquakes.add(new EarthQuake("New York", 2.8f, "02-July-2015"));
        earthquakes.add(new EarthQuake("Mumbai", 5.6f, "01-Jan-2016"));
        earthquakes.add(new EarthQuake("Delhi", 7.9f, "12-Jan-2016"));
        earthquakes.add(new EarthQuake("Bangalore", 3.8f, "27-Mar-2016"));


        EarthquakeCustomAdapter cusAdapter = new EarthquakeCustomAdapter(this,earthquakes);
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);



        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(cusAdapter);
    }
}
