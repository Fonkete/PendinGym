package fonket.pendindong.models.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import fonket.pendindong.R;
import fonket.pendindong.models.data.Queries;
import fonket.pendindong.models.models.Pending;
import fonket.pendindong.models.views.ClosePendingFragment;

/**
 * Created by felip on 03-03-2017.
 */

public class PendingsDoneAdapter extends RecyclerView.Adapter<PendingsDoneAdapter.ViewHolder> {

    private List<Pending> pendings = new Queries().notDone();
    private PendingClickListener listener;

    public PendingsDoneAdapter(PendingClickListener listener) {
        this.listener = listener;
    }


    public PendingsDoneAdapter(ClosePendingFragment closePendingFragment) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        holder.textView.setText(pending.getName());

    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }

    public void addPending(Pending pending) {
        pendings.add(pending);
        notifyDataSetChanged();
    }

    public void resetEverything() {
        List<Pending> done = new Queries().done();
        int listSize = pendings.size();

        for (int i = 0; i < done.size(); i++) {
            Pending pending = done.get(i);
            pending.setDone(false);
            pending.save();
            pendings.add(pending);
        }
        notifyItemRangeInserted(listSize, pendings.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final CheckBox checkBox;
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.pendingCb);
            textView = (TextView) itemView.findViewById(R.id.pendingTv);
        }
    }
}
