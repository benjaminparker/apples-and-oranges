object Checkout {

  val prices = Map(
    "Apple" -> 60,
    "Orange" -> 25
  )

  def totalCost(items: List[String]): Int = cost(items) - discount(items)

  private def cost(items: List[String]): Int = items.foldLeft(0)(_ + prices(_))

  private def discount(items: List[String]): Int = {
    val (apples, oranges) = items.partition(_ == "Apple")
    appleDiscount(apples) + orangeDiscount(oranges)
  }

  private def appleDiscount(apples: List[String]): Int = apples.length / 2 * prices("Apple")

  private def orangeDiscount(oranges: List[String]): Int = oranges.length / 3 * prices("Orange")
}
