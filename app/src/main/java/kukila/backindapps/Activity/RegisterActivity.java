package kukila.backindapps.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kukila.backindapps.Model.BaseResponse;
import kukila.backindapps.Networking.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import kukila.backindapps.R;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView login;
    private ProgressDialog dialog;
    private EditText etFirstName, etLastName, etPassword, etEmail;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lama);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Buat Akun");

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        etFirstName = (EditText) findViewById(R.id.first_name);
        etLastName = (EditText) findViewById(R.id.last_name);
        etEmail = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        btnDaftar = (Button) findViewById(R.id.daftar_akun);



        login = (TextView) findViewById(R.id.masuk);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void register() {
        dialog.show();
        String name = etFirstName.getText().toString() + " " + etLastName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        Call<BaseResponse> responseCall = RestClient.getService().register(name, email, password);
        responseCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful())
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                else
                    Toast.makeText(RegisterActivity.this, "Gagal Registrasi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Gagal Registrasi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    public void login() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
