package com.gui.antonio.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
                submitList(getNotes())
                onClickNote = {
                    findNavController().navigate(R.id.action_notesFragment_to_noteDetailsFragment)
                }
                onDeleteNote = {
                    val action = NoteModalBottomSheetAction.Removing(
                        note = NoteModalBottomSheetModel(
                            title = it.title,
                            description = it.description
                        )
                    )
                    val modal = ModalBottomSheet(action = action)
                    modal.show(parentFragmentManager, ModalBottomSheet.TAG)
                }
                onEditNote = {
                    val action = NoteModalBottomSheetAction.Editing(
                        note = NoteModalBottomSheetModel(
                            title = it.title,
                            description = it.description
                        )
                    )
                    val modal = ModalBottomSheet(action = action)
                    modal.show(parentFragmentManager, ModalBottomSheet.TAG)
                }
            }
        }
        notesBinding?.notesAddFloatingActionButton?.setOnClickListener {
            val modal = ModalBottomSheet(action = NoteModalBottomSheetAction.Adding)
            modal.show(parentFragmentManager, ModalBottomSheet.TAG)
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