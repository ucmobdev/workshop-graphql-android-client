package sk.uc.edu.graphqlclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import sk.uc.edu.graphqlclient.apolloClient.MyApolloClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApolloClient myApolloClient = MyApolloClient.getMyApolloClient();
        myApolloClient.query(GetGroupsQuery.builder().build()).enqueue(new ApolloCall.Callback<GetGroupsQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetGroupsQuery.Data> response) {

            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });

    }
}
