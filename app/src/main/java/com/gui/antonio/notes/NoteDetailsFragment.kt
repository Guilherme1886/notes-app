package com.gui.antonio.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gui.antonio.notes.databinding.FragmentNoteDetailsBinding

class NoteDetailsFragment : Fragment() {

    private var fragmentNoteDetailsBinding: FragmentNoteDetailsBinding? = null
    private val noteArguments: NoteDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (fragmentNoteDetailsBinding == null) {
            fragmentNoteDetailsBinding = FragmentNoteDetailsBinding.inflate(inflater, container, false)
            fragmentNoteDetailsBinding?.apply {
                fragmentNoteDetailsTitleTextView.text = noteArguments.note.title
                fragmentNoteDetailsDescriptionTextView.text = noteArguments.note.description
                fragmentNoteDetailsDeleteButton.setOnClickListener {
                    val action = NoteModalBottomSheetAction.Removing(
                        note = NoteModalBottomSheetModel(
                            title = noteArguments.note.title,
                            description = noteArguments.note.description
                        )
                    )
                    (requireActivity() as MainActivity).showModal(action)
                }
                fragmentNoteDetailsEditButton.setOnClickListener {
                    val action = NoteModalBottomSheetAction.Editing(
                        note = NoteModalBottomSheetModel(
                            title = noteArguments.note.title,
                            description = noteArguments.note.description
                        )
                    )
                    (requireActivity() as MainActivity).showModal(action)
                }
            }
        }
        return fragmentNoteDetailsBinding?.root
    }

    override fun onDestroyView() {
        fragmentNoteDetailsBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteDetailsFragment()
    }
}