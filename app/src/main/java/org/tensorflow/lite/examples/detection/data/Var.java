package org.tensorflow.lite.examples.detection.data;

import android.app.Application;

public class Var extends Application {

    public static int count=0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Var.count = count;
    }
}
