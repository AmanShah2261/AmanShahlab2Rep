package com.example.aman.shah.n01482261;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the Snackbar with an action to close the application
        snackbar = Snackbar.make(findViewById(android.R.id.content), "Press back again to close", Snackbar.LENGTH_LONG);
        snackbar.setAction("Close", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // Intercept the user press on the soft back key
            if (snackbar.isShown()) {
                // If the Snackbar is already shown, close the application
                finish();
            } else {
                // Show the Snackbar with an action to close
                snackbar.show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void submitNow(View view) {
        Toast.makeText(this, R.string.fullname_toast, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Activity2.class);
        String name = getString(R.string.fullname_toast);
        intent.putExtra("key", name);
        startActivity(intent);
    }
}