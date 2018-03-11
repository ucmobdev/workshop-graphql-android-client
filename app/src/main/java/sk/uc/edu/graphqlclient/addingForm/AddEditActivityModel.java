package sk.uc.edu.graphqlclient.addingForm;

import android.arch.lifecycle.ViewModel;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import sk.uc.edu.graphqlclient.AddItemMutation;
import sk.uc.edu.graphqlclient.apolloClient.MyApolloClient;

/**
 * Created by malobicky
 * on 11.3.18.
 * AndroidClient
 */

public class AddEditActivityModel extends ViewModel {

    private ApolloClient myApolloClient;

    public AddEditActivityModel() {
        this.myApolloClient = MyApolloClient.getMyApolloClient();
    }

    public void sendAddItemRequest(String title, String description) {
        myApolloClient.mutate(AddItemMutation.builder()
                .title(title)
                .description(description)
                .build())
                .enqueue(new ApolloCall.Callback<AddItemMutation.Data>() {
                    @Override
                    public void onResponse(@Nonnull Response<AddItemMutation.Data> response) {

                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {

                    }
                });
    }
}
