package com.taingy.tablelayout

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etVersion = findViewById<EditText>(R.id.et_version)
        val etCodeName = findViewById<EditText>(R.id.et_code_name)
        val tbLayout = findViewById<TableLayout>(R.id.tb_layout)
        val btAdd = findViewById<Button>(R.id.bt_add)

        addToTableLayout("Version", "Code Name", tbLayout)

        btAdd.setOnClickListener {
            val version = etVersion.text.toString()
            val codeName = etCodeName.text.toString()
            addToTableLayout(version, codeName, tbLayout)
            etVersion.text.clear()
            etCodeName.text.clear()
            it.hideKeyboard()
        }
    }

    private fun addToTableLayout(version: String, codeName: String, tbLayout: TableLayout) {
        val tbRow = TableRow(this)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        tbRow.layoutParams = layoutParams

        val tvVersion = TextView(this)
        tvVersion.text = version
        tvVersion.textSize = 18F

        val tvCodeName = TextView(this)
        tvCodeName.text = codeName
        tvCodeName.textSize = 18F

        tbRow.addView(tvVersion)
        tbRow.addView(tvCodeName)

        tbLayout.addView(tbRow)
        tbLayout.isStretchAllColumns = true
    }

    fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }
}