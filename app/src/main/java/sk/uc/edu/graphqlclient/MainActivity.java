package sk.uc.edu.graphqlclient;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import sk.uc.edu.graphqlclient.adapter.Adapter;
import sk.uc.edu.graphqlclient.addingForm.AddItemActivity;
import sk.uc.edu.graphqlclient.util.Utils;
import sk.uc.edu.graphqlclient.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_ITEM_REQUEST_CODE = 1;
    private Adapter adapter;

    private RecyclerView recyclerView;
    private Button button;
    private EditText sendEditText;

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        adapter = new Adapter(id -> {
            mainActivityViewModel.finish(id);
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        mainActivityViewModel.getTodosData().observe(this, data -> {
            if (data != null) {
                List<GetTodosQuery.GetAll> getAlls = Utils.filterData(data.getAll);
                adapter.swapItems(getAlls);
            }
        });

        sendRequest();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mainActivityViewModel.loadData();
    }

    private void sendRequest() {
        mainActivityViewModel.loadData();
    }

    private void addItem() {
        //mainActivityViewModel.addItem();
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, ADD_ITEM_REQUEST_CODE);
    }

    private void initLayout() {
        button = findViewById(R.id.activity_main__send_button);
        button.setOnClickListener(v -> sendRequest());
        recyclerView = findViewById(R.id.activity_main__recycler_view);

        sendEditText = findViewById(R.id.activity_main__add_item__button);
        sendEditText.setFocusable(false);
        sendEditText.setOnClickListener(v -> addItem());
    }
}
