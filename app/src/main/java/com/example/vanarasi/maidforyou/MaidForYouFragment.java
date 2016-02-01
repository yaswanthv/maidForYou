package com.example.vanarasi.maidforyou;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaidForYouFragment extends Fragment {

    public MaidForYouFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maid_for_you, container, false);

        final ImageButton fbutton = (ImageButton) rootView.findViewById(R.id.firstButton);
        ImageButton sbutton = (ImageButton) rootView.findViewById(R.id.secondButton);
        ImageButton tbutton = (ImageButton) rootView.findViewById(R.id.thirdButton);

        final TextView displayText = (TextView) rootView.findViewById(R.id.displayText);
        return rootView;
    }
}
