package com.bridgeproject;
// same package name as our project identifier

import com.facebook.react.ReactPackage;
//for making package

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
//Other dependencies for custom package


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//java dependencies


import com.bridgeproject.BridgeModule;
//importing your custom bridge component , we can make multiple components and add it to single package

//interface implementing react packages
public class BridgeModulePackage implements ReactPackage{

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext){
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext){
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new BridgeModule(reactContext));
        return modules;
        //calling the the bridge we just create in BridgeModule.java
    }
}
