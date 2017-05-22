package kenjin.DynamicTabPage.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import kenjin.DynamicTabPage.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OneFragment extends Fragment {

    String tes;

    public  static  OneFragment newInstant(String tes){
        OneFragment customerDetailFragment = new OneFragment();
        Bundle args = new Bundle();
        args.putSerializable("sesicustomer", tes);
        customerDetailFragment.setArguments(args);
        return customerDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null)
            if(null!=arguments.getSerializable("sesicustomer"))
                tes = (String) arguments.getSerializable("sesicustomer");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_one, container, false);
        TextView textView=(TextView) view.findViewById(R.id.text);
        if(null!=tes)
            textView.setText(tes);

        return view;
    }


}
