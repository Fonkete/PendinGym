package fonket.pendindong.models.data;

import java.util.ArrayList;
import java.util.List;

import fonket.pendindong.models.models.Pending;

/**
 * Created by felip on 03-03-2017.
 */

public class Queries {

    public List<Pending> notDone() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }

    public List<Pending> done() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 1");
        if (pendingList != null && pendingList.size() > 0) {
            pendingList.addAll(pendingList);
        }
        return pendings;
    }}
