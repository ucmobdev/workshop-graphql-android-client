package sk.uc.edu.graphqlclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText sendEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        button = findViewById(R.id.activity_main__send_button);

        sendEditText = findViewById(R.id.activity_main__add_item__button);
        sendEditText.setFocusable(false);
    }
}
