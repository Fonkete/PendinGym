package fonket.pendindong.models.adapters;

import fonket.pendindong.models.models.Pending;

/**
 * Created by felip on 03-03-2017.
 */

public interface PendingClickListener {

    void clickedId(long id);
    void clickedPending(Pending pending);
}
