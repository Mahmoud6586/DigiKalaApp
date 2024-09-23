package ir.example.digikalaapp.data.model.home

data class AmazingItem(
    val _id: String,
    val category: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String,
    val star: Double
)