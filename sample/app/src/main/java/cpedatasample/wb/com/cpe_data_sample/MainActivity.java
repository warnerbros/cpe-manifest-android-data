package cpedatasample.wb.com.cpe_data_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.wb.cpedata.CPEDataParser;
import com.wb.cpedata.ManifestItem;
import com.wb.cpedata.data.manifest.CPEData;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	EditText manifestEditText, appDataEditText, cpeStyleEditText;
	public static CPEData movieMetaData = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		manifestEditText = findViewById(R.id.manifest_xml_edit_text);
		manifestEditText.setText("https://cpe-manifest.s3.amazonaws.com/xml/urn:dece:cid:eidr-s:EE48-FE4D-B363-71AF-A3AB-G/FantasticBeasts_V1.2_Manifest.xml");

		appDataEditText = findViewById(R.id.appdata_xml_edit_text);
		appDataEditText.setText("https://cpe-manifest.s3.amazonaws.com/xml/urn:dece:cid:eidr-s:EE48-FE4D-B363-71AF-A3AB-G/FantasticBeasts_V1.1_AppData.xml");

		cpeStyleEditText = findViewById(R.id.cpestyle_xml_edit_text);
		cpeStyleEditText.setText("https://cpe-manifest.s3.amazonaws.com/xml/urn:dece:cid:eidr-s:EE48-FE4D-B363-71AF-A3AB-G/FantasticBeasts_V1.1_style.xml");

		Button loadButton = findViewById(R.id.load_button);
		loadButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ManifestItem manifestItem = new ManifestItem(manifestEditText.getText().toString(), appDataEditText.getText().toString(), cpeStyleEditText.getText().toString());
				movieMetaData = CPEDataParser.parseCPEManifests(MainActivity.this, manifestItem, Locale.US);
				Intent intent = new Intent(MainActivity.this, ManifestViewerActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
