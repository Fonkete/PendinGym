package fonket.pendindong.models.views;

import fonket.pendindong.models.models.Pending;

/**
 * Created by felip on 02-03-2017.
 */

public class CreAcuerdos {
    public Pendingback callback;

    public CreAcuerdos(Pendingback callback) {
        this.callback = callback;
    }
    public void validation(String name){
        if (name.trim().length() >0){
            Pending pending = new Pending();
            pending.setName(name);
            pending.setDone(false);
            pending.save();
            pending.getName();
            callback.created(pending);
        }else {
            callback.noname();
        }
    }
}
