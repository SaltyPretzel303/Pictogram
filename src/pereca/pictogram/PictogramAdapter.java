package pereca.pictogram;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;

public class PictogramAdapter extends ArrayAdapter<RowContainer> {

	private Context context;
	private int row_layout;
	private int pictogram_view;

	private OnClickListener on_click;

	public PictogramAdapter(Context context, int row_layout, int pictogram_view, List<RowContainer> rows,
			OnClickListener on_click) {
		super(context, row_layout, rows);

		this.context = context;
		this.row_layout = row_layout;
		this.pictogram_view = pictogram_view;
		this.on_click = on_click;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		// get bitmaps for single row
		RowContainer row = (RowContainer) this.getItem(position);

		// inflate row
		view = LayoutInflater.from(this.context).inflate(this.row_layout, parent, false);

		// linear layout as container for pictograms
		LinearLayout row_layout = (LinearLayout) view.findViewById(R.id.row_layout);

		View temp_view = null;

		int column = 0;

		for (Bitmap bitmap : row.getSingle_row()) {

			// inflate single pictogram holder
			temp_view = LayoutInflater.from(this.context).inflate(this.pictogram_view, row_layout, false);

			// reference image view from holder and set bitmap in it
			((ImageView) temp_view.findViewById(R.id.pictogram_view)).setImageBitmap(bitmap);

			temp_view.setTag(row.getCategory() + "-" + position + "-" + column);

			temp_view.setOnClickListener(this.on_click);

			// add single pictogram holder to row container
			row_layout.addView(temp_view);

			column++;

		}

		return view;
	}

}
