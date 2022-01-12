package com.gui.antonio.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gui.antonio.notes.databinding.FragmentNoteDetailsBinding

class NoteDetailsFragment : Fragment() {

    private var noteDetailsFragment: FragmentNoteDetailsBinding? = null
    val args : NoteDetailsFragmentArgs by navArgs()

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