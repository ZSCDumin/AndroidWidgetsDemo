package com.edu.zscdm.androidwidgetsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyFragment4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyFragment4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab04,null);
    }
}
