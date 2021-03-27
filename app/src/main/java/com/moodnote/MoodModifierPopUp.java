package com.moodnote;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class MoodModifierPopUp {

    private String color;
    private String icon;
    private String name;

    MoodModifierPopUp(MoodInfo moodInfo) {
        this.color = moodInfo.getColor();
        this.icon = moodInfo.getIcon();
        this.name = moodInfo.getName();
    }

    //PopupWindow display method
    public void showPopupWindow(final View view) {


        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.mood_modifier, null);

        //Specify the length and width through constants
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;

        //Create a window with our parameters
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //Initialize the elements of our window, install the handler

        TextView mood = popupView.findViewById(R.id.mood);
        mood.setText(name);

        ImageView moodIcon = popupView.findViewById(R.id.moodIcon);
        setIcon(moodIcon, view.getContext());

        CardView moodColor = popupView.findViewById(R.id.moodColor);
        moodColor.setCardBackgroundColor(Color.parseColor(color));

        //Handler for clicking on the inactive zone of the window

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Close the window when clicked
                popupWindow.dismiss();
                return true;
            }
        });
    }

    private void setIcon(ImageView moodIcon, Context context) {
        String iconStr = icon + "_39";
        int icon = context.getResources().getIdentifier(iconStr, "drawable", context.getPackageName());

        moodIcon.setImageResource(icon);
    }
}