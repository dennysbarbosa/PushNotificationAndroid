package br.com.pushnotification;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity { 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState); 
		 setContentView(R.layout.activity_main); 
		 } 

	public void registrarClick(View v){
		 GCMRegistrar.checkDevice(this); 
		 GCMRegistrar.checkManifest(this); 
		 final String regId = GCMRegistrar.getRegistrationId(this);  if (regId.equals("")) { 
			 GCMRegistrar.register(this, GCMIntentService.SENDER_ID);
			 } else { 
				 Log.v("NGVL", "Já registrado"); 
				 } 
		 } 
	 public void desregistrarClick(View v){ 
		 GCMRegistrar.unregister(this); 
		 
	 } 
	 }


