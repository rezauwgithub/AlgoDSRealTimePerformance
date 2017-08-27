package net.nitroservices.algodsrealtimeperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int ARRAY_SIZE = 244800;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());



        // Testing
        Random random = new Random();



        int[] testIntArr = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            testIntArr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        Sorting.sortUsingBubbleSort(testIntArr);
        // Sorting.sortUsingInsertionSort(testIntArr);


        for (int element : testIntArr) {
            Log.d(TAG, "testIntArr: " + element);
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
