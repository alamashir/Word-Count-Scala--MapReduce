import org.apache.spark._
import org.apache.spark.SparkContext._

object eg {
  def main(args: Array[String]) {

    //Spark config creation
    val conf = new SparkConf().setAppName("wordCount").setMaster("local[*]")
    // Create a Scala Spark Context.
    val sc = new SparkContext(conf)
    // Load our input data.
    val input =  sc.textFile("/Users/ashiralam/Desktop/testspark.txt")
    // Split up into words.

    val counts = input.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
    // Save the word count back out to a text file, causing evaluation.
    counts.foreach(println)
  }
}
