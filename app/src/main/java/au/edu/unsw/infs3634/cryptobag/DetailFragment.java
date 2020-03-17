package au.edu.unsw.infs3634.cryptobag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private Coin mCoin;
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle arguments = getArguments();
        int position = arguments.getInt("POSITION");
        Coin coin = Coin.getCoins().get(position);

        mName = v.findViewById(R.id.tvName);
        mSymbol = v.findViewById(R.id.tvSymbol);
        mValue = v.findViewById(R.id.tvValueField);
        mChange1h = v.findViewById(R.id.tvChange1hField);
        mChange24h = v.findViewById(R.id.tvChange24hField);
        mChange7d = v.findViewById(R.id.tvChange7dField);
        mMarketcap = v.findViewById(R.id.tvMarketcapField);
        mVolume = v.findViewById(R.id.tvVolumeField);
        mSearch = v.findViewById(R.id.ivSearch);

        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());
        mValue.setText("$" + coin.getValue());
        mChange1h.setText(coin.getChange1h() + " %");
        mChange24h.setText(coin.getChange24h() + " %");
        mChange7d.setText(coin.getChange7d() + " %");
        mMarketcap.setText("$" + String.format("%,.2f", coin.getMarketcap()));
        mVolume.setText("$" + String.format("%,.2f", coin.getVolume()));

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        return v;
    }


    private void search() {
        String url = "https://www.google.com/search?q=cryptocurrency&oq=cry&aqs=chrome.1.69i57j69i59j0l6.2899j0j7&sourceid=chrome&ie=UTF-8";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}