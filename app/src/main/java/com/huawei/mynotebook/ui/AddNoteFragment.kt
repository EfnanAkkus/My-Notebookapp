package com.huawei.mynotebook.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huawei.mynotebook.R
import com.huawei.mynotebook.db.NoteDatabase

class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //we will pass contex (as a activity) here. it is not null(!!)
        //when we write  NoteDatabase(activity!!) this it will call invoke method from NoteDatabase class
        // NoteDatabase(activity!!).getNoteDao()
    }
}