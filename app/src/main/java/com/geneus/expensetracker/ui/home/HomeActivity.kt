package com.geneus.expensetracker.ui.home

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geneus.expensetracker.R
import com.geneus.expensetracker.ui.adapter.RecentTransactionAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
    private val rvRecentTransactions by lazy { findViewById<RecyclerView>(R.id.rvRecentTransactions) }
    private val fabAdd by lazy { findViewById<FloatingActionButton>(R.id.fabAdd) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setRecentTransactionAdapter()

        fabAdd.setOnClickListener {
            selectDialogExpenseType()
        }
    }

    private fun setRecentTransactionAdapter() {
        rvRecentTransactions.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvRecentTransactions.adapter =
            RecentTransactionAdapter(this, this::onClickRecentTransaction)
    }

    private fun selectDialogExpenseType() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.dialog_select_expense)
        dialog.show()

        dialog.findViewById<ImageView>(R.id.ivCloseIcon).setOnClickListener { dialog.dismiss() }
        dialog.findViewById<LinearLayout>(R.id.containerExpense).setOnClickListener {
            dialog.dismiss()
            inputExpenseDetails()
        }
        dialog.findViewById<LinearLayout>(R.id.containerIncome).setOnClickListener {
            dialog.dismiss()
            inputIncomeDetails()
        }
    }

    private fun inputIncomeDetails() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.dialog_income_details)
        dialog.show()

        dialog.findViewById<ImageView>(R.id.ivCloseIcon).setOnClickListener { dialog.dismiss() }
        dialog.findViewById<Button>(R.id.btnAddIncome).setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Income added successfully.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputExpenseDetails() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.dialog_expense_details)
        dialog.show()

        dialog.findViewById<ImageView>(R.id.ivCloseIcon).setOnClickListener { dialog.dismiss() }
        dialog.findViewById<Button>(R.id.btnAddExpense).setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Expense added successfully.", Toast.LENGTH_LONG).show()
        }
    }

    private fun onClickRecentTransaction() {

    }
}