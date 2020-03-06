package com.bridgeproject;
// same package name as our project identifier

import android.widget.Toast;
//native toast module of android
import android.util.Log;
//for logs

// https://facebook.github.io/react-native/
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
//importing react native classes needed for bridging
//can be seen from react-native site

public class BridgeModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;
    //creating instance 
    BridgeModule(ReactApplicationContext context){
    //calling constructor
        super(context);
        //calling context
        reactContext = context;
        //initializing reactContext with context created before
    }

    @Override
    public String getName(){
        return "BridgeModule";
    }
        //returning name of the module as a string to be used in react-native


    @ReactMethod
    public void ShowMessage(String message, int duration){
        Log.d("BRIDGE_MODULE", message);
        //getting message and duration from our react native app
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
    //whatever method we want to import in our ReactNative file is to be written/exported from here
}


