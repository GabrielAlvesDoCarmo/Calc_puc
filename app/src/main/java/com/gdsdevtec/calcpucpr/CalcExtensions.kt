package com.gdsdevtec.calcpucpr

import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
fun String.stringValid() = this.isNotEmpty() && this != "0"
fun AppCompatTextView.isValueValid() = this.text.toString().isNotEmpty()
fun AppCompatButton.getValue() = this.text.toString()
fun AppCompatTextView.setValue(value: String) {
    if (value.isNotEmpty()) this.text = value
}