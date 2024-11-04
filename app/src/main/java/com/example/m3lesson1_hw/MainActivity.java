package com.example.m3lesson1_hw;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.m3lesson1_hw.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.increaseButton.setOnClickListener(v -> {
            counter++;
            binding.counterText.setText(String.valueOf(counter));
        });

        binding.sendButton.setOnClickListener(v -> {
            String message = binding.counterText.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setPackage("com.whatsapp");

            intent.putExtra(
                    Intent.EXTRA_TEXT,
                    message);

            startActivity(intent);
        });
    }
}