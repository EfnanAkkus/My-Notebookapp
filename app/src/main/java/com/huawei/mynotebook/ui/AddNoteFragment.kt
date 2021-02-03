package com.huawei.mynotebook.ui

import android.os.AsyncTask
import android.os.Bundle
import android.renderscript.Script
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.huawei.mynotebook.R
import com.huawei.mynotebook.db.Note
import com.huawei.mynotebook.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment() {

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
        floatingButtonSaveNote.setOnClickListener {
            val noteTitle = edit_text_title.text.toString().trim()
            val noteBody = edit_text_note.text.toString().trim()

            if (noteTitle.isEmpty()) {
                edit_text_title.error = "title required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }
            if (noteBody.isEmpty()) {
                edit_text_note.error = "note required"
                edit_text_note.requestFocus()
                return@setOnClickListener
            }
            launch {
                val note = Note(noteTitle, noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note saved")
                }
            }

            val note = Note(noteTitle, noteBody)
            //we cannot access our database in the main thread alttakini burda yazamayız
            //  NoteDatabase(activity!!).getNoteDao().addNote(note)

            saveNote(note)
        }
    }

    private fun saveNote(note: Note) {

    }


}