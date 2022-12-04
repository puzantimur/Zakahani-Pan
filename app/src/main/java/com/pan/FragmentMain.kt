package com.pan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.pan.databinding.FragmentMainBinding
import java.util.*

class FragmentMain : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.find.setOnClickListener {
            createDatePickerDialog()
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun createDatePickerDialog() {
        val builder = MaterialDatePicker.Builder.dateRangePicker()
        val today = MaterialDatePicker.todayInUtcMilliseconds()
        val calendarConstraints = CalendarConstraints.Builder()
        calendarConstraints.setValidator(DateValidatorPointForward.now())
        calendarConstraints.setStart(today)
        builder.setCalendarConstraints(calendarConstraints.build())
        builder.build().addOnPositiveButtonClickListener {
        }
        builder.build().show(parentFragmentManager, "DATE")
    }


}