package com.kampusdeveloper.easykampus.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.kampusdeveloper.easykampus.R;
import com.kampusdeveloper.easykampus.adapter.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.concurrent.Executor;


public class Ulasan extends Fragment {
    private static final String TAG = "Ambildata";
    private TextView nama,getEmail;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ImageView profilePhoto;

    public Ulasan() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ulasan, container, false);
       mAuth = FirebaseAuth.getInstance();

        nama = (TextView)v.findViewById(R.id.tv_nama_google);
        profilePhoto = (ImageView) v.findViewById(R.id.image);
        getEmail = (TextView)v.findViewById(R.id.tv_emailgoogle);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    for (UserInfo profile : user.getProviderData()) {
                        // Id of the provider (ex: google.com)
                        String providerId = profile.getProviderId();
                        // UID specific to the provider
                        String uid = profile.getUid();

                        // Name, email address, and profile photo Url
                        String name = profile.getDisplayName();
                        String email = user.getEmail();

                        Uri photoUrl = profile.getPhotoUrl();

                        Picasso.with(getContext()).load(photoUrl).transform(new CircleTransform()).into(profilePhoto);
                        nama.setText(name);
//                        getEmail.setText(email);

                        Log.d(TAG, "onAuthStateChanged:signed_id:" +uid);
                        Log.d(TAG, "onAuthStateChanged:signed_email:" +email);
                        Log.d(TAG, "onAuthStateChanged:signed_name:" +name);
                        Log.d(TAG, "onAuthStateChanged:signed_url:" +photoUrl);
                    }
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

           return v;
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());

                        }
                        // ...
                    }
                });
    }
}
