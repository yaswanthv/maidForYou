package com.example.vanarasi.maidforyou;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MaidForYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_for_you);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maid_for_you, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void serviceButtonsClick(View v) {
        int id = v.getId();
        View rootView = v.getRootView();
        ImageButton serviceButton = (ImageButton) v.findViewById(id);
        serviceButton.setSelected(!serviceButton.isSelected());
        switch (id) {
            case R.id.firstButton:
                setDisplayText(rootView);
                break;
            case R.id.secondButton:
                setDisplayText(rootView);
                break;
            case R.id.thirdButton:
                setDisplayText(rootView);
                break;
        }
    }

    public void setDisplayText(View rootView) {
        TextView displayTextView = (TextView) rootView.findViewById(R.id.displayText);
        String displayText = getDisplayText(rootView);
        displayTextView.setText(displayText);
    }

    public String getDisplayText(View rootView) {
        int count = 0;
        String displayText = null;
        if (rootView.findViewById(R.id.firstButton).isSelected()) {
            count++;
        }
        if (rootView.findViewById(R.id.secondButton).isSelected()) {
            count++;
        }
        if (rootView.findViewById(R.id.thirdButton).isSelected()) {
            count++;
        }
        if (count == 0) {
            return getResources().getString(R.string.default_display_text);
        }
        return (getResources().getString(R.string.display_text_prefix) + " " + String.valueOf(count) + " " + getResources().getString(R.string.display_text_suffix));
    }

    public void bookLaterPopup(View v) {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.book_later_menu);
        dialog.setTitle(R.string.book_later_popup_title);

        dialog.show();

        Button popupCancelButton = (Button) dialog.findViewById(R.id.cancel_menu_ride_later);
        Button popupConfirmButton = (Button) dialog.findViewById(R.id.ok_menu_ride_later);
        final TimePicker timePicker = (TimePicker) dialog.findViewById(R.id.rideLaterTimePicker);
        DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.rideLaterDatePicker);

        popupCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        popupConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getHour();
                int min = timePicker.getMinute();

                TextView displayTextView = (TextView) (dialog.getOwnerActivity()).findViewById(R.id.displayText);
                String displayText = displayTextView.getText() + "Your Maid will arrive at " + String.valueOf(hour) + ":" + String.valueOf(min);

                displayTextView.setText(displayText);
            }
        });
    }
}