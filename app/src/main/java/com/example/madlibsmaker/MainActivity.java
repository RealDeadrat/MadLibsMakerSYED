package com.example.madlibsmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendLib(View v)
    {
        EditText noun = (EditText) findViewById(R.id.noun);
        EditText adverb = (EditText) findViewById(R.id.leftOrgEdTxt);
        EditText adjective = (EditText) findViewById(R.id.rightOrgEdTxt);
        EditText adjective2 = (EditText) findViewById(R.id.adjective2);
        EditText place = (EditText) findViewById(R.id.place);
        EditText verb = (EditText) findViewById(R.id.verb);
        EditText object = (EditText) findViewById(R.id.object);
        EditText number = (EditText) findViewById(R.id.number);
        EditText name = (EditText) findViewById(R.id.name);
        EditText verb2 = (EditText) findViewById(R.id.verb2);

        String nounStr = noun.getText().toString();
        String adverbStr = adverb.getText().toString();
        String adjectiveStr = adjective.getText().toString();
        String adjective2Str = adjective2.getText().toString();
        String placeStr = place.getText().toString();
        String verbStr = verb.getText().toString();
        String objectStr = object.getText().toString();
        String numberStr = number.getText().toString();
        String nameStr = name.getText().toString();
        String verb2Str = verb2.getText().toString();


        //here toast pop ups are used to avoid blank mad libs
        //source: https://developer.android.com/guide/topics/ui/notifiers/toasts
        if(nounStr.length()==0 || adverbStr.length()==0 || adjectiveStr.length()==0 || adjective2Str.length()==0
        || placeStr.length()==0 || verbStr.length()==0|| objectStr.length()==0 || numberStr.length()==0 || nameStr.length()==0
        || verb2Str.length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "One of the text boxes are blank, please fill them in";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if(nounStr.contains(" ") || adverbStr.contains(" ") || adjectiveStr.contains(" ") || adjective2Str.contains(" ")
                || placeStr.contains(" ") || verbStr.contains(" ") || objectStr.contains(" ") || numberStr.contains(" ")
                || nameStr.contains(" ") || verb2Str.contains(" "))
        {
            Context context = getApplicationContext();
            CharSequence text = "One of the text boxes contains a space, no spaces are allowed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            //creates a checkbox object, uses the id given in the activity_main.xml to specify which box
            //use the isChecked() method to see if box is checked and apply changes accordingly
            //Source: hhtps://stackoverflow.com/questions/18336151/how-to-check-if-android-checkbox-is-checked-within-its-onclick-method-declared
            //modified the example with my knowledge to apply here
            CheckBox checkbox = (CheckBox) findViewById(R.id.boldingBox);

            if(checkbox.isChecked())
            {
                nounStr = makeBold(nounStr);
                adverbStr = makeBold(adverbStr);
                adjectiveStr = makeBold(adjectiveStr);
                adjective2Str = makeBold(adjective2Str);
                placeStr = makeBold(placeStr);
                verbStr = makeBold(verbStr);
                objectStr = makeBold(objectStr);
                numberStr = makeBold(numberStr);
                nameStr = makeBold(nameStr);
                verb2Str = makeBold(verb2Str);
            }

            CheckBox checkbox2 = (CheckBox) findViewById(R.id.italicizingBox);

            if(checkbox2.isChecked())
            {
                nounStr = makeItalics(nounStr);
                adverbStr = makeItalics(adverbStr);
                adjectiveStr = makeItalics(adjectiveStr);
                adjective2Str = makeItalics(adjective2Str);
                placeStr = makeItalics(placeStr);
                verbStr = makeItalics(verbStr);
                objectStr = makeItalics(objectStr);
                numberStr = makeItalics(numberStr);
                nameStr = makeItalics(nameStr);
                verb2Str = makeItalics(verb2Str);
            }

            Intent intent = new Intent(this, MadLibActivity.class);

            intent.putExtra(MadLibActivity.NOUN, nounStr);
            intent.putExtra(MadLibActivity.ADVERB, adverbStr);
            intent.putExtra(MadLibActivity.ADJECTIVE, adjectiveStr);
            intent.putExtra(MadLibActivity.ADJECTIVE2, adjective2Str);
            intent.putExtra(MadLibActivity.PLACE, placeStr);
            intent.putExtra(MadLibActivity.VERB, verbStr);
            intent.putExtra(MadLibActivity.OBJECT, objectStr);
            intent.putExtra(MadLibActivity.NUMBER, numberStr);
            intent.putExtra(MadLibActivity.NAME, nameStr);
            intent.putExtra(MadLibActivity.VERB2, verb2Str);

            startActivity(intent);
        }




    }

    public void shareLib(View v)
    {
        EditText noun = (EditText) findViewById(R.id.noun);
        EditText adverb = (EditText) findViewById(R.id.leftOrgEdTxt);
        EditText adjective = (EditText) findViewById(R.id.rightOrgEdTxt);
        EditText adjective2 = (EditText) findViewById(R.id.adjective2);
        EditText place = (EditText) findViewById(R.id.place);
        EditText verb = (EditText) findViewById(R.id.verb);
        EditText object = (EditText) findViewById(R.id.object);
        EditText number = (EditText) findViewById(R.id.number);
        EditText name = (EditText) findViewById(R.id.name);
        EditText verb2 = (EditText) findViewById(R.id.verb2);

        String nounStr = noun.getText().toString();
        String adverbStr = adverb.getText().toString();
        String adjectiveStr = adjective.getText().toString();
        String adjective2Str = adjective2.getText().toString();
        String placeStr = place.getText().toString();
        String verbStr = verb.getText().toString();
        String objectStr = object.getText().toString();
        String numberStr = number.getText().toString();
        String nameStr = name.getText().toString();
        String verb2Str = verb2.getText().toString();

        //here toast pop ups are used to avoid blank mad libs
        //source: https://developer.android.com/guide/topics/ui/notifiers/toasts
        if(nounStr.length()==0 || adverbStr.length()==0 || adjectiveStr.length()==0 || adjective2Str.length()==0
                || placeStr.length()==0 || verbStr.length()==0|| objectStr.length()==0 || numberStr.length()==0 || nameStr.length()==0
                || verb2Str.length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "One of the text boxes are blank, please fill them in";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if(nounStr.contains(" ") || adverbStr.contains(" ") || adjectiveStr.contains(" ") || adjective2Str.contains(" ")
                || placeStr.contains(" ") || verbStr.contains(" ") || objectStr.contains(" ") || numberStr.contains(" ")
                || nameStr.contains(" ") || verb2Str.contains(" "))
        {
            Context context = getApplicationContext();
            CharSequence text = "One of the text boxes contains a space, no spaces are allowed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {

            //Note: color change and bold/italics code isn't included because almost apps revert to
            //normal black and white text, and even undo the bold/italics, it was a waste of space


            String strToSend = " There once was a(n) " + objectStr + " named " + nameStr;
            strToSend += ", it Lived all its life in a(n) ";
            strToSend += adjectiveStr + " " + placeStr + ". Until one day, ";
            strToSend += adverbStr + ", " + numberStr + " " + nounStr;
            strToSend +=  " showed up and took over everything. During the war all ";
            strToSend += adjective2Str + " " + objectStr + "(e)s were massacred. ";
            strToSend += nameStr + " started a rebellion. Their army " + verbStr + " ";
            strToSend += "the " + nounStr +", but that wasn't enough. So " + nameStr;
            strToSend += " " + verb2Str + " the " + nounStr + " and ended the war.";


            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, strToSend);

            String chooserTitle = getString(R.string.chooser);


            Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
            startActivity(chosenIntent);
        }
    }

    //uses html code which is later translated to make the text bold/italics
    //source: https://stackoverflow.com/questions/14371092/how-to-make-a-specific-text-on-textview-bold/14371107
    public String makeBold(String word)
    {
        String boldedWord = "<b>" + word + "</b>";
        return boldedWord;
    }

    //used prior knowledge of html to apply the bolding source for italics as well
    public String makeItalics(String word)
    {
        String italicWord = "<i>" + word + "</i>";
        return italicWord;
    }
}
