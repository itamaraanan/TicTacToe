package com.example.tictactoemarnan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // UI components
    TextView tvTitle, tvLoses, tvWins;
    Button btnStart;

    // SharedPreferences for storing wins and losses
    SharedPreferences sp;

    // ActivityResultLauncher for handling results from launched activities
    ActivityResultLauncher<Intent> activityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components and listeners
        initialize();

        // Initialize SharedPreferences
        sp = getSharedPreferences("Score", 0);
        SharedPreferences.Editor editor = sp.edit();

        // Initialize wins and losses if not already set
        if (!sp.contains("init")) {
            editor.putInt("Wins", 0);
            editor.putInt("Losses", 0);
            editor.putBoolean("init", true);
            editor.apply();
        }

        // Update UI with current wins and losses
        tvWins.setText("Wins: " + sp.getInt("Wins", 0));
        tvLoses.setText("Losses: " + sp.getInt("Losses", 0));

        // Register a callback to handle activity results
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Update wins or losses based on result code
                        if (result.getResultCode() == 44) {
                            editor.putInt("Wins", sp.getInt("Wins", 0) + 1);
                            editor.apply();
                            tvWins.setText("Wins: " + sp.getInt("Wins", 0));
                        } else if (result.getResultCode() == 45) {
                            editor.putInt("Losses", sp.getInt("Losses", 0) + 1);
                            editor.apply();
                            tvLoses.setText("Losses: " + sp.getInt("Losses", 0));
                        } else if (result.getResultCode() == 46) {
                            Toast.makeText(MainActivity.this, "It's a Tie!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Match Cancelled", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Method to initialize UI components
    private void initialize() {
        tvLoses = findViewById(R.id.tvloses);
        tvWins = findViewById(R.id.tvWins);
        tvTitle = findViewById(R.id.tvTitle);
        btnStart = findViewById(R.id.btnStart);

        // Set click listener for the start button
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Handle start button click
        if (view == btnStart) {
            // Launch MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            activityLauncher.launch(intent);
        }
    }
}
