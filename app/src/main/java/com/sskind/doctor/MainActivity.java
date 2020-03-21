package com.sskind.doctor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ArrayList<String> matches;
    private ImageButton button,button1;

    //private boolean mIsRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveNextAct();

        checkPermission();

        editText = findViewById(R.id.editText);
        button=findViewById(R.id.button);
        button1=findViewById(R.id.button1);
        final SpeechRecognizer mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);


        final Intent mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault());
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS,2000000);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,3000000);

        //Recording.mIsRecording=false;

        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {
                Recording.mIsRecording=true;
            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {
                /*if(Recording.mIsRecording) {
                    //mSpeechRecognizer.startListening(recognizerIntent);
                    mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                    editText.setHint("Listening...");
                    //Recording.mIsRecording = true;
                */

            }

            @Override
            public void onError(int i) {
                Recording.mIsRecording=false;
            }

            @Override
            public void onResults(Bundle bundle) {
                //getting all the matches

                matches = bundle
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                //Recording.mIsRecording = false;
                //displaying the first match
                if (matches != null) {
                    editText.setText(matches.get(0));
                    //Recording.mIsRecording=false;
                    moveNextAct();
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {
                if(Recording.mIsRecording) {
                    mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                    editText.setHint("Listening...");
                }

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setPressed(true);
                //Recording.mIsRecording=false;
                //if(!Recording.mIsRecording){
                    Recording.mIsRecording=true;
                    mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                    editText.setHint("Listening...");
                //}else{

                //}
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Recording.mIsRecording) {
                    Recording.mIsRecording = false;
                    mSpeechRecognizer.stopListening();
                    editText.setText("");
                }
                /*Recording.mIsRecording=false;
                mSpeechRecognizer.stopListening();
                editText.setText("");
                //if(! .mIsRecording){
                Recording.mIsRecording=true;
                mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                editText.setHint("Listening...");
                //}else{
                */
                //}
            }
        });


        /*findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP:
                        mSpeechRecognizer.stopListening();
                        editText.setHint("You will see input here");
                        break;

                    case MotionEvent.ACTION_DOWN:
                        mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                        editText.setText("");
                        editText.setHint("Listening...");
                        break;
                }
                return false;
            }
        });
*/
    }

    private void moveNextAct() {

        Intent temp=new Intent(MainActivity.this,TemplateActivity.class);
        startActivity(temp);
        //editText.setText(matches.get(0));

    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }

  /*  public void getSpeechInput(View view){

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Start speaking..");
        //intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS,Long.valueOf(30000));

        if(intent.resolveActivity(getPackageManager())!=null) {
            startActivityForResult(intent, 10);
        }else{
            Toast.makeText(this, "Your Device Don\'t Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    etResult.setText(result.get(0));
                }
                break;
        }
    }*/
}
