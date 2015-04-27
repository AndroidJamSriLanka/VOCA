package com.nextgen.kasun.uidesign3;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Kasun on 4/25/2015.
 */
public class VListFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.vlist_fragment, container, false);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ListView listView=(ListView)getView().findViewById(R.id.listView);
        Resources resources=getResources();
        String[] data=resources.getStringArray(R.array.dummyData);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
    }
}
