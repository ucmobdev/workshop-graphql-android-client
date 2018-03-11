package sk.uc.edu.graphqlclient.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import sk.uc.edu.graphqlclient.GetTodosQuery;
import sk.uc.edu.graphqlclient.apolloClient.MyApolloClient;

/**
 * Created by malobicky
 * on 10.3.18.
 * AndroidClient
 */

public class MainActivityViewModel extends ViewModel {

    private ApolloClient myApolloClient;

    private MutableLiveData<GetTodosQuery.Data> todosData;

    public MainActivityViewModel() {

        myApolloClient = MyApolloClient.getMyApolloClient();
        todosData = new MutableLiveData<>();
    }

    public LiveData<GetTodosQuery.Data> getTodosData() {
        return todosData;
    }

    public void loadData() {
        myApolloClient.query(GetTodosQuery.builder().build()).enqueue(new ApolloCall.Callback<GetTodosQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetTodosQuery.Data> response) {
                if (response.data() != null) {
                    GetTodosQuery.Data data = response.data();
                    if (data != null) {
                        todosData.postValue(data);
                    }
                }
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
                //Toast.makeText(MainActivity.this, "Failure called " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
