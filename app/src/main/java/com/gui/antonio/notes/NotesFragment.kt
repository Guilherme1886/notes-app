package com.gui.antonio.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gui.antonio.notes.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private var notesBinding: FragmentNotesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesBinding = FragmentNotesBinding.inflate(inflater, container, false)

        notesBinding?.notesRecyclerView?.apply {
            setHasFixedSize(true)
            adapter = NotesAdapter().apply {
                onClickNote = {
                    findNavController().navigate(R.id.action_notesFragment_to_noteDetailsFragment)
                }
            }
        }

        return notesBinding?.root
    }

    override fun onDestroyView() {
        notesBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotesFragment()
    }
}