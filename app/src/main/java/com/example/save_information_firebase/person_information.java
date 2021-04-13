package com.example.save_information_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;
import java.util.Map;


public class person_information extends AppCompatActivity {

    EditText txtname, txtlastName, txtcity;
    Button save;
    DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);



        txtname = findViewById(R.id.name_text);
        txtlastName = findViewById(R.id.lastname_text);
        txtcity = findViewById(R.id.living_text);
        save = findViewById(R.id.buttonSent);

        mRootReference = FirebaseDatabase.getInstance().getReference();

         //devolver valores del firebase after click CLICK HERE!
        mRootReference.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    Log.e("InformacionUser:",""+snapshot.getValue());

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        }


        //sent data firebase
       public void sentdata(View view) {

           String name = txtname.getText().toString();
           String lastName = txtlastName.getText().toString();
           String city = txtcity.getText().toString();

           Map<String, Object> datosUsuario = new HashMap<>();
           datosUsuario.put("name", name);
           datosUsuario.put("lastName", lastName);
           datosUsuario.put("city", city);

           mRootReference.child("User").push().setValue(datosUsuario);
           clean();


       }

       //clean text
       public void clean() {
        txtname.setText("");
        txtlastName.setText("");
        txtcity.setText("");

    }


    }

