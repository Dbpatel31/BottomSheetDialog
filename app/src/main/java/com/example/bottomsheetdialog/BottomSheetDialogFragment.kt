package com.example.bottomsheetdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ItemDetailSheetFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView=view.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView= view.findViewById<TextView>(R.id.descriptionTextView)

        val title= arguments?.getString("TITLE")
        val description= arguments?.getString("DESCRIPTION")

        titleTextView.text= title
        descriptionTextView.text=description


    }

    companion object{
        fun newInstance(title:String, description:String):ItemDetailSheetFragment{
            val fragment= ItemDetailSheetFragment()
            val bundle= Bundle()
            bundle.putString("TITLE",title)
            bundle.putString("DESCRIPTION",description)
            fragment.arguments=bundle
            return fragment

        }
    }
}