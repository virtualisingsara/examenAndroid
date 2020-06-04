package es.sarascript.examenandroid

class ItemMapper {

    fun transform(items: List<ItemDto>): List<ItemModel> {
        return items.map { transform(it) }
    }

    fun transform(item: ItemDto): ItemModel {
        return ItemModel(
            item.name,
            item.mail,
            item.web)
    }

}