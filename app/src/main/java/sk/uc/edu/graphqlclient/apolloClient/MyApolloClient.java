package sk.uc.edu.graphqlclient.apolloClient;

import com.apollographql.apollo.ApolloClient;

/**
 * Created by malobicky
 * on 24.2.18.
 * AndroidClient
 *
 * schema downloader
 * https://github.com/apollographql/apollo-codegen
 * command:
 * apollo-codegen introspect-schema http://localhost:4000/api --output schema.json
 *
 * execute npm install
 *
 * execute node index.js
 *
 * open browser at http://127.0.0.1:4000/api

 */

public class MyApolloClient {

    private static final String BASE_APOLLO_URL = "http://10.0.2.2:4000/api";
    private static ApolloClient myApolloClient;

    public static ApolloClient getMyApolloClient() {
        if(myApolloClient != null){
            return myApolloClient;
        }

        return myApolloClient;
    }
}