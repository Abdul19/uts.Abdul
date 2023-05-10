package com.stmik.utsabdul

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MotorAdapter(private val context: Context, private val motor: List<Motor>, val listener: (Motor) ->Unit)
    : RecyclerView.Adapter<MotorAdapter.MotorViewHolder>() {

    class MotorViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val imgMotor = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameMotor = view.findViewById<TextView>(R.id.tv_item_name)
        val descMotor = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(motor: Motor, listener: (Motor) -> Unit){
            imgMotor.setImageResource(motor.imgMotor)
            nameMotor.text = motor.nameMotor
            descMotor.text = motor.descMotor
            itemView.setOnClickListener{
                listener(motor)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotorViewHolder {
        return MotorViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_motor, parent, false)
        )
    }

    override fun getItemCount(): Int = motor.size

    override fun onBindViewHolder(holder: MotorViewHolder, position: Int) {
        holder.bindView(motor[position], listener)
    }
}
