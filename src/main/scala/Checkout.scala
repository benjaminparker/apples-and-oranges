object Checkout {

  val prices = Map(
    "Apple" -> 60,
    "Orange" -> 25
  )

  def totalCost(items: List[String]): Int = cost(items) - discount(items)

  def cost(items: List[String]): Int = items.foldLeft(0)(_ + prices(_))

  def discount(items: List[String]): Int = {
    val (apples, oranges) = items.partition(_ == "Apple")
    appleDiscount(apples) + orangeDiscount(oranges)
  }

  def appleDiscount(apples: List[String]): Int = apples.length / 2  * prices("Apple")

  def orangeDiscount(oranges: List[String]): Int = oranges.length / 3  * prices("Orange")
}
