package myapplication.junctionx22.jar

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import myapplication.junctionx22.databinding.DialogLayoutBinding

class DiscountDialogFragment: AppCompatDialogFragment() {
    private lateinit var binding: DialogLayoutBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = DialogLayoutBinding.inflate(LayoutInflater.from(context))
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
    }
}