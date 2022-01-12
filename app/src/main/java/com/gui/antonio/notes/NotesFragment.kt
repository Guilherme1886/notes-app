package com.gui.antonio.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gui.antonio.notes.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private var notesBinding: FragmentNotesBinding? = null
    private var notesAdapter: NotesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (notesBinding == null) {
            notesBinding = FragmentNotesBinding.inflate(inflater, container, false)
            notesBinding?.notesRecyclerView?.apply {
                setHasFixedSize(true)
                notesAdapter = NotesAdapter().apply {
                    submitList(getNotes())
                    onClickNote = {
                        findNavController().navigate(
                            NotesFragmentDirections.actionNotesFragmentToNoteDetailsFragment(
                                note = it
                            )
                        )
                    }
                    onDeleteNote = { note, position ->
                        val action = NoteModalBottomSheetAction.Removing(
                            note = NoteModalBottomSheetModel(
                                title = note.title,
                                description = note.description
                            )
                        )
                        val modal = ModalBottomSheet(action = action) {
                            val b = getNotes()
                            b.removeAt(position)
                            notesAdapter?.submitList(b)
                        }
                        modal.show(parentFragmentManager, ModalBottomSheet.TAG)
                    }
                    onEditNote = { note, position ->
                        val action = NoteModalBottomSheetAction.Editing(
                            note = NoteModalBottomSheetModel(
                                title = note.title,
                                description = note.description
                            )
                        )
                        val modal = ModalBottomSheet(action = action) {
                            val b = getNotes()
                            b.removeAt(position)
                            b.add(position, it)
                            notesAdapter?.submitList(b)
                        }
                        modal.show(parentFragmentManager, ModalBottomSheet.TAG)
                    }
                }
                adapter = notesAdapter
            }
            notesBinding?.notesAddFloatingActionButton?.setOnClickListener {
                val modal = ModalBottomSheet(action = NoteModalBottomSheetAction.Adding) {
                    val b = getNotes()
                    notesAdapter?.submitList(
                        b.apply {
                            add(
                                NotePresentation(
                                    title = it.title,
                                    description = it.description
                                )
                            )
                        }
                    )
                }
                modal.show(parentFragmentManager, ModalBottomSheet.TAG)
            }
        }
        return notesBinding?.root
    }

    override fun onDestroyView() {
        Log.d("NotesFragment", "onDestroyView")
//        notesBinding = null
        super.onDestroyView()
    }

    fun getNotes() = mutableListOf(
        NotePresentation(
            title = "My day",
            description = "i will to the doctor"
        ),
        NotePresentation(
            title = "Job",
            description = "payment will be today"
        ),
        NotePresentation(
            title = "Study",
            description = "Germany and English study today"
        ),
        NotePresentation(
            title = "Vacation",
            description = "Go to Sao Paulo in the next week"
        )
    )

    companion object {
        @JvmStatic
        fun newInstance() = NotesFragment()
    }
}