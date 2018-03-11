package sk.uc.edu.graphqlclient.addingForm;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import sk.uc.edu.graphqlclient.R;

/**
 * Created by malobicky
 * on 11.3.18.
 * AndroidClient
 */

public class AddItemActivity extends AppCompatActivity {

    private AddEditActivityModel model;

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        initLayout();

        model = ViewModelProviders.of(this).get(AddEditActivityModel.class);
    }

    private void initLayout() {
        titleEditText = findViewById(R.id.main_form__title_edittext);

        descriptionEditText = findViewById(R.id.main_form__description);

        sendButton = findViewById(R.id.activity_add_edit_item__add_item_button);
        sendButton.setOnClickListener(v -> {
            sendAddItemRequest();
        });
    }

    private void sendAddItemRequest() {
        model.sendAddItemRequest(
                String.valueOf(titleEditText.getText()),
                String.valueOf(descriptionEditText.getText())
        );
    }

    @Override
    public void onBackPressed() {
        sendAddItemRequest();
        super.onBackPressed();
    }
}