package ivan.kopeykin.opticalcharacteristicscalc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import ivan.kopeykin.opticalcharacteristicscalc.domain.Cable;

/**
 * Created by Developer on 26.01.2017.
 */

public class CablesAdapter extends RecyclerView.Adapter<CablesAdapter.CableViewHolder> {

    public static class CableViewHolder extends RecyclerView.ViewHolder {
        TextView mark;
        TextView chrs;
        View parent;
        CableViewHolder(View itemView) {
            super(itemView);
            mark = (TextView)itemView.findViewById(R.id.mark);
            chrs = (TextView)itemView.findViewById(R.id.chrs);
            this.parent = itemView;
        }
    }

    private List<Cable> cables;
    private CableClickCallback onItemClick;

    public CablesAdapter(List<Cable> cables, CableClickCallback onItemClick) {
        this.cables = cables;
        this.onItemClick = onItemClick;
    }

    @Override
    public CableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cable_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        CableViewHolder vh = new CableViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CableViewHolder holder, int position) {
        final Cable cable = cables.get(position);
        holder.mark.setText(cable.getMark());
        NumberFormat formatter = new DecimalFormat("0.#####E0");
        StringBuilder builder =new StringBuilder();
        builder.append("Длина волны:");
        builder.append(String.format(Locale.getDefault(),"%4.0f\n",cable.getL()));
        builder.append("Длина волны нулевой дисперсии:");
        builder.append(String.format(Locale.getDefault(), "%4.0f\n", cable.getL0D()));
        builder.append("Наклон нулевой дисперсии:");
        builder.append(formatter.format(cable.getS0()));
        builder.append("пс/нм2⋅км\n");
        holder.chrs.setText(builder);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.Callback(cable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cables.size();
    }
}
