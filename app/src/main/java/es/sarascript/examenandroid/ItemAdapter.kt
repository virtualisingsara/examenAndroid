package es.sarascript.examenandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class ItemAdapter (val items: List<ItemModel>, val listener: (ItemModel) -> Unit)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Añadir los campos del layout
        var itemName = itemView.rowItemName
        var itemMail = itemView.rowItemMail
        var itemWebsite = itemView.rowItemWebsite
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)) // Layout para cada item (row_item.xml)
    }

    // Número de rows (items)
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.get(position)
        // Asignamos el valor de las propiedades de cada item a su campo del layout
        holder.itemName.text = item.name
        holder.itemMail.text = item.mail
        holder.itemWebsite.text = item.web

        holder.itemView.setOnClickListener() {
            listener(item)
        }
    }

}