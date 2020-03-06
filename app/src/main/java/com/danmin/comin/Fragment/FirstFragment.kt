package com.danmin.comin.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danmin.comin.Fragment.MarketInfo.MarketinfoActivity
import com.danmin.comin.R
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentsListModel>(
            ContentsListModel("a", "a", 1, "d"),
            ContentsListModel("a", "b", 1, "d"),
            ContentsListModel("a", "c", 1, "d"),
            ContentsListModel("a", "d", 1, "d"),
            ContentsListModel("a", "e", 1, "d"),
            ContentsListModel("a", "f", 1, "d"),
            ContentsListModel("a", "g", 1, "d")
        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter = list_adapter

        view.listview_first_fragment.setOnItemClickListener { adapterView, view, i, id ->
            val intent = Intent(requireContext(), MarketinfoActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}
