package com.cowok.hijrah.chapter6topic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cowok.hijrah.chapter6topic1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: BlurViewModel by viewModels {
        BlurViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goButton.setOnClickListener {
            viewModel.applyBlur(blurLevel)
        }
    }

    private val blurLevel: Int get() = when (binding.radioBlurGroup.checkedRadioButtonId) {
        R.id.radio_blur_lv_1 -> 1
        R.id.radio_blur_lv_2 -> 2
        R.id.radio_blur_lv_3 -> 3
        else -> 1
    }
}