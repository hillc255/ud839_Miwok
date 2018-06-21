package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    /** Resource ID for the background color for this list of words */
     private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words          A List of word objects to display in a list
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
   // public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

   // @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       // Check if the existing view is being reused, otherwise inflate the view
       View listItemView = convertView;
       if(listItemView == null) {
           listItemView = LayoutInflater.from(getContext()).inflate(
                   R.layout.list_item, parent, false);
 //       return super.getView(position, convertView, parent);
    }

    // Get the {@link Word} object located at this position in the list
    Word currentWord = getItem(position);

    // Find the TextView in the list_item.xml layout with the ID miwok_text_view
    TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
    // Get the version name from the current Word object and
    // set this text on the name TextView
        miwokTextView.setText(currentWord.getmMiwokTranslation());

    // Find the TextView in the list_item.xml layout with the ID default_text_view
    TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
    // Get the version number from the current AndroidFlavor object and
    // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

    // Find the ImageView in the list_item.xml layout with the ID list_item_icon
    ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
    // Get the image resource ID from the current AndroidFlavor object and

        if (currentWord.hasImage()) {
            //Set the ImageView to the image resource specified in the current Word
            iconView.setImageResource(currentWord.getImageResourceId());

            //make sure view is visible
            iconView.setVisibility(View.VISIBLE);
        }
        //otherwise hide the the image view
        else{
            iconView.setVisibility(View.GONE);
        }
    // set the image to iconView
     //   iconView.setImageResource(currentWord.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


    // Return the whole list item layout (containing 2 TextViews)
    // so that it can be shown in the ListView
        return listItemView;
}
}
