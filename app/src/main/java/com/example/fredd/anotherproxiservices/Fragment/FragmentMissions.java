package com.example.fredd.anotherproxiservices.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fredd.anotherproxiservices.R;
import com.example.fredd.anotherproxiservices.model.Mission;
import com.example.fredd.anotherproxiservices.model.Missions;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMissions.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMissions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMissions extends Fragment {
	Context context;
	ListView listviewOfMissions;
	Missions lesMissions;
	MissionAdapter missionAdapter;

	private OnFragmentInteractionListener mListener;

	// TODO: Rename and change types of parameters

	public FragmentMissions() {
		// Required empty public constructor
	}


	// TODO: Rename and change types and number of parameters
	public static FragmentMissions newInstance() {
		FragmentMissions fragment = new FragmentMissions();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		generateFakeMissions();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_fragment_missions, container, false);
		listviewOfMissions = view.findViewById(R.id.listviewOfMissions);
		missionAdapter = new MissionAdapter(context, lesMissions);
		listviewOfMissions.setAdapter(missionAdapter);

		return view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Context context) {
		this.context = context;
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.context = activity.getBaseContext();
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
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
		void onFragmentInteraction(Uri uri);
	}

	/**
	 * Adapter
	 */

	private class MissionAdapter extends ArrayAdapter<Mission> {
        public MissionAdapter(Context context, Missions missions){
        	super(context, R.layout.fragment_fragment_missions, missions);
		}
		//TODO Ajouter des éléments, pour l'instant il n'y a que le nom de la mission
        private class ViewHolder {
            TextView txtMission;
        }
		public View getView(int position, @Nullable View itemView, @NonNull ViewGroup parent) {
			final Mission mission = getItem(position);
			final ViewHolder viewHolder;

			if (itemView == null) {
				viewHolder = new ViewHolder();
				itemView = LayoutInflater.from(context).inflate(R.layout.mission_list_item, parent, false);
				viewHolder.txtMission = itemView.findViewById(R.id.txtMission);
				itemView.setTag(viewHolder);

			} else {
				viewHolder = (ViewHolder) itemView.getTag();
			}

//			viewHolder.txtMission.setText(article.getTitle().toUpperCase());
//					Toast.makeText(context, viewHolder.txtDescriptif.getText(), Toast.LENGTH_LONG).show();
//				}
//			});

			return itemView;
		}
	}

	/**
	 * méthode pour générer les missions
	 */
	private void generateFakeMissions() {
		lesMissions = new Missions();

		for(int i = 0; i <=10; i++){
			Mission uneMission = new Mission();
			uneMission.setMissionFriendlyName("mission " + i);
			lesMissions.add(uneMission);
		}
	}
}
