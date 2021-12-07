package com.gui.antonio.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gui.antonio.notes.databinding.FragmentNoteDetailsBinding

class NoteDetailsFragment : Fragment() {

    private var noteDetailsFragment: FragmentNoteDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        noteDetailsFragment = FragmentNoteDetailsBinding.inflate(inflater, container, false)
        return noteDetailsFragment?.root
    }

    override fun onDestroyView() {
        noteDetailsFragment = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteDetailsFragment()
    }
}