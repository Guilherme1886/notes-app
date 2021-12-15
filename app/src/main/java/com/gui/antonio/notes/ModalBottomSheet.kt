package com.gui.antonio.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.gui.antonio.notes.databinding.ModalBottomSheetContentBinding

class ModalBottomSheet(
    private val action: NoteModalBottomSheetAction
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ModalBottomSheetContentBinding.inflate(inflater, container, false)
        when (action) {
            is NoteModalBottomSheetAction.Adding -> binding.modalBottomButton.text = "CREATE NOTE"
            is NoteModalBottomSheetAction.Editing -> {
                binding.modalTitleEditText.setText(action.note.title)
                binding.modalDescriptionEditText.setText(action.note.description)
                binding.modalBottomButton.text = "EDIT NOTE"
            }
            is NoteModalBottomSheetAction.Removing -> {
                binding.modalTitleEditText.setText(action.note.title)
                binding.modalDescriptionEditText.setText(action.note.description)
                binding.modalBottomButton.text = "REMOVE NOTE"
            }
        }
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}