package sk.uc.edu.graphqlclient.adapter;

import java.io.Serializable;

/**
 * Created by malobicky
 * on 6.3.18.
 * AndroidClient
 */

public interface LoadableItem extends Identifiable, Cloneable, Serializable {
    boolean compareContentTo(LoadableItem var1);

    boolean compareIdTo(LoadableItem var1);

    String getUniqueId();
}
