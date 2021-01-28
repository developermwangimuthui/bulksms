package com.intelligentsoftwares.bulksms.activities.sendBulkSms.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.sms_contact_user_single_view.*
import com.intelligentsoftwares.bulksms.R


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

class PreviewContactViewHolder constructor(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    private lateinit var clickClosure: (Int) -> Unit

    init {
        smsContactUserSingleCancelImageView.setOnClickListener {
            clickClosure.invoke(adapterPosition)
        }
    }

    fun setClickListener(clickClosure: (Int) -> Unit) {
        this.clickClosure = clickClosure
    }

    fun bind(contact: String) {
        smsContactUserSinglePhoneTextView.text = contact
    }

    companion object {

        fun create(parent: ViewGroup) = PreviewContactViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.sms_contact_user_single_view, parent, false
            )
        )
    }
}