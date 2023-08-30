package fr.poseidonj.marketapp.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public class Utils {
    public static Intent startIntent(Context context, Class<?> activityTarget) {
        return new Intent(context, activityTarget);
    }

    public static Intent startIntentWithBundle(Context context, Class<?> activityTarget, Serializable object) {
        Intent intent = startIntent(context, activityTarget);
        Bundle bundle=new Bundle();
        bundle.putSerializable("data", object);
        intent.putExtras(bundle);
        return intent;
    }
}
