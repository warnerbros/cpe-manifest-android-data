package cpedatasample.wb.com.cpe_data_sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wb.cpedata.data.manifest.CPEData;
import com.wb.cpedata.parser.appdata.ManifestAppDataSetType;
import com.wb.cpedata.parser.cpestyle.CPEStyleSetType;

import java.util.ArrayList;
import java.util.List;

public class ManifestViewerActivity extends Activity {
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	private TextView titleTextBox, loadTimeTextBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		recyclerView = findViewById(R.id.my_recycler_view);
		titleTextBox = findViewById(R.id.title_textBox);
		loadTimeTextBox = findViewById(R.id.loadtime_textBox);

		titleTextBox.setText(MainActivity.movieMetaData.getMovieTitle().toUpperCase());

		double loadTimeSecond = ((double)MainActivity.movieMetaData.getTotalLoadTime()) / 1000.0;
		loadTimeTextBox.setText("Total load time: " + Double.toString(loadTimeSecond) + "s");

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		recyclerView.setHasFixedSize(true);

		// use a linear layout manager
		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		// specify an adapter (see also next example)
		adapter = new ManifestListAdapter();
		recyclerView.setAdapter(adapter);
	}

	class ManifestListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

		final static int TYPE_HEADER = 0;
		final static int TYPE_CONTENT = 1;
		List<Object> values;

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
			switch (type) {
				case TYPE_HEADER:
					return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_row, viewGroup, false));
				case TYPE_CONTENT:
				default:
					return new ContentViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_row, viewGroup, false));
			}
		}

		public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
			Object item = values.get(position);

			if (item instanceof CPEData) {
				((ContentViewHolder)holder).setText("Manifest");
			}
			if (item instanceof CPEStyleSetType) {
				((ContentViewHolder)holder).setText("CPEStyle");
			}
			if (item instanceof ManifestAppDataSetType) {
				((ContentViewHolder)holder).setText("AppData");
			}
		}

		@Override
		public int getItemViewType(int position) {
			return TYPE_CONTENT;
		}

		public int getItemCount() {
			if (values == null) {
				values = new ArrayList();
				if (MainActivity.movieMetaData != null) {
					values.add(MainActivity.movieMetaData);
					if (MainActivity.movieMetaData.getAppDataSet() != null) {
						values.add(MainActivity.movieMetaData.getAppDataSet());
					}
					if (MainActivity.movieMetaData.getCPEStyleSet() != null) {
						values.add(MainActivity.movieMetaData.getCPEStyleSet());
					}
				}
			}
			return values.size();
		}
	}

	class HeaderViewHolder extends RecyclerView.ViewHolder {
		TextView headerText;
		public HeaderViewHolder(View itemView) {
			super(itemView);
			headerText = itemView.findViewById(R.id.header_text);
		}

		public void setText(String text){
			if (headerText != null)
				headerText.setText(text);
		}
	}

	class ContentViewHolder extends RecyclerView.ViewHolder {
		TextView contentText;
		public ContentViewHolder(View itemView) {
			super(itemView);
			contentText = itemView.findViewById(R.id.content_text);
		}

		public void setText(String text){
			if (contentText != null)
				contentText.setText(text);
		}
	}
}
