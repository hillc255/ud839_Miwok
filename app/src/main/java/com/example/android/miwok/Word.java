package com.example.android.miwok;

/**
 * {@Link Word represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwork translation for that word} - Class Declaration
 */
public class Word {

    /**
     * Default translation for the word - State
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the work - State
     */
    private String mMiwokTranslation;


    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    /**
     * Constructor - create new word object
     * Setters not needed because the word object will not change
     *
     * @param vMiwokTranslation   is the Miwok word
     * @param vDefaultTranslation is the translated word
     * @param vAudioResourceId is the audio file
     */
    public Word(String vDefaultTranslation, String vMiwokTranslation, int vAudioResourceId){
        mDefaultTranslation = vDefaultTranslation;
        mMiwokTranslation = vMiwokTranslation;
        mAudioResourceId = vAudioResourceId;
    }

    /**
     * Constructor2 - create new word object
     * Setters not needed because the word object will not change
     *
     * @param vMiwokTranslation   is the Miwok word
     * @param vDefaultTranslation is the translated word
     * @param vImageResourceId is the drawable resource for the image
     * @param vAudioResourceId
     */
    public Word(String vDefaultTranslation, String vMiwokTranslation, int vImageResourceId, int vAudioResourceId) {
        mDefaultTranslation = vDefaultTranslation;
        mMiwokTranslation = vMiwokTranslation;
        mImageResourceId = vImageResourceId;
        mAudioResourceId = vAudioResourceId;
    }

    /**
     * Get the default translation of the word - Getter Method
     *
     * @return String
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get Miwork translation of the word - Getter Method
     *
     * @return String
     */
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get image resoure for the word - Getter Method
     * Return the image resource ID of the word.
     *
     * @return int
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get audio resource for the word - Getter Method
     * Return the audio resource ID of the word.
     *
     * @return int
     */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }


}
