package com.nerdery.university.coffield.nuflickr.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nerdery.university.coffield.nuflickr.NUFlickrProjectApplication;
import com.nerdery.university.coffield.nuflickr.R;
import com.nerdery.university.coffield.nuflickr.model.DummyContent;
import com.nerdery.university.coffield.nuflickr.model.FlickrPhoto;
import com.nerdery.university.coffield.nuflickr.model.FlickrPhotoContent;
import org.json.JSONObject;

/**
 * A fragment representing a list of Flickr photo items
 *
 * Created by Iain on 4/30/14.
 */
public class FlickrPhotosListFragment extends BaseFragment implements ListView.OnItemClickListener {

    private ArrayAdapter<FlickrPhoto> adapter;
    private ListView listView;
    private OnFragmentInteractionListener listener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FlickrPhotosListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the flickr call
        String flickrUrl = "https://api.flickr.com/services/rest";
        String format = "json";
        String method = "flickr.photos.search";
        String apiKey = "96fe9ff37cb0ab084eb85ef658c55127";
        String tags = "nerdery";

        Uri.Builder builder = Uri.parse(flickrUrl).buildUpon();
        builder.appendQueryParameter("method", method);
        builder.appendQueryParameter("api_key", apiKey);
        builder.appendQueryParameter("tags", tags);
        builder.appendQueryParameter("format", format);
        builder.appendQueryParameter("nojsoncallback", "1");

        VolleyLog.d("URL", builder.toString());

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, builder.toString(), null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        VolleyLog.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error.Response:", error.getMessage());
                    }
                }
        );

        NUFlickrProjectApplication.getInstance().addToRequestQueue(getRequest);


        // TODO Change the adapter to display content
        adapter = new ArrayAdapter<FlickrPhoto>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                FlickrPhotoContent.ITEMS
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flickrphotos_list, container, false);

        // Set the adapter
        listView = (ListView) view.findViewById(R.id.flickrPhotoList);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if( null != listener ) {
            // Notify the active callback listener that an item has been selected
            listener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}