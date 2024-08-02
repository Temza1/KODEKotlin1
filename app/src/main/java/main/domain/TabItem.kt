package main.domain

data class TabItem(
    val title : String,
    val titleForSort : String
)

fun getTabItems(): List<TabItem> {
    return listOf(
        TabItem("Все","Все"),
        TabItem("Android","android"),
        TabItem("Backend","backend"),
        TabItem("Ios","ios"),
        TabItem("Qa","qa"),
        TabItem("Back-office","back_office"),
        TabItem("Frontend","frontend"),
        TabItem("Management","management"),
        TabItem("Design","design"),
        TabItem("Hr","hr"),
        TabItem("Pr","pr"),
        TabItem("Support","support"),
        TabItem("Analytics","analytics")
    )
}