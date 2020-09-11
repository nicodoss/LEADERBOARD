package com.e.leaderboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectSubmission extends AppCompatActivity {
    EditText firstName,LastName,Email,Githublink;
    String gLastName,gfirstName,gEmail,gGithublink;
    Button submit;
    private  GADSAPI gadsapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_project_submission);
       firstName=findViewById(R.id.idfirstname);
       LastName=findViewById(R.id.idlastname);
       Email=findViewById(R.id.idemailadress);
       Githublink=findViewById(R.id.idurlgit);
       submit=findViewById(R.id.idsubmit);
final ActionBar actionBar=getSupportActionBar();
        actionBar.setCustomView(R.layout.actionbar_custom_view_home);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
       /////

        ///
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gfirstName=firstName.getText().toString();
                gLastName=LastName.getText().toString();
                gEmail=Email.getText().toString();
                gGithublink=Githublink.getText().toString();
                showDialog();

            }
        });




        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://docs.google.com/forms/d/e/").client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        gadsapi=retrofit.create(GADSAPI.class);


    }
    void showDialog(){
        LayoutInflater inflater= LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.senddialog,null);
        AlertDialog alertDialog=new AlertDialog.Builder(this).setView(view).create();
        alertDialog.show();
        Button yesbutton=view.findViewById(R.id.idyesdialog);
        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print(gEmail);
                if(gfirstName.isEmpty()&& gLastName.isEmpty() && gEmail.isEmpty()&& gGithublink.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please check all field before send",Toast.LENGTH_LONG).show();
                }else{
                    CreatePost(gfirstName,gLastName,gEmail,gGithublink);
                    alertDialog.dismiss();

                }
            }
        });
    }





    private void CreatePost(String FirstName,String LastName,String Adressemail,String GithubLink){
        LayoutInflater inflater= LayoutInflater.from(this);
        View viewsuccess=inflater.inflate(R.layout.dialogsuccess,null);
        AlertDialog alertDialog=new AlertDialog.Builder(this).setView(viewsuccess).create();
        Call<Void> call=gadsapi.CreatePost(FirstName,LastName,Adressemail,GithubLink);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            if(response.isSuccessful()){
                alertDialog.show();
                System.out.println("success");}}

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            System.out.println("error");
            System.out.print(t.getMessage());
                alertDialog.show();
            }
        });
    }
}
