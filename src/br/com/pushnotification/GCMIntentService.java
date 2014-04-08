package br.com.pushnotification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {
	  public static final String SENDER_ID = "659600333161"; 
	  private static final String IP = "172.27.171.36"; 
	  @Override 
	  protected void onRegistered(Context ctx, final String regId) { 
	  Log.d("NGVL", "onRegistered: "+ regId); 
	  new Thread(){ 
	  public void run() { 
	  sendRegistrationIdToServer(regId); 
	  }; 
	  }.start(); 
	  } 
	 @Override 
	  protected void onUnregistered(Context ctx, String regId) { 
	  Log.d("NGVL", "onUnregistered: "+ regId);
	  }
	  @Override 
	  protected void onMessage(Context contexto, Intent intent) {
	  Log.d("NGVL", "onMessage");
	  Bundle extras = intent.getExtras(); 
	  Log.d("NGVL", "Mensagem recebida: "+ extras.getString("mensagem")); 
	  PendingIntent pit = PendingIntent.getActivity( contexto, 0, new Intent(), 0); 
	  Notification notificacao = new NotificationCompat.Builder(contexto) .setTicker("Chegou uma mensagem do GCM") .setContentTitle("Nova mensagem") .setContentIntent(pit) .setContentText(extras.getString("mensagem")) .setSmallIcon(R.drawable.ic_launcher) .setAutoCancel(true) .build(); 
	  NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); 
	  manager.notify(1, notificacao);
	   } 
	
	  @Override 
	  protected void onError(Context ctx, String errorId) { 
	  Log.d("NGVL", "onError: "+ errorId); 
	  }
	  public void sendRegistrationIdToServer(String registrationId) { 
	  final String deviceId = Secure.getString( getContentResolver(), Secure.ANDROID_ID); 
	  HttpClient client = new DefaultHttpClient(); 
	  HttpPost post = new HttpPost( "http://" + IP + ":8080/PushNotification/doRegister"); 
	  try { 
	  List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1); 
	  nameValuePairs.add(new BasicNameValuePair( "deviceid", deviceId)); 
	  nameValuePairs.add(new BasicNameValuePair( "registrationid", registrationId)); 
	  post.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
	  ResponseHandler<String> responseHandler = new BasicResponseHandler(); 
	  String responseBody = client.execute(post, responseHandler); 
	  System.out.println(responseBody); 
	 } catch (IOException e) { 
	  e.printStackTrace(); 
	  } 
	  }
	  }