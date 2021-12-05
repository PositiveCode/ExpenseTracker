package com.geneus.expensetracker.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.geneus.expensetracker.R

class RecentTransactionAdapter(
    private val context: Context,
    private val onSelect: () -> Unit
) :
    RecyclerView.Adapter<RecentTransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_transactions, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cvContainer.setOnClickListener {
            onSelect.invoke()
        }

        when (position) {
            2 -> {
                holder.setExpenseTv("-$10.00")
                holder.setType(context, "food")
            }
            3 -> {
                holder.setExpenseTv("-$40.00")
                holder.setType(context, "home")
            }
            9 -> {
                holder.setExpenseTv("-$100.00")
                holder.setType(context, "transport")
            }

            4 -> {
                holder.setIncomeTv("+$50.00")
                holder.setType(context, "food")
            }
            7 -> {
                holder.setExpenseTv("-$25.00")
                holder.setType(context, "food")
            }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val cvContainer: CardView = itemView.findViewById(R.id.cvContainer)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val ivType: ImageView = itemView.findViewById(R.id.ivType)

        fun setExpenseTv(amount: String){
            tvAmount.text = amount
            tvAmount.setTextColor(Color.parseColor("#C73E1D"))
        }

        fun setIncomeTv(amount: String){
            tvAmount.text = amount
            tvAmount.setTextColor(Color.parseColor("#118C4F"))
        }

        fun setType(context: Context, type: String){
            Glide.with(context)
                .load(
                    when(type){
                        "food" -> R.drawable.ic_type_food
                        "home" -> R.drawable.ic_type_home
                        "transport" -> R.drawable.ic_type_home
                        else -> R.drawable.ic_type_entertainment
                    }
                )
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(ivType)
        }
    }

}